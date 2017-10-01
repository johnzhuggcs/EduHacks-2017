package com.company;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GoogleParser {

    /** manages JSON
     *
     * @param json, must be string, will not be passed in if NULL
     *
     * {

     */
    public GoogleParser(){

        boolean yes = true;


    }

    public HashMap[][] actuallyParsing(String json){
        try {
            JSONObject response = new JSONObject(json);
            JSONArray routes = response.getJSONArray("routes");
            HashMap[][] parsedRouteCoords = new HashMap[][]{};



            for(int x = 0; x<routes.length() - 1; x++){
                parsedRouteCoords[x] = routeDataInitializer(routes.getJSONObject(x));
            }
            return parsedRouteCoords;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HashMap[] routeDataInitializer(JSONObject route){
        try {
            JSONArray leg = route.getJSONArray("legs");
            HashMap[] parsedRouteSteps = new HashMap[]{};
            for(int x = 0; x<leg.length() - 1;x++){
                parsedRouteSteps = legDataInitializer(leg.getJSONObject(x), parsedRouteSteps);
            }
            return parsedRouteSteps;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HashMap[] legDataInitializer(JSONObject leg, HashMap[] parsedRouteSteps){
        try {
            JSONArray steps = leg.getJSONArray("steps");

            for(int x = 0; x<steps.length() - 1;x++){
                parsedRouteSteps[x] = startEndInitializer(steps.getJSONObject(x));
            }
            return parsedRouteSteps;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }

    // [route, route ...]
    // [[step, step], [step, step]]
    // [[{[lat, lon]:[lat, lon]}, {[lat, lon]:[lat, lon]}]]

    public HashMap startEndInitializer(JSONObject step){
        try {
            JSONObject start = step.getJSONObject("start_location");
            List<String> startGeo = Arrays.asList(start.get("lat").toString(), start.get("lon").toString());

            JSONObject end = step.getJSONObject("end_location");
            List<String> endGeo = Arrays.asList(end.get("lat").toString(), end.get("lon").toString());

            HashMap<List<String>, List<String>> stepCoords = new HashMap<>();

            stepCoords.put(startGeo, endGeo);

            return stepCoords;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    // parser

}
