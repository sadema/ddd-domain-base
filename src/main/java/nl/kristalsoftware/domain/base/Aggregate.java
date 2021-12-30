package nl.kristalsoftware.domain.base;

public interface Aggregate<R> {

    R getReference();

    void setNumberOfEvents(int size);

}
