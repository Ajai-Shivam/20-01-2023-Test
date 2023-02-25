package com.thirukuralapplcation.getthirukkural;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class GetThirukkuralController implements GetModelControllerCallBack,GetViewControllerCallBack{
    private GetControllerModelCallBack getThirukkuralModel;
    private GetControllerViewCallBack getThirukkuralView;
    public GetThirukkuralController(GetThirukkuralView getThirukkuralView) throws IOException, ParseException {
        this.getThirukkuralView = getThirukkuralView;
        getThirukkuralModel = new GetThirukkuralModel(this);
;    }

    public void getThirukkuralEnglish(int thirukkuralnumber) {
        if(thirukkuralnumber>=1 && thirukkuralnumber<=1330){
            getThirukkuralModel.getThirukkuralEnglish(thirukkuralnumber);
        }else{
            getThirukkuralView.InvalidNumberEnglish("Give a Valid Number");
        }
    }

    public void getThirukkuralTamil(int thirukkuralnumber) {
        if(thirukkuralnumber>=1 && thirukkuralnumber<=1330){
            getThirukkuralModel.getThirukkuralTamil(thirukkuralnumber);
        }else{
            getThirukkuralView.InvalidNumberTamil("சரியான எண்ணைக் கொடுங்கள்");
        }
    }

    public void getThirukkuralSuccessFullEnglish(JSONObject thirukkural) {
        getThirukkuralView.getThirukkuralSuccessFullEnglish(thirukkural);
    }

    public void getThirukkuralSuccessFullTamil(JSONObject thirukkural) {
        getThirukkuralView.getThirukkuralSuccessFullTamil(thirukkural);
    }
}
