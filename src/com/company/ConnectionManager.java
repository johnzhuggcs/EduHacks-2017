package com.company;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class ConnectionManager {

    // https://maps.googleapis.com/maps/api/directions/json?parameters
    // https://maps.googleapis.com/maps/api/directions/json?origin=Toronto&destination=Montreal&key=AIzaSyDGfTWMXhGEkmUGYn9E5ZFVO1J7krYEHvk
    // API-Key: AIzaSyDGfTWMXhGEkmUGYn9E5ZFVO1J7krYEHvk

    private String googleurl = "https://maps.googleapis.com/maps/api/directions/json?";
    private String origin = "origin=";
    private String dst = "&destination=";
    private String key = "&key=AIzaSyDGfTWMXhGEkmUGYn9E5ZFVO1J7krYEHvk";

    private InputStream inputStream;

    public ConnectionManager(String origin, String dst){
        this.origin += origin;
        this.dst += dst;
        googleurl+= this.origin + this.dst + key;
        setConnection();
        //System.out.println(googleurl);
    }

    public void setConnection(){
        try {
            URL url = new URL(googleurl);
            inputStream = url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getResponse(){
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return jsonText;
        }catch (IOException e) {
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
}
