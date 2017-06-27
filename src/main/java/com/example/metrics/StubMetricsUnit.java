package com.example.metrics;

import java.util.Map;

/**
 * Created by Mamot on 6/26/2017.
 */
public class StubMetricsUnit implements MetricsUnit {

    static final StubMetricsUnit INSTANCE = new StubMetricsUnit();

    private StubMetricsUnit() {}

    @Override
    public MetricsTransaction start() {
        return StubTransaction.INSTANCE;
    }

    @Override
    public Map<String, Object> jsonReport() {
        return null;
    }

    public static class StubTransaction implements MetricsTransaction {

        private static final StubTransaction INSTANCE = new StubTransaction();

        @Override
        public void success() {}

        @Override
        public void failure() {}

    }

}
