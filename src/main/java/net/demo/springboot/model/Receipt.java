package net.demo.springboot.model;

public class Receipt {

    private String from;
    private String to;
    private User user;
    private String pricePaid;

    public Receipt(String from, String to, User user, String pricePaid) {
        this.from = from;
        this.to = to;
        this.user = user;
        this.pricePaid = pricePaid;
    }
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(String pricePaid) {
        this.pricePaid = pricePaid;
    }

}
