package com.thirukuralapplcation.searchadhigaram;

import org.json.simple.JSONObject;

public interface SearchControllerViewCallBack {
    void InvalidNumberEnglish(String give_a_valid_number);

    void getSearchAdhikaramSuccessful(JSONObject[] adhikaram);

    void InvalidNumberTamil(String சரியான_எண்ணைக்_கொடுங்கள்);

    void getSearchAdhikaramSuccessfulTamil(JSONObject[] adhikaram);
}
