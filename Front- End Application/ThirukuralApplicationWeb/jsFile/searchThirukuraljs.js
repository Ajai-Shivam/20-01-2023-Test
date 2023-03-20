import json from "../jsonFile/thirukkural.json" assert {type : 'json'};


var Submitbtn = document.getElementById("searchSubmit");
Submitbtn.onclick = function searchThirukural(getNumber){
    var getNumber = document.getElementById("searchbtn");
    var number = parseInt(getNumber.value);
    
    var thirukkural = json.kural[number-1];
    var thirukuralNo = document.getElementById("ThiruNo");
    var thirukuralline1 = document.getElementById("Thirulin1");
    var thirukuralline2 = document.getElementById("Thirulin2");
    var thirukuralmeaning =document.getElementById("thirukuralmeaning");
    
    thirukuralNo.innerHTML = "<b>திருக்குறள் எண் : </b>" + thirukkural.Number;
    thirukuralline1.innerHTML = thirukkural.Line1;
    thirukuralline2.innerHTML = thirukkural.Line2;
    thirukuralmeaning.innerHTML =  "<b>பொருள் : </b><br><br>"+thirukkural.mv+".";

    var temp =  document.getElementById("temp");
    temp.style.display = "inline-block";
}