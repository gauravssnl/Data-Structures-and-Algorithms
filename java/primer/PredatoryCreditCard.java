package primer;

public class PredatoryCreditCard extends CreditCard {
    // Additional instance variable
    private double apr; // annnual percentage rate

    // Constructor for this class
    public PredatoryCreditCard(String customerName, String bankName, String accountId, int limit, double initialBalance,
            double rate) {
        super(customerName, bankName, accountId, limit, initialBalance);
        apr = rate;
    }

    // A new method for assessing montly interest charge
    public void processMonth() {
        if (balance > 0) { // only charge interest on a positive balance
            double monthlyFactor = Math.pow(1 + apr, 1.0 / 12);
            balance *= monthlyFactor;

        }
    }

    // Overriding the charge method defined in the superclass
    @Override
    public boolean charge(double price) {
        boolean isSuccess = super.charge(price);
        if (!isSuccess)
            balance += 5; // add $5 penalty for using credit card after limit is reached
        return isSuccess;
    }

    @Override
    public String toString() {
        return "PredatoryCreditCard [accountId=" + super.getAccountId() + ", balance=" + balance + ", bankName="
                + super.getBankName() + ", customerName=" + super.getCustomerName() + ", limit=" + super.getLimit()
                + ", annual percentage rate=" + apr + "]";
    }
}