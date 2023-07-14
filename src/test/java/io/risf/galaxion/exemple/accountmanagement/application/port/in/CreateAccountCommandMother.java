package io.risf.galaxion.exemple.accountmanagement.application.port.in;

import java.util.concurrent.ThreadLocalRandom;

public class CreateAccountCommandMother {
    String firstName;
    String lastName;
    String email;
    int age;

    public CreateAccountCommandMother minorAccount() {
        return this.withAge(ThreadLocalRandom.current().nextInt(1, 18))
                .withFirstName("Tom")
                .withLastName("Bombadil")
                .withEmail("tom.bombadil@lotr.com");
    }

    public CreateAccountCommandMother majorAccount() {
        return this.withAge(ThreadLocalRandom.current().nextInt(18, 99 + 1))
                .withFirstName("Tom")
                .withLastName("Bombadil")
                .withEmail("tom.bombadil@lotr.com");
    }

    public CreateAccountCommandMother withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CreateAccountCommandMother withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CreateAccountCommandMother withEmail(String email) {
        this.email = email;
        return this;
    }

    public CreateAccountCommandMother withAge(int age) {
        this.age = age;
        return this;
    }

    public CreateAccountCommand build() {
        return new CreateAccountCommand(firstName, lastName, email, age);
    }
}
