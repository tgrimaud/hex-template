package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NodeSTId implements Serializable {
    String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeSTId nodeSTId = (NodeSTId) o;
        return Objects.equals(id, nodeSTId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
