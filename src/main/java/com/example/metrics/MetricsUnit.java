package com.example.metrics;

import java.util.Map;

/**
 * Created by Mamot on 6/26/2017.
 */
public interface MetricsUnit {

    MetricsTransaction start();

    Map<String, Object> jsonReport();

}
