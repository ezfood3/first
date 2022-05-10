package test;

public class modifier2 extends modifier {
  public static void main(String[] args) {
    modifier2 obj = new modifier2();

    System.out.println(obj.public_value);
    System.out.println(obj.protected_value);
    System.out.println(obj.default_value);
    // System.out.println(obj.private_value);

  }
}
