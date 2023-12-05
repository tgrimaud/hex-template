package io.risf.galaxion.exemple.subscriptionmanagement.domain.service;

import io.risf.galaxion.exemple.TemplateApplicationTest;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.exception.InvalidSubscriptionException;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Account;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Equipment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = TemplateApplicationTest.class)
@ActiveProfiles({"test", "joinedtable"})
public class SubscriptionServiceTest {
    @Autowired
    SubscriptionService subscriptionService;

    @Test
    public void given_AnAccountAndAndEquipment_cannotSubscribeException() {
        Assertions.assertThrows(InvalidSubscriptionException.class,
        ()-> {
            Account account = Account.withoutId();

            account.setFirstName("Bob");
            account.setLastName("Sponge");

            Equipment equipment = Equipment.withoutId();
            equipment.setPartNumber("myPartNumber");
            equipment.setSerialNumber("myPartNumber");

            subscriptionService.subscribe(account, equipment);
        });
    }
}
