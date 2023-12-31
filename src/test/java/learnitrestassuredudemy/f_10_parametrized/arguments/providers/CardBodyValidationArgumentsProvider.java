package learnitrestassuredudemy.f_10_parametrized.arguments.providers;

import learnitrestassuredudemy.f_10_parametrized.arguments.holders.CardBodyValidationArgumentsHolder;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Map;
import java.util.stream.Stream;

import static learnitrestassuredudemy.f_10_parametrized.consts.UrlParamValues.EXISTING_LIST_ID;

public class CardBodyValidationArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                        new CardBodyValidationArgumentsHolder(Map.of("name", 12345,
                                "idList", EXISTING_LIST_ID),
                                "invalid value for name"
                        ),
                        new CardBodyValidationArgumentsHolder(
                                Map.of(
                                        "name", "New cardMiro"
                                ),
                                "invalid value for idList"
                        ),
                        new CardBodyValidationArgumentsHolder(
                                Map.of(
                                        "name", "New card",
                                        "idList", "invalid"
                                ),
                                "invalid value for idList"
                        )
                )
                .map(Arguments::of);
    }
}