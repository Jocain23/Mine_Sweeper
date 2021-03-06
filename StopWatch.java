/***************************************************
*This is one of the simplest classes we made as it 
*just displays a stopwatch, so the user can know
*how much time has elapsed, while they play.
*@author Hardeep Mann, Jonluke O'Cain and Vayun Malik
*@version 1.0
 ****************************************************/
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import java.time.Duration;
import java.time.Instant;

import javax.swing.*;
/***********************************
*This creates all the different 
*timings of seconds minutes and hours.
***********************************/
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
/***********************************
*Sets the font and starts the watch.
***********************************/	
   public StopWatch()
   {
      this.setForeground(Color.BLUE);
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
/***********************************
*Gets the times in milliseconds,
*performs the divisions and prints
*the time to the user.
***********************************/
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
