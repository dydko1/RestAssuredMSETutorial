package learnitrestassuredudemy.f_10_parametrized.arguments.providers;

import learnitrestassuredudemy.f_10_parametrized.arguments.holders.BoardIdValidationArgumentsHolder;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Map;
import java.util.stream.Stream;

public class BoardIdValidationArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                new BoardIdValidationArgumentsHolder(
                        Map.of("id", "6107c3c8772cbe6e3734fc3e"), // Złe id
                        "The requested resource was not found.",
                        404
                ),
                new BoardIdValidationArgumentsHolder(
                        Map.of("id", "invalid"),
                        "invalid id",
                        400
                )
        ).map(Arguments::of);
    }
}
