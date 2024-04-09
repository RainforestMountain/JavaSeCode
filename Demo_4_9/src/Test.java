import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main1(String[] args) {
        LinkedList<Character> list = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (!list.isEmpty()) {
                    int size = list.size();
                    if (list.getLast() == ch) {
                        list.removeLast();
                    } else {
                        list.addLast(ch);
                    }
                } else {
                    list.addLast(ch);
                }
            }
            for (Character v : list) {
                System.out.print(v);
            }
        }
    }

    public static boolean isSubsequence(String S, String T) {
        // write code here
        if (T.length() == 0) {
            if (S.length() == 0) {
                return true;
            } else {
                return false;
            }
        }
        if (S.length() == 0) {
            return true;
        }
        if (S.length() > T.length()) {
            return false;
        }
        //a 97
        int[] countS = new int[26];
        int[] countT = new int[26];
        for (int i = 0; i < T.length(); i++) {
            char ch = T.charAt(i);
            countT[ch - 97]++;
        }
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            countS[ch - 97]++;
        }
        boolean flag = true;
        for (int i = 0; i < 26; i++) {
            if (countT[i] < countS[i]) {
                flag = false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();

        System.out.println(isSubsequence(s, t));
    }

    public static void main3(String[] args) {
        Stack<Character> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(ch);
                } else {
                    char temp = stack.pop();
                    if (temp != ch) {
                        stack.push(temp);
                        stack.push(ch);
                    }
                }
            }

            Character[] array = stack.toArray(new Character[0]);
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
            }
            System.out.println();
        }
    }

    public static void main4(String[] args) {
        System.out.println((int) 'a');
    }
}
