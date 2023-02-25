package com.thirukuralapplcation.getthirukkural;

import org.json.simple.JSONObject;

public interface GetModelControllerCallBack {
    void getThirukkuralSuccessFullEnglish(JSONObject thirukkural);

    void getThirukkuralSuccessFullTamil(JSONObject thirukkural);
}
