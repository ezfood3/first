package school;

import java.util.Scanner;

public class Quiz8Re {
  public static void main(String[] args) {
    // N값 2 ~ 10 사이의 값 받기, 다른 값은 예외 처리
    Scanner scan = new Scanner(System.in);
    int inputInt = 0;
    while (true) {
      System.out.println("행렬 N의 크기를 입력하세요:");
      inputInt = scan.nextInt();
      if (2 <= inputInt && inputInt <= 10) {
        System.out.println("\n===============================");
        break;
      }
      System.out.println("\n===============================");
    }

    // N 값 배열 2차원 생성
    int[][] arr = new int[inputInt][inputInt];

    // 행렬 방향 결정 (1: 시계, 2: 반시계)
    int clock = 0;
    while (true) {
      System.out.println("\n달팽이 행렬의 생성 방향은?(1:시계, 2:반시계):");
      clock = scan.nextInt();
      if (1 <= clock && clock <= 2) {
        break;
      }
      System.out.println("\n-------------------------------\n");
    }

    // 시계 달팽이 알고리즘
    switch (clock) {
      // 시계 방향 달팽이 배열 만들기
      case 1: {
        int count = 1, row = -1, col = 0, ck = 1;
        for (int i = inputInt; i > 0; i--) {
          for (int j = 0; j < inputInt; j++) {
            row = row + ck;
            arr[col][row] = count++;
          }
          inputInt--;
          for (int j = 0; j < inputInt; j++) {
            col = col + ck;
            arr[col][row] = count++;
          }
          ck = ck * -1;
        }
      }
        break;
      // 반시계 방향 달팽이 배열 만들기
      case 2: {
        int count = 1, row = 0, col = -1, ck = 1;
        for (int i = inputInt; i > 0; i--) {
          for (int j = 0; j < inputInt; j++) {
            col = col + ck;
            arr[col][row] = count++;
          }
          inputInt--;
          for (int j = 0; j < inputInt; j++) {
            row = row + ck;
            arr[col][row] = count++;
          }
          ck = ck * -1;
        }
      }
        break;
    }
    // print
    System.out.println("\n-------------------------------\n");
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + "\t");
      }
      System.out.println();
    }
    scan.close();
  }
}
