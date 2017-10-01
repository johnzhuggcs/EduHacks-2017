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

        ConnectionManager connectionManager = new ConnectionManager(start, end);

        String json = connectionManager.getResponse();

        GoogleParser googleParser = new GoogleParser();

        List<List<HashMap>> result = googleParser.actuallyParsing(json);

        //return result;

    }

}
