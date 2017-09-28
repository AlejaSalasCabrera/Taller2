package com.i012114.taller2.Parser;


import com.i012114.taller2.Models.CountryDetail;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aula7 on 28/09/17.
 */

public class JsonCountryDetail {

    public static List<CountryDetail> getData(String content) throws JSONException {
        JSONArray jsonArray = new JSONArray(content);
        List<CountryDetail> countryDetailList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject item = jsonArray.getJSONObject(i);
            JSONArray languages = item.getJSONArray("languages");
            JSONObject native1 = languages.getJSONObject(0);
            CountryDetail countryDetail = new CountryDetail();
            countryDetail.setSubregion(item.getString("subregion"));
            countryDetail.setLanguages(native1.getString("nativeName"));
            countryDetail.setArea(item.getInt("area"));
            countryDetailList.add(countryDetail);
        }
        return countryDetailList;
    }
}
