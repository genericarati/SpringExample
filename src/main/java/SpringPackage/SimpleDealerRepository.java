package SpringPackage;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SimpleDealerRepository implements DealerRepository {

    private Map<String,String> dealerInformation;

    @Override
    @Cacheable(value="dealers", key="#dealerId")
    public Dealer getByDealerId(String dealerId) {
        simulateSlowService();
        Dealer dealer = new Dealer(dealerId,dealerInformation.get(dealerId));

        return dealer;
    }

    @Override
    public void createDealerInformation() {
         dealerInformation = new HashMap<>();
         dealerInformation.put("dealer-1234","Jack Demmer");
         dealerInformation.put("dealer-4567","dealer-4567");
    }

    @Override
    @CachePut(value = "dealers", key="#result.deaerId")
    public void addDealer(Dealer dealer) {
        if (dealerInformation.size()>0){
            dealerInformation.put(dealer.getDealerId(),dealer.getDealerName);
        }
    }

    @Override
    @CacheEvict(value="dealers", key="#id")
    public void deleteDealer(String dealerId) {
        dealerInformation.remove(dealerId);
    }

    @Override
    @CacheEvict(value="dealers", allEntries = true )
    public void evictCache() {

    }


    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
