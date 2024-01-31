import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Settings extends JFrame implements ActionListener {

  JPanel bg;
  JLabel title, colours, size;
  JButton back, classic, pastel, rainbow, greyscale, winter, nature, three, four;

  boolean colourChanged; // if the user changes the colour palette, then this is true

  // constructor
  public Settings() {

    // JFrame settings
    setLayout(null);
    setBounds(0, 0, 400, 400);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    // set background
    bg = new JPanel();
    bg.setLayout(null);
    bg.setBounds(0, 0, 400, 400);
    bg.setBackground(Colour.bg);
    this.add(bg);

    // title
    title = new JLabel("Settings");
    title.setBounds(100, 5, 200, 40);
    title.setForeground(Colour.text);
    title.setHorizontalAlignment(JTextField.CENTER);
    title.setFont(new Font("Serif", Font.BOLD, 20));
    this.add(title);
    bg.add(title);

    // back button
    back = new JButton("Back");
    back.setBounds(5, 5, 70, 40);
    back.setBackground(Colour.accent1);
    back.setForeground(Colour.text);
    back.setFont(new Font("Serif", Font.PLAIN, 14));
    back.setFocusPainted(false);
    back.addActionListener(this);
    this.add(back);
		bg.add(back);

    // colour palettes
    colours = new JLabel("Colour Palette");
    colours.setBounds(100, 60, 200, 40);
    colours.setForeground(Colour.text);
    colours.setHorizontalAlignment(JTextField.CENTER);
    colours.setFont(new Font("Serif", Font.PLAIN, 18));
    this.add(colours);
    bg.add(colours);

    // classic
    classic = new JButton("Classic");
    classic.setBounds(30, 110, 100, 40);
    classic.setBackground(Colour.CLASSIC_ACCENT1);
    classic.setForeground(Colour.CLASSIC_TEXT);
    classic.setFont(new Font("Serif", Font.PLAIN, 14));
    classic.setFocusPainted(false);
    classic.addActionListener(this);
    this.add(classic);
		bg.add(classic);

    // pastel
    pastel = new JButton("Pastel");
    pastel.setBounds(150, 110, 100, 40);
    pastel.setBackground(Colour.PASTEL_ACCENT1);
    pastel.setForeground(Colour.PASTEL_TEXT);
    pastel.setFont(new Font("Serif", Font.PLAIN, 14));
    pastel.setFocusPainted(false);
    pastel.addActionListener(this);
    this.add(pastel);
		bg.add(pastel);

    // rainbow
    rainbow = new JButton("Rainbow");
    rainbow.setBounds(270, 110, 100, 40);
    rainbow.setBackground(Colour.RAINBOW_ACCENT1);
    rainbow.setForeground(Colour.RAINBOW_TEXT);
    rainbow.setFont(new Font("Serif", Font.PLAIN, 14));
    rainbow.setFocusPainted(false);
    rainbow.addActionListener(this);
    this.add(rainbow);
		bg.add(rainbow);

    // greyscale
    greyscale = new JButton("Greyscale");
    greyscale.setBounds(30, 170, 100, 40);
    greyscale.setBackground(Colour.GREYSCALE_ACCENT1);
    greyscale.setForeground(Colour.GREYSCALE_TEXT);
    greyscale.setFont(new Font("Serif", Font.PLAIN, 14));
    greyscale.setFocusPainted(false);
    greyscale.addActionListener(this);
    this.add(greyscale);
		bg.add(greyscale);

    // winter
    winter = new JButton("Winter");
    winter.setBounds(150, 170, 100, 40);
    winter.setBackground(Colour.WINTER_ACCENT1);
    winter.setForeground(Colour.WINTER_TEXT);
    winter.setFont(new Font("Serif", Font.PLAIN, 14));
    winter.setFocusPainted(false);
    winter.addActionListener(this);
    this.add(winter);
		bg.add(winter);

    // nature
    nature = new JButton("Nature");
    nature.setBounds(270, 170, 100, 40);
    nature.setBackground(Colour.NATURE_ACCENT1);
    nature.setForeground(Colour.NATURE_TEXT);
    nature.setFont(new Font("Serif", Font.PLAIN, 14));
    nature.setFocusPainted(false);
    nature.addActionListener(this);
    this.add(nature);
		bg.add(nature);

    // size of the board
    size = new JLabel("Board Size");
    size.setBounds(100, 240, 200, 40);
    size.setForeground(Colour.text);
    size.setHorizontalAlignment(JTextField.CENTER);
    size.setFont(new Font("Serif", Font.PLAIN, 18));
    this.add(size);
    bg.add(size);

    // 3x3 board button
    three = new JButton("3x3");
    three.setBounds(90, 290, 100, 40);
    three.setBackground(Colour.accent1);
    three.setForeground(Colour.text);
    three.setFont(new Font("Serif", Font.PLAIN, 14));
    three.setFocusPainted(false);
    three.addActionListener(this);
    this.add(three);
		bg.add(three);

    // 4x4 board button
    four = new JButton("4x4");
    four.setBounds(210, 290, 100, 40);
    four.setBackground(Colour.accent1);
    four.setForeground(Colour.text);
    four.setFont(new Font("Serif", Font.PLAIN, 14));
    four.setFocusPainted(false);
    four.addActionListener(this);
    this.add(four);
		bg.add(four);
    
    // colour palette has not yet been changed
    colourChanged = false;
  }

  // if a button is clicked
  @Override
  public void actionPerformed(ActionEvent e) {

    // return to main menu
    if (e.getSource() == back) {
      Main.exitSettings(colourChanged);

    } else if (e.getSource() == classic) {
      Colour.changeColours(1);
      colourChanged = true;

    } else if (e.getSource() == pastel) {
      Colour.changeColours(2);
      colourChanged = true;

    } else if (e.getSource() == rainbow) {
      Colour.changeColours(3);
      colourChanged = true;
      
    } else if (e.getSource() == greyscale) {
      Colour.changeColours(4);
      colourChanged = true;

    } else if (e.getSource() == winter) {
      Colour.changeColours(5);
      colourChanged = true;

    } else if (e.getSource() == nature) {
      Colour.changeColours(6);
      colourChanged = true;

    } else if (e.getSource() == three) {
      Main.boardSize = 3;

    } else if (e.getSource() == four) {
      Main.boardSize = 4;
    }

    // change the colours of all the components
    if (colourChanged) {
      bg.setBackground(Colour.bg);
      bg.revalidate();
      bg.repaint();

      title.setForeground(Colour.text);
      title.revalidate();
      title.repaint();

      colours.setForeground(Colour.text);
      colours.revalidate();
      colours.repaint();

      size.setForeground(Colour.text);
      size.revalidate();
      size.repaint();

      back.setForeground(Colour.text);
      back.setBackground(Colour.accent1);
      back.revalidate();
      back.repaint();

      three.setForeground(Colour.text);
      three.setBackground(Colour.accent1);
      three.revalidate();
      three.repaint();

      four.setForeground(Colour.text);
      four.setBackground(Colour.accent1);
      four.revalidate();
      four.repaint();
    }
  
  }

}