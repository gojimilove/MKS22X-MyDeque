public class Calculator{
  /*Evaluate a postfix expression stored in s.
  *Assume valid postfix notation, separated by spaces.
  */
  public static double eval(String s){
    MyDeque<Double> tokens = new MyDeque<>(s.length());
    String[] elements = s.split(" ");
    for (int i = 0; i < elements.length; i++) {
      //if its an integer add it to the Deque
      if (isDouble(elements[i])) {
        tokens.addLast(Double.parseDouble(elements[i]));
        System.out.println(tokens);
        //System.out.println(elements[i]);
      }
      //if its an operator pop last 2 elements of deque and add a new one
      else if ("+-*/%".contains(elements[i])) {
        System.out.println(elements[i]);
        if (elements[i].equals("+")) {
          Double x = tokens.removeLast() + tokens.removeLast();
          System.out.println(tokens);
          tokens.addLast(x);
          System.out.println(tokens);
          System.out.println(x);
        }
        if (elements[i].equals("-")) {
          Double x = tokens.removeLast();
          Double y = tokens.removeLast();
          Double z = y - x;
          System.out.println(tokens);
          tokens.addLast(z);
          System.out.println(tokens);
          System.out.println(z);
        }
        if (elements[i].equals("*")) {
          Double x = tokens.removeLast() * tokens.removeLast();
          System.out.println(tokens);
          tokens.addLast(x);
          System.out.println(tokens);
          System.out.println(x);
        }
        if (elements[i].equals("/")) {
          Double x = tokens.removeLast();
          Double y = tokens.removeLast();
          Double z = y / x;
          System.out.println(tokens);
          tokens.addLast(z);
          System.out.println(tokens);
          System.out.println(z);
        }
        if (elements[i].equals("%")) {
          Double x = tokens.removeLast();
          Double y = tokens.removeLast();
          Double z = y % x;
          System.out.println(tokens);
          tokens.addLast(z);
          System.out.println(tokens);
          System.out.println(z);
        }
      }
    }
    //return tokens.getLast();
    return -1;
  }

  public static boolean isDouble(String s) {
    try {
      //try to make it a double, if successful return true
      Double.parseDouble(s);
      return true;
    } catch(Exception e) {
      //cant turn it into a double, return false
      return false;
    }
  }

  public static void main(String[] args) {
    eval("10 2.0 +");
    eval("8 2 + 99 9 - * 2 + 9 -");
  }
}
