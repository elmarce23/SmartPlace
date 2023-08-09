package com.example.smartplace.remote;

public class ApiUtils {
    private ApiUtils() {}
    public static final String BASE_URL = "http://jsonplaceholder.typicode.com/";//localhost or ip local
    public static ApiService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
