package com.prakhar.ETEjournal.scheduler;

import com.prakhar.ETEjournal.Entity.User;
import com.prakhar.ETEjournal.Repository.UserRepositoryImpl;
import com.prakhar.ETEjournal.Service.EmailService;
import com.prakhar.ETEjournal.Service.SentimentAnalysisService;
import com.prakhar.ETEjournal.cache.AppCache;

import com.prakhar.ETEjournal.model.SentimentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserSchedular {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    @Autowired
    private SentimentAnalysisService sentimentAnalysisService;

    @Autowired
    private AppCache appCache;

    @Autowired
    private KafkaTemplate<String, SentimentData> kafkaTemplate;

//    @Scheduled(cron="0 9 * * SUN")
    public void fetchUserAndSendEmail() {
        List<User> usersForSA = userRepositoryImpl.getUsersForSA();
        for (User user : usersForSA) {
            String to =  user.getEmail();
            SentimentData sentimentData = SentimentData.builder().email(to).sentiment(sentimentAnalysisService.getSentiment(" ")+"").build();
            kafkaTemplate.send("sentiment", sentimentData.getEmail(), sentimentData);
        }

    }

    @Scheduled(cron ="0 */10 * * * *")
    public void refreshCache() {
        appCache.init();
    }
}
