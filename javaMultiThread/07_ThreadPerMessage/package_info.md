# 参考

https://www.techscore.com/tech/Java/JavaSE/Thread/index/
https://java.keicode.com/lang/multithreading-executor.php

# 各クラスの概要

## Main(役割：依頼者/Client)



## Host class(役割：依頼者からの要求から、スレッドを新しく起動/Host)
無名インナークラスを使い、(https://qiita.com/icelandnono/items/fdc7e8b3a4b55608720d)
Runnableクラスのサブクラスのインスタンスを生成し、それを使ってスレッドを起動している。

※メリット：「その場で使い捨てる」クラスを作りたい場合


## Helper class(役割：要求を処理する機能をHostに提供/Helper)


#本デザインパターンのメリット

- Client役に対するHost役の応答性が上がる
	- 依頼する作業が終わるのを待たずに、client役は別の処理(ex.)他の要求依頼等)を進めることができるから


# 補足：「スレッドを生成して起動する」処理のバリエーション

## 1.Threadクラス

- 基本中の基本。
- newでインスタンスを生成し、startメゾットでスレッド起動

```
new Thread() {
	public void run() {
		helper.handale(count ,c)
	}
}.start();

```

## 2.Runnableインターフェース


```
new Thread(
	new Runnale()) {
	public void run() {
		helper.handale(count ,c)
	}
).start();

```

## 3.java.util.concurrent.ThradFactoryインターフェース

- ThradFactoryは、スレッド生成を抽象化したインターフェース
- メリット：「1.Threadクラス」の場合だと、スレッド生成部分がThreadクラスに依存してしまう
  →Host枠役を利用する、cliet側から、スレッド生成の詳細を変更できる(再利用性がある)

```
public class Host {
    private final Helper helper = new Helper();
    private final ThreadFactory threadFactory;

    public Host(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    public void request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        threadFactory.newThread(
            new Runnable() {
                public void run() {
                    helper.handle(count, c);
                }
            }
        ).start();
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}



public class Main {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        Host host = new Host(
            new ThreadFactory() { // we can change the method of thread creating method etc.
                public Thread newThread(Runnable r) {
                    return new Thread(r);
                }
            }
        );
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println("main END");
    }
}

```



## 4.java.util.concurrent.Excutorインターフェース

- 何らかの「処理を実行する」ことを抽象化したインターフェース
- 引数で与えるRunnableオブジェクトは「実行する処理内容」を表している
- メリット(違い):ThradFactoryインターフェースは、スレッド生成の詳細は隠蔽しているが、スレッド生成そのものは隠蔽していない
   →Excutorインターフェースは、スレッドの生成までも隠蔽できる
   →→Host役を使う側で、処理の実行を制御できる(コンストラクタに与えられたExcutorオブジェクト次第)

```
public class Main {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        Host host = new Host(
            new Executor() {
                public void execute(Runnable r) {
                    new Thread(r).start();
                }
            }
        );
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println("main END");
    }
}


public class Host {
    private final Helper helper = new Helper();
    private final Executor executor;

    public Host(Executor executor) {
        this.executor = executor;
    }

    public void request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        executor.execute(
            new Runnable() {
                public void run() {
                    helper.handle(count, c);
                }
            }
        );
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}

```


## 5.java.util.concurrent.ExcutorServiceインターフェース



