package com.andrewbogdanovich.github.epamproject.json.parsing;

import com.google.gson.annotations.SerializedName;

import java.util.List;



class UsersListWithObjectGson implements IUserList {
    @SerializedName("items")
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
