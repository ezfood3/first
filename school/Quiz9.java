package school;

public class Quiz9 {
  public static void main(String[] args) {
    {// Quiz 9-1 : 문자열 합치기
      System.out.println("\nQuiz 9-1 : 문자열 합치기");
      char[] value1 = { 'h', 'e', 'l', 'l', 'o' };
      char[] value2 = { ' ', 'w', 'o', 'r', 'l', 'd' };

      char[] values = concatenate(value1, value2);

      System.out.println(values);
    }

    {// Quiz 9-2 : 문자열 비교
      System.out.println("\nQuiz 9-2 : 문자열 비교");
      boolean result = compareTo(
          new String("문자열1").toCharArray(),
          new String("문자열2").toCharArray());

      System.out.println(result ? "같음" : "다름");
    }

    {// Quiz 9-3 : 문자열 위치 찾기
      System.out.println("\nQuiz 9-3 : 문자열 위치 찾기");
      int index = indexOf(
          new String("abcdefg").toCharArray(),
          new String("cde").toCharArray());

      System.out.println(index);
    }

    {// Quiz 9-4 : 문자열 치환
      System.out.println("\nQuiz 9-4 : 문자열 치환");
      char[] result = replace(
          new String("abcdefg").toCharArray(),
          new String("cde").toCharArray(),
          new String("k").toCharArray());

      System.out.println(result);
    }
  }

  // Quiz 9-1 : 문자열 합치기
  // 두 개의 문자열을 하나의 문자열로 병합하는 메서드
  public static char[] concatenate(char[] arg1, char[] arg2) {
    // arg1 + arg2 결과 값 반환 메서드
    char[] args = new char[arg1.length + arg2.length];
    int count = 0;
    for (int i = 0; i < arg1.length; i++) {
      args[count++] = arg1[i];
    }
    for (int i = 0; i < arg2.length; i++) {
      args[count++] = arg2[i];
    }
    return args;
  }

  // Quiz 9-2 : 문자열 비교
  public static boolean compareTo(char[] arg1, char[] arg2) {
    // arg1 과 arg2 문자열 비교후 일치: "참", 아닐 경우 "거짓" 반환
    boolean result = true;
    for (int i = 0; i < arg1.length; i++) {
      if (arg1[i] != arg2[i]) {
        result = false;
      }
    }
    return result;
  }

  // Quiz 9-3 문자열 위치 찾기
  public static int indexOf(char[] arg1, char[] arg2) {
    // arg1에서 arg2 문자열을 찾을 경우 시작 인덱스 값 리턴
    // 찾는 문자열이 없을 경우 "-1" 반환
    int index = -1, count = 0;
    for (int i = 0; i < arg1.length; i++) {
      for (int j = 0; j < arg2.length; j++) {
        if (arg1[i] != arg2[j]) {
          break;
        }
        count = i;
        for (int k = i, l = 0, q = 0; l < arg2.length; k++, l++) {
          if (arg1[k] == arg2[l]) {
            q++;
            if (q == arg2.length) {
              return count;
            }
          }
        }
      }
    }
    return index;
  }

  // Quiz 9-4 문자열 치환
  public static char[] replace(char[] arg1, char[] arg2, char[] arg3) {
    // arg1 : 검색 대상 문자열, arg2 : 찾을 문자열, arg3 : 바꿀 문자열
    // arg1 에서 arg2 문자열을 찾을 경우 찾은 문자열을 arg3으로 치환
    // 찾는 문자열이 없을 경우 arg1 값 반환
    char[] result = new char[arg1.length];

    // arg1 과 arg2 가 동일하면 arg3 출력
    boolean ck = true;
    for (int i = 0; i < arg1.length; i++) {
      if (arg1.length != arg2.length) {
        ck = false;
        break;
      }
      if (arg1[i] != arg2[i]) {
        ck = false;
      }
    }
    if (ck) {
      return arg3;
    }

    for (int i = 0; i < arg1.length; i++) {
      for (int j = 0; j < arg2.length; j++) {
        if (arg1[i] != arg2[j]) {
          result[i] = arg1[i];
          break;
        }
        int count = i;
        for (int k = i, l = 0, q = 0; l < arg2.length; k++, l++) {
          if (arg1[k] == arg2[l]) {
            q++;
            if (q == arg2.length) {
              for (int m = 0; m < arg3.length; m++) {
                result[count++] = arg3[m];
              }
              i = i + q;
            }
          }
        }
      }
    }
    return result;
  }

}
