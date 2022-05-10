package first.school.test2;

import first.school.test.modifier;

public class modifier1 extends modifier {

  public static void main(String[] args) {
    modifier1 obj = new modifier1();

    System.out.println(obj.public_value);
    System.out.println(obj.protected_value);
    // System.out.println(obj.default_value);
    // System.out.println(obj.private_value);
  }
}