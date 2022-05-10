package first.school;

import java.util.*;

public class Quiz4_3Re {
  public static void main(String[] args) {
    // 키보드로부터 양의 정수 하나 입력받기
    // 입력받은 값이 1이상 100이하의 값만 수용, 아닐 경우 Msg 출력 후 재입력
    Scanner scan = new Scanner(System.in);
    int arrLen = 0;
    System.out.println("배열의 개수를 입력하세요.");
    while (true) {
      arrLen = scan.nextInt();
      if (arrLen < 1) {
        System.out.println("1 이상의 값을 입력하세요.");
      } else if (arrLen > 100) {
        System.out.println("100 이하의 값을 입력하세요.");
      } else {
        scan.close();
        break;
      }
    }

    // 입력받은 값만큼 정수형 배열 선언하기
    int[] arr = new int[arrLen];
    // 51로 초기화 하기
    Arrays.fill(arr, 51);

    // 난수(-50 ~ 50)를 중복값 없이 배열에 채우기
    for (int i = 0; i < arr.length; i++) {
      while (true) {
        int rand = (int) (Math.random() * 101) - 50;
        // 중복 체크하기
        int count = 0;
        for (int j = 0; j < arr.length; j++) {
          if (arr[j] == rand) { // 중복이 있을 경우 count++
            count++;
          }
        }
        if (count == 0) { // 중복이 없을 경우 배열에 추가 후 반복문 탈출
          arr[i] = rand;
          break;
        }
      }
    }

    // 최대값 구하기
    int max = -51;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }

    // 최소값 구하기
    int min = 51;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < min) {
        min = arr[i];
      }
    }

    // 실수 로 된 평균값 구하기
    double avg = 0.0;
    for (int i = 0; i < arr.length; i++) {
      avg += arr[i];
    }
    avg = avg / arrLen;

    // 배열 내의 난수 값 구하기
    String outString = "";
    for (int i = 0; i < arr.length; i++) {
      outString += arr[i] + ", ";
    }

    // print
    System.out.println("배 열 의  개 수 : " + arrLen);
    System.out.println("배열 내 난수 값 : " + outString.substring(0, outString.length() - 2));
    System.out.println("최    대     값 : " + max);
    System.out.println("최    소     값 : " + min);
    System.out.println("평    균     값 : " + avg);
    System.out.println();

    // 히스토그램
    System.out.println("히스토그램");
    // 히스토그램 포맷 작성
    String[] histo = new String[10];
    for (int i = 0; i < histo.length; i++) {
      if (i == 9) { // 마지막 히스토그램
        histo[i] = (-50 + (i * 10)) + " ~ " + (-40 + (i * 10)) + " : ";
      } else { // 나머지 히스토그램
        histo[i] = (-50 + (i * 10)) + " ~ " + (-41 + (i * 10)) + " : ";
      }
    }

    // 구간별 난수의 개수 구하기
    for (int i = 0; i < histo.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if (i == 9 && arr[j] >= (-50 + (i * 10)) && arr[j] <= (-40 + (i * 10))) {
          histo[i] += "*";
        } else if (arr[j] >= (-50 + (i * 10)) && arr[j] <= (-41 + (i * 10))) {
          histo[i] += "*";
        }
      }
      System.out.println(histo[i]);
    }
  }
}
