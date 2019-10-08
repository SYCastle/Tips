import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public class ClientThread extends Thread {
    private final ExecutorService executorService;
    private static final Random random = new Random();
    public ClientThread(String name, ExecutorService executorService) {
        super(name);
        this.executorService = executorService;
    }
    public void run() {
        try {
            for (int i = 0; true; i++) {
                Request request = new Request(getName(), i);

                //ExecutorService�C���^�[�t�F�[�X����āA�X���b�h�v�[���𗘗p
                executorService.execute(request);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
        } catch (RejectedExecutionException e) {//�X���b�h�v�[�����I����Ԃ̏ꍇ�́Aexecute���]�b�g�͎��s�����ۂ����
            System.out.println(getName() + " : " + e);
        }
    }
}
