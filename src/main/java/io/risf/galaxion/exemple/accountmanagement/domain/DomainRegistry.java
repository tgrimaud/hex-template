package io.risf.galaxion.exemple.accountmanagement.domain;

import io.risf.galaxion.exemple.accountmanagement.domain.model.AccountEventPublisher;
import io.risf.galaxion.exemple.accountmanagement.domain.service.AccountDomainService;

public class DomainRegistry {


    public static AccountEventPublisher accountEventPublisher(){
        return AccountEventPublisher.getInstance();
    }

    public static AccountDomainService accountDomainService(){

        return AccountDomainService.getInstance();
    }
    // ......
}
