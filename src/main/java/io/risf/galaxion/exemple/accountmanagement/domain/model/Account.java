package io.risf.galaxion.exemple.accountmanagement.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {

    private final AccountId id;

    private final String firstName;
    private final String lastName;
    private final String email;
    private final int age;

    public static Account withoutId(String firstName, String lastName, String email, int age) {
        return new Account(AccountId.nextAvailableId(), firstName, lastName, email, age);
    }

    public static Account withId(AccountId accountId,String firstName, String lastName, String email, int age) {
        return new Account(accountId, firstName, lastName, email, age);
    }



}
