package com.thirukuralapplcation.repository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;


public class ThirukkuralRespository {

    private JSONObject[] thirukkuralDetails = new JSONObject[1330];
    private ThirukkuralRespository() throws IOException, ParseException {
        readJsonFile();
    }
    private static ThirukkuralRespository Instance;
    public static ThirukkuralRespository getInstance() throws IOException, ParseException {
        if(Instance!=null){
            return Instance;
        }
        Instance = new ThirukkuralRespository();
        return Instance;
    }

    public void readJsonFile() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader file = new FileReader("C:\\Practice\\Thirukural\\src\\com\\thirukuralapplcation\\repository\\thirukkural.json");
        Object obj = jsonParser.parse(file);
        JSONObject Thirukkuralobj = (JSONObject)obj;
        JSONArray thiruArray =  (JSONArray) Thirukkuralobj.get("Thirukkural");
        for (int i = 0; i < 1330; i++) {
            thirukkuralDetails[i] = (JSONObject) thiruArray.get(i);
        }
    }

    public JSONObject getThirukkuralEnglish(int thirukkuralnumber) {
        JSONObject thirukkural = thirukkuralDetails[thirukkuralnumber-1];
        return thirukkural;
    }

    public JSONObject[] getSearchAdhikaram(int searchAdhikaramNumber) {
        JSONObject[] adhikaramKural = new JSONObject[10];
        int j =0;
        for (int i = (searchAdhikaramNumber-1)*10; i < ((searchAdhikaramNumber-1)*10)+10 ; i++) {
            adhikaramKural[j] = thirukkuralDetails[i];
            j++;
        }
        return adhikaramKural;
    }
}
