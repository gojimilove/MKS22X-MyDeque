public class Calculator{
  /*Evaluate a postfix expression stored in s.
  *Assume valid postfix notation, separated by spaces.
  */
  public static double eval(String s){
    MyDeque<String> tokens = new MyDeque<>(s.length());
    for (int i = 0; i < s.length(); i++) {
      String token = "";
    }
  }

  public static void main(String[] args) {
    eval("10 2.0 +");
  }
}
