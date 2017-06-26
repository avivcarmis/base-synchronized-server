package com.example.endpoints;

import com.example.server.Endpoint;
import io.github.avivcarmis.trafficante.exceptions.APIException;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Mamot on 6/21/2017.
 */
public class ExampleEndpoint extends Endpoint<ExampleEndpoint.Request, ExampleEndpoint.Response> {

    public ExampleEndpoint() {
        super(RequestMethod.GET, true, true);
    }

    @Override
    protected Response handle(Request request) throws APIException {
        return new Response("request was: " + request.requestProperty);
    }

    public static class Request {

        private String requestProperty;

    }

    public static class Response {

        private final String responseProperty;

        public Response(String responseProperty) {
            this.responseProperty = responseProperty;
        }
    }

}