package primer;

public class DynamicDispatchDemo {
    public static void main(String[] args) {
        CreditCard card;
        card = new CreditCard("Gaurav", "CITI", "123", 20000, 100);
        System.out.println(card);
        System.out.println(card instanceof CreditCard);

        card = new PredatoryCreditCard("Gaurav", "CITI", "123", 30000, 200, 0.685);
        System.out.println(card);
        System.out.println(card instanceof PredatoryCreditCard);
        System.out.println(card instanceof CreditCard);
        System.out.println(card instanceof Object);
    }
}
