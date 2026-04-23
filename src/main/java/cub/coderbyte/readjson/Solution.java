package cub.leetcode.easy.arrangingcoins;

import com.google.gson.*;
import okhttp3.*;

class Solution2 {
    private static final String POSTS_URL = "https://coderbyte.com/api/challenges/json/all-posts";

    public static int fetchAndCountPosts(final String postsUrl) throws Exception {
        OkHttpClient client = new OkHttpClient();
        Request req = new Request.Builder().url(postsUrl).get().build();
        Response res = client.newCall(req).execute();
        JsonArray arr = JsonParser.parseString(res.toString()).getAsJsonArray();
        return arr.size();
    }

    public static void main(String[] args) throws Exception {
        int numberOfPosts = fetchAndCountPosts(POSTS_URL);
        System.out.println("Number of posts: " + numberOfPosts);
    }
}
