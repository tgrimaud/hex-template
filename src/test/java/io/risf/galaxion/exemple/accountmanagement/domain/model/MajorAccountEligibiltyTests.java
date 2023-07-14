package io.risf.galaxion.exemple.accountmanagement.domain.model;

import io.risf.galaxion.exemple.accountmanagement.domain.service.AccountDomainService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MajorAccountEligibiltyTests {

    @Test
    void nonEligibleAccountTest() {

        MajorAccountEligibilibittyPolicy accountEligibilty = new MajorAccountEligibilibittyPolicy();

        Account nonEligibleAccount = new AccountMother().minorAccount()
                .withFirstName("Tom")
                .withLastName("Bombadil")
                .withEmail("tom.bombadil@lotr.com")
                .build();

        Assertions.assertFalse(accountEligibilty.isAccountEligible(nonEligibleAccount));
    }

    @Test
    void eligibleAccountTest() {
        MajorAccountEligibilibittyPolicy accountEligibilty = new MajorAccountEligibilibittyPolicy();


        Account nonEligibleAccount = new AccountMother().majorAccount()
                .withFirstName("Tom")
                .withLastName("Bombadil")
                .withEmail("tom.bombadil@lotr.com")
                .build();
        Assertions.assertTrue(accountEligibilty.isAccountEligible(nonEligibleAccount));
    }
}
