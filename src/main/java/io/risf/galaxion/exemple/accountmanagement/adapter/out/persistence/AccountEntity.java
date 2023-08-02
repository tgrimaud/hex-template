package io.risf.galaxion.exemple.accountmanagement.adapter.out.persistence;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {

    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private int age;
}
