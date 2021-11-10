import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
  JTextField userGuess;
  JButton guess;
  JButton playAgain;
  JLabel makeGuess;
  JLabel highLow;
  JLabel lastGuess;
  Random r = new Random();
  int num;
GuessingGame(){
num = r.nextInt(100) + 1;
JFrame frame = new JFrame("Guessing Game");
frame.setLayout(new FlowLayout());
frame.setSize(240, 120);
userGuess = new JTextField(10);
userGuess.setActionCommand("myTF");
guess = new JButton("Guess");
playAgain = new JButton("Play Again");
userGuess.addActionListener(this);
guess.addActionListener(this);
playAgain.addActionListener(this);
makeGuess = new JLabel("Enter your guess: ");
highLow = new JLabel("");
lastGuess = new JLabel("");
frame.add(makeGuess);
frame.add(userGuess);
frame.add(guess);
frame.add(highLow);
frame.add(lastGuess);
frame.add(playAgain);
frame.setVisible(true);
}
public void actionPerformed(ActionEvent ae){
  if(ae.getActionCommand().equals("Guess")){
  int guess = Integer.parseInt(userGuess.getText());
  if(guess<num){
    highLow.setText("Too Low!");
  }
  else if(guess>num){
    highLow.setText("Too high!");
  }
  else{
    highLow.setText("You got it!");
    lastGuess.setText("Last guess was " + userGuess.getText());
  }
  } else
  if(ae.getActionCommand().equals("Play Again")){
  num = r.nextInt(100) + 1;
  makeGuess.setText("Enter your guess:");
  highLow.setText("");
  lastGuess.setText("");
  userGuess.setText("");
  }
  else{
  highLow.setText("You pressed enter. Please press the Guess Button.");
  }
  }
}
