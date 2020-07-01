package com.microservices.saga.choreography.supervisor.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Mark field in Bean-class with this annotation,
 * to inject {@link com.microservices.saga.choreography.supervisor.EventLogger}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface InjectEventLogger {
    String value() default "";
}
