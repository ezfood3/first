package test2;

import test.modifier;

public class modifier1 extends modifier {

  public static void main(String[] args) {
    modifier1 obj = new modifier1();

    System.out.println(obj.public_value);
    System.out.println(obj.protected_value);
    // System.out.println(obj.default_value);
    // System.out.println(obj.private_value);
  }
}