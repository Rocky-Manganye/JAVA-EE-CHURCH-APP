package rocksta.donation;

public class DonationAccount {
    private double amount;
    private String id;
    String account;

    public DonationAccount(double amount, String id, String account) {
        this.amount = amount;
        this.id = id;
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    
    
}
