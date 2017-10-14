package com.andrewbogdanovich.github.epamproject.json.parsing;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Tom on 14.10.2017.
 */

class UsersListWithObjectGson implements IUserList {
    @SerializedName("users")
    private List<UserGson> mUserList;

    @SerializedName("backendVersion")
    private Integer backendVersion;

    @Override
    public List<UserGson> getUserList() {
        return mUserList;
    }

    public Integer getBackendVersion() {
        return backendVersion;
    }
}
