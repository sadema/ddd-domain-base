package nl.kristalsoftware.domain.base;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import nl.kristalsoftware.domain.base.annotations.DomainEntity;
import org.springframework.context.ApplicationEventPublisher;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Getter
@DomainEntity
@RequiredArgsConstructor
public class BaseAggregateRoot<R,T> implements Aggregate {

    private final R reference;

    private final ApplicationEventPublisher eventPublisher;

    private Integer numberOfEvents;

    protected void sendEvent(T event) {
        eventPublisher.publishEvent(event);
    }

    public long getEpochMilliFromLocalDate(LocalDate localDate) {
        return localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public LocalDate getLocalDateFromMillis(Long date) {
        Instant instant = Instant.ofEpochMilli(date);
        return LocalDate.ofInstant(instant, ZoneId.systemDefault());
    }

    @Override
    public void setNumberOfEntities(int size) {
        numberOfEvents = size;
    }

    public boolean exists() {
        return numberOfEvents > 0;
    }

    public boolean notExists() {
        return !exists();
    }

}
