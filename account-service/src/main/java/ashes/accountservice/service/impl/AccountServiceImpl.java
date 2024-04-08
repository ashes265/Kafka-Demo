package ashes.accountservice.service.impl;

import ashes.accountservice.service.AccountService;
import ashes.registercore.core.AccountDTO;
import ashes.registercore.core.MessageDTO;
import ashes.registercore.core.StatisticDTO;
import ashes.registercore.util.AppUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void add(AccountDTO dto) {
        StatisticDTO stats = StatisticDTO.builder()
                .message("Account " + dto.getEmail() + " is created!!")
                .createdDate(new Date())
                .build();
        MessageDTO message = MessageDTO.builder()
                .to(dto.getEmail())
                .toName(dto.getName())
                .subject("Ngài eo giấu tên")
                .content("Chúc iem buổi tối vui vẻ <3")
                .build();

        kafkaTemplate.send(AppUtils.KAFKA_NOTIFY_TOPIC, message);
        kafkaTemplate.send(AppUtils.KAFKA_STATISTIC_TOPIC, stats);
    }
}
