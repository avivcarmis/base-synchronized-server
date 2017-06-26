package com.example.metrics;

import com.codahale.metrics.*;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mamot on 6/26/2017.
 */
public class ConcreteMetricsUnit implements MetricsUnit {

    private final Meter _enter;

    private final AbsoluteRateMeter.TenSecond _tenSecondEnter;

    private final Meter _exit;

    private final Counter _active;

    private final Timer _timer;

    ConcreteMetricsUnit(String groupName, String unitName, MetricRegistry metricRegistry) {
        _enter = metricRegistry.meter(MetricRegistry.name(groupName, unitName, "enter"));
        _tenSecondEnter = new AbsoluteRateMeter.TenSecond();
        _exit = metricRegistry.meter(MetricRegistry.name(groupName, unitName, "exit"));
        _active = metricRegistry.counter(MetricRegistry.name(groupName, unitName, "active"));
        _timer = metricRegistry.timer(MetricRegistry.name(groupName, unitName, "timer"));
    }

    @Override
    public MetricsTransaction start() {
        _enter.mark();
        _tenSecondEnter.mark();
        _active.inc();
        Timer.Context context = _timer.time();
        return new ConcreteTransaction(context);
    }

    @Override
    public Map<String, Object> jsonReport() {
        Map<String, Object> enterReport = jsonReport(_enter);
        enterReport.put("lastTenSecondsRate", _tenSecondEnter.getResult());
        return ImmutableMap.of(
                "enter", enterReport,
                "exit", jsonReport(_exit),
                "active", jsonReport(_active),
                "execution", jsonReport(_timer)
        );
    }

    public class ConcreteTransaction implements MetricsTransaction {

        private final Timer.Context _context;

        private ConcreteTransaction(Timer.Context context) {
            _context = context;
        }

        @Override
        public void success() {
            _exit.mark();
            _active.dec();
            _context.stop();
        }

        @Override
        public void failure() {
            _exit.mark();
            _active.dec();
        }

    }

    private static Map<String, Object> jsonReport(Meter meter) {
        Map<String, Object> result = new HashMap<>(5);
        result.put("meanRate", meter.getMeanRate());
        result.put("oneMinuteRate", meter.getOneMinuteRate());
        result.put("fiveMinuteRate", meter.getFiveMinuteRate());
        result.put("fifteenMinuteRate", meter.getFifteenMinuteRate());
        result.put("count", meter.getCount());
        return result;
    }

    private static Map<String, Object> jsonReport(Counter counter) {
        return ImmutableMap.of("count", counter.getCount());
    }

    private static Map<String, Object> jsonReport(Timer timer) {
        Snapshot snapshot = timer.getSnapshot();
        Map<String, Object> result = new HashMap<>(10);
        result.put("min", snapshot.getMin() / 1000);
        result.put("max", snapshot.getMax() / 1000);
        result.put("median", snapshot.getMedian() / 1000);
        result.put("mean", snapshot.getMean() / 1000);
        result.put("percentile75th", snapshot.get75thPercentile() / 1000);
        result.put("percentile95th", snapshot.get95thPercentile() / 1000);
        result.put("percentile98th", snapshot.get98thPercentile() / 1000);
        result.put("percentile99th", snapshot.get99thPercentile() / 1000);
        result.put("percentile999th", snapshot.get999thPercentile() / 1000);
        result.put("StandardDeviation", snapshot.getStdDev() / 1000);
        return result;
    }

}
