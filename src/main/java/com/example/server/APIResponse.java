package com.example.server;

/**
 * Created by Mamot on 6/26/2017.
 */
public class APIResponse<T> {

    private final boolean success;

    private final T result;

    private final String error;

    private final ServerInfo serverInfo;

    private APIResponse(boolean success, T result, String error) {
        this.success = success;
        this.result = result;
        this.error = error;
        this.serverInfo = ServerInfo.INSTANCE;
    }

    static <T> APIResponse<T> success(T result) {
        return new APIResponse<>(true, result, null);
    }

    static <T> APIResponse<T> failure(Throwable t) {
        return new APIResponse<>(false, null, t.getMessage());
    }

    public static class ServerInfo {

        private static final ServerInfo INSTANCE = new ServerInfo();

        private final String environment = Server.LOCAL_CONFIG.environment.get().name();

        private final String machineId = Server.LOCAL_CONFIG.machineId.get();

        private final String version = Server.APPLICATION_VERSION;

    }

}