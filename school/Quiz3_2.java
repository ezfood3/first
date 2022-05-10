package school;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Quiz3_2 {
  public static void main(String[] args) {
    // 2.1 학생 성적을 저장할 2차원 배열 선언
    int[][] arr = new int[5][8];
    int count = 0;

    while (true) {
      // 2.2 메뉴 출력

      System.out.println("---------------");
      System.out.println("1. 성적 입력");
      System.out.println("2. 전체 성적 출력 (평균 기준 오름차순)");
      System.out.println("3. 학생 조회 후 출력");
      System.out.println("4. 종료");
      System.out.println("---------------");
      System.out.print("메뉴 선택 : ");
      // 2.3 키보드로부터 1 입력 시“1. 성적 입력” 기능 구현
      // 키보드로 부터 입력받기
      Scanner scan = new Scanner(System.in);
      int inputMenu = scan.nextInt();

      // 1 입력 시“1. 성적 입력” 기능 구현

      if (inputMenu == 1) {
        int[] inputArr = new int[8];
        count++;
        inputArr[0] = count;
        System.out.println("학번을 입력 하세요:");
        inputArr[1] = scan.nextInt();
        System.out.println("국어 성적을 입력 하세요");
        inputArr[2] = scan.nextInt();
        System.out.println("영어 성적을 입력 하세요");
        inputArr[3] = scan.nextInt();
        System.out.println("수학 성적을 입력 하세요");
        inputArr[4] = scan.nextInt();
        inputArr[5] = inputArr[2] + inputArr[3] + inputArr[4];
        inputArr[6] = inputArr[5] / 3;
        System.out.println("입력 값 :");
        System.out.printf("학번 : %d 국어 : %d 영어 : %d 수학 : %d 총점 : %d 평균 : %d\n", inputArr[1], inputArr[2], inputArr[3],
            inputArr[4], inputArr[5], inputArr[6]);
        // 배열에 추가

        for (int i = 0; i < inputArr.length; i++) {
          arr[count - 1][i] = inputArr[i];
        }
      }

      // 2.4 키보드로부터 2 입력 시“2. 전체 성적 출력” 기능 구현
      // 평균을 기준으로 내림차순
      else if (inputMenu == 2) {
        Arrays.sort(arr, new Comparator<int[]>() {

          @Override
          public int compare(int[] o1, int[] o2) {
            return o2[6] - o1[6];
          }
        });
        // 순위 입력하기
        int rank = 1;
        for (int i = 0; i < arr.length; i++) {
          if (i == 0) { // 순위 1등
            arr[i][7] = rank;
          } else {
            if (arr[i][6] == arr[i - 1][6]) { // 전 사람과 평균이 같으면
              arr[i][7] = rank;
            } else { // 전 사람과 평균이 다르면
              rank++;
              arr[i][7] = rank;
            }
          }
        }

        // 출력하기
        System.out.println("입력순번\t학번\t국어\t영어\t수학\t총점\t평균\t순위");
        for (int i = 0; i < arr.length; i++) {
          for (int j = 0; j < arr[i].length; j++) {
            System.out.print("\t" + arr[i][j]);
          }
          System.out.println();
        }
      }

      // 2.5 키보드로부터 3 입력시 “3. 학생 조회 후 출력” 기능구현

      else if (inputMenu == 3) {
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
      }

      // 2.6 키보드로부터 4 입력 시“4. 프로그램 종료” 기능 구현
      else if (inputMenu == 4) {
        scan.close();
        break;
      }
      scan.close();
    }
  }
}
