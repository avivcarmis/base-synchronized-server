package com.example.metrics;

import com.codahale.metrics.MetricRegistry;
import com.example.server.Server;
import org.ocpsoft.prettytime.PrettyTime;

import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Created by Mamot on 6/26/2017.
 */
public class MetricsManager {

    private static final MetricRegistry METRIC_REGISTRY = new MetricRegistry();

    private static final ConcurrentHashMap<String, ConcurrentHashMap<String, MetricsUnit>> METRICS_UNITS =
            new ConcurrentHashMap<>();

    private static final PrettyTime PRETTY_TIME = new PrettyTime();

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static MetricsUnit registerUnit(String groupName, String unitName, boolean stub) {
        if (stub) {
            return StubMetricsUnit.INSTANCE;
        }
        return METRICS_UNITS
                .computeIfAbsent(groupName, s -> new ConcurrentHashMap<>())
                .computeIfAbsent(unitName, s -> new ConcreteMetricsUnit(groupName, unitName, METRIC_REGISTRY));
    }

    public static Map<String, Object> jsonReport() {
        Map<String, Object> result = METRICS_UNITS.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                groupEntry -> groupEntry.getValue().entrySet().stream().collect(Collectors.toMap(
                        Map.Entry::getKey,
                        unitEntry -> unitEntry.getValue().jsonReport()
                ))
        ));
        result.put("upSince", DATE_FORMAT.format(Server.UP_SINCE) + " (" + PRETTY_TIME.format(Server.UP_SINCE) + ")");
        return result;
    }

}
