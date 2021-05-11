/***************************************************
This is one of the simplest classes we made as it 
just plays a sound: either a trumpet noise or a
sound of an explosion depending on whether the 
user wins or loses the minesweeper game.
@author Hardeep Mann, Jonluke O'Cain and Vayun Malik
@version 1.0
 ****************************************************/

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlaySound {

   public static void playSoundGameOver(boolean isWinner, int loops) {
   
      String fileName = null;
      if (isWinner) {
         fileName = "snare.wav";
      } else {
         fileName = "mine1.wav";
      }
   
      playSoundFile(fileName, loops);
   }

   public static void playSoundFile(String file, int loops) {
      AudioInputStream audioInputStream = null;
   
      Clip clip = null;
   
      try {
         java.net.URL url = null;
      
         url = PlaySound.class.getResource(file);
         audioInputStream = AudioSystem.getAudioInputStream(url);
      	
         clip = AudioSystem.getClip();
         clip.open(audioInputStream);
      
      } catch (LineUnavailableException e) {
      	// TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
      	// TODO Auto-generated catch block
         e.printStackTrace();
      
      } catch (UnsupportedAudioFileException e1) {
      	// TODO Auto-generated catch block
         e1.printStackTrace();
      }
   
      clip.loop(loops);
      clip.flush();
   }
}
