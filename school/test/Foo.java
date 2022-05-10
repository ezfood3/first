package first.school.test;

import first.school.test2.Apple;

class bar extends Apple {
  protected void prtColor() {
    super.prtColor();
    System.out.println("bar's color");
  }

  void test() {
    this.value = 30;
    System.out.println(value);
  }
}

public class Foo {

  public static void main(String[] args) {
    // Apple obj = new Apple();
    // obj.prtColor();
    bar obj2 = new bar();
    obj2.prtColor();
    obj2.test();
  }
}
