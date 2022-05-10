package school;

import java.util.Scanner;

public class Quiz5Re {
  public static void main(String[] args) {
    // 라인 수 와 라인당 글자 수 입력받기
    Scanner scan = new Scanner(System.in);
    System.out.println("입력 문자열의 줄(Line) 수를 입력하세요!");
    int line_num = scan.nextInt();
    System.out.println("한 줄(Line)의 글자 수를 입력하세요!");
    int char_num = scan.nextInt();
    scan.nextLine();

    // 2차원 배열 생성하기
    String[][] str_arr = new String[line_num][char_num];
    for (int i = 0; i < str_arr.length; i++) {
      for (int j = 0; j < str_arr[i].length; j++) {
        str_arr[i][j] = "";
      }
    }

    // 영문자를 키보드로 입력받기
    int str_count = 0;

    for (int i = 0; i < str_arr.length; i++) {
      char[] buffer = new char[char_num + 1];
      int count = 0;

      System.out.printf("%d 번째 라인의 문자열을 입력하세요.\n", i + 1);
      String str = scan.nextLine();
      str += ' ';
      str.getChars(0, str.length(), buffer, 0);

      // 2차원 배열에 저장하기
      str = "";
      for (int j = 0; j < buffer.length; j++) {
        if (buffer[j] != ' ') {
          str += buffer[j];
        } else {
          str_arr[i][count] += str;
          count++;
          str_count++;
          str = "";
        }
      }
      count = 0;
    }

    // 검색할 단어를 키보드로 입력 받고, 문자열 유/무 판별
    int[] search_count = new int[line_num];
    while (true) {
      int count = 0;
      System.out.println("검색 할 문자열을 입력하세요.");
      String search_str = scan.nextLine();

      for (int i = 0; i < str_arr.length; i++) {
        for (int j = 0; j < str_arr[i].length; j++) {
          char[] str_buffer = new char[str_arr[i][j].length()];
          char[] search_buffer = new char[search_str.length()];

          str_arr[i][j].getChars(0, str_arr[i][j].length(), str_buffer, 0);
          search_str.getChars(0, search_str.length(), search_buffer, 0);

          if (str_buffer.length == search_buffer.length) {
            int buffer_count = 0;
            for (int k = 0; k < str_buffer.length; k++) {

              if (str_buffer[k] == search_buffer[k]) {
                buffer_count++;
              }
            }
            if (buffer_count == str_buffer.length) {
              count++;
              search_count[i]++;
            }
          }
        }
      }

      // 검색된 라인 수 print
      String count_print = "";
      for (int i = 0; i < search_count.length; i++) {
        if (search_count[i] != 0) {
          count_print += (i + 1) + ", ";
        }
      }

      // 찾는 문자열이 없을 경우
      if (count == 0) {
        System.out.print("찾을 수가 없습니다. ");
      } // 찾는 문자열이 있을 경우
      else {
        System.out.println(search_str + "를 찾았습니다.");
        System.out.println("검색된 라인 수 : " + count_print.substring(0, count_print.length() - 2));
        System.out.println("검색된 횟수 : " + count);
        System.out.println("총 단어 수 : " + str_count);
        break;
      }
    }
    scan.close();
  }
}
