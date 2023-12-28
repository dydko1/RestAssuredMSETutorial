package learnitrestassuredudemy.f_10_parametrized.arguments.providers;

import learnitrestassuredudemy.f_10_parametrized.arguments.holders.AuthValidationArgumentsHolder;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

import static learnitrestassuredudemy.f_10_parametrized.consts.UrlParamValues.VALID_KEY;
import static learnitrestassuredudemy.f_10_parametrized.consts.UrlParamValues.VALID_TOKEN;

public class AuthValidationArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                new AuthValidationArgumentsHolder(
                        Collections.emptyMap()
                ),
                new AuthValidationArgumentsHolder(
                        Map.of("key", VALID_KEY)
                ),
                new AuthValidationArgumentsHolder(
                        Map.of("token", VALID_TOKEN)
                )
        ).map(Arguments::arguments);
    }
}
