import java.awt.Color;

public final class Colour {

  // current colours used in the GUI
  static Color bg;
  static Color text;
  static Color board1;
  static Color board2;
  static Color accent1;
  static Color[] blocks = new Color[17]; // length of 17 since 2^17 the highest possible block in 2048
  
  // classic colour palette
  static final Color CLASSIC_BG = new Color(250, 248, 239);
  static final Color CLASSIC_TEXT = new Color(0, 0, 0);
  static final Color CLASSIC_BOARD1 = new Color(187, 173, 160);
  static final Color CLASSIC_BOARD2 = new Color(214, 205, 196);
  static final Color CLASSIC_ACCENT1 = new Color(240, 238, 229);
  static final Color[] CLASSIC_BLOCKS = {
    new Color(238, 228, 218), // 1
    new Color(237, 224, 200), // 2
    new Color(242, 177, 121), // 3
    new Color(246, 151, 108), // 4
    new Color(249, 125, 105), // 5
    new Color(247, 96, 72),   // 6
    new Color(234, 205, 111), // 7
    new Color(238, 202, 102), // 8
    new Color(238, 201, 84),  // 9
    new Color(229, 200, 59),  // 10
    new Color(233, 196, 40),  // 11
    new Color(239, 101, 104), // 12
    new Color(235, 76, 87),   // 13
    new Color(112, 178, 212), // 14
    new Color(91, 160, 219),  // 15
    new Color(4, 121, 178),   // 16
    new Color(4, 92, 135)     // 17
  };

  // pastel colour palette
  static final Color PASTEL_BG = new Color(250, 248, 239);
  static final Color PASTEL_TEXT = new Color(48, 48, 47);
  static final Color PASTEL_BOARD1 = new Color(187, 173, 160);
  static final Color PASTEL_BOARD2 = new Color(214, 205, 196);
  static final Color PASTEL_ACCENT1 = new Color(191, 169, 194);
  static final Color[] PASTEL_BLOCKS = {
    new Color(242, 191, 216), // 1
    new Color(227, 184, 187), // 2
    new Color(237, 211, 154), // 3
    new Color(235, 215, 101), // 4
    new Color(238, 201, 84),  // 5
    new Color(222, 213, 138), // 6
    new Color(209, 222, 138), // 7
    new Color(187, 224, 141), // 8
    new Color(148, 224, 141), // 9
    new Color(141, 224, 177), // 10
    new Color(141, 224, 203), // 11
    new Color(141, 198, 224), // 12
    new Color(141, 176, 224), // 13
    new Color(141, 145, 224), // 14
    new Color(162, 141, 224), // 15
    new Color(91, 160, 219),  // 16
    new Color(176, 141, 224)  // 17
  };

  // rainbow colour palette
  static final Color RAINBOW_BG = new Color(250, 248, 239);
  static final Color RAINBOW_TEXT = new Color(0, 0, 0);
  static final Color RAINBOW_BOARD1 = new Color(140, 138, 126);
  static final Color RAINBOW_BOARD2 = new Color(179, 176, 162);
  static final Color RAINBOW_ACCENT1 = new Color(214, 75, 126);
  static final Color[] RAINBOW_BLOCKS = {
    new Color(252, 76, 63),   // 1
    new Color(252, 135, 63),  // 2
    new Color(250, 177, 67),  // 3
    new Color(250, 210, 67),  // 4
    new Color(250, 250, 67),  // 5
    new Color(149, 250, 67),  // 6
    new Color(62, 214, 70),   // 7
    new Color(62, 214, 130),  // 8
    new Color(62, 214, 173),  // 9
    new Color(141, 224, 203), // 10
    new Color(62, 201, 214),  // 11
    new Color(91, 160, 219),  // 12
    new Color(62, 125, 214),  // 13
    new Color(115, 80, 230),  // 14
    new Color(167, 80, 230),  // 15
    new Color(215, 80, 230)   // 16
  };

  // greyscale colour palette
  static final Color GREYSCALE_BG = new Color(247, 247, 247);
  static final Color GREYSCALE_TEXT = new Color(0, 0, 0);
  static final Color GREYSCALE_BOARD1 = new Color(181, 181, 181);
  static final Color GREYSCALE_BOARD2 = new Color(227, 227, 227);
  static final Color GREYSCALE_ACCENT1 = new Color(138, 138, 138);
  static final Color[] GREYSCALE_BLOCKS = {
    new Color(245, 245, 245), // 1
    new Color(235, 235, 235), // 2
    new Color(225, 225, 225), // 3
    new Color(215, 215, 215), // 4
    new Color(205, 205, 205), // 5
    new Color(195, 195, 195), // 6
    new Color(185, 185, 185), // 7
    new Color(175, 175, 175), // 8
    new Color(165, 165, 165), // 9
    new Color(155, 155, 155), // 10
    new Color(145, 145, 145), // 11
    new Color(135, 135, 135), // 12
    new Color(125, 125, 125), // 13
    new Color(115, 115, 115), // 14
    new Color(105, 105, 105), // 15
    new Color(95, 95, 95),    // 16
    new Color(85, 85, 85)     // 17
  };

