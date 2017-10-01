package test;

import com.company.GoogleParser;
import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

public class GoogleParserTest {

    @Test
    public void testParser(){

        try {
            URL url = new URL("https://maps.googleapis.com/maps/api/directions/json?origin=Chicago,IL&destination=Los+Angeles,CA&waypoints=Joplin,MO|Oklahoma+City,OK&key=AIzaSyDGfTWMXhGEkmUGYn9E5ZFVO1J7krYEHvk");
            InputStream is = url.openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            System.out.println(jsonText);

            //GoogleParser p = new GoogleParser();
            //p.parseResponce(jsonText);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    @Test
    public void testActualParsing(){

        try {
            URL url = new URL("https://maps.googleapis.com/maps/api/directions/json?origin=Chicago,IL&destination=Los+Angeles,CA&waypoints=Joplin,MO|Oklahoma+City,OK&key=AIzaSyDGfTWMXhGEkmUGYn9E5ZFVO1J7krYEHvk");
            InputStream is = url.openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            GoogleParser googleParser = new GoogleParser();
            List<List<HashMap>> result = googleParser.parseToLatLon(jsonText);
            System.out.println(jsonText);
            System.out.println("parsed info");
            //System.out.println(result.toString());

            List<HashMap> temp = result.get(0);

            for(int x =0;x<temp.size();x++){
                HashMap tempMap = temp.get(0);
                for (Object name: tempMap.keySet()){

                    Object key =name;
                    String value = tempMap.get(name).toString();
                    System.out.println(key + " " + value);


                }


            }


            //GoogleParser p = new GoogleParser();
            //p.parseResponce(jsonText);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

