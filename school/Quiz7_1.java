package school;

import java.util.Arrays;

public class Quiz7_1 {
  public static void main(String[] args) {
    // 정수형 5 X 5 배열 선언
    int[][] arr = new int[5][5];

    // 1 ~ 50 난수 생성 및 1차원 배열에 중복 없이 저장
    int[] rand_arr = new int[(arr.length * arr[0].length)];
    for (int i = 0; i < rand_arr.length; i++) {
      rand_arr[i] = (int) ((Math.random() * 50) + 1);
      for (int j = 0; j < i; j++) {
        if (rand_arr[i] == rand_arr[j]) {
          i--;
        }
      }
    }

    // 2차원 배열에 저장
    for (int i = 0, k = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = rand_arr[k++];
      }
    }

    // 행 최소, 최대, 중간값 구하기
    int[][] row_arr = new int[arr.length][arr[0].length];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        row_arr[i][j] = arr[i][j];
      }
      Arrays.sort(row_arr[i]);
    }

    // 열 최소, 최대, 중간값 구하기
    int[][] col_arr = new int[arr.length][arr[0].length];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        col_arr[i][j] = arr[j][i];
      }
      Arrays.sort(col_arr[i]);
    }

    // 전체 최소, 최대, 중간값 구하기

    // 5 * 5 배열과 행 최소, 최대, 중간값 print
    String[] print = { "최소값", "", "최대값", "", "중간값" };
    System.out.printf("\t".repeat(7) + "%s\t%s\t%s\n", print[0], print[2], print[4]);
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print("\t" + arr[i][j]);
      }
      System.out.printf("\t\t%d\t%d\t%d\n", row_arr[i][0], row_arr[i][4], row_arr[i][2]);
    }
    System.out.println();

    // 열 최소, 최대, 중간값 print
    for (int i = 0; i < arr.length; i++) {
      if (i == 0) {
        System.out.print(print[i]);
        for (int j = 0; j < arr[i].length; j++) {
          System.out.printf("\t%d", col_arr[j][i]);
        }
        System.out.println();
      } else if (i == 4) {
        System.out.print(print[i]);
        for (int j = 0; j < arr[i].length; j++) {
          System.out.printf("\t%d", col_arr[j][2]);
        }
        System.out.println();
      } else if (i == 2) {
        System.out.print(print[i]);
        for (int j = 0; j < arr[i].length; j++) {
          System.out.printf("\t%d", col_arr[j][4]);
        }
        System.out.println();
      }
    }
    System.out.println();

    // 전체 최소, 최대, 중간값 print
    Arrays.sort(rand_arr);
    System.out.printf("%s\t%d\n", print[0], rand_arr[0]);
    System.out.printf("%s\t%d\n", print[4], rand_arr[(rand_arr.length - 1) / 2]);
    System.out.printf("%s\t%d\n", print[2], rand_arr[rand_arr.length - 1]);
  }
}
