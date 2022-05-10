package first.school;

import java.util.Arrays;

public class Quiz3_1 {
  public static void main(String[] args) {
    // 8 * 8 배열 생성
    char[][] arr = new char[8][8];

    // A - Z 중 알파벳 하나를 골라 배열에 저장 및 화면에 출력
    // Loop 1 -> 64
    System.out.println("8 X 8, 알파벳 발생 결과");
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        int rand = ((int) (Math.random() * 26));
        char team = 'a';
        team = (char) (team + rand);
        arr[i][j] = team;
        System.out.print("\t" + arr[i][j]);
      }
      ;
      System.out.println();
    }

    // 최소 발생 알파벳, 횟수 출력
    int[] alpha = new int[26];
    // 발생 빈도 구하기 (새로운 배열에 카운팅)
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        int index = ((int) (arr[i][j]) - (int) 'a');
        alpha[index]++;
      }
    }
    // 최소 발생 알파벳 구하기
    int min = 100; // 최소
    int count = 0; // 최소 알파벳 개수
    // 최소변수 구하기
    for (int i = 0; i < alpha.length; i++) {
      if (alpha[i] < min && alpha[i] != 0) {
        min = alpha[i];
      }
    }

    // count
    for (int i = 0; i < alpha.length; i++) {
      if (alpha[i] == min) {
        count++;
      }
    }
    // print
    System.out.println("최소 발생 알파벳");
    System.out.println("- 발생 빈도 : " + min);
    System.out.println("- 중복 알파벳 개수 : " + count);
    System.out.print("- 알파벳 : ");
    for (int i = 0; i < alpha.length; i++) {
      if (alpha[i] == min) {
        char team = 'a';
        System.out.print((char) (team + i) + ", ");
      }
    }
    System.out.println();

    // 최대 발생 알파벳, 횟수 출력
    int max = 0;
    count = 0;
    for (int i = 0; i < alpha.length; i++) {
      if (alpha[i] > max) {
        max = alpha[i];
      }
    }
    // count
    for (int i = 0; i < alpha.length; i++) {
      if (alpha[i] == max) {
        count++;
      }
    }
    // print
    System.out.println("최대 발생 알파벳");
    System.out.println("- 발생 빈도 : " + max);
    System.out.println("- 중복 알파벳 개수 : " + count);
    System.out.print("- 알파벳 : ");
    for (int i = 0; i < alpha.length; i++) {
      if (alpha[i] == max) {
        char team = 'a';
        System.out.print((char) (team + i) + ", ");
      }
    }
    System.out.println();

    // a -> z 오름차순 정렬 후 출력
    int[] sortarr = new int[64]; // 1차원 배열 생성
    count = 0; // count
    // 2차원 배열 -> 1차원 배열
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        sortarr[count] = (arr[i][j]);
        count++;
      }
    }
    // sort
    Arrays.sort(sortarr);

    count = 0;
    // 1차원 배열 -> 2차원 배열
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        arr[i][j] = (char) (sortarr[count]);
        System.out.print("\t" + arr[i][j]);
        count++;
      }
      // print
      System.out.println();
    }
  }
}
