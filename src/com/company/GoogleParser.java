package com.company;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleParser {

   // https://maps.googleapis.com/maps/api/directions/json?parameters
   // https://maps.googleapis.com/maps/api/directions/json?origin=Toronto&destination=Montreal&key=AIzaSyDGfTWMXhGEkmUGYn9E5ZFVO1J7krYEHvk
    // API-Key: AIzaSyDGfTWMXhGEkmUGYn9E5ZFVO1J7krYEHvk

    private String googleurl = "https://maps.googleapis.com/maps/api/directions/json?";
    private String origin = "origin=";
    private String dst = "&destination=";
    private String key = "&key=AIzaSyDGfTWMXhGEkmUGYn9E5ZFVO1J7krYEHvk";

    public GoogleParser(String origin, String dst){
//        googleurl += googleurl + this.origin + dst + key
//        origin.concat(origin);
//        dst.concat(dst);
//        googleurl.concat(origin);
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
