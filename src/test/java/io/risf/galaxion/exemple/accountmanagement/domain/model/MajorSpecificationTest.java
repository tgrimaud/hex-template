package io.risf.galaxion.exemple.accountmanagement.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MajorSpecificationTest {

    @Test
    void nonSatisfiedAccountTest() {

        MajorAccountSpecification accountAgeSpecification = new MajorAccountSpecification();

        Account nonEligibleAccount = new AccountMother().minorAccount()
                .withFirstName("Tom")
                .withLastName("Bombadil")
                .withEmail("tom.bombadil@lotr.com")
                .build();

        Assertions.assertFalse(accountAgeSpecification.isSatisfiedBy(nonEligibleAccount));
    }

    @Test
    void satisfiedAccountTest() {
        MajorAccountSpecification accountAgeSpecificaiton = new MajorAccountSpecification();


        Account nonEligibleAccount = new AccountMother().majorAccount()
                .withFirstName("Tom")
                .withLastName("Bombadil")
                .withEmail("tom.bombadil@lotr.com")
                .build();
        Assertions.assertTrue(accountAgeSpecificaiton.isSatisfiedBy(nonEligibleAccount));
    }

    @Test
    void satisfiedAccountWithNameTest() {
        MajorAccountSpecification accountAgeSpecification = new MajorAccountSpecification();
        NameAccountSpecification nameAccountSpecification = new NameAccountSpecification("Tom");

        Account nonEligibleAccount = new AccountMother().majorAccount()
                .withFirstName("Tom")
                .withLastName("Bombadil")
                .withEmail("tom.bombadil@lotr.com")
                .build();
        Assertions.assertTrue(accountAgeSpecification.and(nameAccountSpecification).isSatisfiedBy(nonEligibleAccount));
    }

    @Test
    void NonSatisfiedAccountWithNameTest() {
        MajorAccountSpecification accountAgeSpecification = new MajorAccountSpecification();
        NameAccountSpecification nameAccountSpecification = new NameAccountSpecification("Tom");

        Account nonEligibleAccount = new AccountMother().majorAccount()
                .withFirstName("Bob")
                .withLastName("Bombadil")
                .withEmail("bob.bombadil@lotr.com")
                .build();

        Assertions.assertFalse(accountAgeSpecification.and(nameAccountSpecification).isSatisfiedBy(nonEligibleAccount));
    }

    @Test
    void SatisfiedAccountAgeOrNameTest() {
        MajorAccountSpecification accountAgeSpecification = new MajorAccountSpecification();
        NameAccountSpecification nameAccountSpecification = new NameAccountSpecification("Tom");

        Account nonEligibleAccount = new AccountMother().majorAccount()
                .withFirstName("Bob")
                .withLastName("Bombadil")
                .withEmail("bob.bombadil@lotr.com")
                .build();

        Assertions.assertTrue(accountAgeSpecification.or(nameAccountSpecification).isSatisfiedBy(nonEligibleAccount));
    }
}
