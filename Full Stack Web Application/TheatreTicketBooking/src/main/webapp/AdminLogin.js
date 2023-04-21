let moviesDetails = "";
let displayMovietable = document.getElementById("analyticsMovie");
let displayDateTS = document.getElementById("displayTS");
let displayTableTS = document.getElementById("displayTSTable");
let displayDateTR = document.getElementById("displayTR");
let displayTableTR = document.getElementById("displayTRTable");
let displayActice = document.getElementById("displayActive");


function loadingDtails() {
	var moviesavailable = document.getElementById("moviesAvailable");
	var totaltickets = document.getElementById("totaltickets")
	var totrevenue = document.getElementById("totalRevenue");
	var usercount = document.getElementById("userscount");
	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (req.readyState == 4) {
			var data = JSON.parse(req.responseText);
			moviesavailable.innerHTML = data.totalMovies;
			totaltickets.innerHTML = data.totalBooking;
			totrevenue.innerHTML = data.totalAmount;
			usercount.innerHTML = data.users_count;
			ticketSold = data.TicketSold;
			moviesDetails = data.moviesdetails;
		}
	}
	req.open("GET", "http://localhost:8081/TheatreTicketBooking/AdminViewServlet", true);
	req.send();
}
function displayTRDate() {
	var a = document.getElementById("trDate");
	  a.value = "";

	displayDateTS.style.display = "none";
	displayMovietable.style.display = "none";
	displayDateTR.style.display = "none";
	displayActice.style.display = "none";
		displayTableTS.style.display = "none";

	displayDateTR.style.display = "inline-block";
}
function displayTSDate() {
	var a = document.getElementById("tsdate");
		  a.value = "";

	displayDateTS.style.display = "none";
	displayMovietable.style.display = "none";
	displayDateTR.style.display = "none";
	displayTableTR.style.display = "none";
		displayActice.style.display = "none";

	displayDateTS.style.display = "inline-block";
}
function totalRevenue() {
	var date = document.getElementById("trDate");
	console.log(date.value);
	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (req.readyState == 4) {
			var revenue = JSON.parse(req.responseText);
			var TRadd = document.getElementById("addTRDetails");
			TRadd.innerHTML = ``;
			for (let i = 0; i < revenue.length; i++) {
				TRadd.innerHTML += `<tr>
          <td>${revenue[i].show_time}</td>
          <td>${revenue[i].movie_name}</td>
          <td>${revenue[i].totalamount}</td>
        </tr>`
			}
			displayTableTR.style.display = "inline-block";
		}


	}

	req.open("GET", "http://localhost:8081/TheatreTicketBooking/GetRevenue?date=" + date.value, true);
	req.send();
}
function movieAnalytics() {
	displayDateTS.style.display = "none";
	displayTableTS.style.display = "none";
	displayDateTR.style.display = "none";
	displayTableTR.style.display = "none";
		displayActice.style.display = "none";

	var movietable = document.getElementById("addMovieDetails");
	movietable.innerHTML = ``;
	for (let i = 0; i < moviesDetails.length; i++) {
		movietable.innerHTML += `<tr>
          <td>${moviesDetails[i].movie_name}</td>
          <td>${moviesDetails[i].movie_duration}</td>
          <td>${moviesDetails[i].certificate}</td>
          <td>${moviesDetails[i].trailer}</td>
        </tr>`
	}
	displayMovietable.style.display = "inline-block";
}

function ticketsAnalytics() {
	var date = document.getElementById("tsdate");

	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {


		if (req.readyState == 4) {
			var ticketSold = JSON.parse(req.responseText);
			var TSadd = document.getElementById("addTSDetails");
			TSadd.innerHTML = ``;
			for (let i = 0; i < ticketSold.length; i++) {
				TSadd.innerHTML += `<tr>
          <td>${ticketSold[i].bookingID}</td>
          <td>${ticketSold[i].movie_name}</td>
			<td>${ticketSold[i].screen_name}</td>
           <td>${ticketSold[i].show_time}</td>
          <td>${ticketSold[i].date_D}</td>
          <td>${ticketSold[i].movie_name}</td>
          <td>${ticketSold[i].payment_method}</td>
          <td>${ticketSold[i].total_amount}</td>
        </tr>`



			}
			displayTableTS.style.display = "inline-block";
		}
	}
	req.open("GET", "http://localhost:8081/TheatreTicketBooking/GetTicketSold?date=" + date.value);
	req.send();
}
function Addshow() {
	var dom = document.getElementById("addMovie");
	dom.innerHTML = ``;

	for (let i = 0; i < moviesDetails.length; i++) {
		dom.innerHTML += `  <option value="${moviesDetails[i].movie_ID}">${moviesDetails[i].movie_name}</option>`;
	}

	var dom2 = document.getElementById("SelectDate");
	dom2.innerHTML = '';
	var Currentdate = new Date();

	for (let i = 1; i <= 7; i++) {
		var date = (Currentdate.getDate() + i) + "-" + (Currentdate.getMonth() + 1) + "-" + Currentdate.getFullYear();
		var datefordb = Currentdate.getFullYear() + "-" + (Currentdate.getMonth() + 1) + "-" + (Currentdate.getDate() + i);
		dom2.innerHTML += `<option value="${datefordb}">${date}</option>`;
	}
}

