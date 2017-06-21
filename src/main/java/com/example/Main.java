package com.example;

import io.github.avivcarmis.trafficante.core.ServerNamingStrategy;
import io.github.avivcarmis.trafficante.core.Trafficante;

/**
 * Created by Mamot on 6/21/2017.
 */
public class Main {

    public static void main(String[] args) {
        Trafficante.start(
                "com.example",
                ServerNamingStrategy.SNAKE_CASE,
                "0.0.0.0",                          // host name to be registered - "0.0.0.0" to allow all
                8080,                               // port to be used
                true,                               // whether or not to enable swagger - should typically be `false` in production environments
                false,                               // whether or not to enable JMX support
                args                                // program arguments - may be null
        );
    }

}
