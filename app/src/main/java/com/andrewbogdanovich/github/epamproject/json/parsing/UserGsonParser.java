package com.andrewbogdanovich.github.epamproject.json.parsing;

import com.google.gson.Gson;

/**
 * Created by Tom on 14.10.2017.
 */

public class UserGsonParser implements IUserParser {

    private final String mSource;

    UserGsonParser(final String pSource){
        mSource = pSource;
    }

    @Override
    public IUser parse() throws Exception {
        return new Gson().fromJson(mSource,UserGson.class);
    }
}
