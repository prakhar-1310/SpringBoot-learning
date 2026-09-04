package com.prakhar.ETEjournal.schedular;

import com.prakhar.ETEjournal.scheduler.UserSchedular;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserSchedulerTests {

    @Autowired
    private UserSchedular userSchedular;

    @Test
    public void fetchUserAndEmailTests() throws InterruptedException {
        userSchedular.fetchUserAndSendEmail();
        Thread.sleep(30000);
    }
}
