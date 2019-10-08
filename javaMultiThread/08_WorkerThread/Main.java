import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

    	//�w������̃��[�J�[�X���b�h���쐬����X���b�h�v�[���쐬
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        try {
            new ClientThread("Alice", executorService).start();
            new ClientThread("Bobby", executorService).start();
            new ClientThread("Chris", executorService).start();

            // ��5�b�҂�
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        } finally {
        	//�Ō�ɃX���b�h�v�[���̒�~
            executorService.shutdown();
        }
    }
}
