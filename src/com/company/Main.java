package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String url = "ftp://webftp.vancouver.ca/opendata/json/crime_json_all_years.zip";
        String file =  "crime_json_all_years.zip";

        CrimeSource cs = new CrimeSource(url, file);

        try {
            cs.downloadCrimeSource();

        }catch(IOException e){
            e.printStackTrace();
        }


    }
}
