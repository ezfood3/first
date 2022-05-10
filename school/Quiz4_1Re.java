
package school;

public class Quiz4_1Re {
  public static void main(String[] args) {
    // 구구단 출력하기
    // 짝수단 출력 구현시 % 연산자 이용
    // X * Y 에서 X 반복문 만들기 (2 ~ 9 단)
    for (int i = 2; i <= 9; i++) {
      // X * Y 에서 Y 반복문 만들기 (1 ~ 9 곱하기)
      for (int j = 1; j <= 9; j++) {
        // 짝수단 만 출력하게 조건문 작성
        if (i % 2 == 0) {
          // print
          System.out.printf("%d X %d = %d\t", i, j, i * j);
          // 3번 반복하고 줄바꿈
          if (j % 3 == 0) {
            System.out.println();
          }
        }
      }
      // 단 끝나고 줄바꿈
      System.out.println();
    }
  }
}
