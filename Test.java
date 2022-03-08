import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    GuGuDan GD = new GuGuDan();
    Scanner scan = new Scanner(System.in);
    int input = 0;
    while (true) {
      GD.print();
      input = scan.nextInt();
      if (input == 1) {
        while (true) {
          System.out.println("출력할 단을 입력하세요. 2~9 까지 입력");
          input = scan.nextInt();
          if (input > 1 && input < 10) {
            GD.play(input);
            break;
          } else {
            System.out.println("다시 입력해주세요. 2~9 입니다.");
          }
        }
      } else if (input == 2){
        return;
      }else{
        System.out.println("다시 입력해주세요.");
      }
    }
  }
}

class GuGuDan {
  void print() {
    System.out.println("----------");
    System.out.println("1. 구구단 실행");
    System.out.println("2. 프로그램 종료");
    System.out.println("----------");
  }

  void play(int dan) {
    for (int i = 1; i <= 9; i++) {
      System.out.printf("%d X %d = %d\n", dan, i, i * dan);
    }
  }
}