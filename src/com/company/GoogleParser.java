package com.company;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GoogleParser {

    /** manages JSON
     *
     *
     *
     * {

     */
    public GoogleParser(){

        boolean yes = true;

    }

    public List<List<HashMap>> parseToLatLon(String json){
        try {
            JSONObject response = new JSONObject(json);
            JSONArray routes = response.getJSONArray("routes");
            List<List<HashMap>> parsedRouteCoords = new ArrayList<List<HashMap>>();

            for(int x = 0; x<routes.length(); x++){
                parsedRouteCoords.add(routeDataInitializer(routes.getJSONObject(x)));
            }
            return parsedRouteCoords;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<HashMap> routeDataInitializer(JSONObject route){
        try {
            JSONArray leg = route.getJSONArray("legs");
            List<HashMap> parsedRouteSteps = new ArrayList<HashMap>();
            for(int x = 0; x<leg.length();x++){
                parsedRouteSteps = legDataInitializer(leg.getJSONObject(x), parsedRouteSteps);
            }
            return parsedRouteSteps;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<HashMap> legDataInitializer(JSONObject leg, List<HashMap> parsedRouteSteps){
        try {
            JSONArray steps = leg.getJSONArray("steps");
            for(int x = 0; x<steps.length();x++){
                parsedRouteSteps.add( startEndInitializer(steps.getJSONObject(x)));
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
            List<String> startGeo = Arrays.asList(start.get("lat").toString(), start.get("lng").toString());

            JSONObject end = step.getJSONObject("end_location");
            List<String> endGeo = Arrays.asList(end.get("lat").toString(), end.get("lng").toString());

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
