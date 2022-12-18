package online.beles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerWikimediaApplication implements CommandLineRunner {

    @Autowired
    private WikimediaProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerWikimediaApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        producer.sendMessage();
    }
}
