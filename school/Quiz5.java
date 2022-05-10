package first.school;

import java.util.Scanner;

public class Quiz5 {
  public static void main(String[] args) {
    // 사용자로부터 라인 수와 라인당 글자 수 입력받기
    Scanner scan = new Scanner(System.in);
    System.out.println("입력 문자열의 줄(Line) 수를 입력하세요!");
    int line_num = scan.nextInt();
    System.out.println("한 줄(Line)의 글자 수를 입력하세요!");
    int char_num = scan.nextInt();
    scan.nextLine();

    // 입력받고 2차원 배열 생성하기
    char[][] char_arr = new char[line_num][char_num + 1];

    // 영문자를 입력받아서 2차원 배열에 저장하기
    for (int i = 0; i < char_arr.length; i++) {
      char[] buffer = new char[char_num + 1];
      System.out.printf("%d 번째 라인의 문자열을 입력하세요.\n", i + 1);
      String input_str = scan.nextLine();
      input_str += ' ';
      input_str.getChars(0, input_str.length(), buffer, 0);
      for (int j = 0; j < char_arr[i].length; j++) {
        char_arr[i][j] = buffer[j];
      }
    }

    // 검색할 단어를 입력받고 배열에 추가하기
    while (true) {
      System.out.println("검색 할 문자열을 입력하세요.");
      String search_str = scan.nextLine();

      String[][] arr_Strings = new String[line_num][char_num + 1];
      int[] line_count = new int[line_num];
      int str_count = 0;

      for (int i = 0; i < char_arr.length; i++) {
        String str = "";
        for (int j = 0; j < char_arr[i].length; j++) {
          if (char_arr[i][j] != ' ') {
            str += char_arr[i][j];
          } else if (char_arr[i][j] == ' ') {
            arr_Strings[i][str_count] = str;
            str_count++;
            str = "";
          }
        }
      }

      // 문자열이 있을 경우 검색 된 단어의 줄, 총 검색 횟수 출력
      int search_count = 0;
      for (int i = 0; i < arr_Strings.length; i++) {
        for (int j = 0; j < arr_Strings[i].length; j++) {
          if (search_str.equals(arr_Strings[i][j])) {
            line_count[i]++;
            search_count++;
          }
        }
      }

      if (search_count != 0) {
        String line_str = "";
        for (int i = 0; i < line_count.length; i++) {
          if (line_count[i] > 0) {
            line_str += (i + 1 + ", ");
          }
        }
        System.out.println(search_str + "를 찾았습니다.");
        System.out.println("검색된 라인 : " + line_str.substring(0, line_str.length() - 2));
        System.out.println("검색된 횟수 : " + search_count);
        System.out.println("총 단어 수 : " + str_count);
        break;
      }
      // 문자열이 없을 경우 게속해서 문자열 검색
      else if (search_count == 0) {
        System.out.print("찾을 수가 없습니다.");
      }
    }
    scan.close();
  }
}
