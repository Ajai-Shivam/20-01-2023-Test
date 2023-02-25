package com.thirukuralapplcation.randomthirukural;
import com.thirukuralapplcation.repository.ThirukkuralRespository;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class RandomThirukkuralModel implements RandomControllerModelCallBack{
    private RandomViewControllerCallBack randomThirukkuralController;
    private ThirukkuralRespository thirukkuralRespository;
    public RandomThirukkuralModel(RandomThirukkuralController randomThirukkuralController) throws IOException, ParseException {
            this.randomThirukkuralController = randomThirukkuralController;
            thirukkuralRespository = ThirukkuralRespository.getInstance();
    }
    public void getRandomThirukkuralTamil(int i) {
      JSONObject randomThirukkural = thirukkuralRespository.getThirukkuralEnglish(i);
      randomThirukkuralController.getRandomTamilSuccess(randomThirukkural);
    }

    public void getRandomThirukkuralEnglish(int i) {
        JSONObject randomThirukkural= thirukkuralRespository.getThirukkuralEnglish(i);
        randomThirukkuralController.getRandomSuccessfull(randomThirukkural);
    }
}
