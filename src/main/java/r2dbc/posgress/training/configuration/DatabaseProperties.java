package r2dbc.posgress.training.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "database")
public class DatabaseProperties {

    String driver;
    String protocol;
    String host;
    Integer port;
    String username;
    String password;
    String database;
}
