package nl.kristalsoftware.domain.base;

import org.apache.avro.specific.SpecificRecord;

public interface DomainEventHandler<T extends SpecificRecord> {

    String appliesTo();

    void saveEvent(T eventData);

}
