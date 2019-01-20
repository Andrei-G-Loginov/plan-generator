package de.lendico.plangenerator.controller.model.response;

/**
 * Representation of base JSON response for {@code PlanGenegatorController}.
 *
 * @author Andrei
 *
 */
public class BaseResponse {

    private Boolean success = Boolean.TRUE;
    private String errorCode = "0";
    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "success=" + success +
                ", errorCode='" + errorCode + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
