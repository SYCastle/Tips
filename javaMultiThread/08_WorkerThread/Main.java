import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

    	//指定個数分のワーカースレッドを作成するスレッドプール作成
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        try {
            new ClientThread("Alice", executorService).start();
            new ClientThread("Bobby", executorService).start();
            new ClientThread("Chris", executorService).start();

            // 約5秒待つ
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        } finally {
        	//最後にスレッドプールの停止
            executorService.shutdown();
        }
    }
}
