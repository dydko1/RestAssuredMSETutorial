package learnitrestassuredudemy.f_10_parametrized.arguments.holders;

import java.util.Map;

public class AuthValidationArgumentsHolder1 {
    private final Map<String, String> authParams;
    private final String errorMessage;

    public AuthValidationArgumentsHolder1(Map<String, String> authParams, String errorMessage) {
        this.authParams = authParams;
        this.errorMessage = errorMessage;
    }

    public Map<String, String> getAuthParams() {
        return authParams;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
