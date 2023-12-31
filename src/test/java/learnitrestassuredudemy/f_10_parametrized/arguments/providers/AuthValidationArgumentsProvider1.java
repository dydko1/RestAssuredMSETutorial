package learnitrestassuredudemy.f_10_parametrized.arguments.providers;

import learnitrestassuredudemy.f_10_parametrized.arguments.holders.AuthValidationArgumentsHolder1;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

import static learnitrestassuredudemy.f_10_parametrized.consts.UrlParamValues.VALID_KEY;
import static learnitrestassuredudemy.f_10_parametrized.consts.UrlParamValues.VALID_TOKEN;

public class AuthValidationArgumentsProvider1 implements ArgumentsProvider {
    @Override
    public Stream provideArguments(ExtensionContext context) {
        return Stream.of(
                new AuthValidationArgumentsHolder1(
                        Collections.emptyMap(),
                        "invalid key"
                ),
                new AuthValidationArgumentsHolder1(
                        Map.of("key", VALID_KEY),
                        "unauthorized card permission requested"
                ),
                new AuthValidationArgumentsHolder1(
                        Map.of("token", VALID_TOKEN),
                        "invalid key"
                )
        ).map(Arguments::of);
    }
}