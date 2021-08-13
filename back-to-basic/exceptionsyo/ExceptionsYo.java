package exceptionsyo;

class MyException extends Exception {
  final String message;

  public MyException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return this.message;
  }
}

public class ExceptionsYo {

  public static void throwingException(String name) throws MyException {
    if (name.equals("Sherlock Holmes")) {
      System.out.println("My name is Sherlock Holmes");
    } else {
      throw new MyException("I don't know you");
    }
  }

  public static void main(String[] args) {
    try {
      throwingException("John Watson");
      throwingException("Sherlock Holmes");
    } catch (MyException e) {
      System.out.println(e.getMessage());
    }
  }
}