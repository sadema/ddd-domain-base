package nl.kristalsoftware.domain.base;

import org.springframework.context.ApplicationEventPublisher;

public interface EventStore<T,U> {

    T loadAggregate(ApplicationEventPublisher eventPublisher);

    T loadAggregate(U memberReference, ApplicationEventPublisher eventPublisher);

}
