package school;

import java.util.Scanner;

public class Quiz4_2 {
  public static void main(String[] args) {
    // 키보드로부터 정수 2개를 입력 받기
    Scanner scan = new Scanner(System.in);
    System.out.println("M값을 입력하세요");
    int M = scan.nextInt();
    System.out.println("N값을 입력하세요");
    int N = scan.nextInt();
    scan.close();

    // M < N 일 경우 M에서 N까지 정수 출력
    String strout = "";
    if (M < N) {
      System.out.printf("M : %d ~ N : %d사이 정수 값은\n", M, N);
      while (M <= N) {
        strout += M + ", ";
        M++;
      }
      System.out.println(strout.substring(0, strout.length() - 2));
      System.out.println("----감사합니다----");
    }

    // M > N 일 경우 N에서 M까지 정수 출력
    else if (M > N) {
      System.out.printf("N : %d ~ M : %d사이 정수 값은\n", N, M);
      while (M >= N) {
        strout += M + ", ";
        M--;
      }
      System.out.println(strout.substring(0, strout.length() - 2));
      System.out.println("----감사합니다----");
    }

    // M == N 일 경우 입력 값 출력
    else if (M == N) {
      System.out.printf("N, M 정수 값 : %d", M);
      System.out.println("\n----감사합니다----");
    }
  }
}
