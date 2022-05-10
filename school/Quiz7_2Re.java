package first.school;

import java.util.Scanner;

public class Quiz7_2Re {
  public static void main(String[] args) {
    // 16진수를 문자열로 입력받기
    // 문자열의 최대 길이는 20자
    // 유효범위 0~9 A~F
    // 이외의 값 재입력
    Scanner scan = new Scanner(System.in);
    Change ch = new Change();
    String input_hex = "";
    boolean flag = true;

    while (flag) {
      int count = 0;
      System.out.print("//입력값 ");
      input_hex = scan.next();
      // 20자 이상 재입력
      if (input_hex.length() > 20) {
        System.out.print("//결과값");
        System.out.print(" 유효하지 않은 16진수입니다. 재입력 하세요\n");
        continue;
      }
      //
      for (int i = 0; i < input_hex.length(); i++) {
        if (input_hex.charAt(i) >= '0' && input_hex.charAt(i) <= '9'
            || input_hex.charAt(i) >= 'A' && input_hex.charAt(i) <= 'F') {
          count++;
        }
      }
      if (count == input_hex.length()) {
        flag = false;
      } else {
        System.out.print("//결과값 ");
        System.out.print("유효하지 않은 16진수입니다. 재입력 하세요\n");
      }
    }
    scan.close();

    // 16진수 -> 10진수 변환
    long dec = ch.hexToDec(input_hex);

    System.out.print("//결과값 ");
    // 2진수 출력
    System.out.println("이진수: " + ch.decToBin(dec));
    // 8진수 출력
    System.out.println("\t 팔진수: " + ch.decToOct(dec));
    // 10진수 출력
    System.out.println("\t 십진수: " + dec);
  }
}

// Change class
class Change {
  // 16진수 -> 10진수
  long hexToDec(String input_hex) {
    int[] dec_arr = new int[input_hex.length()];
    for (int i = 0; i < input_hex.length(); i++) {
      if (input_hex.charAt(i) >= '0' && input_hex.charAt(i) <= '9') {
        dec_arr[i] = input_hex.charAt(i) - '0';
      } else {
        dec_arr[i] = (input_hex.charAt(i) - 'A') + 10;
      }
    }
    long dec = 0;
    for (int i = dec_arr.length - 1, j = 0; i >= 0; i--) {
      dec += dec_arr[i] * Math.pow(16, j++);
    }
    return dec;
  }

  // 10진수 -> 2진수
  String decToBin(long dec) {
    String bin_out = "";
    while (dec > 0) {
      long rem = dec % 2;
      dec = (long) (dec / 2);
      bin_out = rem + bin_out;
    }

    /*
     * // 자리수 ex) 2진수 "11" -> 2진수 "0011"
     * if (bin_out.length() % 4 != 0) {
     * while (bin_out.length() % 4 > 0 && bin_out.length() != 0) {
     * bin_out = "0" + bin_out;
     * }
     * }
     */

    return bin_out;
  }

  // 10진수 -> 8진수
  String decToOct(long dec) {
    String oct_out = "";
    while (dec > 0) {
      long rem = dec % 8;
      dec = (long) (dec / 8);
      oct_out = rem + oct_out;
    }

    /*
     * // 자리수 ex) 8진수 "17" -> 8진수 "017"
     * if (oct_out.length() % 3 != 0) {
     * while (oct_out.length() % 3 > 0 && oct_out.length() != 0) {
     * oct_out = "0" + oct_out;
     * }
     * }
     */
    return oct_out;
  }
}