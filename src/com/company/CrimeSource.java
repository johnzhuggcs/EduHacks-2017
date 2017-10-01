package com.company;


import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class CrimeSource extends CrimeSourceJson {

    String url;
    String file;

    public CrimeSource(String urlStr, String file){
        this.url = urlStr;
        this.file =  file;
    }

    public void downloadCrimeSource()
            throws IOException {

        URL url = new URL(this.url);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(this.file);

        byte[] buffer = new byte[1024];
        int count = 0;
        while((count = bis. read(buffer, 0, 1024)) != -1){
            fis.write(buffer, 0, count);
        }

        fis.close();
        bis.close();

        try{
            CrimeUnzip();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
