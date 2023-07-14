package io.risf.galaxion.exemple.accountmanagement.application.port.in;


public record CreateAccountCommand(String firstName, String lastName, String email, int age) {
}
