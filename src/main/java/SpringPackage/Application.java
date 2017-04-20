package SpringPackage;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
@EnableCaching
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ConcurrentMapCacheManager cacheManager(){
        ConcurrentMapCacheManager concurrentMapCacheManager = new ConcurrentMapCacheManager("dealers");
        return concurrentMapCacheManager;
    }


}
