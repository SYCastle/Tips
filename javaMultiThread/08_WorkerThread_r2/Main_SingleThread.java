public class Main_SingleThread {
    public static void main(String[] args) {

        System.out.println("main BEGIN");
        long startTime = System.currentTimeMillis();

        System.out.println("main otherJob BEGIN");

        RealData rb1 = new RealData(100, 'A');
        RealData rb2 = new RealData(200, 'B');
        RealData rb3 = new RealData(300, 'C');

        System.out.println("main otherJob END");
        long endTime = System.currentTimeMillis();
        //(�}�[�W)���������g���āA�˗����Ă����d���̌��ʂ��󂯎��
        System.out.println("data1 = " + rb1.getContent());
        System.out.println("data2 = " + rb2.getContent());
        System.out.println("data3 = " + rb3.getContent());
        System.out.println("�������ԁF" + (endTime - startTime) + " ms");
        System.out.println("main END");
    }
}
