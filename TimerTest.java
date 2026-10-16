import org.junit.Test;
import static org.junit.Assert.*;

public class TimerTest {

    @Test
    public void testStopTimer() throws InterruptedException {
        Timer timer = new Timer();

        timer.startTimer();
        Thread.sleep(1000);

        double time = timer.stopTimer();

        assertTrue(time >= 1.0);
        assertTrue(time < 2.0);
    }

    @Test
    public void testImmediateStop() {
        Timer timer = new Timer();
        timer.startTimer();
        // Stop immediately without sleeping
        double time = timer.stopTimer();
        assertTrue(time >= 0.0);
    }
}