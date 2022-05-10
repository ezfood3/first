package first.school;

import java.util.Scanner;

public class Quiz4_2Re {
  public static void main(String[] args) {
    // 키보드로부터 정수 2개 입력받기
    Scanner scan = new Scanner(System.in);
    System.out.println("M값을 입력하세요");
    int M = scan.nextInt();
    System.out.println("N값을 입력하세요");
    int N = scan.nextInt();
    scan.close();

    // M < N 일 경우 M 에서 N 까지 정수 출력하기 (오름차순)
    String outString = "";
    if (M < N) {
      System.out.printf("M : %d ~ N ; %d사이 정수 값은\n", M, N);
      while (M <= N) {
        outString += M + ", ";
        M++;
      }
      System.out.println(outString.substring(0, outString.length() - 2));
      System.out.println("-----ありがとうございます-----");
    }
    // M > N 일 경우 N 에서 M 까지 정수 출력하기 (내림차순)
    else if (M > N) {
      System.out.printf("N : %d ~ M : %d사이 정수 값은\n", N, M);
      while (N <= M) {
        outString += M + ", ";
        M--;
      }
      System.out.println(outString.substring(0, outString.length() - 2));
      System.out.println("-----ありがとうございます-----");
    }
    // M = N 일 경우 정수 값 출력
    else if (M == N) {
      System.out.printf("N, M 정수 값 : %d\n", M);
      System.out.println("-----ありがとうございます-----");
    }

  }
}
