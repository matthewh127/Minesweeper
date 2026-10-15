public class Timer {
    private long startTime = System.currentTimeMillis();
    private long endTime;
    public Timer(){
    }
    public void startTimer(){
        startTime = System.currentTimeMillis();
    }
    public double stopTimer(){
        endTime = System.currentTimeMillis();
        return (double)(endTime - startTime) / 1000.0;
    }

}
