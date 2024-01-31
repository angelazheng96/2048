public class Main {

  // different windows
  static Menu menu;
  static Settings settings;
  static Game game;

  static int boardSize;

  public static void main(String[] args) {
    // set to default colour palette
    Colour.changeColours(1);

    // set board size to default: 4
    boardSize = 4;
    
    // open the main menu
    menu = new Menu();
    menu.setVisible(true);
  }

  // opens the settings page
  public static void openSettings() {
    menu.setVisible(false);
    settings = new Settings();
    settings.setVisible(true);
  }

  // goes back from settings to the menu
  public static void exitSettings(boolean colourChanged) {
    settings.setVisible(false);
    settings.dispose();

    // update colours on the menu
    if (colourChanged) {
      menu.bg.setBackground(Colour.bg);
      menu.title.setForeground(Colour.text);

      menu.play.setBackground(Colour.accent1);
      menu.play.setForeground(Colour.text);

      menu.settings.setBackground(Colour.accent1);
      menu.settings.setForeground(Colour.text);
    }

    menu.setVisible(true);
  }

  // anytime the game begins (whether it's from the menu or restarting)
  public static void gameBegin() {
    game.randomBlock();
    game.randomBlock();
  }

  // starts the game
  public static void startGame() {
    menu.setVisible(false);
    game = new Game(boardSize);
    game.setVisible(true);

    gameBegin();
  }

  // restarts the game
  public static void restartGame() {
    game.clearBoard();

    // if the player beat the high score, then write it to the text file
    if (game.beatingHs) {
      game.writeHighScore();
    }

    // settings involving the score
    game.updateScore(0);
    game.beatingHs = false;
    game.readHighScore();

    gameBegin();
  }

  // user presses the back button, exiting the game
  public static void exitGame() {

    // writes high score to the text file
    game.writeHighScore();

    // gets rid of the game window and goes back to the menu
    game.setVisible(false);
    game.dispose();
    menu.setVisible(true);

  }

}