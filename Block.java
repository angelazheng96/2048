public class Block {

  // block's properties
  private int number;
  private int value;
  private String valueStr;

  // constructor
  public Block(int num) {
    number = num;
    value = (int) Math.pow(2, number + 1);
    valueStr = Integer.toString(value);
  }

  // getters
  public int getNumber() {
    return number;
  }

  public int getValue() {
    return value;
  }

  public String getValueStr() {
    return valueStr;
  }

  public boolean equals(Block b) {
    if (number == b.getNumber()) {
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return valueStr;
  }

}