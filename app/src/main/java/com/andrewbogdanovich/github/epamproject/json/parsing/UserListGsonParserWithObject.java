package com.andrewbogdanovich.github.epamproject.json.parsing;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by Tom on 14.10.2017.
 */

public class UserListGsonParserWithObject implements IUserListParser {

    private final InputStream mInputStream;

    public UserListGsonParserWithObject(InputStream pInputStream) {
        this.mInputStream = pInputStream;
    }

    @Override
    public IUserList parse() throws Exception {
        Reader reader = new InputStreamReader(mInputStream);
        return new Gson().fromJson(reader, UsersListWithObjectGson.class);
    }
}