  // winter colour palette
  static final Color WINTER_BG = new Color(250, 248, 239);
  static final Color WINTER_TEXT = new Color(30, 30, 30);
  static final Color WINTER_BOARD1 = new Color(181, 180, 170);
  static final Color WINTER_BOARD2 = new Color(219, 217, 211);
  static final Color WINTER_ACCENT1 = new Color(179, 219, 232);
  static final Color[] WINTER_BLOCKS = {
    new Color(245, 245, 245), // 1
    new Color(209, 229, 232), // 2
    new Color(181, 223, 230), // 3
    new Color(159, 206, 214), // 4
    new Color(140, 193, 222), // 5
    new Color(114, 172, 204), // 6
    new Color(96, 169, 209),  // 7
    new Color(84, 158, 199),  // 8
    new Color(62, 150, 199),  // 9
    new Color(42, 136, 189),  // 10
    new Color(26, 127, 184),  // 11
    new Color(16, 118, 176),  // 12
    new Color(7, 107, 163),   // 13
    new Color(6, 90, 138),    // 14
    new Color(7, 82, 125),    // 15
    new Color(12, 75, 110),   // 16
    new Color(12, 64, 110)    // 17
  };

  // nature colour palette
  static final Color NATURE_BG = new Color(240, 233, 223);
  static final Color NATURE_TEXT = new Color(26, 15, 0);
  static final Color NATURE_BOARD1 = new Color(199, 186, 163);
  static final Color NATURE_BOARD2 = new Color(227, 216, 195);
  static final Color NATURE_ACCENT1 = new Color(161, 140, 106);
  static final Color[] NATURE_BLOCKS = {
    new Color(218, 235, 199), // 1
    new Color(211, 235, 185), // 2
    new Color(211, 235, 185), // 3
    new Color(202, 235, 167), // 4
    new Color(183, 232, 130), // 5
    new Color(176, 232, 116), // 6
    new Color(146, 207, 81),  // 7
    new Color(132, 199, 62),  // 8
    new Color(104, 201, 38),  // 9
    new Color(94, 201, 20),   // 10
    new Color(85, 184, 17),   // 11
    new Color(45, 171, 14),   // 12
    new Color(37, 156, 8),    // 13
    new Color(31, 143, 4),    // 14
    new Color(26, 120, 4),    // 15
    new Color(22, 97, 4),     // 16
    new Color(24, 82, 10)     // 17
  };

  // changes the colours to the chosen colour palette
  public static void changeColours(int n) {
    switch (n) {
      case 1 -> setDefaultColours();
      case 2 -> setPastelColours();
      case 3 -> setRainbowColours();
      case 4 -> setGreyscaleColours();
      case 5 -> setWinterColours();
      case 6 -> setNatureColours();
    }
  }

  // sets the current colours to default values (classic colour palette)
  public static void setDefaultColours() {
    bg = CLASSIC_BG;
    text = CLASSIC_TEXT;
    board1 = CLASSIC_BOARD1;
    board2 = CLASSIC_BOARD2;
    accent1 = CLASSIC_ACCENT1;
    blocks = CLASSIC_BLOCKS;
  }

  // sets current colours to pastel colour palette
  public static void setPastelColours() {
    bg = PASTEL_BG;
    text = PASTEL_TEXT;
    board1 = PASTEL_BOARD1;
    board2 = PASTEL_BOARD2;
    accent1 = PASTEL_ACCENT1;
    blocks = PASTEL_BLOCKS;
  }

  // sets current colours to rainbow colour palette
  public static void setRainbowColours() {
    bg = RAINBOW_BG;
    text = RAINBOW_TEXT;
    board1 = RAINBOW_BOARD1;
    board2 = RAINBOW_BOARD2;
    accent1 = RAINBOW_ACCENT1;
    blocks = RAINBOW_BLOCKS;
  }

  // sets current colours to greyscale colour palette
  public static void setGreyscaleColours() {
    bg = GREYSCALE_BG;
    text = GREYSCALE_TEXT;
    board1 = GREYSCALE_BOARD1;
    board2 = GREYSCALE_BOARD2;
    accent1 = GREYSCALE_ACCENT1;
    blocks = GREYSCALE_BLOCKS;
  }

  // sets current colours to greyscale colour palette
  public static void setWinterColours() {
    bg = WINTER_BG;
    text = WINTER_TEXT;
    board1 = WINTER_BOARD1;
    board2 = WINTER_BOARD2;
    accent1 = WINTER_ACCENT1;
    blocks = WINTER_BLOCKS;
  }

  // sets current colours to greyscale colour palette
  public static void setNatureColours() {
    bg = NATURE_BG;
    text = NATURE_TEXT;
    board1 = NATURE_BOARD1;
    board2 = NATURE_BOARD2;
    accent1 = NATURE_ACCENT1;
    blocks = NATURE_BLOCKS;
  }
}