package io.risf.galaxion.exemple.accountmanagement.domain.model;

import java.util.Date;

public class AccountEventFactory {

    //Permet de Cacher et cemtraliser la "complexite" de creation d'un event
    public static AccountCreated createAccountCreatedEventV1(Account account) {
        return AccountCreated.builder()
                .accountId(account.getId())
                .accountLastName(account.getLastName())
                .accountFirstName(account.getLastName())
                .accountEmail(account.getEmail())
                .accountAge(account.getAge())
                .occurredAt(new Date())
                .version("1").build();
    }
}
