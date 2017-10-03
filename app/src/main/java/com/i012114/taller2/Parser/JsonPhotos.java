package com.i012114.taller2.Parser;



import com.i012114.taller2.Models.Photos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aula7 on 3/10/17.
 */

public class JsonPhotos {
    public static List<Photos> getData(String content) throws JSONException {
        JSONArray jsonArray = new JSONArray(content);
        List<Photos> countryList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject item = jsonArray.getJSONObject(i);
            Photos country = new Photos();
            country.setTitle(item.getString("title"));
            country.setUrl(item.getString("url"));
            country.setThumbnailUrl(item.getString("thumbnailUrl"));
            countryList.add(country);
        }
        return countryList;
    }
}
