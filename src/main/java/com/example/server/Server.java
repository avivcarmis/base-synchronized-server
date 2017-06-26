package com.example.server;

import com.example.config.ClusterConfig;
import com.example.config.LocalConfig;
import com.example.utils.EncodingUtils;
import io.github.avivcarmis.confeager.sources.ConfeagerSourceSystemProperties;
import io.github.avivcarmis.trafficante.core.ServerNamingStrategy;
import io.github.avivcarmis.trafficante.core.Trafficante;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Mamot on 6/21/2017.
 */
public class Server {

    public static final LocalConfig LOCAL_CONFIG = ConfeagerSourceSystemProperties.INSTANCE.bind(LocalConfig.class);

    public static final ClusterConfig CLUSTER_CONFIG = ConfeagerSourceSystemProperties.INSTANCE.bind(ClusterConfig.class);

    public static final String APPLICATION_VERSION = loadApplicationVersion();

    public static final Date UP_SINCE = new Date();

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

    private static String loadApplicationVersion() {
        try {
            return EncodingUtils.readResourceFile("/version");
        } catch (IOException e) {
            throw new RuntimeException("could not load server version", e);
        }
    }

}
