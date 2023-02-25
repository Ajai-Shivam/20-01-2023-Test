package com.thirukuralapplcation.randomthirukural;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class RandomThirukkuralController implements RandomModelControllerCallBack,RandomViewControllerCallBack{
    private RandomControllerViewCallBack randomThirukkuralView;
    private RandomControllerModelCallBack randomThirukkuralModel;
    public RandomThirukkuralController(RandomThirukkuralView randomThirukkuralView) throws IOException, ParseException {
        this.randomThirukkuralView = randomThirukkuralView;
      randomThirukkuralModel = new RandomThirukkuralModel(this);
    }


    public void getRandomThirukkuralTamil(int i) {
        randomThirukkuralModel.getRandomThirukkuralTamil(i);
    }

    public void getRandomThirukkuralEnglish(int i) {
        randomThirukkuralModel.getRandomThirukkuralEnglish(i);
    }

    public void getRandomSuccessfull(JSONObject randomThirukkural) {
        randomThirukkuralView.getRandomSuccesfull(randomThirukkural);
    }

    public void getRandomTamilSuccess(JSONObject randomThirukkural) {
        randomThirukkuralView.getRandomTamilSuccesfull(randomThirukkural);
    }
}
