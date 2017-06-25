package com.example;

import io.github.avivcarmis.confeager.ConfeagerSource;
import io.github.avivcarmis.confeager.sources.ConfeagerSourceSystemProperties;
import io.github.avivcarmis.trafficante.core.ServerNamingStrategy;
import io.github.avivcarmis.trafficante.core.Trafficante;

/**
 * Created by Mamot on 6/21/2017.
 */
public class Server {

    public static final LocalConfig LOCAL_CONFIG = ConfeagerSourceSystemProperties.INSTANCE.bind(LocalConfig.class);

    public static void main(String[] args) {
        Trafficante.start(
                "com.example",
                ServerNamingStrategy.SNAKE_CASE,
                LOCAL_CONFIG.host.get(),
                LOCAL_CONFIG.port.get(),
                LOCAL_CONFIG.enableSwagger.get(),
                false,
                args
        );
    }

}
