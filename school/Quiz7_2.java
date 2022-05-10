package first.school;

import java.util.Scanner;

public class Quiz7_2 {
  public static void main(String[] args) {
    // 키보드로 부터 16진수의 값을 문자열로 입력받기
    // 최대 길이 20자, 0~9, A~F만 가능 나머지 예외처리
    Scanner scan = new Scanner(System.in);
    boolean flag = true;
    String input_hex = "";
    char char_hex = ' ';
    while (flag) {
      System.out.print("//입력값 ");
      input_hex = scan.nextLine();
      if (input_hex.length() > 20) {
        System.out.println("최대 길이는 20자 입니다. 재입력 하세요");
        continue;
      }
      for (int i = 0; i < input_hex.length(); i++) {
        String str_hex = input_hex.substring(i, i + 1);
        char_hex = str_hex.charAt(0);
        if (char_hex < '0' || char_hex > '9' && char_hex < 'A' || char_hex > 'F') {
          System.out.println("유효하지 않은 16진수 입니다. 재입력 하세요");
          break;
        }
        if (i == (input_hex.length() - 1)) {
          flag = false;
          break;
        }
      }
    }
    scan.close();
    // 입력된 16진수 값을 2진수, 8진수, 10진수로 변환
    // 16 진수 자리 하나를 10진수로 변환
    int[] int_hex = new int[input_hex.length()];
    for (int i = 0; i < input_hex.length(); i++) {
      String str_hex = input_hex.substring(i, i + 1);
      char_hex = str_hex.charAt(0);
      if (char_hex >= '0' && char_hex <= '9') {
        int_hex[i] = char_hex - '0';
      } else {
        int_hex[i] = char_hex - '7';
      }
    }

    int[] bin = { 0, 0, 0, 0 };
    String print_bin = "", print_oct = "";

    // 10진수 -> 2진수로 변환
    for (int i = 0; i < int_hex.length; i++) {
      int quotient = int_hex[i]; // 목
      for (int j = 3; j >= 0; j--) {
        int remainder = 0; // 나머지
        remainder = quotient % 2;
        quotient = (int) (quotient / 2);
        bin[j] = remainder;
      }

      // 2진수 str 저장
      for (int j = 0; j < bin.length; j++) {
        print_bin += bin[j];
      }
    }
    // 2진수 출력
    System.out.println("이진수 : " + print_bin);

    // 2진수 -> 8진수 변환
    int count = 2;
    int[] oct = { 0, 0, 0 };

    // 8진수 계산을 위해 앞에 0 추가
    while (true) {
      if (print_bin.length() % 3 == 0) {
        break;
      }
      print_bin = "0" + print_bin;
    }

    // 8진수 계산
    for (int i = print_bin.length(); i > 0; i--) {
      String str_oct = print_bin.substring(i - 1, i);
      char char_oct = str_oct.charAt(0);
      oct[count--] = char_oct - '0';
      if (count < 0) {
        int int_oct = (oct[0] * 4) + (oct[1] * 2) + (oct[2] * 1);
        print_oct = int_oct + print_oct;
        count = 2;
      }
    }
    // 앞자리 0이면 0제거
    if (print_oct.subSequence(0, 1).equals("0")) {
      print_oct = print_oct.substring(1, 2);
    }
    // 8진수 출력
    System.out.println("팔진수 : " + print_oct);

    // 2진수 -> 10진수 변환
    count = 1;
    int dec = 0;
    for (int i = print_bin.length(); i > 0; i--) {
      String str_dec = print_bin.substring(i - 1, i);
      char char_dec = str_dec.charAt(0);
      dec += (char_dec - '0') * count;
      count *= 2;
    }
    // 10진수 출력
    System.out.println("십진수 : " + dec);
  }
}