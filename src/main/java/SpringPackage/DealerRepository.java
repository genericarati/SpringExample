package SpringPackage;

public interface DealerRepository {

    Dealer getByDealerId(String dealerId);

    void createDealerInformation();

    void addDealer(Dealer dealer);

    void deleteDealer(String dealerId);

    void evictCache();
}
