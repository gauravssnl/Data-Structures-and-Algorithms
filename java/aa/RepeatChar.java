package aa;

public class RepeatChar {
    // Time complexity : 1 + 2 + 3 + ... + n = O(n^2)
    public static String repeat1(char c, int n) {
        String answer = "";
        for (int i = 0; i < n; i++)
            // re-assignment creates new String since String is immutable
            answer += c;
        return answer;
    }

    // Time complexity : O(n)
    public static String repeat2(char c, int n) {
        StringBuilder answer = new StringBuilder("");
        for (int i = 0; i < n; i++)
            // re-assignment does not creates new Object
            answer.append(c);
        return answer.toString();
    }
}
