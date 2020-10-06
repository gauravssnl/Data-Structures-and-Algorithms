package recursion;

public class EnglishRuler {
    /**
     * Draws an English ruler for the given number of inches and major tick length.
     */
    public static void drawRuler(int numOfInches, int majorLength) {
        drawLine(majorLength, 0); // draw inch 0 amd label
        for (int j = 1; j <= numOfInches; j++) {
            drawInterval(majorLength - 1); // draw interior ticks for inch
            drawLine(majorLength, j); // draw inch j and label
        }
    }

    public static void drawInterval(int centralLength) {
        if (centralLength >= 1) { // otherwise, do nothing
            drawInterval(centralLength - 1); // recursively draw top interval
            drawLine(centralLength); // draw central tick ( without label)
            drawInterval(centralLength - 1); // recursively draw bottom interval
        }
    }

    public static void drawLine(int tickLength, int tickLabel) {
        for (int j = 0; j < tickLength; j++)
            System.out.print("-");
        if (tickLabel >= 0) // we need to print label for the starting value 0 too
            System.out.println(" " + tickLabel);
        System.out.println("\n"); // Print newline to bring the cursor to next line
    }

    public static void drawLine(int tickLength) {
        drawLine(tickLength, -1); // Pass negative vaue as we don't need inch label
    }

    public static void main(String[] args) {
        int numOfInches = 2;
        int majorLength = 4;
        System.out.println("numOfInches: " + numOfInches + ", majorLength: " + majorLength);
        drawRuler(numOfInches, majorLength);

        numOfInches = 1;
        majorLength = 5;
        System.out.println("numOfInches: " + numOfInches + ", majorLength: " + majorLength);
        drawRuler(numOfInches, majorLength);

        numOfInches = 3;
        majorLength = 3;
        System.out.println("numOfInches: " + numOfInches + ", majorLength: " + majorLength);
        drawRuler(numOfInches, majorLength);
    }
}
