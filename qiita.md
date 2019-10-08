#参考サイト

https://www.techscore.com/tech/Java/JavaSE/Thread/index/
https://java.keicode.com/lang/multithreading-executor.php


# 0.intro
### javaスレッドの基本

- マルチスレッドはどんな時に使われる?
    - GUIアプリケーション
        - 検索をするスレッドと、中止ボタンを押されたら、検知して検索を中止させるスレッド
    - 時間がかかるI/O処理
        - I/O処理を担当するスレッドと、I/O処理に依存せず、実行できる作業を個別に進めておくスレッド
    - 複数のクライアント
    
- マルチスレッドで、各スレッドが乱立しているとき、プログラムの終了地点はどこ？
    - javaのプログラムが終了するのは、デーモンスレッドを除いた全てのスレッドが終了したとき
        - ex.)メインスレッドからキックしたマルチスレッドの作業が終わらないと、いくらメインスレッド側の作業が終わってもプログラムは終わらない
        - おまけ)setDeamoメゾットにより、対象スレッドをデーモンスレッド化することも可能
    - スレッドの状態遷移(.getStatus)
        - (生成)初期
        - 実行可能/実行状態
        - 待ち状態
        - ロック状態
        - 終了状態
   

- 問題 1-2,1-3

### マルチスレッドプログラムの評価基準

- (必須)安全性
    - オブジェクトが設計者の意図とは異なる状態にならないこと
- (必須)生存性
    - 必要な処理はいつか必ず正常に実行されること
- 再利用性
  
- パフォーマンス
    - スループット(単位時間当たりの処理数)
    - 応答性(要求を出してから反応が返るまでの時間)
    - キャパシティ(同時に処理できる数)
    - その他(スケーラビリティ etc)
- あ


# 1.single threaded execution - この橋を渡れるのは一人

|メリット|デメリット|
|-----|-----|
|競合/不整合が発生しない | |

- まとめ(P.481)
<img width="402" alt="SingleThreadExection_pattern.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/f1e828a8-a45e-bf0b-1c00-cea978dad9fe.png">


- ★コレクションクラスをスレッドセーフにするメゾット(No.102 synchroniedMap ,etc)
- デットロックが発生する条件 P.64
    - 解除する例. 共有変数が対象である→非対称にする P.475

# immutable - 壊したくても壊せない

|メリット|デメリット|
|-----|-----|
|競合/不整合が発生しないから排他制御不要 | |


<img width="405" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/8887b3d4-ca69-574c-de02-ee1e9d17310c.png">

# Guarede Suspension - 用意できるまで待て

- インタンスが準備OKとなるまで、スレッドがメゾットを実行しないようにする

|メリット|デメリット|
|-----|-----|
|インスタンスが不整合な状態になるのを防ぐ | |


<img width="400" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/a03d5b99-d321-be0f-96f6-50f221392941.png">

<img width="383" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/ae72e5e3-ad68-8add-bec0-b33059e85dc7.png">


# Balking - 必要なかったら、やめる

- インスタンスが期待した状態になっていなかったら、メソッドの実行を中断する

|メリット|デメリット|
|-----|-----|
|無駄な待機や過剰なメソッド実行を防ぐ | |




<img width="406" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/f053451a-1fa3-957d-0fcc-6f50eed5bf19.png">
<img width="417" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/e52daa6a-98ec-ea63-d64f-029edeea82ed.png">

# Producer-Counsumer 私が作り、あなたが使う

|メリット|デメリット|
|-----|-----|
|複数のスレッドが協調して動作 | |


<img width="400" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/3f8e5ec7-d7bd-f747-d881-d32afb573d49.png">

<img width="404" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/a9cd85e7-72e0-d17a-998f-bc82088082ab.png">

# Read-Write Lock 皆で読んでいいけど、読んでいる間は書き込み禁止

|メリット|デメリット|
|-----|-----|
|柔軟な排他制御 | |



<img width="400" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/39c8f241-f829-cfb3-ddb3-33ebae873a36.png">

<img width="352" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/9256aa19-448f-32a9-4251-43dc1abdcfec.png">

<img width="367" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/736ad095-cb55-c3d3-033e-5f970986bb65.png">



# 7.Thread-Per-Messeage この仕事、やっといてね

|メリット|デメリット|
|-----|-----|
|別のスレッドに仕事を任せて、自分はすぐ次の作業に進むことができる | |


<img width="395" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/2f75f685-7ddf-eff9-1462-6b95cfbf6c76.png">






# 8.Worker Thread 仕事来るまで待ち、来たら働く

- スレッドプール活用

|メリット|デメリット|
|-----|-----|
| スレッドの生成オーバーヘッドを抑えれる| |

<img width="405" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/e55a2415-3df4-fa42-5793-115a25f950ab.png">


<img width="363" alt="重要.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/200da11d-a282-5d20-1122-01dfe5b80886.png">




<img width="367" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/e36bb549-1426-54e8-d2f5-b4bf8989070f.png">






# 9.Future 

- 別スレッドに任せておいた仕事の結果を同期的に受け取る(非同期)

|メリット|デメリット|
|-----|-----|
| 非同期処理の呼び出しに役立つ| |


<img width="416" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/285a7704-6385-f99c-33de-3614fb27107b.png">


<img width="373" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/c2d9b141-6ef1-7670-b014-6c7735db0e80.png">


<img width="375" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/72240b21-31e4-cc52-7847-7e11580c4fd6.png">


<img width="366" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/c99f8c00-89af-0ecf-b344-4e7aa51754b6.png">















# 10.Two-Phase Terminaiton ちゃんと後片付けしてから、バイバイ


|メリット|デメリット|
|-----|-----|
| 安全にスレッドを終了| |

<img width="403" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/7e9ed1fa-950c-8feb-7e16-47c2c83442cf.png">

# 11. Thread-Specific Storege スレッドごとのコインロッカー

- スレッドごとに変数領域を確保する


|メリット|デメリット|
|-----|-----|
| 排他制御が不要| |

<img width="399" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/762774cc-add6-74d7-7248-9e413e9c4bcd.png">

<img width="372" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/17697896-7d05-93c0-7fd8-e39d1b440d89.png">


# 12.Active Object 非同期メッセージを受け取る、能動的オブジェクト


|メリット|デメリット|
|-----|-----|
| | |





![uploading-0]()




<img width="395" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/44c98b12-f084-9654-3ffd-4564acd81650.png">



<img width="374" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/e0c687dd-3c11-654a-b2d2-2e21d457f128.png">


# 付録：javaスレッドの優先度

<img width="395" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/fe115249-e6ea-4a86-b0f3-710de2c62387.png">

# スレッド関連のAPI



<img width="399" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/a8509874-f0ac-b960-52aa-35d89519faf4.png">

# java.util.concurrent



<img width="399" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/ca00c943-e732-8d7d-04d3-e0574e379468.png">



<img width="370" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/ce58e3c7-1b09-534b-76c4-8521d399f7cf.png">

<img width="367" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/cf458e6c-af41-a2e6-6fbc-0ab3048f9b1d.png">



<img width="365" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/dda4b92d-a7d7-05cd-ce0e-72d2cf6769ac.png">
<img width="368" alt="キャプチャ1.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/853c8f03-f112-b3bd-5430-2a20e2691cda.png">



<img width="376" alt="キャプチャ.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/47b59cfd-be6a-8fe8-b230-c89bf715cb7f.png">



<img width="396" alt="キャプチャ1.PNG" src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/271543/a698996f-b75e-5b44-881e-2aea16d23000.png">






