package com.andrewbogdanovich.github.epamproject.json.parsing;

import java.io.InputStream;

/**
 * Created by Tom on 14.10.2017.
 */

public class UsersListParserFactory {

    public IUserListParser createParser(InputStream pSource) throws Exception {
        return new UsersListGSONParser(pSource);
    }

    public IUserListParser createParserForResponceWithObject(InputStream pSource) {
        return new UserListGsonParserWithObject(pSource);
    }
}
