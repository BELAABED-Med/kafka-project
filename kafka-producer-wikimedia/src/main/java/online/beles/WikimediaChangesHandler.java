package online.beles;


import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;

@AllArgsConstructor
@Slf4j
public class WikimediaChangesHandler implements EventHandler {

    KafkaTemplate<String,String> template;
    private String topic;

    @Override
    public void onOpen() throws Exception {
        log.info("WikimediaChangesHandler:onOpen");

    }

    @Override
    public void onClosed() throws Exception {
        log.info("WikimediaChangesHandler:onClosed");
    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        log.info(String.format("Event data : %s",messageEvent.getData()));
        template.send(topic,messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {
        log.info("WikimediaChangesHandler:onComment");
    }

    @Override
    public void onError(Throwable throwable) {
        log.info("WikimediaChangesHandler:onError");
    }
}
