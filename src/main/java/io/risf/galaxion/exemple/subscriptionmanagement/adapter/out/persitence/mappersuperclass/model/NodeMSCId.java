package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.model;

import lombok.Setter;
import org.springframework.context.annotation.Profile;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Setter
@Profile("mappersuperclass")
public class NodeMSCId implements Serializable {
    String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeMSCId nodeMSCId = (NodeMSCId) o;
        return Objects.equals(id, nodeMSCId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
