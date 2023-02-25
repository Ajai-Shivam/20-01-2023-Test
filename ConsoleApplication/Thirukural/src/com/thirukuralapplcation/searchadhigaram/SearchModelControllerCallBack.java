package com.thirukuralapplcation.searchadhigaram;

import org.json.simple.JSONObject;

public interface SearchModelControllerCallBack {

    void getSearchAdhikaramSuccessful(JSONObject[] adhikaram);

    void getSearchAdhikaramSuccessfulTamil(JSONObject[] adhikaram);
}
