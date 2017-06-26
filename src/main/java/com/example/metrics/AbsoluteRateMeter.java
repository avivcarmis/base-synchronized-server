package com.example.metrics;

import com.codahale.metrics.Metric;

import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by avivc on 7/6/2016.
 */
public class AbsoluteRateMeter implements Metric {

    private static final ScheduledExecutorService EXECUTOR_SERVICE =
            Executors.newScheduledThreadPool(1);

    private final Object _updateLock;

    private final int _intervalCount;

    private final AtomicInteger _currentIntervalCount;

    private final LinkedList<Integer> _recentIntervals;

    private int _recentIntervalSum;

    public AbsoluteRateMeter(int intervalMillis, int intervalCount) {
        _updateLock = new Object();
        _intervalCount = intervalCount;
        _currentIntervalCount = new AtomicInteger(0);
        _recentIntervals = new LinkedList<>();
        for (int i = 0; i < _intervalCount; i++) {
            _recentIntervals.add(0);
        }
        _recentIntervalSum = 0;
        EXECUTOR_SERVICE.scheduleAtFixedRate(this::update, intervalMillis, intervalMillis, TimeUnit.MILLISECONDS);
    }

    public double getResult() {
        return (double) _recentIntervalSum / (double) _intervalCount;
    }

    protected void mark() {
        _currentIntervalCount.incrementAndGet();
    }

    private void update() {
        synchronized (_updateLock) {
            Integer last = _recentIntervals.removeLast();
            Integer first = _currentIntervalCount.getAndSet(0);
            if (last == null) {
                last = 0;
            }
            _recentIntervals.addFirst(first);
            _recentIntervalSum = _recentIntervalSum + first - last;
        }
    }

    public static class TenSecond extends AbsoluteRateMeter {

        public TenSecond() {
            super(1000, 10);
        }

    }

}