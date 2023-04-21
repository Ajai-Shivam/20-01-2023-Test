function shows() {
	var showreq = new XMLHttpRequest();
	showreq.onreadystatechange = function() {
		if (showreq.readyState == 4) {
			var showArray = JSON.parse(showreq.responseText);
			var showButton = document.getElementById("showTiming");
			showButton.innerHTML = ``;
			for (let i = 0; i < showArray.length; i++) {
				const originalTime = showArray[i].showtiming;
				const [hours, minutes, seconds] = originalTime.split(":");
				const date = new Date(0, 0, 0, hours, minutes, seconds);
				const formattedTime = date.toLocaleTimeString('en-US', { hour: 'numeric', minute: '2-digit', hour12: true });
				if (i == 0) {
					showButton.innerHTML += ` <input type="radio" value= "${formattedTime}" class="btn-check" name="options" id="option${i + 1}" autocomplete="off" checked>
<label class="btn btn-secondary" for="option${i + 1}">${formattedTime}</label>`
				} else {
					showButton.innerHTML += ` <input type="radio" value= "${formattedTime}" class="btn-check" name="options" id="option${i + 1}" autocomplete="off" >
<label class="btn btn-secondary" for="option${i + 1}">${formattedTime}</label>`
				}
			}


		}
	}
	showreq.open("POST", "http://localhost:8081/TheatreTicketBooking/GetShows", true);
	showreq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	showreq.send();
}
function getCinimaHall() {
	var b = document.getElementById("pickseats");
	b.style.display = "grid";
	var timing = "";
	var buttn = document.getElementsByClassName("btn-check");
	for (let i = 0; i < buttn.length; i++) {
		if (buttn[i].checked) {
			buttn.checked = false;
			timing = buttn[i].value;
			break;
		
		}
	}
	
	var cinireq = new XMLHttpRequest();
	cinireq.onreadystatechange = function() {
		if (cinireq.readyState == 4) {
			var cinihall = JSON.parse(cinireq.responseText);
			var cinimaSeats = document.getElementById("add");
			cinimaSeats.innerHTML = ``;
			for (let i = 0; i < cinihall.length; i++) {
				cinimaSeats.innerHTML += `<div class = "char">${cinihall[i].row}</div>`;
				for (let j = 0; j < cinihall[i].seat.length; j++) {
					if (cinihall[i].seat[j] == true) {
						cinimaSeats.innerHTML += `<div class="checkbox-container">
    <div class="booked"></div>
  </div> </div>`
					} else {
						cinimaSeats.innerHTML += `<div class="checkbox-container">
      <input class= "checkbttn" onclick="checkBox('${cinihall[i].row}${j + 1}')" value ="${cinihall[i].row}${j + 1}"  type="checkbox" id="ch${cinihall[i].row}${j + 1}" name = "cb">
      <label for="ch${cinihall[i].row}${j + 1}"></label>
  </div>`
					}
				}
			}


		}
	}
  var [time, period] = timing.split(' '); // split time string into time and period
  var [hours, minutes] = time.split(':'); // split time into hours and minutes
  
  let seconds = '00'; // set seconds to '00' by default
  if (period === 'PM' && hours !== '12') {
    hours = (Number(hours)) + 12; // add 12 to hours if period is 'PM' and hours is not already 12
  } else if (period === 'AM' && hours === '12') {
    hours = '00'; // set hours to '00' if period is 'AM' and hours is 12
  }
  else{
	  hours= 0+hours;
  }
  const time24 = `${hours}:${minutes}:${seconds}`;

	cinireq.open("GET", "http://localhost:8081/TheatreTicketBooking/GetCinimaHall?showtiming=" + time24, true);
	cinireq.send();
}
let ticketsend = "";
function checkBox(cbid) {
	let total = 0;
	var checkbttn = document.getElementsByClassName("checkbttn");
	ticketsend = "";
	for (let i = 0; i < checkbttn.length; i++) {
		if (checkbttn[i].checked == true) {
			if (total == 0) {
				ticketsend += checkbttn[i].value;
			} else {
				ticketsend += "," + checkbttn[i].value;
			}
			total++;
		}
	}

	var change = document.getElementById("ch" + cbid);

	if (total > ticketneed) {
		change.checked = false;
	}
	var paybuttn = document.getElementById("ad");
	var footer = document.getElementById("footer");
	if (total < ticketneed) {
		footer.style.display = "none";
	}
	paybuttn.innerHTML = ``;
	if (total == ticketneed) {
		paybuttn.innerText = "Pay Rs." + (ticketneed * 120);
		footer.style.display = "contents";

	}
}
let ticketneed = 0;
function display() {
	var a = document.getElementById("cinihall");
	var b = document.getElementById("seatspick");

	var ticket = document.getElementById("noticket").value;
	ticketneed = Number(ticket);
	if (ticketneed > 10 || ticketneed < 1) {
		var x = document.getElementById("toast")
		x.className = "show";
		setTimeout(function() { x.className = x.className.replace("show", ""); }, 5000);
	} else {
		a.style.display = "grid";
		b.style.display = "grid";
	}
}
function bookticket() {
	var bookticket = new XMLHttpRequest();
	bookticket.onreadystatechange = function() {
		if (bookticket.readyState == 4) {
			var showArray = JSON.parse(bookticket.responseText);


		}
	}
	bookticket.open("POST", "http://localhost:8081/TheatreTicketBooking/paymentdone", true);
	bookticket.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	bookticket.send("seatnumber=" + ticketsend);
}