package nl.kristalsoftware.domain.base;

import java.util.UUID;

public interface Aggregate {

    UUID getReferenceValue();

    void setNumberOfEntities(int size);

}
