package com.example.server;

import io.github.avivcarmis.trafficante.core.BasicErrorHandler;

/**
 * Created by Mamot on 6/26/2017.
 */
public class ErrorHandler extends BasicErrorHandler<APIResponse<?>> {

    @Override
    protected APIResponse<?> wrapFailure(Throwable t) {
        return APIResponse.failure(t);
    }

}