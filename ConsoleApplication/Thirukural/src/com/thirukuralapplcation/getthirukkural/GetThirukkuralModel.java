package com.thirukuralapplcation.getthirukkural;

import com.thirukuralapplcation.repository.ThirukkuralRespository;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class GetThirukkuralModel implements GetControllerModelCallBack{
    private GetModelControllerCallBack thirukkuralController;
    private ThirukkuralRespository thirukkuralRespository;
    public GetThirukkuralModel(GetThirukkuralController getThirukkuralController) throws IOException, ParseException {
        this.thirukkuralController = getThirukkuralController;
        thirukkuralRespository =ThirukkuralRespository.getInstance();
    }


    public void getThirukkuralEnglish(int thirukkuralnumber) {
        JSONObject thirukkural = thirukkuralRespository.getThirukkuralEnglish(thirukkuralnumber);
        thirukkuralController.getThirukkuralSuccessFullEnglish(thirukkural);
    }

    public void getThirukkuralTamil(int thirukkuralnumber) {
        JSONObject Thirukkural = thirukkuralRespository.getThirukkuralEnglish(thirukkuralnumber);
        thirukkuralController.getThirukkuralSuccessFullTamil(Thirukkural);
    }
}
