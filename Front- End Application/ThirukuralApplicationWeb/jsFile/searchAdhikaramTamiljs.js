import json from "../jsonFile/thirukkural.json" assert {type : 'json'};

var Submitbtn = document.getElementById("searchSubmit");
Submitbtn.onclick = function(){
    var adhikaramno = document.getElementById("searchbtn");
    adhikaramno = parseInt(adhikaramno.value);
    var adhikaram = document.getElementById("adhikaram");
    adhikaram.innerHTML = "அதிகாரம் எண் : " + adhikaramno;
    adhikaramno = adhikaramno-1;
    adhikaramno = adhikaramno*10;
    adhikaram.style.display = "inline-block";
    var thirukuralNo = null;
    var thirukuralline1 = null;
    var thirukuralline2 = null;
    var thirukuralmeaning = null;
    var thirukkural = null;
    for (let index = 0; index < 10; index++){
        var thiruno = "ThiruNo"+(index+1);
        var thiruline = "Thirulin1"+(index+1);
        var thirulin2 = "Thirulin2"+(index+1);
        var meaning = "thirukuralmeaning"+(index+1);
        var number = parseInt(adhikaramno + index);
    thirukkural =  json.kural[number];
    thirukuralNo = document.getElementById(thiruno);
    thirukuralline1 = document.getElementById(thiruline);
    thirukuralline2 = document.getElementById(thirulin2);
    thirukuralmeaning = document.getElementById(meaning);    
    
    thirukuralNo.innerHTML = "<b>திருக்குறள் எண் : </b>" + thirukkural.Number;
    thirukuralline1.innerHTML = thirukkural.Line1;
    thirukuralline2.innerHTML = thirukkural.Line2;
    thirukuralmeaning.innerHTML =  "<b>பொருள் : </b><br><br>"+thirukkural.mv+".";

    var temp = document.getElementsByClassName("temp1");
    temp[index].style.display= "inline-block"
}
}