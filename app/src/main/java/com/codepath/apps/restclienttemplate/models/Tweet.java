package com.codepath.apps.restclienttemplate.models;

import com.codepath.apps.restclienttemplate.TimeFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Tweet {

    public String body;
    public String createdAt;
    public User user;

    // for parcel
    public Tweet() {}


    public static Tweet fromJason(JSONObject jsonObject) throws JSONException {

        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        return tweet;
    }

    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {

        List<Tweet> tweets = new ArrayList<>();

        for(int i = 0; i < jsonArray.length(); i++) {
            tweets.add(fromJason(jsonArray.getJSONObject(i)));
        }
        return tweets;
    }

    public static String getFormattedTime(Tweet tweet) {
        return TimeFormatter.getTimeDifference(tweet.createdAt);
    }




}
