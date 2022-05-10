package test;

public class modifier {

  public int public_value = 2000;
  protected int protected_value = 200;
  int default_value = 20;
  private int private_value = 2;

  void get() {
    System.out.println(this.private_value);
  }

  public static void main(String[] args) {
    Test obj = new Test();

    System.out.println(obj.public_value);
    System.out.println(obj.protected_value);
    System.out.println(obj.default_value);
    // System.out.println(obj.private_value);
    System.out.println(obj.get());
  }
}

class Test {
  public int public_value = 1000;
  protected int protected_value = 100;
  int default_value = 10;
  private int private_value = 1;

  int get() {
    return this.private_value;
  }
}
