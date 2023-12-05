package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Profile;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Profile("joinedtable")
public class NodeJTId implements Serializable {
    String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeJTId nodeJTId = (NodeJTId) o;
        return Objects.equals(id, nodeJTId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}