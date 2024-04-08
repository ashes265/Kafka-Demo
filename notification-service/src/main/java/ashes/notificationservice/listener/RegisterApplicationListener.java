package ashes.notificationservice.listener;

import ashes.notificationservice.service.EmailService;
import ashes.registercore.core.MessageDTO;
import ashes.registercore.util.AppUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@RequiredArgsConstructor
public class RegisterApplicationListener {

    private final EmailService service;

    @KafkaListener(id = AppUtils.KAFKA_NOTIFY_GROUP, topics = AppUtils.KAFKA_NOTIFY_TOPIC)
    public void listen(MessageDTO dto) {
        service.sendEmail(dto);
        log.info("Send message success!!");
    }
}