function downloadTable(tableID) {
	var table2excel = new Table2Excel();
	table2excel.export(document.querySelectorAll("#" + tableID));
}


document.querySelector('#addShow').addEventListener('submit', function(event) {
	let screenInput = document.querySelector('#screen');
	let showtimingInput = document.querySelector('#showtiming');
	let dateInput = document.querySelector('#date');
	let screenError = document.querySelector('#screen-error');
	let showtimingError = document.querySelector('#showtiming-error');
	let dateError = document.querySelector('#date-error');

	// Validate screen input
	if (screenInput.value === '' || screenInput.value > 3) {
		screenError.textContent = 'Please enter a valid screen number (must be less than or equal to 3).';
		event.preventDefault();
	} else {
		screenError.textContent = '';
	}

	// Validate showtiming input
	if (showtimingInput.value === '') {
		showtimingError.textContent = 'Please enter a valid show timing.';
		event.preventDefault();
	} else {
		showtimingError.textContent = '';
	}

	// Validate date input
	if (dateInput.value === '' || new Date(dateInput.value) < new Date() || new Date(dateInput.value) > new Date(new Date().getTime() + 7 * 24 * 60 * 60 * 1000)) {
		dateError.textContent = 'Please enter a valid date (must be within 7 days from today).';
		event.preventDefault();
	} else {
		dateError.textContent = '';
	}

});
function AddShowConform() {
	var screens = document.getElementById("chooseScreen");
	var showtiming = document.getElementById("showtiming");
	var date = document.getElementById("SelectDate");
	var movie = document.getElementById("addMovie");
	var req = new XMLHttpRequest();

	req.onreadystatechange = function() {

		if (req.readyState == 4) {
			let toastBox = document.getElementById('toastbar');

			var response = req.responseText;
			if (response == "true") {
				var close = document.getElementById("addClose");
				close.click();

				let success = "<i class='fa-sharp fa-solid fa-circle-check'></i> Successfully Added";

				let toast = document.createElement('div');
				toast.classList.add('alerttoast')
				toast.innerHTML = success;
				toastBox.append(toast);

				toast.classList.add('success');


				setTimeout(() => {
					toast.remove();
				}, 4000);

			} else {
				let failure = "<i class='fa-solid fa-circle-exclamation'></i> Cannot Add This Show Timing";
				let toast = document.createElement('div');
				toast.classList.add('alerttoast')
				toast.innerHTML = failure;
				toastBox.append(toast);

				toast.classList.add('error');

				setTimeout(() => {
					toast.remove();
				}, 4000);
			}



		}
	}
	req.open("GET", "http://localhost:8081/TheatreTicketBooking/AddShow?date=" + date.value + "&showtiming=" + showtiming.value + "&SelectedScreen=" + screens.value + "&SelectMovie=" + movie.value);
	req.send();
}


