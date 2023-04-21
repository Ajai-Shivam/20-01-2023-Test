function movieAvailable() {
	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		if (req.readyState == 4) {
			var moviesArray = JSON.parse(req.responseText);
			console.log(moviesArray[0].trailer);
			var movieAvailable = document.getElementById("moviesAvailable");
			for (let i = 0; i < moviesArray.length; i++) {
				movieAvailable.innerHTML += `<div class="col-md-3 mt-5 "><div class="card" style="width: 20rem;">
					<img src="${moviesArray[i].image}" class="card-img-top" >
				
						<div class="card-body">
							<h5 class="card-title">${moviesArray[i].movie_name}</h5>
							<p class="card-text">${moviesArray[i].movie_duration}</p>
							<a target="_blank" href="${moviesArray[i].trailer}" class="btn btn-primary">Details</a>
							<a onclick="chooseMovie('${moviesArray[i].movie_ID}')" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Book Tickets</a>
						</div>
						
					</div>
				</div>`;
			}

		}
	}
	req.open("GET", "http://localhost:8081/TheatreTicketBooking/getMovies", true);
	//req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	req.send();
}
var movie = "";
function chooseMovie(movieID) {
	var movie = movieID;
	var datereq = new XMLHttpRequest();
	datereq.onreadystatechange = function() {
		if (datereq.readyState == 4) {
			var dateArray = JSON.parse(datereq.responseText);
			var dateButton = document.getElementById("dateButton");
			dateButton.innerHTML=``;
			for (let i = 0; i < dateArray.length; i++) {
				const originalDate = dateArray[i].date;
				const [year, month, day] = originalDate.split("-");
				const newDate = new Date(year, month - 1, day);
				const formattedDate = newDate.toLocaleDateString('en-GB', { day: '2-digit', month: '2-digit', year: 'numeric' }).replace(/\//g, '-');

				if (i == 0) {
					dateButton.innerHTML += ` <input type="radio" value= "${formattedDate}" class="btn-check" name="options" id="option${i + 1}" autocomplete="off" checked>
<label class="btn btn-secondary" for="option${i + 1}">${formattedDate}</label>`
				} else {
					dateButton.innerHTML += ` <input type="radio" value= "${formattedDate}" class="btn-check" name="options" id="option${i + 1}" autocomplete="off" >
<label class="btn btn-secondary" for="option${i + 1}">${formattedDate}</label>`
				}

			}



		}
	}
	datereq.open("GET", "http://localhost:8081/TheatreTicketBooking/GetDate?movieID=" + movieID, true);
	datereq.send();

}
function chooseShows() {
	var dateChoosed = document.getElementsByClassName("btn-check");
	var bookpage = new XMLHttpRequest();
	var date;
	for (let i = 0; i < dateChoosed.length; i++) {
		if (dateChoosed[i].checked) {
			dateChoosed[i].checked = false;
			date = dateChoosed[i].value;
			break;
		}
	}
	const originalDate = date;
	const [day, month, year] = originalDate.split("-");

	const newDate = new Date(`${year}-${month}-${day}`);
	const formattedDate = newDate.toISOString().slice(0, 10);
	bookpage.onreadystatechange = function() {
		if (bookpage.readyState == 4) {

			window.location.href = "Booking.html";

		}

	}
	bookpage.open("GET", "http://localhost:8081/TheatreTicketBooking/GetShows?date=" + formattedDate, true);
	bookpage.send();
}