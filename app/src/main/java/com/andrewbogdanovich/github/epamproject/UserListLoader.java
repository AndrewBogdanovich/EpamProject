package com.andrewbogdanovich.github.epamproject;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.andrewbogdanovich.github.epamproject.http.HttpClient;
import com.andrewbogdanovich.github.epamproject.http.IHttpClient;
import com.andrewbogdanovich.github.epamproject.json.parsing.IUserList;
import com.andrewbogdanovich.github.epamproject.json.parsing.UserGson;
import com.andrewbogdanovich.github.epamproject.json.parsing.UsersListParserFactory;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Tom on 23.10.2017.
 */

public class UserListLoader extends AsyncTask<Context, Void, String> {
    public static final String NO_DATA = "No data";
    private IUserList userListWithObject;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {
        final UsersListParserFactory usersListParserFactory = new UsersListParserFactory();
        IHttpClient httpClient = new HttpClient();

        userListWithObject = null;

        httpClient.request(IApi.USER_URL, new HttpClient.ResponseListener() {
            @Override
            public void onResponse(InputStream pInputStream) {
                try {
                    userListWithObject = usersListParserFactory.createParserForResponceWithObject(pInputStream).parse();
                } catch (final Exception e) {
                    onError(e);
                }

            }

            @Override
            public void onError(final Throwable pThrowable) {

            }
        });





    context = params[0];

        if (userListWithObject == null) {
        return NO_DATA;
    }

    List<UserGson> usersList = userListWithObject.getUserList();

        if (usersList == null || usersList.isEmpty()) {
        return NO_DATA;
    }

        return usersList.get(usersList.size() -1).getName();
}

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }
}
