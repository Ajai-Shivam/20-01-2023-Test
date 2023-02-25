package com.thirukuralapplcation.getthirukkural;

import org.json.simple.JSONObject;

public interface GetControllerViewCallBack {
    void InvalidNumberEnglish(String give_a_valid_number);

    void InvalidNumberTamil(String சரியான_எண்ணைக்_கொடுங்கள்);

    void getThirukkuralSuccessFullEnglish(JSONObject thirukkural);

    void getThirukkuralSuccessFullTamil(JSONObject thirukkural);
}
