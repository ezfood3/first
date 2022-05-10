package school;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Quiz3_2Re {
  public static void main(String[] args) {
    // 성적 저장 2차원 배열 선언
    int[][] arr = new int[5][8];
    int count = 1;
    Menu menu = new Menu();
    Scanner scan = new Scanner(System.in);
    while (true) {

      // 메뉴 출력
      menu.print();
      int inputMenu = scan.nextInt();

      // 1 입력시 성적 입력 기능 구현

      if (inputMenu == 1) {

        int[] inputArr = new int[8];

        System.out.println("학번을 입력 하세요:");
        inputArr[1] = scan.nextInt();
        for (int i = 0; i < arr.length; i++) {
          if (arr[i][1] == inputArr[1]) {
            System.out.println("중복된 학번 입니다. 재입력 합니다.");
            for (int j = 0; j < arr.length; j++) {
              arr[i][j] = 0;
            }
            break;
          }
        }

        System.out.println("국어 성적을 입력 하세요");
        inputArr[2] = scan.nextInt();
        System.out.println("영어 성적을 입력 하세요");
        inputArr[3] = scan.nextInt();
        System.out.println("수학 성적을 입력 하세요");
        inputArr[4] = scan.nextInt();
        // sum
        inputArr[5] = inputArr[2] + inputArr[3] + inputArr[4];
        // age
        inputArr[6] = inputArr[5] / 3;
        System.out.println("입력 값 :");
        System.out.printf("학번 : %d 국어 : %d 영어 : %d 수학 :%d 총점 : %d 평균 : %d ", inputArr[1], inputArr[2], inputArr[3],
            inputArr[4], inputArr[5], inputArr[6]);
        System.out.println();
        inputArr[0] = count;

        for (int i = 0; i < inputArr.length; i++) {
          arr[count - 1][i] = inputArr[i];
        }

        if (count < 5) {
          count++;
        }
      } else if (inputMenu == 2) {
        // 2입력시 전체성적 출력 기능 구현
        Arrays.sort(arr, new Comparator<int[]>() {

          @Override
          public int compare(int[] o1, int[] o2) {
            return o2[6] - o1[6];
          }
        });

        // 순위 구하기
        int rank = 1;
        for (int i = 0; i < arr.length; i++) {
          if (i == 0) { // 순위 1등
            arr[i][7] = rank;
          } else {
            if (arr[i][6] == arr[i - 1][6]) { // 전 사람과 평균이 같으면
              arr[i][7] = rank;
            } else { // 전 사람과 평균이 다르면
              arr[i][7] = ++rank;
            }
          }
        }
        System.out.println("입력순번\t학번\t국어\t영어\t수학\t총점\t평균\t순위");
        for (int i = 0; i < arr.length; i++) {
          for (int j = 0; j < arr[i].length; j++) {
            System.out.print("\t" + arr[i][j]);
          }
          System.out.println();
        }
      } else if (inputMenu == 3) {
        // 학생 조회 후 출력 기능 구현
        int play = 1;
        while (play <= 3) {
          System.out.println("검색 할 학생의 학번을 입력 하세요");
          int schoolNum = scan.nextInt();
          for (int i = 0; i < arr.length; i++) {
            if (arr[i][1] == schoolNum) {
              System.out.println("입력순번\t학번\t국어\t영어\t수학\t총점\t평균\t순위");

              for (int j = 0; j < arr[i].length; j++) {
                System.out.print("\t" + arr[i][j]);
              }
              System.out.println();
              play = 4;
              break;
            }
            if (i >= 4) {
              System.out.println("입력하신 학번은 없는 학번입니다. 다시 입력하세요.");
              play++;
            }
          }
        }
      } else if (inputMenu == 4) {
        scan.close();
        break;
      }
    }
  }
}

class Menu {
  void print() {
    System.out.println("--------------------");
    System.out.println("1. 성적 입력");
    System.out.println("2. 전체 성적 출력 (평균 기준 내림차순)");
    System.out.println("3. 학생 조회 후 출력");
    System.out.println("4. 종료");
    System.out.println("--------------------");
    System.out.print("메뉴 선택 : ");
  }
}
