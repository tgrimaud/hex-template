package io.risf.galaxion.exemple.accountmanagement.domain.model;

import java.util.concurrent.ThreadLocalRandom;

public class AccountMother {
    private AccountId id = null;

    private String firstName;
    private String lastName;
    private String email;
    private int age;

    public AccountMother minorAccount() {
        return this.withAge(ThreadLocalRandom.current().nextInt(1, 18))
                .withFirstName("Tom")
                .withLastName("Bombadil")
                .withEmail("tom.bombadil@lotr.com");
    }

    public AccountMother majorAccount() {
       return this.withAge(ThreadLocalRandom.current().nextInt(18, 99 + 1))
               .withFirstName("Tom")
               .withLastName("Bombadil")
               .withEmail("tom.bombadil@lotr.com");
    }

    public AccountMother randomAccount() {
        return this.withAge(ThreadLocalRandom.current().nextInt(1, 99 + 1))
                .withFirstName("Tom")
                .withLastName("Bombadil")
                .withEmail("tom.bombadil@lotr.com");
    }

    public AccountMother withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public AccountMother withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AccountMother withEmail(String email) {
        this.email = email;
        return this;
    }

    public AccountMother withAge(int age) {
        this.age = age;
        return this;
    }

    public AccountMother withId(AccountId id) {
        this.id = id;
        return this;
    }

    public AccountMother withId(Long id) {
        this.id = AccountId.of(id);
        return this;
    }

    public Account build() {
        return Account.withId(id,this.firstName,this.lastName, this.email, this.age);
    }
}
