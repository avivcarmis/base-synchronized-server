package com.example;

import io.github.avivcarmis.trafficante.core.BasicEndpoint;
import io.github.avivcarmis.trafficante.exceptions.APIException;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Mamot on 6/21/2017.
 */
public class GetUserById extends BasicEndpoint<GetUserById.Request, GetUserById.Response, GetUserById.Response> {

    public GetUserById() {
        super(RequestMethod.GET, true);
    }

    @Override
    protected Response handle(Request request) throws APIException {
        Integer userId = request.userId;
        return new Response("aviv", "carmi", "what.com");
    }

    @Override
    protected Response wrapResponse(Response response) {
        return response;
    }

    @Override
    protected Response wrapFailure(Throwable throwable) {
        return new Response(null, null, null);
    }

    public static class Request {

        private Integer userId;

    }

    public static class Response {

        private final String firstName;

        private final String lastName;

        private final String websiteURL;

        public Response(String firstName, String lastName, String websiteURL) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.websiteURL = websiteURL;
        }

    }

}