function addMovieSubmit() {
	var movieName = document.getElementById("movie-name").value.trim();
	var movieTrue = false;

	if (movieName.length > 0) {
		movieTrue = true;
	}
	var duration = document.getElementById("movie-duration").value.trim();
	const durationRegex = /^(\d+):(\d{2}):(\d{2})$/;
	var durationTrue = false;
	if (durationRegex.test(duration)) {
		durationTrue = true;
	}

	var certification = document.getElementById("movie-certificate").value.trim();



	const urlRegex = /\b((https?|ftp|file):\/\/[-\w+&@#/%?=~|!:,.;]*[-\w+&@#/%=~|])/i;
	var certificationTrue = false;
	if (certification != "") {
		certificationTrue = true;
	}

	var trailer = document.getElementById("trailer-url").value.trim();
	var trailerTrue = false;
	if (urlRegex.test(trailer)) {
		trailerTrue = true;
	}

	var banner = document.getElementById("movie-banner").value.trim();
	var bannerTrue = false;
	if (urlRegex.test(banner)) {
		bannerTrue = true;
	}

	if (movieTrue && durationTrue && certificationTrue && trailerTrue && bannerTrue) {
		var send = "moviename=" + movieName + "&movieduration=" + duration + "&certification=" + certification + "&trailer=" + trailer + "&banner=" + banner;
		var req = new XMLHttpRequest;
		req.onreadystatechange = function() {
			if (req.readyState == 4) {
				var res = req.responseText;

				let toastBox = document.getElementById('toastbar');
				var close = document.getElementById("closeMovieAdd");
				close.click();
				let input = document.querySelectorAll('input');
				input.forEach(inputs => inputs.value = "");
				if (res == "true") {
					let success = "<i class='fa-sharp fa-solid fa-circle-check'></i>Movie Successfully Added";

					let toast = document.createElement('div');
					toast.classList.add('alerttoast')
					toast.innerHTML = success;
					toastBox.append(toast);

					toast.classList.add('success');


					setTimeout(() => {
						toast.remove();
					}, 4000);

				} else {
					let failure = "<i class='fa-solid fa-circle-exclamation'></i> Movie Alreay Exist";
					let toast = document.createElement('div');
					toast.classList.add('alerttoast')
					toast.innerHTML = failure;
					toastBox.append(toast);

					toast.classList.add('error');

					setTimeout(() => {
						toast.remove();
					}, 4000);
				}
			}
		}

		req.open("POST", "http://localhost:8081/TheatreTicketBooking/AddMovie", true);
		req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		req.send(send);

	} else {
		window.alert("Give Valid Entries and Fill Every Flied");
	}
}

function onupdateShow() {
	var addDate = document.getElementById("UpdDate");
	addDate.innerHTML = ``;
	var Currentdate = new Date();
	for (let i = 1; i <= 7; i++) {
		var date = (Currentdate.getDate() + i) + "-" + (Currentdate.getMonth() + 1) + "-" + Currentdate.getFullYear();
		var datefordb = Currentdate.getFullYear() + "-" + (Currentdate.getMonth() + 1) + "-" + (Currentdate.getDate() + i);
		addDate.innerHTML += `<option onClick="viewShow('${datefordb}')" value="${datefordb}">${date}</option>`;
	}
	var addmovie = document.getElementById("UpdMovie");
	addmovie.innerHTML = ``;
	for (let i = 0; i < moviesDetails.length; i++) {
		addmovie.innerHTML += `<option value= "${moviesDetails[i].movie_name}">${moviesDetails[i].movie_name}</option>`
	}
}
function viewShow() {
	var screen = document.getElementById("UpdScreenName").value;
	var date = document.getElementById('UpdDate').value;
	if (date != "" && screen != "") {
		var req = new XMLHttpRequest();
		req.onreadystatechange = function() {


			if (req.readyState == 4) {
				var res = JSON.parse(req.responseText);
				var addshow = document.getElementById("UpdShow");
				addshow.innerHTML = ``;

				for (let i = 0; i < res.length; i++) {
					addshow.innerHTML += `<option value = "${res.show_Timing}">${res.show_Timing}</option>`
				}
			}
		}
		req.open("POST", "http://localhost:8081/TheatreTicketBooking/ViewShow", true);
		req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		req.send("date=" + date + "&screen=" + screen);
	}
}
function updateShow() {
	var screen = document.getElementById("UpdScreenName").value;
	var checkscreen = false;
	if (screen != "") {
		checkscreen = true;
	}
	var date = document.getElementById("UpdDate").value;
	var checkDate = false;
	if (date != "") {
		checkDate = true;
	} var show = document.getElementById("UpdShow").value;
	var checkshow = false;
	if (show != "") {
		checkshow = true;
	} var movie = document.getElementById("UpdMovie").value;
	var checkmovie = false;
	if (movie != "") {
		checkmovie = true;
	}


	if (checkscreen && checkshow && checkmovie && checkDate) {
		var send = "screen=" + screen + "&date=" + date + "&show=" + show + "&movie=" + movie;
		var req = new XMLHttpRequest();
		req.onreadystatechange = function() {
			if (req.readyState == 4) {
				var res = req.responseText;

				if (res == "true") {
					let toastBox = document.getElementById('toastbar');

					let success = "<i class='fa-sharp fa-solid fa-circle-check'></i>Updated Successfully";
					let toast = document.createElement('div');
					toast.classList.add('alerttoast')
					toast.innerHTML = success;
					toastBox.append(toast);

					toast.classList.add('success');


					setTimeout(() => {
						toast.remove();
					}, 4000);
				}
			}
		}
		req.open("POST", "http://localhost:8081/TheatreTicketBooking/UpdateShow", true);
		req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		req.send(send);
	}

}
function onDeleteMovie() {
	var addMovie = document.getElementById("MovieRemoveTable");
	addMovie.innerHTML = ``;
	for (let i = 0; i < moviesDetails.length; i++) {
		addMovie.innerHTML += `<tr id = "${moviesDetails[i].movie_ID}"><td>${moviesDetails[i].movie_name}</td><td>${moviesDetails[i].movie_duration}</td><td>${moviesDetails[i].trailer}</td><td>${moviesDetails[i].certificate}</td><td>${moviesDetails[i].image}</td><td><button class = "btn btn-primary" onclick = "deletemovie(${moviesDetails[i].movie_ID})">Delete</button></td></tr>`;

	}
}
function deletemovie(movie) {
	var a = document.getElementById(movie);
	a.remove();
	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (req.readyState == 4) {
			var res = req.responseText;
			if (res == "true") {
				let toastBox = document.getElementById('toastbar');

				let success = "<i class='fa-sharp fa-solid fa-circle-check'></i>Updated Successfully";
				let toast = document.createElement('div');
				toast.classList.add('alerttoast')
				toast.innerHTML = success;
				toastBox.append(toast);

				toast.classList.add('success');


				setTimeout(() => {
					toast.remove();
				}, 4000);

				loadingDtails();
			}
		}
	}
	req.open("POST", "http://localhost:8081/TheatreTicketBooking/deleteMovie", true);
	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	req.send("movie_id=" + movie);
}

function ondeleteshow() {
	var add = document.getElementById("ondeleteshow");
	add.innerHTML = ``;
	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (req.readyState == 4) {
			var res = JSON.parse(req.responseText);
			for (let i = 0; i < res.length; i++) {
				add.innerHTML += `<tr id = ${res[i].seat_ID}><td>${res[i].date}</td><td>${res[i].show_timing}</td><td>${res[i].movie_name}</td><td><button class = "btn btn-primary" onclick = "deleteShow(${res[i].seat_ID})">Delete</button></td></tr>`
			}
		}
	}
	req.open("POST", "http://localhost:8081/TheatreTicketBooking/GetAvailableShows", true);
	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	req.send();

}
function deleteShow(seat_ID){
	var a = document.getElementById(seat_ID);
	a.remove();
	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (req.readyState == 4) {
			var res = req.responseText;
			if(res == "true"){
				let toastBox = document.getElementById('toastbar');

				let success = "<i class='fa-sharp fa-solid fa-circle-check'></i>Updated Successfully";
				let toast = document.createElement('div');
				toast.classList.add('alerttoast')
				toast.innerHTML = success;
				toastBox.append(toast);

				toast.classList.add('success');


				setTimeout(() => {
					toast.remove();
				}, 4000);

			}
		}
	}
	req.open("POST","http://localhost:8081/TheatreTicketBooking/DeleteShow",true);
	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	req.send("seat_ID"+seat_ID);
	
}
function showActive() {
	displayDateTS.style.display = "none";
	displayTableTS.style.display = "none";
	displayDateTR.style.display = "none";
	displayTableTR.style.display = "none";
		displayActice.style.display = "inline-block";
	var add = document.getElementById("addActiveTable");
	add.innerHTML = ``;
	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (req.readyState == 4) {
			var res = JSON.parse(req.responseText);
							console.log("ajai");

			for (let i = 0; i < res.length; i++) {
				if(res[i].active == "true"){
				add.innerHTML += `<tr id = ${res[i].seat_ID}><td>${res[i].show_timing}</td><td>${res[i].date}</td><td>${res[i].movie_name}</td><td><button id = "${res[i].seat_ID}" class = "btn btn-primary" onclick = "deactivated(${res[i].seat_ID})">De Activate</button></td></tr>`
				}else{
									add.innerHTML += `<tr id = ${res[i].seat_ID}><td>${res[i].show_timing}</td><td>${res[i].date}</td><td>${res[i].movie_name}</td><td><button class = "btn btn-primary" disabled>De Activated</button></td></tr>`

				}
			}
		}
	}
	req.open("GET", "http://localhost:8081/TheatreTicketBooking/GetShowsActive", true);
	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	req.send();

}

function deactivated(){
		
	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (req.readyState == 4) {
			var res = JSON.parse(req.responseText);
				console.log();
				const myButton = document.getElementById(seat_ID);
				myButton.setAttribute("disabled", true);
			}
		}
	
	req.open("POST", "http://localhost:8081/TheatreTicketBooking/GetShowsActive", true);
	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	req.send();
}