package com.thirukuralapplcation.searchadhigaram;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class SearchAdhiKaramController implements SearchModelControllerCallBack,SearchViewControllerCallBack{
    private SearchControllerViewCallBack searchAdhiKaramView;
    private SearchControllerModelCallBack searchAdhikaramModel;
    public SearchAdhiKaramController(SearchAdhiKaramView searchAdhiKaramView) throws IOException, ParseException {
        this.searchAdhiKaramView = searchAdhiKaramView;
        searchAdhikaramModel = new SearchAdhikaramModel(this);
    }
    public void getSearchAdhikaramEnglish(int searchAdhikaramNumber) {
        if(searchAdhikaramNumber>=1 && searchAdhikaramNumber<=133) {
            searchAdhikaramModel.getSearchAdhikaramEnglish(searchAdhikaramNumber);
        }else{
            searchAdhiKaramView.InvalidNumberEnglish("Give a Valid Number");
        }
    }

    public void getSearchAdhikaramSuccessful(JSONObject[] adhikaram) {
        searchAdhiKaramView.getSearchAdhikaramSuccessful(adhikaram);
    }

    public void getSearchAdhikaramTamil(int searchAdhikaramNumber) {
        if(searchAdhikaramNumber>=1 && searchAdhikaramNumber<=133) {
            searchAdhikaramModel.getSearchAdhikaramTamil(searchAdhikaramNumber);
        }else{
            searchAdhiKaramView.InvalidNumberTamil("சரியான எண்ணைக் கொடுங்கள்");
        }
    }

    public void getSearchAdhikaramSuccessfulTamil(JSONObject[] adhikaram) {
        searchAdhiKaramView.getSearchAdhikaramSuccessfulTamil(adhikaram);
    }
}
