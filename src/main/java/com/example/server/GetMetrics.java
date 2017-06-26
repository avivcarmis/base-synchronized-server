package com.example.server;

import com.example.metrics.MetricsManager;
import io.github.avivcarmis.trafficante.exceptions.APIException;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by Mamot on 6/26/2017.
 */
public class GetMetrics extends Endpoint<Void, Map<String, Object>> {

    public GetMetrics() {
        super(RequestMethod.GET, false, false);
    }

    @Override
    protected Map<String, Object> handle(Void request) throws APIException {
        return MetricsManager.jsonReport();
    }

}
