package com.thirukuralapplcation.randomthirukural;

import org.json.simple.JSONObject;

public interface RandomControllerViewCallBack {
    void getRandomSuccesfull(JSONObject randomThirukkural);

    void getRandomTamilSuccesfull(JSONObject randomThirukkural);
}
