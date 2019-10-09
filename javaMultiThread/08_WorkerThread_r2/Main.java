public class Main {
    public static void main(String[] args) {

        System.out.println("main BEGIN");
        long startTime = System.currentTimeMillis();
        Host host = new Host();

        //実行をまたずに、とりあえず引換券をもらったイメージ
        Data data1 = host.request(100, 'A');//小タスクA
        Data data2 = host.request(200, 'B');//小タスクB
        //Data data3 = host.request(10, 'C');//小タスクC

        System.out.println("main otherJob BEGIN");

        //引き換え券をもらって、別の仕事を実施
        RealData rb = new RealData(300, 'C');

        System.out.println("main otherJob END");
        long endTime = System.currentTimeMillis();
        //(マージ)引換券を使って、依頼していた仕事の結果を受け取る
        System.out.println("data1 = " + data1.getContent());
        System.out.println("data2 = " + data2.getContent());
        System.out.println("data3 = " + rb.getContent());
        System.out.println("処理時間：" + (endTime - startTime) + " ms");
        System.out.println("main END");
    }
}
