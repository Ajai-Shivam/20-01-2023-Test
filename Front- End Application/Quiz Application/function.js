import json from "./Question.json" assert {type :  'json'};

let Qno = 0;
let scoreCount  = 0;
showQuestion(json.data,Qno);

function showQuestion(data,Qno){
    if(Qno<4){
    var currentQuestion = data[Qno];
    var Question = document.getElementById("Question");
    Question.innerHTML = currentQuestion.question;
    var option1 = document.getElementById("opt-1");
    var option2 = document.getElementById("opt-2");
    var option3 = document.getElementById("opt-3");
    var option4 = document.getElementById("opt-4");

    option1.innerHTML = currentQuestion.options[0];
    option2.innerHTML = currentQuestion.options[1];
    option3.innerHTML = currentQuestion.options[2];
    option4.innerHTML = currentQuestion.options[3];
    }
    else {
        var bttn = document.getElementById("bttn");
        bttn.value = "Submit";
        var currentQuestion = data[Qno];
        var Question = document.getElementById("Question");
        Question.innerHTML = currentQuestion.question;
        var option1 = document.getElementById("opt-1");
        var option2 = document.getElementById("opt-2");
        var option3 = document.getElementById("opt-3");
        var option4 = document.getElementById("opt-4");

        option1.innerHTML = currentQuestion.options[0];
        option2.innerHTML = currentQuestion.options[1];
        option3.innerHTML = currentQuestion.options[2];
        option4.innerHTML = currentQuestion.options[3];
        }

}
var buttonSubmit = document.getElementById("bttn");
buttonSubmit.onclick = function(){
    Qno++;
    if(Qno<=4){
    var options = document.getElementsByClassName("option");
    var optionChoosed;
    for (let index = 0; index < options.length; index++) {
        if(options[index].checked){
            options[index].checked = false;
            optionChoosed = options[index].value;
            break;
        }
    }
    if(optionChoosed=="undefined"){

    }else{
        if(optionChoosed ===  json.data[Qno].answer){
            scoreCount++;
        }
    }
    showQuestion(json.data,Qno);  
    }else{
        var bttn = document.getElementById("bttn");
        bttn.value = scoreCount+"/5";
    }
};


