package primer;

public class BoxingUnboxingDemo {
    public static void take_int(int x) {
        System.out.println(x);
    }
    public static void main(String[] args) {
        Boolean flag1 = Boolean.valueOf(true);
        boolean flag2 = flag1;
        System.out.println(flag1 == flag2);
        Integer a  = 12345;
        int m = a + 127;
        System.out.println(m);
        take_int(a);
        int c = a.intValue();
        System.out.println(c);
        Integer i = Integer.parseInt("235");
        System.out.println(i);
    }
}
