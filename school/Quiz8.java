package first.school;

import java.util.Scanner;

public class Quiz8 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    // 2 ~ 10 사이의 값 받기
    int inputInt = 0;
    while (true) {
      System.out.println("행렬 N의 크기를 입력하세요: (2~10)");
      inputInt = scan.nextInt();
      if (inputInt >= 2 && inputInt <= 10) {
        break;
      }
    }

    // 행렬 방향 결정 (1: 시계, 2: 반시계):
    int rightLeft = 0;
    while (true) {
      System.out.println("달팽이 행렬 생성 방향은(1: 시계, 2: 반시계):");
      rightLeft = scan.nextInt();
      if (rightLeft >= 1 && rightLeft <= 2) {
        break;
      }
    }

    // N 값 배열 2차원 생성
    int[][] arr = new int[inputInt][inputInt];

    // 시계 달팽이 알고리즘
    if (rightLeft == 1) {
      int count = 1;
      int row = -1;
      int col = 0;
      int ck = 1;
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
    } else if (rightLeft == 2) {
      int count = 1;
      int row = 0;
      int col = -1;
      int ck = 1;
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

    // print
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + "\t");
      }
      System.out.println();
    }
    scan.close();
  }
}
