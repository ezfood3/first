package first.school;

import java.util.Scanner;

public class Test2Re {
  public static void main(String[] args) {
    // 키보드로 부터 영단어 3개를 입력 받아 배열에 저장
    // 5 ~ 20 자 유효범위 이외 단어 재입력
    Scanner scan = new Scanner(System.in);
    String[] input_str = { "첫 번째", "두 번째", "세 번째" };
    for (int i = 0;;) {
      System.out.printf("%s 단어를 입력하세요\n", input_str[i]);
      String str = scan.nextLine();
      if (str.length() >= 5 && str.length() <= 20) {
        input_str[i] = str;
        i++;
      } else {
        System.out.println("5이상 20이하 글자로 구성된 단어를 입력 하세요");
      }
      if (i >= 3) {
        break;
      }
    }
    // 3개의 단어 중 한 개 단어를 선택
    int rand = (int) (Math.random() * 3);
    char[] game_char = new char[input_str[rand].length()];
    char[] check_char = new char[input_str[rand].length()];
    for (int i = 0; i < game_char.length; i++) {
      game_char[i] = input_str[rand].charAt(i);
      check_char[i] = input_str[rand].charAt(i);
    }
    String game_str = input_str[rand];
    System.out.println("단어 선택 완료 게임을 시작 합니다. 선택된 단어 : " + game_str);

    // 선택된 단어의 글자 중 50%를 랜덤으로 blind 처리 (올림 4.5 -> 5)
    if (game_char.length % 2 == 0) { // 짝수면
      rand = game_char.length / 2;
    } else { // 홀수면
      rand = game_char.length / 2;
      rand++;
    }

    boolean flag = true;
    while (flag) {
      check_char[(int) (Math.random() * check_char.length)] = '_';
      for (int i = 0, count = 0; i < check_char.length; i++) {
        if (check_char[i] == '_') {
          count++;
        }
        if (count == rand) {
          flag = false;
        }
      }
    }

    // 키보드로부터 알파벳 한 글자 입력
    int count = 1;
    for (;; count++) {
      for (int i = 0; i < check_char.length; i++) {
        System.out.print(check_char[i]);
      }
      System.out.printf("\n%d번째 시도, 아래 단어를 구성하는 알파벳 한 개 입력하세요.\n", count);
      String check_str = scan.nextLine();
      char cheak = check_str.charAt(0);
      int sum = 0;
      // 단어를 구성하는 알파벳 count
      for (int i = 0; i < check_char.length; i++) {
        if (game_char[i] == cheak && check_char[i] == '_') {
          check_char[i] = cheak;
          sum++;
        }
      }
      // 입력받은 알파벳이 단어 내 존재 할 경우 blind 해재, 없을경우 "없음" 출력
      if (sum != 0) {
        System.out.printf("입력한 알파벳 단어 내 포함 : %d글자\n", sum);
      } else {
        System.out.println("단어 내 포함되지 않은 알파벳입니다.");
      }
      // 단어 완성 체크
      int eq = 0;
      for (int i = 0; i < game_char.length; i++) {
        if (game_char[i] == check_char[i]) {
          eq++;
        }
      }
      // 단어가 완성되면
      if (eq == game_char.length) {
        scan.close();
        break;
      }
    }

    // 단어의 모든 글자를 맞출 경우 게임종료 (종료시 시도 횟수 출력)
    System.out.printf("Clear - 선택된 단어 : %s, 총 시도 횟수 : %d", game_str, count);
  }
}
