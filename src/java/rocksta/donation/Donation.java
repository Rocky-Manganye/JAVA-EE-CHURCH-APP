package rocksta.donation;

public class Donation {
   private String date;
   private double amount;

    public Donation() {
    }

    public Donation(String date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
   
   
}
