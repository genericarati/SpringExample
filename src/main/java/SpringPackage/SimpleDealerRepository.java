package SpringPackage;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleDealerRepository implements DealerRepository {

    @Override
    @Cacheable("dealers")
    public Dealer getByDealerId(String dealerId) {
        simulateSlowService();
        return new Dealer("dealer-1234", "Jack Demmer");
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
