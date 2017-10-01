package handler;


import com.company.ConnectionManager;
import com.company.GoogleParser;

import java.util.HashMap;
import java.util.List;

public class ServiceHandler {

    String start;
    String end;
    public ServiceHandler(String strt, String dst){
        start = strt;
        end = dst;

        String json = DirectionQuerier();



        List<List<HashMap>> result = parsedGeoCode(json);

        //return result;

    }

    public String DirectionQuerier(){
        ConnectionManager connectionManager = new ConnectionManager(start, end);

        String json = connectionManager.getResponse();
        return json;
    }

    public List<List<HashMap>> parsedGeoCode(String json){
        GoogleParser googleParser = new GoogleParser();

        List<List<HashMap>> result = googleParser.parseToLatLon(json);
        return result;
    }

}
