package ood;

// Nested class example
// Outer class
public class CreditCard {
    // static nested class
    private static class Transaction {
        /* details omitted */
    }

    // inner class - nested class
    private class ServiceProvider {
        /* details omitted */
    }

    Transaction[] history; // kep log of all transactions for this card;
    ServiceProvider serviceProvider; // inner class instance
}
