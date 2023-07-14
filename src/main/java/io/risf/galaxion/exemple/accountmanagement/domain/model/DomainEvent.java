package io.risf.galaxion.exemple.accountmanagement.domain.model;

import java.util.Date;

public interface DomainEvent {
    public Date occurredAt();
    public String version();
}
