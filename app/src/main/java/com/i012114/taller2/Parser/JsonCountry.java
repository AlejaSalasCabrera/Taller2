package com.i012114.taller2.Parser;

import com.i012114.taller2.Models.Country;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aula7 on 26/09/17.
 */

public class JsonCountry {

    public static List<Country> getData(String content) throws JSONException {
        JSONArray jsonArray = new JSONArray(content);
        List<Country> countryList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject item = jsonArray.getJSONObject(i);
            Country country = new Country();
            country.setName(item.getString("name"));
            country.setCapital(item.getString("capital"));
            country.setAlphacode(item.getString("alpha3Code"));
            countryList.add(country);
        }
        return countryList;
    }

}
