package com.thirukuralapplcation.randomthirukural;

import org.json.simple.JSONObject;

public interface RandomViewControllerCallBack {
    void getRandomTamilSuccess(JSONObject randomThirukkural);

    void getRandomThirukkuralTamil(int i);

    void getRandomThirukkuralEnglish(int i);

    void getRandomSuccessfull(JSONObject randomThirukkural);
}
