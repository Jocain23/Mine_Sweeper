

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import java.time.Duration;
import java.time.Instant;

import javax.swing.*;

public class StopWatch extends JLabel implements ActionListener {

   public final static long ONE_SECOND = 1000;
   public final static long SECONDS = 60;

   public final static long ONE_MINUTE = ONE_SECOND * 60;
   public final static long MINUTES = 60;

   public final static long ONE_HOUR = ONE_MINUTE * 60;
   public final static long HOURS = 24;

   public final static long ONE_DAY = ONE_HOUR * 24;

   boolean stop = false;
   Instant start = Instant.now();
   Instant end = Instant.now();
	
   public StopWatch()
   {
      this.setForeground(Color.BLUE);
    	//this.setBackground(Color.CYAN);
      this.setFont(new Font("Arial", Font.PLAIN, 16));
      Timer timer = new Timer(1000, this);
      timer.setInitialDelay(1);
      timer.start();
   }

   public void startStopWatch() {
      start = Instant.now();
   }

   public void stopStopWatch() {
      end = Instant.now();
      stop = true;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (stop == false) {
         Instant end = Instant.now();
         Duration duration1 = Duration.between(start, end);
         long duration = duration1.toMillis();
         String res = "";
         duration = duration / ONE_SECOND;
         int seconds = (int) (duration % SECONDS);
         duration /= SECONDS;
         int minutes = (int) (duration % MINUTES);
         duration /= MINUTES;
         int hours = (int) (duration % HOURS);
         int days = (int) (duration / HOURS);
         if (days == 0) {
            res = String.format("%02d:%02d:%02d", hours, minutes, seconds);
         } else {
            res = String.format("%dd%02d:%02d:%02d", days, hours, minutes, seconds);
         }
      
      
         setText("Time Elapsed: " + res);
      }
   
   }

}
