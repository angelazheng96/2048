import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener {

  // GUI components
  JPanel bg;
  JLabel title;
  JButton play, settings;

  public Menu() {
    setLayout(null);
    setBounds(0, 0, 400, 400);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    // set background
    bg = new JPanel();
    bg.setLayout(null);
    bg.setBounds(0, 0, 400, 400);
    bg.setBackground(Colour.bg);
    this.add(bg);

    // text for the title
    title = new JLabel("2048");
    title.setBounds(100, 40, 200, 100);
    title.setForeground(Colour.text);
    title.setHorizontalAlignment(JTextField.CENTER);
    title.setFont(new Font("Serif", Font.PLAIN, 50));
    this.add(title);
    bg.add(title);

    // play button
    play = new JButton("Play");
    play.setBounds(150, 160, 100, 50);
    play.setBackground(Colour.accent1);
    play.setForeground(Colour.text);
    play.setHorizontalAlignment(JTextField.CENTER);
    play.setFont(new Font("Serif", Font.PLAIN, 20));
    play.setFocusPainted(false);
    play.addActionListener(this);
    this.add(play);
    bg.add(play);

    // settings button
    settings = new JButton("Settings");
    settings.setBounds(150, 230, 100, 50);
    settings.setBackground(Colour.accent1);
    settings.setForeground(Colour.text);
    settings.setHorizontalAlignment(JTextField.CENTER);
    settings.setFont(new Font("Serif", Font.PLAIN, 20));
    settings.setFocusPainted(false);
    settings.addActionListener(this);
    this.add(settings);
    bg.add(settings);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == play) {
      Main.startGame();
    } else if (e.getSource() == settings) {
      Main.openSettings();
    }
  }

}