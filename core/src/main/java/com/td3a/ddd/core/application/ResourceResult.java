package com.td3a.ddd.core.application;

import com.td3a.ddd.core.exceptions.ApplicationDomainException;
import com.td3a.ddd.core.exceptions.ApplicationInfrastructureException;
import com.td3a.ddd.core.exceptions.ApplicationValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.function.Supplier;

@Slf4j
public class ResourceResult {

    private ResourceResult(String requestType) {
        this.requestType = requestType;
    }

    private String requestType;
    private HttpStatus successfulStatus;
    private HttpStatus errorStatus;
    private HttpStatus failedStatus;

    public static ResourceResult with(String requestType) {
        return new ResourceResult(requestType);
    }

    public ResourceResult onSuccess(HttpStatus status) {
        this.successfulStatus = status;
        return this;
    }

    public ResourceResult onError(HttpStatus status) {
        this.errorStatus = status;
        return this;
    }

    public ResourceResult onFailed(HttpStatus status) {
        this.failedStatus = status;
        return this;
    }

    public <T> ResponseEntity<T> execute(Supplier<T> supplier) {
        try {
            T entity = supplier.get();
            return new ResponseEntity<>(entity, successfulStatus);
        } catch (ApplicationValidationException ex) {
            log.warn(String.format("The request of %s is invalid", requestType));
            return new ResponseEntity<>(errorStatus);
        } catch (ApplicationDomainException ex) {
            log.warn( String.format("Exception raised %s REST Call", requestType));
            return new ResponseEntity<>(failedStatus);
        } catch (ApplicationInfrastructureException ex) {
            log.error( String.format("Fatal exception raised %s REST Call", requestType));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> execute(Runnable runnable) {
        try {
            runnable.run();
            return new ResponseEntity<>(successfulStatus);
        } catch (ApplicationValidationException ex) {
            log.warn( String.format("The request of %s is invalid", requestType));
            return new ResponseEntity<>(errorStatus);
        } catch (ApplicationDomainException ex) {
            log.warn( String.format("Exception raised %s REST Call", requestType));
            return new ResponseEntity<>(failedStatus);
        } catch (ApplicationInfrastructureException ex) {
            log.error( String.format("Fatal exception raised %s REST Call", requestType));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
