public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        Timer time = new Timer();

        
        double elapsedTime = time.stopTimer();
        System.out.println("Your time was: " + elapsedTime + " seconds");
    }
}
