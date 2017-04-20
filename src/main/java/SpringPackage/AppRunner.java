package SpringPackage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AppRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);



    private final DealerRepository dealerRepository;

    public AppRunner(DealerRepository dealerRepository) {
        this.dealerRepository = dealerRepository;
    }



    @Override
    public void run(String... args) throws Exception {
        dealerRepository.createDealerInformation();
        logger.info(".... Fetching Dealers");
        logger.info("dealer-1234 -->" + dealerRepository.getByDealerId("dealer-1234"));
        logger.info("dealer-4567 -->" + dealerRepository.getByDealerId("dealer-4567"));
        logger.info("dealer-1234 -->" + dealerRepository.getByDealerId("dealer-1234"));
        logger.info("dealer-4567 -->" + dealerRepository.getByDealerId("dealer-4567"));
        logger.info("dealer-1234 -->" + dealerRepository.getByDealerId("dealer-1234"));
        logger.info("dealer-1234 -->" + dealerRepository.getByDealerId("dealer-1234"));
    }
}
