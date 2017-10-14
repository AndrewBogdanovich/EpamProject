package com.andrewbogdanovich.github.epamproject.json.parsing;

/**
 * Created by Tom on 14.10.2017.
 */

import org.json.JSONObject;

public class UserJSONObjectParser implements IUserParser {

    private final String mSource;

    UserJSONObjectParser(final String pSource) {
        mSource = pSource;

    }

    @Override
    public IUser parse() throws Exception {
        final JSONObject jsonObject = new JSONObject(mSource);
        return new UserJSONWrapper(jsonObject);
    }
}
