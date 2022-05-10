package school;

import java.util.Arrays;

public class Quiz3_1Re {
  public static void main(String[] args) {
    // 8 * 8 2차원 배열 선언
    char[][] arr = new char[8][8];

    // 2차원 배열에 a ~ z 알파벳 랜덤으로 선택 후 저장 및 출력
    System.out.println("8 X 8, 알파벳 발생 결과");
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        char input = 'a';
        int rand = (int) (Math.random() * 26);
        input = (char) (input + rand);
        arr[i][j] = input;
        System.out.print(arr[i][j] + "\t");
      }
      System.out.println();
    }

    // 2차원 배열 최소 발생 알파벳 출력
    int[] alpha = new int[26];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        int index = arr[i][j] - 'a';
        alpha[index]++;
      }
    }
    // 최소 발생 횟수 구하기
    int min = 100;
    int count = 0;
    // min
    for (int i = 0; i < alpha.length; i++) {
      if (alpha[i] != 0 && alpha[i] < min) {
        min = alpha[i];
      }
    }
    // count
    String alphaOut = "";
    for (int i = 0; i < alpha.length; i++) {
      if (alpha[i] == min) {
        alphaOut += (char) (i + 'a') + ", ";
        count++;
      }
    }
    alphaOut = alphaOut.substring(0, alphaOut.length() - 2);

    // print
    System.out.println("최소 발생 알파벳");
    System.out.println("- 발생 빈도 : " + min);
    System.out.println("- 중복 알파벳 개수 : " + count);
    System.out.println("- 알파벳: : " + alphaOut);

    // 2차원 배열 최대 발생 알파벳 출력
    int max = 0;
    count = 0;

    // max
    for (int i = 0; i < alpha.length; i++) {
      if (alpha[i] > max) {
        max = alpha[i];
      }
    }

    // count
    alphaOut = "";
    for (int i = 0; i < alpha.length; i++) {
      if (alpha[i] == max) {
        alphaOut += (char) (i + 'a') + ", ";
        count++;
      }
    }
    alphaOut = alphaOut.substring(0, alphaOut.length() - 2);
    // print
    System.out.println("최대 발생 알파벳");
    System.out.println("- 발생 빈도 : " + max);
    System.out.println("- 중복 알파벳 개수 : " + count);
    System.out.println("- 알파벳: : " + alphaOut);

    // 2차원 배열 저장값을 a -> z 오름차순 정렬 후 출력
    int[] sortArr = new int[64];
    count = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        sortArr[count] += arr[i][j];
        count++;
      }
    }
    // sort
    Arrays.sort(sortArr);

    // print
    count = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        System.out.print((char) (sortArr[count]) + "\t");
        count++;
      }
      System.out.println();
    }
  }
}
