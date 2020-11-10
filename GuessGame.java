import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import java.util.Random;



public class GuessGame implements ActionListener { 
  JTextField userGuessField; 
  JButton userGuessButton, againButton; 
  JLabel jlabPrompt, jlabContents, jlabLast;  
  int randomNum;
  Random r;
 
  GuessGame() { 
    r = new Random();
    randomNum = r.nextInt(101) + 1;

    JFrame frame = new JFrame("Guess Game"); 
 
    frame.setLayout(new FlowLayout()); 
 
    frame.setSize(240, 120); 
  
    userGuessField = new JTextField(10); 
 
    userGuessField.setActionCommand("myTF"); 
  
    userGuessButton = new JButton("Guess"); 
   
    againButton = new JButton("Play Again"); 

    userGuessField.addActionListener(this); 
    userGuessButton.addActionListener(this); 
    againButton.addActionListener(this);

    jlabPrompt = new JLabel("Enter your guess: "); 
    jlabContents = new JLabel("");
    jlabLast = new JLabel(""); 
 

    frame.add(jlabContents); 
    frame.add(jlabLast);
    frame.add(againButton);
    frame.add(jlabPrompt); 
    frame.add(userGuessField);  
    frame.add(userGuessButton);
    frame.setVisible(true); 
  } 
 
 
  public void actionPerformed(ActionEvent ae) { 
   
    if(ae.getActionCommand().equals("Guess")) { 

      int guess = Integer.parseInt(userGuessField.getText());     
      
      if(guess < randomNum) {
        jlabContents.setText("Too low!");
      }
      else if (guess > randomNum) {
        jlabContents.setText("Too high!");
      }
      else {
        jlabContents.setText("You got it!");
      }

      jlabLast.setText("Last guess was: " + userGuessField.getText());

    } 
    else if(ae.getActionCommand().equals("Play Again")) {
      randomNum = r.nextInt(101) + 1;
      jlabPrompt.setText("Enter your guess: ");
      jlabContents.setText("");
      jlabLast.setText("");
      userGuessField.setText("");
    }
    else {
      jlabContents.setText("You pressed ENTER. \n Please press the Guess button");
    }
  } 
} 
