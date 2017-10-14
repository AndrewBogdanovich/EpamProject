package com.andrewbogdanovich.github.epamproject.json.parsing;

import java.util.List;

/**
 * Created by Tom on 14.10.2017.
 */

public class UsersListGson implements IUserList {

    private List<UserGson> mUsersList;

    public UsersListGson(List<UserGson> mUsersList) {
        this.mUsersList = mUsersList;
    }

    @Override
    public List<UserGson> getUserList() {
        return mUsersList;
    }
}

