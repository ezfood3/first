package school;

public class Quiz4_1 {
  public static void main(String[] args) {
    // 구구단 출력 (15점)
    for (int i = 2; i <= 9; i++) {
      for (int j = 1; j <= 9; j++) {
        if (i % 2 == 0) {
          System.out.printf("%d X %d = %d\t", i, j, i * j);
          if (j % 3 == 0) {
            System.out.println();
          }
        }
      }
      System.out.println();
    }

    // 짝수단 출력 구현 시, “% 연산자를 이용하여 구현 할 것!”
    // 출력 포맷 준수, 하드코딩 점수 없음, 반복문 안에 로직을 만들어 작성
  }
}
