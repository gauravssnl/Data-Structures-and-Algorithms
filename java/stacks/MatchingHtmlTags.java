package stacks;

public class MatchingHtmlTags {

    /** Tests if every opening tag has a matching closing tag in HTML string. */
    public static boolean isHTMLMatched(String html) {
        Stack<String> buffer = new LinkedStack<>();
        int j = html.indexOf("<"); // find first '<' character if any
        while (j != -1) {
            // start search from index j + 1
            int k = html.indexOf(">", j + 1); // find '>' character if any
            if (k == -1)
                return false; // invalid tag
            String tag = html.substring(j + 1, k); // strip away < & >
            if (!tag.startsWith("/")) // this is an opening tag
                buffer.push(tag);
            else { // this is a closing tag
                if (buffer.isEmpty()) // no closing tag to match
                    return false;
                // since we have stored clsoing tag including '/' , we need to skip it while
                // comparing with previous opening tag
                if (!tag.substring(1).equals(buffer.pop()))
                    return false;
            }
            j = html.indexOf("<", k + 1); // find next '<' character (if any)
        }
        return buffer.isEmpty(); // were all opening tags matched?
    }

    public static void main(String[] args) {
        String html = "<html>\n<head>\n<title>Hello</title>\n</head>\n<body> Hello</body>\n</html>";
        System.out.println(isHTMLMatched(html));
        html = "<html>\n<head>\n<title>Hello</title>\n<head>\n<body> Hello</body>\n</html>";
        System.out.println(isHTMLMatched(html));
    }
}
