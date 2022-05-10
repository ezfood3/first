package first.school;

import java.util.Scanner;

public class Test1Re {
  public static void main(String[] args) {
    // 중간고사 1번 refactoring

    // 사용자로 부터 정수 N값 입력받기 (3 ~ 5사이, 아니면 재입력 받기)
    Scanner scan = new Scanner(System.in);
    Sort2 st = new Sort2();

    int input_int = 0;
    while (true) {
      System.out.println("정수 N을 입력하세요");
      input_int = scan.nextInt();
      if (input_int >= 3 && input_int <= 5) {
        break;
      }
    }

    // 정수형 N X N 2차원 배열 선언
    int[][] arr = new int[input_int][input_int];

    // 선언된 2차원 배열 내애 -10 ~ 30 사이의 중복없는 난수 저장
    // 중복없는 1차원 배열 만들기
    int[] sort_arr = new int[input_int * input_int];
    for (int i = 0; i < sort_arr.length; i++) {
      sort_arr[i] = (int) (Math.random() * 41) - 10;
      for (int j = 0; j < i; j++) {
        if (sort_arr[i] == sort_arr[j]) {
          i--;
        }
      }
    }
    // 1차원 배열 -> 2차원 배열
    for (int i = 0, k = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = sort_arr[k++];
      }
    }

    // 포맷
    for (int i = 0; i < arr.length; i++) {
      System.out.print("\t");
    }
    System.out.println("\t\t\t최소값\t최대값\t중간값");

    // 각 열 최소, 최대, 중간값 찾아서 출력
    for (int i = 0; i < arr.length; i++) {
      int[] row_arr = new int[arr.length];
      // sort
      for (int j = 0; j < arr[i].length; j++) {
        row_arr[j] = arr[i][j];
      }
      st.sort(row_arr);
      // print
      System.out.print("\t");
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print("\t" + arr[i][j]);
      }
      System.out
          .println(
              "\t\t" + row_arr[0] + "\t" + row_arr[row_arr.length - 1] + "\t" + row_arr[(row_arr.length - 1) / 2]);
    }
    System.out.println();

    // 각 대각선 최소, 최대, 중간값 찾기
    String[] col_print = new String[3];
    col_print[0] = "최소값\t";
    col_print[1] = "최대값\t";
    col_print[2] = "중간값\t";

    int[] dia_arr = new int[arr.length];
    // 대각선 오른쪽위 -> 왼쪽아래
    for (int i = 0, j = arr[i].length - 1; i < arr.length; i++, j--) {
      dia_arr[i] = arr[i][j];
    }
    st.sort(dia_arr);
    col_print[0] += dia_arr[0] + "\t";
    col_print[1] += dia_arr[dia_arr.length - 1] + "\t";
    col_print[2] += dia_arr[(dia_arr.length - 1) / 2] + "\t";

    // 각 행 최소, 최대, 중간값 찾기
    for (int i = 0; i < arr.length; i++) {
      int[] col_arr = new int[arr.length];
      for (int j = 0; j < arr[i].length; j++) {
        col_arr[j] = arr[j][i];
      }
      st.sort(col_arr);
      for (int j = 0; j < arr[i].length; j++) {
        if (j == 0) {
          col_print[0] += col_arr[0] + "\t";
        } else if (j == col_arr.length - 1) {
          col_print[1] += col_arr[col_arr.length - 1] + "\t";
        } else if (j == (col_arr.length - 1) / 2) {
          col_print[2] += col_arr[(col_arr.length - 1) / 2] + "\t";
        }
      }
    }
    // 대각선 왼쪽위 -> 오른쪽 아래
    for (int i = 0, j = 0; i < arr.length; i++, j++) {
      dia_arr[i] = arr[i][j];
    }
    st.sort(dia_arr);
    col_print[0] += "\t" + dia_arr[0] + "\t" + dia_arr[dia_arr.length - 1] + "\t" + dia_arr[(dia_arr.length - 1) / 2];

    for (int i = 0; i < col_print.length; i++) {
      System.out.println(col_print[i]);
    }
    System.out.println();

    // N X N 2차원 배열 전체를 기준으로 구간별 숫자 발생 빈도 히스토그램 출력
    String[] histo = new String[4];
    histo[0] = "-10 ~ 0 : ";
    histo[1] = " 1 ~ 10 : ";
    histo[2] = "11 ~ 20 : ";
    histo[3] = "21 ~ 30 : ";

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] >= -10 && arr[i][j] <= 0) {
          histo[0] += "*";
        } else if (arr[i][j] >= 1 && arr[i][j] <= 10) {
          histo[1] += "*";
        } else if (arr[i][j] >= 11 && arr[i][j] <= 20) {
          histo[2] += "*";
        } else if (arr[i][j] >= 21 && arr[i][j] <= 30) {
          histo[3] += "*";
        }
      }
    }
    System.out.println("\t\t구간별 발생 빈도");
    for (int i = 0; i < histo.length; i++) {
      System.out.println(histo[i]);
    }
    scan.close();
  }
}

class Sort2 {
  int[] sort(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i] < arr[j]) {
          int value = arr[i];
          arr[i] = arr[j];
          arr[j] = value;
        }
      }
    }
    return arr;
  }
}