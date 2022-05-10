package school;

import java.util.*;

public class Quiz4_3 {
  public static void main(String[] args) {
    // 키보드로부터 양의 정수 하나(N)를 입력
    // 입력받은 N 값이 1이상 100이하의 값만 수용
    Scanner scan = new Scanner(System.in);
    int input = 0;
    while (true) {
      System.out.println("배열의 개수를 입력하세요.");
      input = scan.nextInt();
      if (input > 0 && input < 101) {
        break;
      }
      System.out.println("1이상, 100이하의 값을 입력하세요.");
    }
    scan.close();

    // N개 크기의 정수형 배열을 선언
    int[] arr = new int[input];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = 51;
    }

    // 선언된 배열 안에 “–50” ~ “50” 사이의 난수로 중복값 없이 채우기
    // -50 ~ 50 난수 생성하고 배열에 저장
    for (int i = 0; i < arr.length; i++) {
      while (true) {
        int randInput = (int) (Math.random() * 101);
        int count = 0;
        randInput -= 50;
        if (i == 0) {
          arr[i] = randInput;
          break;
        } else {
          for (int j = 0; j < arr.length; j++) {
            count = 0;
            if (arr[j] == randInput) {
              count++;
              break;
            }
          }
          if (count == 0) {
            arr[i] = randInput;
            break;
          }
        }
        if (i == arr.length) {
          break;
        }
      }
    }
    // MAX
    int max = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }

    // MIN
    int min = 51;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < min) {
        min = arr[i];
      }
    }

    // age
    double age = 0;
    for (int i = 0; i < arr.length; i++) {
      age += arr[i];
    }
    age = age / input;

    // string
    String outArr = "";
    for (int i = 0; i < arr.length; i++) {
      outArr += arr[i] + ", ";
    }
    // 최대값, 최소값, 평균값을 계산해서 출력
    System.out.println("배열의 개수 : " + input);
    System.out.println("배열 내 난수 값 : " + outArr.substring(0, outArr.length() - 2));
    System.out.println("최대값 : " + max);
    System.out.println("최소값 : " + min);
    System.out.println("평균값 : " + age);
    System.out.println();

    // 각 구간별 난수의 개수를 히스토그램으로 출력
    System.out.println("히스토그램");
    String[] histo = new String[10];
    for (int i = 0; i < 9; i++) {
      histo[i] = (-50 + (i * 10)) + " ~ " + (-41 + (i * 10) + " : ");
    }
    histo[9] = 40 + " ~ " + 50 + " : ";

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < arr.length; j++) {
        if (arr[j] >= -50 + (i * 10) && arr[j] <= -41 + (i * 10)) {
          histo[i] += "*";
        }
      }
      System.out.println(histo[i]);
    }
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] >= 40 && arr[i] <= 50) {
        histo[9] += "*";
      }
    }
    System.out.println(histo[9]);

  }
}
