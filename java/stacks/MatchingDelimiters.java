package stacks;

public class MatchingDelimiters {
    /** Tests if delimiters in the given expression are properly matched. */
    public static boolean isMatched(String expression) {
        final String opening = "({["; // opening deleimiters
        final String closing = ")}]"; // respective closing delimiters
        Stack<Character> buffer = new LinkedStack<>();
        for (char c : expression.toCharArray()) {
            if (opening.indexOf(c) != -1) // this is a left delimiter
                buffer.push(c);
            else if (closing.indexOf(c) != -1) { // this is a right delimiter
                if (buffer.isEmpty()) // nothing to match with
                    return false;
                if (closing.indexOf(c) != opening.indexOf(buffer.pop())) // mismatched delimiter
                    return false;
            }
        }
        return buffer.isEmpty(); // were all opening delimiters matched?
    }

    public static void main(String[] args) {
        String expression = "( )(( )){([( )])}";
        System.out.println(isMatched(expression));
        expression = "((( )(( )){([( )])}))";
        System.out.println(isMatched(expression));
        expression = ")(( )){([( )])}";
        System.out.println(isMatched(expression));
        expression = "({[ ])}";
        System.out.println(isMatched(expression));
        expression = "(";
        System.out.println(isMatched(expression));
    }
}
