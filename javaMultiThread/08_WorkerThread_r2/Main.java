public class Main {
    public static void main(String[] args) {

        System.out.println("main BEGIN");
        long startTime = System.currentTimeMillis();
        Host host = new Host();

        //���s���܂����ɁA�Ƃ肠��������������������C���[�W
        Data data1 = host.request(100, 'A');//���^�X�NA
        Data data2 = host.request(200, 'B');//���^�X�NB
        //Data data3 = host.request(10, 'C');//���^�X�NC

        System.out.println("main otherJob BEGIN");

        //������������������āA�ʂ̎d�������{
        RealData rb = new RealData(300, 'C');

        System.out.println("main otherJob END");
        long endTime = System.currentTimeMillis();
        //(�}�[�W)���������g���āA�˗����Ă����d���̌��ʂ��󂯎��
        System.out.println("data1 = " + data1.getContent());
        System.out.println("data2 = " + data2.getContent());
        System.out.println("data3 = " + rb.getContent());
        System.out.println("�������ԁF" + (endTime - startTime) + " ms");
        System.out.println("main END");
    }
}
