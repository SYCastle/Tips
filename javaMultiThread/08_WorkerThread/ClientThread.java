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

                //ExecutorServiceインターフェースを介して、スレッドプールを利用
                executorService.execute(request);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
        } catch (RejectedExecutionException e) {//スレッドプールが終了状態の場合は、executeメゾットは実行を拒否される
            System.out.println(getName() + " : " + e);
        }
    }
}
