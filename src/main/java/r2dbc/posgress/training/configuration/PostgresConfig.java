package r2dbc.posgress.training.configuration;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;

@Configuration
@RequiredArgsConstructor
public class PostgresConfig extends AbstractR2dbcConfiguration {

    private final DatabaseProperties properties;

    @Bean
    @Override
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get(ConnectionFactoryOptions.builder()
                .option(DRIVER, properties.getDriver())
                .option(PROTOCOL, properties.getProtocol())
                .option(HOST, properties.getHost())
                .option(PORT, properties.getPort())
                .option(USER, properties.getUsername())
                .option(PASSWORD, properties.getPassword())
                .option(DATABASE, properties.getDatabase())
                .build());
    }
}

