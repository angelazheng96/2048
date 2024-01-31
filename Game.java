import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Game extends JFrame implements ActionListener, KeyListener {

  // GUI components
  JPanel topPanel, boardPanel, bottomPanel;
  JButton back, restart;
  JLabel title, jScore, jHighScore;

  // variables that have to do with the size of GUI elements
  int size; // board size
  int frameWidth, frameHeight, widthMiddle; // x-value of the middle

  // other variables
  Block[][] board;
  int[][][] map; // coordinates of the JPanels
  JLabel[][] jBoard;
  int numBlocks;

  int score;
  int highScore;
  boolean beatingHs; // true when current score is higher than the high score
  String hsFileName; // file name where high score is stored

  boolean moved; // true when blocks have been moved after pressing an arrow key

  // constructor
  public Game(int s) {

    // initializing non-GUI variables
    size = s;
    frameWidth = size * 100 + (size + 1) * 10;
    frameHeight = frameWidth + 100;
    widthMiddle = frameWidth / 2;

    board = new Block[size][size];
    jBoard = new JLabel[size][size];
    numBlocks = 0;
    moved = false;

    // JFrame's attributes
    setLayout(null);
    setBounds(0, 0, frameWidth, frameHeight);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // KeyListener
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);

    // JPanels
    topPanel = new JPanel();
    topPanel.setLayout(null);
    topPanel.setBounds(0, 0, frameWidth, 50);
    topPanel.setBackground(Colour.bg);
    this.add(topPanel);

    boardPanel = new JPanel();
    boardPanel.setLayout(null);
    boardPanel.setBounds(0, 50, frameWidth, frameWidth);
    boardPanel.setBackground(Colour.board1);
    this.add(boardPanel);

    bottomPanel = new JPanel();
    bottomPanel.setLayout(null);
    bottomPanel.setBounds(0, frameWidth + 50, frameWidth, 50);
    bottomPanel.setBackground(Colour.bg);
    this.add(bottomPanel);

    // items on the top panel
    back = new JButton("Back");
    back.setBounds(10, 5, 100, 40);
    back.setBackground(Colour.accent1);
    back.setForeground(Colour.text);
    back.setFont(new Font("Serif", Font.PLAIN, 14));
    back.setFocusPainted(false);
    back.addActionListener(this);
    this.add(back);
		topPanel.add(back);

    restart = new JButton("Restart");
    restart.setBounds(frameWidth - 110, 5, 100, 40);
    restart.setBackground(Colour.accent1);
    restart.setForeground(Colour.text);
    restart.setFont(new Font("Serif", Font.PLAIN, 14));
    restart.setFocusPainted(false);
    restart.addActionListener(this);
    restart.setFocusable(false);
    this.add(restart);
		topPanel.add(restart);

    title = new JLabel("2048");
    title.setBounds(widthMiddle - 125, 0, 250, 50);
    title.setForeground(Colour.text);
    title.setHorizontalAlignment(JTextField.CENTER);
    title.setFont(new Font("Serif", Font.BOLD, 28));
    this.add(title);
    topPanel.add(title);

    // items on the bottom panel - JLabels for the current score & high score
    jScore = new JLabel();
    jScore.setBounds(10, 5, widthMiddle, 40);
    jScore.setForeground(Colour.text);
    jScore.setHorizontalAlignment(JTextField.LEFT);
    jScore.setFont(new Font("Serif", Font.PLAIN, 20));
    this.add(jScore);
    bottomPanel.add(jScore);

    jHighScore = new JLabel();
    jHighScore.setBounds(widthMiddle - 10, 5, widthMiddle, 40);
    jHighScore.setForeground(Colour.text);
    jHighScore.setHorizontalAlignment(JTextField.RIGHT);
    jHighScore.setFont(new Font("Serif", Font.PLAIN, 20));
    this.add(jHighScore);
    bottomPanel.add(jHighScore);

    // read & write from the right file that contains the high score
    if (size == 3) {
      hsFileName = "highscore3x3.txt";
    } else {
      hsFileName = "highscore4x4.txt";
    }

    // read value of the high score variable
    updateScore(0);
    readHighScore();
    beatingHs = false;

    // setting coordinates for the block's JPanels
    map = new int[size][size][2];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        map[i][j][0] = j * 110 + 10;
        map[i][j][1] = i * 110 + 10;

        // creating an empty block in every cell (to create the grid)
        newEmptyBlock(i, j);
      }
    }

  }

  // when a button is clicked
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == back) {
      Main.exitGame();
    } else if (e.getSource() == restart) {
      Main.restartGame();
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {}

  // when an arrow key is pressed, move the blocks in the right direction
  @Override
  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      moveUp();
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      moveRight();
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      moveDown();
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      moveLeft();
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {}

  // updates the value of the score
  public void updateScore(int n) {
    score = n;
    jScore.setText("Score: " + score);
    jScore.revalidate();
    jScore.repaint();
  }

  // updates the value of the high score
  public void updateHighScore(int n) {
    highScore = n;
    jHighScore.setText("High score: " + highScore);
    jHighScore.revalidate();
    jHighScore.repaint();

    writeHighScore();
  }

  // reads the high score from the text file
  public void readHighScore() {
    try {
      FileReader fr = new FileReader(hsFileName);
      BufferedReader br = new BufferedReader(fr);
      highScore = Integer.parseInt(br.readLine());
      br.close();

    } catch (IOException e) {
      highScore = 0;
    }

    updateHighScore(highScore);
  }

  // writes the high score to the text file
  public void writeHighScore() {
    try {
      FileWriter fw = new FileWriter(hsFileName);
      PrintWriter pw = new PrintWriter(fw);
      pw.print(highScore);
      pw.close();
    } catch(IOException e) {}
  }

  // checking if a specific spot is taken
  // i = row number, j = column number
  private boolean spotTaken(int i, int j) {
    if (board[i][j] != null) {
      return true;
    }
    return false;
  }

  // checking if a column is empty
  private boolean columnIsEmpty(int j) {
    for (int i = 0; i < size; i++) {
      if (spotTaken(i, j)) {
        return false;
      }
    }
    return true;
  }

  // checking if a row is empty
  private boolean rowIsEmpty(int i) {
    for (int j = 0; j < size; j++) {
      if (spotTaken(i, j)) {
        return false;
      }
    }
    return true;
  }

  // checking if all the board's spots are taken
  private boolean isFull() {
    if (numBlocks == Math.pow(size, 2)) {
      return true;
    }
    return false;
  }

  // creates a default-coloured JPanel to a cell (to create the appearance of a grid)
  private void newEmptyBlock(int i, int j) {
    jBoard[i][j] = new JLabel();
    jBoard[i][j].setBounds(map[i][j][0], map[i][j][1], 100, 100);
    jBoard[i][j].setHorizontalAlignment(JLabel.CENTER);
    jBoard[i][j].setFont(new Font("Serif", Font.PLAIN, 20));
    jBoard[i][j].setOpaque(true);
    jBoard[i][j].setBackground(Colour.board2);
    jBoard[i][j].setForeground(Colour.text);
    this.add(jBoard[i][j]);
    boardPanel.add(jBoard[i][j]);
  }

  // generates a new block at a specific spot if it isn't already taken
  private void newBlock(int i, int j, int num) {
    // creating the new block
    board[i][j] = new Block(num);
    numBlocks++;

    // JPanel settings
    jBoard[i][j].setText(board[i][j].getValueStr());
    jBoard[i][j].setBackground(Colour.blocks[board[i][j].getNumber()]);

    boardPanel.revalidate();
    boardPanel.repaint();
  }

  // generating a random integer - min and max are inclusive
  private int random(int min, int max) {
    return (int) Math.floor(Math.random() * (max - min + 1) + min);
  }

  // generating a random block
  public void randomBlock() {

    // value of the block (90% chance of a 2, 10% chance of a 4)
    int num;
    double randomNum = Math.random();
    if (randomNum < 0.9) {
      num = 0;
    } else {
      num = 1;
    }

    // random coordinates of the block
    int i = random(0, size - 1);
    int j = random(0, size - 1);

    // if the spot is already taken, keep generating random coordinates
    while (spotTaken(i, j)) {
      i = random(0, size - 1);
      j = random(0, size - 1);
    }

    // create the new block
    newBlock(i, j, num);
  }

  // deletes a block
  private void deleteBlock(int i, int j) {
    board[i][j] = null;

    // sets the colour back to the "grid" JPanels
    jBoard[i][j].setText("");
    jBoard[i][j].setBackground(Colour.board2);

    numBlocks--;
  }

  // clears the entire board by deleting all the blocks
  public void clearBoard() {

    // runs through each row & column
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        // if there is a block there, delete it
        if (spotTaken(i, j)) {
          deleteBlock(i, j);
        }
      }
    }

  }

  // checks if there are any possible moves left
  private boolean gameIsOver() {

    // if the board isn't full, then it's not over yet
    if (!isFull()) {
      return false;
    }

    // runs through each row
    for (int i = 0; i < size; i++) {
      
      // runs through each cell in the row and checks if it's beside a block of the same value
      // if they are the same value, then there are still possible moves
      for (int j = 0; j < size - 1; j++) {
        if (board[i][j].equals(board[i][j + 1])) {
          return false;
        }
      }

    }

    // runs through each column
    for (int j = 0; j < size; j++) {

      // checks if each cell in the column is above/below a block of the same value
      for (int i = 0; i < size - 1; i++) {
        if (board[i][j].equals(board[i + 1][j])) {
          return false;
        }
      }

    }

    // if there were no moves found, then the game is over
    return true;

  }

  // combine two blocks
  // the block listed first (i1, j1) is the direction the two blocks will move towards
  private void combineBlocks(int i1, int j1, int i2, int j2) {

    // saves the number value
    int num = board[i1][j1].getNumber();

    // deletes both blocks
    deleteBlock(i1, j1);
    deleteBlock(i2, j2);

    // creates the new block with a higher number & adds it to the score
    newBlock(i1, j1, num + 1);
    updateScore(score += board[i1][j1].getValue());

    // if the score is higher than the current high score
    // then change the variable
    if (!beatingHs && score >= highScore) {
      beatingHs = true;
    }

    // if the user is beating the high score, update the high score alongside the score
    if (beatingHs) {
      updateHighScore(score);
    }

    // if the user has won the game (i.e. max block value reached)
    if (num == Math.pow(size, 2) - 1) {
      // display popup text
      JLabel endMessage = new JLabel("Congratulations - you have won the game!");
      endMessage.setHorizontalAlignment(JLabel.CENTER);
      endMessage.setForeground(Colour.text);
      
      JOptionPane.showMessageDialog(this, endMessage, "Game Ended", JOptionPane.PLAIN_MESSAGE);
      Main.restartGame();
    }

    // if the block value of 2048 has been reached
    if (size == 4 && num == 9) {
      // display popup text
      JLabel endMessage = new JLabel("Keep going and see how far you can get. :)");
      endMessage.setHorizontalAlignment(JLabel.CENTER);
      endMessage.setForeground(Colour.text);
      
      JOptionPane.showMessageDialog(this, endMessage, "2048 Reached!", JOptionPane.PLAIN_MESSAGE);
    }

  }

  // moves a block in a direction on the board for a specific distance
  // direction variable - 1 = up, 2 = right, 3 = down, 4 = left
  private void moveBlock(int i, int j, int dist, int direction) {

    switch (direction) {
      case 1 -> newBlock(i - dist, j, board[i][j].getNumber());
      case 2 -> newBlock(i, j + dist, board[i][j].getNumber());
      case 3 -> newBlock(i + dist, j, board[i][j].getNumber());
      case 4 -> newBlock(i, j - dist, board[i][j].getNumber());
    }

    deleteBlock(i, j);

  }

  // moves a column or row of blocks in a direction (without combining)
  // values for the direction variable are the same as in moveBlock()
  private void moveBlocks(int n, int direction) {

    // counts how many consecutive empty cells there are
    int emptyCounter = 0;

    switch (direction) {

      case 1: // moving up

        // running through all the cells in the column & counting the empty ones
        for (int i = 0; i < size; i++) {
          if (!spotTaken(i, n)) {
            emptyCounter++;
            continue;
          }
    
          // if there's empty space above the block, then move it up
          if (emptyCounter > 0) {
            moveBlock(i, n, emptyCounter, 1);
            moved = true;
          }
        }
        break;

      case 2: // moving right

        // running through all the cells in the row
        for (int j = size - 1; j > -1; j--) {
          if (!spotTaken(n, j)) {
            emptyCounter++;
            continue;
          }
    
          // if there's empty space to the right of the block, then move it right
          if (emptyCounter > 0) {
            moveBlock(n, j, emptyCounter, 2);
            moved = true;
          }
        }
        break;

      case 3: // moving down

        // running through all the cells in the column
        for (int i = size - 1; i > -1; i--) {
          if (!spotTaken(i, n)) {
            emptyCounter++;
            continue;
          }
    
          // if there's empty space below the block, then move it down
          if (emptyCounter > 0) {
            moveBlock(i, n, emptyCounter, 3);
            moved = true;
          }
        }
        break;

      case 4: // moving left

        // running through all the cells in the row
        for (int j = 0; j < size; j++) {
          if (!spotTaken(n, j)) {
            emptyCounter++;
            continue;
          }
    
          // if there's empty space to the left of the block, then move it left
          if (emptyCounter > 0) {
            moveBlock(n, j, emptyCounter, 4);
            moved = true;
          }
        }
        break;

    }

  }

  // moving blocks up
  private void moveUp() {

    moved = false; // resetting the variable

    // go through all four columns
    for (int j = 0; j < size; j++) {

      // if column is empty, then skip it
      if (columnIsEmpty(j)) {
        continue;
      }

      moveBlocks(j, 1);

      // go through each cell in the column
      // figure out which blocks need to be combined
      for (int i = 0; i < size - 1; i++) {

        // if current cell or next cell is empty, continue to next cell
        if (!spotTaken(i, j) || !spotTaken(i + 1, j)) {
          continue;
        }

        // if it's the same number as the one below, then combine them
        if (board[i][j].equals(board[i + 1][j])) {
          combineBlocks(i, j, i + 1, j);
        }

      }

      moveBlocks(j, 1);

    }

    if (moved) {
      randomBlock();
    }

    // checks whether the game has ended
    if (gameIsOver()) {
      // display popup text
      JLabel endMessage = new JLabel("No moves left - game over!");
      endMessage.setHorizontalAlignment(JLabel.CENTER);
      endMessage.setForeground(Colour.text);
      
      JOptionPane.showMessageDialog(this, endMessage, "Game Ended", JOptionPane.PLAIN_MESSAGE);
      Main.restartGame();
    }

  }

  // moving blocks right
  private void moveRight() {

    moved = false; // resetting the variable

    // go through all four rows
    for (int i = 0; i < size; i++) {

      // if row is empty, then skip it
      if (rowIsEmpty(i)) {
        continue;
      }

      moveBlocks(i, 2);

      // go through each cell in the row
      // figure out which blocks need to be combined
      for (int j = size - 1; j > 0; j--) {

        // if current cell or next cell is empty, continue to next cell
        if (!spotTaken(i, j) || !spotTaken(i, j - 1)) {
          continue;
        }

        // if it's the same number as the one below, then combine them
        if (board[i][j].equals(board[i][j - 1])) {
          combineBlocks(i, j - 1, i, j);
        }

      }

      moveBlocks(i, 2);

    }

    if (moved) {
      randomBlock();
    }

    // checks whether the game has ended
    if (gameIsOver()) {
      // display popup text
      JLabel endMessage = new JLabel("No moves left - game over!");
      endMessage.setHorizontalAlignment(JLabel.CENTER);
      endMessage.setForeground(Colour.text);
      
      JOptionPane.showMessageDialog(this, endMessage, "Game Ended", JOptionPane.PLAIN_MESSAGE);
      Main.restartGame();
    }

  }

  // moving blocks down
  private void moveDown() {

    moved = false; // resetting the variable

    // go through all four columns
    for (int j = 0; j < size; j++) {

      // if column is empty, then skip it
      if (columnIsEmpty(j)) {
        continue;
      }

      moveBlocks(j, 3);

      // go through each cell in the column
      // figure out which blocks need to be combined
      for (int i = size - 1; i > 0; i--) {

        // if current cell or cell above is empty, continue to next cell
        if (!spotTaken(i, j) || !spotTaken(i - 1, j)) {
          continue;
        }

        // if it's the same number as the one above, then combine them
        if (board[i][j].equals(board[i - 1][j])) {
          combineBlocks(i, j, i - 1, j);
        }

      }

      moveBlocks(j, 3);

    }

    if (moved) {
      randomBlock();
    }

    // checks whether the game has ended
    if (gameIsOver()) {
      // display popup text
      JLabel endMessage = new JLabel("No moves left - game over!");
      endMessage.setHorizontalAlignment(JLabel.CENTER);
      endMessage.setForeground(Colour.text);
      
      JOptionPane.showMessageDialog(this, endMessage, "Game Ended", JOptionPane.PLAIN_MESSAGE);
      Main.restartGame();
    }

  }

  // moving blocks left
  private void moveLeft() {

    moved = false; // resetting the variable

    // go through all four rows
    for (int i = 0; i < size; i++) {

      // if row is empty, then skip it
      if (rowIsEmpty(i)) {
        continue;
      }

      moveBlocks(i, 4);

      // go through each cell in the row
      // figure out which blocks need to be combined
      for (int j = 0; j < size - 1; j++) {

        // if current cell or next cell is empty, continue to next cell
        if (!spotTaken(i, j) || !spotTaken(i, j + 1)) {
          continue;
        }

        // if it's the same number as the one below, then combine them
        if (board[i][j].equals(board[i][j + 1])) {
          combineBlocks(i, j, i, j + 1);
        }

      }

      moveBlocks(i, 4);

    }

    if (moved) {
      randomBlock();
    }

    // checks whether the game has ended
    if (gameIsOver()) {
      // display popup text
      JLabel endMessage = new JLabel("No moves left - game over!");
      endMessage.setHorizontalAlignment(JLabel.CENTER);
      endMessage.setForeground(Colour.text);
      
      JOptionPane.showMessageDialog(this, endMessage, "Game Ended", JOptionPane.PLAIN_MESSAGE);
      Main.restartGame();
    }

  }

}