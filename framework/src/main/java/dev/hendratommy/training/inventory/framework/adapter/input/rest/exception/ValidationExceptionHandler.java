package dev.hendratommy.training.inventory.framework.adapter.input.rest.exception;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Provider
public class ValidationExceptionHandler implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException e) {
        var violations = e.getConstraintViolations();
        var map = new HashMap<String, String>();
        violations.forEach(violation -> {
            var path = violation.getPropertyPath().toString().split("\\.");
            map.put(path[path.length-1], violation.getMessage());
        });
        var responseModel = new ValidationResponse(Response.Status.BAD_REQUEST.getStatusCode(), map);
        return Response.status(Response.Status.BAD_REQUEST).entity(responseModel).build();
    }

    class ValidationResponse implements Serializable {
        private static final long serialVersionUID = 6484185993994270214L;

        private int status;
        private Map<String, String> violations = new HashMap<>();

        public ValidationResponse(int status, Map<String, String> violations) {
            this.status = status;
            this.violations = violations;
        }

        public int getStatus() {
            return status;
        }

        public Map<String, String> getViolations() {
            return violations;
        }
    }
}
