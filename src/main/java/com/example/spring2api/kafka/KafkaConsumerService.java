package com.example.spring2api.kafka;

import com.example.spring2api.entity.ChangeLog;
import com.example.spring2api.repository.ChangelogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @Autowired
    private ChangelogRepository changelogRepository;

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "ru-sokolov-person", groupId = "group_id")
    public void listen(String message) {
        logger.info("Received message in Kafka Consumer: {}", message);
        ChangeLog changelog = new ChangeLog();
        changelog.setData(message);
        logger.info("Saving to database: {}", changelog.getData());
        changelogRepository.save(changelog);
        logger.info("Saved successfully");
    }
}

