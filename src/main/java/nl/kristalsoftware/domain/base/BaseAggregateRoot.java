package nl.kristalsoftware.domain.base;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import nl.kristalsoftware.domain.base.annotations.DomainEntity;
import org.springframework.context.ApplicationEventPublisher;

import java.util.UUID;

@Getter
@DomainEntity
@RequiredArgsConstructor
public class BaseAggregateRoot<R extends TinyUUIDType> implements Aggregate {

    private final R reference;

    private final ApplicationEventPublisher eventPublisher;

    protected void sendEvent(BaseEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public UUID getReferenceValue() {
        return reference.getValue();
    }
}
