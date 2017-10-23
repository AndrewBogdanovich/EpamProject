package com.andrewbogdanovich.github.epamproject.http;

import java.io.InputStream;

/**
 * Created by Tom on 14.10.2017.
 */

public interface IHttpClient {
    void request(String url, HttpClient.ResponseListener listener);
}
