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
public class NodeId {
    String id;

    public static NodeId of(String value){
        return new NodeId(value);
    }

    public static NodeId nextAvailableId() {
        return NodeId.of(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeId nodeId = (NodeId) o;
        return Objects.equals(id, nodeId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

