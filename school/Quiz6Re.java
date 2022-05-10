package school;

import java.util.Scanner;

public class Quiz6Re {
  public static void main(String[] args) {
    // 0~9사이 정수 중복값 없는난수 3개생성
    int[] rand_arr = new int[3]; // random 배열
    Scanner scan = new Scanner(System.in);
    // 중복체크
    for (int i = 0; i < rand_arr.length; i++) {
      rand_arr[i] = (int) (Math.random() * 10);
      for (int j = 0; j < i; j++) {
        if (rand_arr[i] == rand_arr[j]) {
          i--;
        }
      }
    }

    // 시도 횟수 출력
    int play_count = 1, out = 0;
    while (true) {
      System.out.printf("시도횟수: %d\n", play_count++);

      // 키보드로부터 0~9사이 정수 3개 입력받기
      int[] input_arr = new int[3];
      System.out.println("정수 3개를 입력하세용~~^__^");
      input_arr[0] = scan.nextInt();
      input_arr[1] = scan.nextInt();
      input_arr[2] = scan.nextInt();

      // strike, ball, out 판별하기
      int strike = 0, ball = 0;
      for (int i = 0; i < rand_arr.length; i++) {
        for (int j = 0; j < input_arr.length; j++) {
          if (rand_arr[i] == input_arr[j]) {
            if (i == j) {
              strike++;
              break;
            } else {
              ball++;
              break;
            }
          }
        }
      }
      if (strike == 0 && ball == 0) {
        out++;
      }

      // print
      if (strike != 0 && ball != 0) {
        System.out.printf("%d Strike %d Ball\n", strike, ball);
      } else if (strike != 0 && ball == 0) {
        System.out.printf("%d Strike\n", strike);
      } else if (strike == 0 && ball != 0) {
        System.out.printf("%d Ball\n", ball);
      } else {
        System.out.printf("Out: 아웃 %d번\n", out);
      }

      // 게임결과, 정답 표시
      if (strike == 3) {
        System.out.println("정답입니다.");
        System.out.printf("정답은: %d %d %d 입니다.\n", rand_arr[0], rand_arr[1], rand_arr[2]);
        System.out.println("계속하려면 아무 키나 누르십시오 . . .");
        break;
      } else if (play_count >= 5) {
        System.out.println("게임횟수 초과");
        System.out.println("아까비~~~졌네용..");
        System.out.printf("정답은: %d %d %d 입니다.\n", rand_arr[0], rand_arr[1], rand_arr[2]);
        System.out.println("계속하려면 아무 키나 누르십시오 . . .");
        break;
      } else if (out == 2) {
        System.out.println("OUT!!");
        System.out.println("아까비~~~졌네용..");
        System.out.printf("정답은: %d %d %d 입니다.\n", rand_arr[0], rand_arr[1], rand_arr[2]);
        System.out.println("계속하려면 아무 키나 누르십시오 . . .");
        break;
      }
    }
    scan.close();
  }
}
