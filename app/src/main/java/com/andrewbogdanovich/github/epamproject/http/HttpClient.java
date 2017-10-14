package com.andrewbogdanovich.github.epamproject.http;

import java.io.InputStream;

/**
 * Created by Tom on 14.10.2017.
 */

public class HttpClient implements IHttpClient {


    public static final String IMPLEMENT_HTTP_CLIENT = "implement httpClient";

    @Override
    public InputStream request(String url) {
        throw new IllegalStateException(IMPLEMENT_HTTP_CLIENT);
    }
}
