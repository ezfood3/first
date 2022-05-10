package first.school;

import java.util.Scanner;

public class Quiz10 {
  public static void main(String[] args) {
    // 키보드로 부터 정수 N을 입력받기 (2 <= N <= 8)
    int inVal = 0;
    Scanner scan = new Scanner(System.in);
    while (true) {
      System.out.print("정수 N을 입력하시오.(2 ~ 8): ");
      inVal = scan.nextInt();
      if (2 <= inVal && inVal <= 8) {
        break;
      }
    }

    // N X N 매트릭스 생성
    int[][] arr = new int[inVal][inVal];

    // 1 ~ N X N 까지 원소 초기화 (중복 X)
    int count = 1;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        arr[i][j] = count++;
      }
    }
    // 매트릭스 출력
    printArr(arr);

    // 효과 실행
    while (true) {
      // 메뉴 출력
      printMenu();

      inVal = scan.nextInt();

      if (inVal == 1) { // 오른쪽 90도
        arr = right(arr);
        printArr(arr);

      } else if (inVal == 2) { // 왼쪽 90도
        arr = left(arr);
        printArr(arr);

      } else if (inVal == 3) { // 상하
        arr = upDown(arr);
        printArr(arr);

      } else if (inVal == 4) { // 좌우
        arr = leftRight(arr);
        printArr(arr);

      } else if (inVal == 5) { // 종료
        scan.close();
        break;
      } else { // 나머지
        System.out.println("다시 입력해주세요.");
      }
    }
  }

  // Print Menu
  static void printMenu() {
    System.out.println("1) 오른쪽으로 90도 회전");
    System.out.println("2) 왼쪽으로 90도 회전");
    System.out.println("3) 상하반전");
    System.out.println("4) 좌우반전");
    System.out.println("5) 프로그램 종료");
  }

  // Print array
  static void printArr(int[][] arr) {
    for (int[] i : arr) {
      for (int j : i) {
        System.out.print(j + "\t");
      }
      System.out.println();
    }
  }

  // 효과 알고리즘
  // 오른쪽으로 90도 회전
  public static int[][] right(int[][] arr) {
    int[][] out_arr = new int[arr.length][arr[0].length];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        out_arr[i][j] = arr[arr.length - 1 - j][i];
      }
    }
    return out_arr;
  }

  // 왼쪽으로 90도 회전
  public static int[][] left(int[][] arr) {
    int[][] out_arr = new int[arr.length][arr[0].length];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        out_arr[i][j] = arr[j][arr.length - 1 - i];
      }
    }
    return out_arr;
  }

  // 상하반전
  public static int[][] upDown(int[][] arr) {
    int[][] out_arr = new int[arr.length][arr[0].length];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        out_arr[arr.length - 1 - i][j] = arr[i][j];
      }
    }
    return out_arr;
  }

  // 좌우반전
  public static int[][] leftRight(int[][] arr) {
    int[][] out_arr = new int[arr.length][arr[0].length];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        out_arr[i][arr.length - 1 - j] = arr[i][j];
      }
    }
    return out_arr;
  }
}
