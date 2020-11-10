import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Main {

   public static void main(String args[]) {
      SwingUtilities.invokeLater(new Runnable() {
          public void run() {

            new GuessGame();
          }



      });
    }



}