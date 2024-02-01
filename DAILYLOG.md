# Daily Log

## Wednesday, December 21, 2022
* Planned UMLs (still in progress) for Block.java, GUI.java, Board.java  
* Learned about scoring in 2048 and [maximum block values](https://en.wikipedia.org/wiki/2048_(video_game))  
* Learned how to use the java.awt/java.swing libraries in [VS Code](https://code.visualstudio.com/docs/java/java-gui)  

## Thursday, December 22, 2022
* Added Game.java to UMLs  
* Added sketch of GUI  
* Learned about keyPressed events  
* Started a "default" colour palette on Canva (eyedropped from [here](http://2048-variations.net/en/original) with a few tweaks)  

## Monday, January 9, 2023
* Changed GUI.java to Menu.java; created the main menu  
* Found [all available fonts](https://alvinalexander.com/blog/post/jfc-swing/swing-faq-list-fonts-current-platform/) for the in-game text  
* Learned about [opening a new JFrame]([url](https://stackoverflow.com/questions/4716372/java-how-do-i-close-a-jframe-while-opening-another-one)https://stackoverflow.com/questions/4716372/java-how-do-i-close-a-jframe-while-opening-another-one) without exiting the entire program  

## Tuesday, January 10, 2023
* Started working on the actual game's code; Board.java and Block.java  
* Generating a new random Block  

## Wednesday, January 11, 2023
* Displaying Blocks on screen (two-dimensional array of JPanels)  
* Deleted the file Board.java (merged into Game.java) due to issues with the 2D array of JPanels  
* Some Blocks didn't seem to be showing up in the right places; wrong coordinates somehow  
* Wanted to change the background colour, but the opacity is transparent by default and seems like it can't be changed easily  

## Thursday, January 12, 2023
* Fixed problems with the map matrix (which contains coordinates for all 16 Blocks on the screen)  
    * Added a JPanel at the bottom (bottomPanel) so that the blocks show up in the right spot (forgot to set layout manager to null the day before)  
    * Realized the ewindow needs to be resized manually because it doesn't start off big enough to show the entire JFrame  
* [Removed focus border from JButtons](https://stackoverflow.com/questions/9361658/disable-jbutton-focus-border)  
* Added the back button (to leave and go back to the main menu) and the restart button (to restart the game)  
    * Had some problems with [deleting the JPanels of the existing Blocks](https://stackoverflow.com/questions/11438512/fully-remove-jlabel-from-jpanel-not-setvisiblefalse)
* Added temporary arrow buttons (will add keyboard input in the future)  

## Friday, January 13, 2023
* Started working on moving the Blocks (combineBlocks, deleteBlock, moveBlock)  
* The game is now "playable" - Blocks move around on the screen & combine correctly  
* If the Blocks were moved, it generates a new random Block  

## Monday, January 16, 2023
* Added colour palettes (classic block colours & pastel)  
* Score changes when blocks are combined  
* High score is stored in highscore.txt  

## Tuesday, January 17, 2023
* Added more colour palettes (rainbow, winter, nature)  
* Added Settings.java - user can change the colour palette  
* Changing board size - user can choose between 3x3 or 4x4 board  

## Wednesday, January 18, 2023
* Added KeyListener (using arrow keys to control the game)  
* Game ends when the board is full and no more moves are possible  
    * Shows a JOptionPane message  
* Game also ends when the user "wins" by reaching the [maximum block value of 2^17]([url](https://www.quora.com/What-is-your-highest-tile-in-2048)https://www.quora.com/What-is-your-highest-tile-in-2048)  

## Thursday, January 19, 2023
* Finalized code (reordered some methods to make more sense, got rid of print statements from testing, etc.)  
* Shows a popup message when the user creates a 2048 Block as well as the maximum block value of 2^17  
* Fixed a small issue: when the user lost and no more moves were possible, they had to press an arrow key again for the popup to show  
    * Now it shows the popup right away
