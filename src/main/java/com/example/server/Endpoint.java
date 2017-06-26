package com.example.server;

import com.example.metrics.MetricsManager;
import com.example.metrics.MetricsTransaction;
import com.example.metrics.MetricsUnit;
import io.github.avivcarmis.trafficante.core.BasicEndpoint;
import io.github.avivcarmis.trafficante.exceptions.APIException;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Mamot on 6/26/2017.
 */
abstract public class Endpoint<REQ, RES> extends BasicEndpoint<REQ, RES, APIResponse<RES>> {

    private final MetricsUnit _metricsUnit;

    public Endpoint(RequestMethod httpMethod, boolean enableFlowLogging, boolean enableMetrics) {
        super(httpMethod, enableFlowLogging);
        _metricsUnit = MetricsManager
                .registerUnit("endpoints", getHttpMethod() + defaultPathProvider(), !enableMetrics);
    }

    @Override
    protected APIResponse<RES> wrapResponse(RES response) {
        return APIResponse.success(response);
    }

    @Override
    protected APIResponse<RES> wrapFailure(Throwable t) {
        return APIResponse.failure(t);
    }

    @Override
    public RES defaultInvocationWrapper(REQ request) throws APIException {
        MetricsTransaction transaction = _metricsUnit.start();
        RES response;
        try {
            response = super.defaultInvocationWrapper(request);
        } catch (Throwable t) {
            transaction.failure();
            throw t;
        }
        transaction.success();
        return response;
    }
}