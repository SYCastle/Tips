public class RealData implements Data {
    private final String content;
    public RealData(int count, char c) {
        System.out.println("        [task] making RealData(" + count + ", " + c + ") BEGIN");
        char[] buffer = new char[count];

        int k = 1;
        for (int i = 0; i < count; i++) {
            buffer[i] = c;
            k = k * i;
            try {
                Thread.sleep(100); //時間がかかるタスクを表現
            } catch (InterruptedException e) {
            }
            if (k % 2 == 0) k = k +1;
        }
        System.out.println("        [task] making RealData(" + count + ", " + c + ") END");
        this.content = new String(buffer);
    }
    public String getContent() {
        return content;
    }
}
