package primer;

import java.util.Arrays;

public class EnumDemo {
    public static void main(String[] args) {
        System.out.println(Day.MONDAY);
           System.out.println(Day.MONDAY.ordinal());
        System.out.println(DayWithValue.MONDAY.getValue());
        System.out.println(Arrays.toString(DayWithValue.values()));
        for(DayWithValue dv : DayWithValue.values()) {
            System.out.println("Day: " + dv + ", value: " + dv.getValue());
        }
    }
}

enum Day {
    MONDAY, TUESDAY, WEDNESDAY
};

enum DayWithValue {
    MONDAY(1), TUESDAY(1), WEDNESDAY(3);

    private int value;

    DayWithValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
