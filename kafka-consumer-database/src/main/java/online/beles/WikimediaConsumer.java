package online.beles;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.beles.domain.WikimediaData;
import online.beles.repositories.WikimediaDataRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class WikimediaConsumer {

    private WikimediaDataRepository dataRepository;

    @KafkaListener(
            topics = "wikimedia_recentchange",
            groupId = "myGroup"
    )
    public void consume(String event){
        log.info(String.format("event Received -> %s",event));

        dataRepository.save(new WikimediaData(event));

    }

}
