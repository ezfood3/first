package first.school;

import java.util.Scanner;

public class Quiz6 {
  public static void main(String[] args) {
    // 중복없는 난수 3개 생성 (0 ~ 9)
    int[] rand_arr = new int[3];
    for (int i = 0; i < rand_arr.length; i++) {
      rand_arr[i] = (int) (Math.random() * 10);
      for (int j = 0; j < i; j++) {
        if (rand_arr[i] == rand_arr[j]) {
          i--;
        }
      }
    }

    // 사용자로부터 3개 정수 입력받기
    Scanner scan = new Scanner(System.in);
    int play_count = 1, out_count = 0;
    strPrint sp = new strPrint();
    while (true) {
      System.out.printf("시도 횟수: %d\n", play_count);
      System.out.println("정수 3개를 입력하세용~~~ ^__^");
      String[] inputStr_arr = scan.nextLine().split(" ");

      // str -> int
      int[] inputInt_arr = new int[inputStr_arr.length];
      for (int i = 0; i < inputStr_arr.length; i++) {
        inputInt_arr[i] = Integer.parseInt(inputStr_arr[i]);
      }

      // 스트라이크, 볼, 아웃 판별하기
      int strike = 0, ball = 0, out = 0;
      for (int i = 0; i < rand_arr.length; i++) {
        for (int j = 0; j < inputInt_arr.length; j++) {
          if (rand_arr[i] == inputInt_arr[j] && i == j) {
            strike++;
            break;
          } else if (rand_arr[i] == inputInt_arr[j]) {
            ball++;
            break;
          } else {
            out++;
          }
        }
      }

      // 시도횟수, 스트라이크, 볼, 아웃 출력하기
      if (out == 9) {
        out_count++;
        System.out.printf("Out: 아웃 %d번\n", out_count);
      } else if (strike >= 1 || ball >= 1) {
        System.out.printf("%d Strike %d Ball\n", strike, ball);
      } else if (strike >= 1 || ball == 0) {
        System.out.printf("%d Strike\n", strike);
      } else if (strike == 0 || ball >= 1) {
        System.out.printf("%d Ball\n", ball);
      }
      play_count++;

      // 게임결과 출력하기 + 정답
      if (strike == 3) {
        sp.print_win(rand_arr[0], rand_arr[1], rand_arr[2]);
        break;
      } else if (play_count == 5) {
        sp.count_lose(rand_arr[0], rand_arr[1], rand_arr[2]);
        break;
      } else if (out_count == 2) {
        sp.strike_lose(rand_arr[0], rand_arr[1], rand_arr[2]);
        break;
      }
    }
    scan.close();
  }
}

// print class
class strPrint {
  void print_win(int rand1, int rand2, int rand3) {
    System.out.println("Home Run !!!");
    System.out.println("정답입니다~~~");
    System.out.printf("정답은: %d %d %d 입니다.\n", rand1, rand2, rand3);
    System.out.println("계속하려면 아무 키나 누르십시오 . . .");
  }

  void strike_lose(int rand1, int rand2, int rand3) {
    System.out.println("Strike Out !!!");
    System.out.println("아까비~~~졌네용...");
    System.out.printf("정답은: %d %d %d 입니다.\n", rand1, rand2, rand3);
    System.out.println("계속하려면 아무 키나 누르십시오 . . .");
  }

  void count_lose(int rand1, int rand2, int rand3) {
    System.out.println("게임횟수 초과 !!!");
    System.out.println("아까비~~~졌네용...");
    System.out.printf("정답은: %d %d %d 입니다.\n", rand1, rand2, rand3);
    System.out.println("계속하려면 아무 키나 누르십시오 . . .");
  }
}
