package com.thirukuralapplcation.searchadhigaram;

import com.thirukuralapplcation.repository.ThirukkuralRespository;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class SearchAdhikaramModel implements SearchControllerModelCallBack{
    private SearchModelControllerCallBack searchAdhiKaramController;
    private ThirukkuralRespository thirukkuralRespository;
    public SearchAdhikaramModel(SearchAdhiKaramController searchAdhiKaramController) throws IOException, ParseException {
        this.searchAdhiKaramController = searchAdhiKaramController;
        thirukkuralRespository = ThirukkuralRespository.getInstance();
    }
    public void getSearchAdhikaramEnglish(int searchAdhikaramNumber) {
        JSONObject[] adhikaram = thirukkuralRespository.getSearchAdhikaram(searchAdhikaramNumber);
        searchAdhiKaramController.getSearchAdhikaramSuccessful(adhikaram);
    }

    public void getSearchAdhikaramTamil(int searchAdhikaramNumber) {
        JSONObject[] adhikaram = thirukkuralRespository.getSearchAdhikaram(searchAdhikaramNumber);
        searchAdhiKaramController.getSearchAdhikaramSuccessfulTamil(adhikaram);
    }
}
