package SpringPackage;


public class Dealer {


    private String dealerId;

    private String dealerName;

    public Dealer(String dealerId, String dealerName) {
        this.dealerId = dealerId;
        this.dealerName = dealerName;
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "dealerId='" + dealerId + '\'' +
                ", dealerName='" + dealerName + '\'' +
                '}';
    }

}
