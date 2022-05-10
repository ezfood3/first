package school;

public class Quiz7_1Re {
  public static void main(String[] args) {
    // 정수형 5 * 5 2차원 배열 선언
    int[][] arr = new int[5][5];

    // 2차원 배열에 1 ~ 50 사이의 중복되지 않은 난수 저장
    // 1차원 배열에 중복없는 난수 저장
    int[] rand_arr = new int[arr.length * arr[0].length];
    for (int i = 0; i < rand_arr.length; i++) {
      rand_arr[i] = (int) ((Math.random() * 50) + 1);
      for (int j = 0; j < i; j++) {
        if (rand_arr[i] == rand_arr[j]) {
          i--;
        }
      }
    }

    // 1차원 배열 -> 2차원 배열
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = rand_arr[count++];
      }
    }

    Sortarr sort = new Sortarr();
    // 행 최대, 최소, 중간값 구하기 및 출력
    System.out.println("\t\t\t\t\t\t\t최소값\t최대값\t중간값");

    for (int i = 0; i < arr.length; i++) {
      int[] sort_arr = new int[arr.length];
      for (int j = 0; j < arr[i].length; j++) {
        sort_arr[j] = arr[i][j];
        System.out.print("\t" + sort_arr[j]);
      }
      // sort
      sort.sort(sort_arr);
      // print
      System.out.printf("\t\t%d\t%d\t%d\n", sort_arr[0], sort_arr[sort_arr.length - 1], sort_arr[sort_arr.length / 2]);
    }

    int[][] col_arr = new int[arr.length][arr[0].length];
    // 열 최대, 최소, 중간값 구하기
    for (int i = 0; i < arr.length; i++) {
      int[] sort_arr = new int[arr.length];
      for (int j = 0; j < arr[i].length; j++) {
        sort_arr[j] = arr[j][i];
      }
      // sort
      sort.sort(sort_arr);
      for (int j = 0; j < arr[i].length; j++) {
        col_arr[i][j] = sort_arr[j];
      }
    }
    System.out.println();

    // arr -> String
    String[] print = new String[arr.length];
    for (int i = 0; i < arr.length; i++) {
      if (i == 0) {
        print[i] = "최소값";
        for (int j = 0; j < arr.length; j++) {
          print[i] += ("\t" + col_arr[j][i]);
        }
      } else if (i == 4) {
        print[i] = "최대값";
        for (int j = 0; j < arr.length; j++) {
          print[i] += ("\t" + col_arr[j][i]);
        }
      } else if (i == 2) {
        print[i] = "중간값";
        for (int j = 0; j < arr.length; j++) {
          print[i] += ("\t" + col_arr[j][i]);
        }
      }
    }
    // print
    System.out.println(print[0]);
    System.out.println(print[4]);
    System.out.println(print[2]);
    System.out.println();

    // 전체 최대, 최소, 중간값 구하기
    sort.sort(rand_arr);
    System.out.printf("최소값\t%d\n최대값\t%d\n중간값\t%d\n", rand_arr[0], rand_arr[rand_arr.length - 1],
        rand_arr[rand_arr.length / 2]);

  }
}

// sort class
class Sortarr {
  int[] sort(int[] sort_arr) {
    for (int i = 0; i < sort_arr.length; i++) {
      for (int j = 0; j < i; j++) {
        if (sort_arr[i] < sort_arr[j]) {
          int tmp = sort_arr[i];
          sort_arr[i] = sort_arr[j];
          sort_arr[j] = tmp;
        }
      }
    }
    return sort_arr;
  }
}