package com.andrewbogdanovich.github.epamproject.json.parsing;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

/**
 * Created by Tom on 14.10.2017.
 */

public class UsersListGSONParser implements IUserListParser {

    private final InputStream mInputStream;

    public UsersListGSONParser(InputStream pInputStream) {
        this.mInputStream = pInputStream;
    }


    @Override
    public IUserList parse() throws Exception {
        Reader reader = new InputStreamReader(mInputStream);
        UserGson[] result = new Gson().fromJson(reader, UserGson[].class);
        return new UsersListGson(Arrays.asList(result));
    }
}
