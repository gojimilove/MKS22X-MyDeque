public class Calculator{
  /*Evaluate a postfix expression stored in s.
  *Assume valid postfix notation, separated by spaces.
  */
  public static double eval(String s){
    MyDeque<Integer> tokens = new MyDeque<>(s.length());
    String[] elements = s.split(" ");
    for (int i = 0; i < elements.length; i++) {
      System.out.println(elements[i]);
      //if its an integer add it to the Deque
      //if its an operator pop last 2 elements of deque and add a new one
    }
    //return tokens.getLast();
    return -1;
  }

  public static void main(String[] args) {
    eval("10 2.0 +");
  }
}
