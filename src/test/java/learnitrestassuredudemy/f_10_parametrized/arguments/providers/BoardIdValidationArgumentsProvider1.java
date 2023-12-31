package learnitrestassuredudemy.f_10_parametrized.arguments.providers;

import learnitrestassuredudemy.f_10_parametrized.arguments.holders.BoardIdValidationArgumentsHolder;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Map;
import java.util.stream.Stream;

public class BoardIdValidationArgumentsProvider1 implements ArgumentsProvider {
    @Override
    public Stream provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                new BoardIdValidationArgumentsHolder(
                        Map.of("id", "invalid"),
                        "invalid id",
                        HttpStatus.SC_BAD_REQUEST
                ),
                new BoardIdValidationArgumentsHolder(
                        Map.of("id", "60d847d9aad2437cb984f8e1"),
                        "The requested resource was not found.",
                        HttpStatus.SC_NOT_FOUND
                )

        ).map(Arguments::of);
    }
}