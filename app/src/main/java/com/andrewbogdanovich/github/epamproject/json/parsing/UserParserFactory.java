package com.andrewbogdanovich.github.epamproject.json.parsing;

/**
 * Created by Tom on 14.10.2017.
 */

public class UserParserFactory {
    public IUserParser createParser(String pSource) {
        return new UserJSONObjectParser(pSource);
    }
}
