package com.comrades.app.core.bases;

import javax.validation.ConstraintViolation;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	private final transient Set<ConstraintViolation> violations;

    public BusinessException() {
        super();
        violations = null;
    }

    public BusinessException(String message, Throwable cause,
                             boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        violations = null;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        violations = null;
    }

    public BusinessException(String message) {
        super(message);
        violations = null;
    }

    public BusinessException(Throwable cause) {
        super(cause);
        violations = null;
    }

    public BusinessException(Set<ConstraintViolation> violations) {
        this.violations = CloneUtils.clone(violations);
    }

    public Set<ConstraintViolation> getViolations() {
        return CloneUtils.clone(violations);
    }
}
