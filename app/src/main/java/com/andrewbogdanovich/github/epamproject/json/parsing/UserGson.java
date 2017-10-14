package com.andrewbogdanovich.github.epamproject.json.parsing;

/**
 * Created by Tom on 14.10.2017.
 */

import com.google.gson.annotations.SerializedName;

public class UserGson implements IUser {
    @SerializedName("id")
    private long Id;

    @SerializedName("name")
    private String Name;

    @SerializedName("age")
    private int Age;

    @SerializedName("city")
    private String City;

    @Override
    public long getId() {
        return Id;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public int getAge() {
        return Age;
    }

    @Override
    public String getCity() {
        return City;
    }

}
