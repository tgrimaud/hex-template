package io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RelationId {
    String id;

    public static RelationId of(String value){
        return new RelationId(value);
    }

    public static RelationId nextAvailableId() {
        return RelationId.of(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelationId that = (RelationId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
