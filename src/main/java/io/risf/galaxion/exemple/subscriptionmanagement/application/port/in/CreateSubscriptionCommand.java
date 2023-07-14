package io.risf.galaxion.exemple.subscriptionmanagement.application.port.in;

public record CreateSubscriptionCommand(Long AccountId , String firstName, String lastName) {
}
