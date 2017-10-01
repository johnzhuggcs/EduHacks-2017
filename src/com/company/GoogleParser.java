package com.company;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class GoogleParser {

   // https://maps.googleapis.com/maps/api/directions/json?parameters
   // https://maps.googleapis.com/maps/api/directions/json?origin=Toronto&destination=Montreal&key=AIzaSyDGfTWMXhGEkmUGYn9E5ZFVO1J7krYEHvk
    // API-Key: AIzaSyDGfTWMXhGEkmUGYn9E5ZFVO1J7krYEHvk

    private String googleurl = "https://maps.googleapis.com/maps/api/directions/json?";
    private String origin = "origin=";
    private String dst = "&destination=";
    private String key = "&key=AIzaSyDGfTWMXhGEkmUGYn9E5ZFVO1J7krYEHvk";

    public GoogleParser(String origin, String dst){
        this.origin += origin;
        this.dst += dst;
        googleurl+= this.origin + this.dst + key;
        //System.out.println(googleurl);
    }

    public String setConnection(){
        try {
            URL url = new URL(googleurl);
            InputStream is = null;
            is = url.openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            //System.out.println(jsonText);
            return jsonText;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
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

}
