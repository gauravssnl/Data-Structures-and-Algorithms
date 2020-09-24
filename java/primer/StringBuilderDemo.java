package primer;

/* 
StringBuilder is faster and preferred over StringBuffer for single threaded program. 
If thread safety is needed, then StringBuffer is used.
*/

class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello").append(" , Rust.");
        System.out.println(sb.capacity()); // capacity will be more than the length
        System.out.println(sb.length());
        sb.insert(0, "Hello world.");
        System.out.println(sb);
        sb.setCharAt(6, ',');
        // Reverse the string builder data
        sb.reverse();
        System.out.println(sb);
        System.out.println(sb.substring(2, 8));
        System.out.println(sb.subSequence(2, 8));
    }
}