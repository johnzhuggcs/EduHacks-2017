package com.company;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class GoogleParser {

    // Manages JSON
    public GoogleParser(){

    }

    public void parseResponce(String json){
        try {
            JSONObject resp = new JSONObject(json);
            JSONArray routes = resp.getJSONArray("routes");
            //System.out.println(routes.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    // parser

}
