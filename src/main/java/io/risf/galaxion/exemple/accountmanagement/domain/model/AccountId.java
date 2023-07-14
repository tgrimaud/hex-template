package io.risf.galaxion.exemple.accountmanagement.domain.model;

import lombok.Value;

@Value
public class AccountId {
    private Long value;
    private static Long newAvailableId = 1L;

    public static AccountId nextAvailableId() {
        return AccountId.of(newAvailableId++);

    }
    public static AccountId of(Long value){
        return new AccountId(value);
    }
}
