package com.andrewbogdanovich.github.epamproject.json.parsing;

import org.json.JSONObject;

/**
 * Created by Tom on 14.10.2017.
 */

public class UserJSONWrapper implements IUser {

    private final static String ID = "id";
    private final static String NAME = "name";
    private final static String AGE = "age";
    private final static String CITY = "city";

    private final JSONObject mJsonObject;

    UserJSONWrapper(final JSONObject pJsonObject) {
        mJsonObject = pJsonObject;
    }

    @Override
    public long getId() {
        return mJsonObject.optLong(ID);
    }

    @Override
    public String getName() {
        return mJsonObject.optString(NAME);
    }

    @Override
    public int getAge() {
        return mJsonObject.optInt(AGE);
    }

    @Override
    public String getCity() {
        return mJsonObject.optString(CITY);
    }
}
