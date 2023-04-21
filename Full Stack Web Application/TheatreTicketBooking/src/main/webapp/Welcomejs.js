const togglebutton = document.getElementsByClassName('toggle-button')[0];
const navbarlinks = document.getElementsByClassName('navbarlinks')[0];

togglebutton.addEventListener('click', () => {
	navbarlinks.classList.toggle('active')

})
const username = document.getElementById("username");
const email = document.getElementById("email");
const password = document.getElementById("password");
const conform = document.getElementById("conpassword");

const usernameRegex = /^[a-zA-Z][a-zA-Z0-9_]{5,29}$/;
const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
const passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;


function userDislay() {
	let welcome = document.getElementById("welcome");
	let logindis = document.getElementById("Userlogin");
	let adminlogin = document.getElementById("adminlogin");
	let regdis = document.getElementById("signup");
	welcome.style.filter = "blur('2px') ";
	regdis.style.display = "none";
	adminlogin.style.display = "none";
	logindis.style.display = "inline-block";


}
function home() {
	let logindis = document.getElementById("Userlogin");
	let adminlogin = document.getElementById("adminlogin");
	let regdis = document.getElementById("signup");
	regdis.style.display = "none";
	adminlogin.style.display = "none";
	logindis.style.display = "none";

}
function adminDisplay() {
	let welcome = document.getElementById("welcome");
	let logindis = document.getElementById("Userlogin");
	let adminlogin = document.getElementById("adminlogin");
	let regdis = document.getElementById("signup");
	welcome.style.filter = "blur('2px') ";
	regdis.style.display = "none";
	adminlogin.style.display = "inline-block";
	logindis.style.display = "none";
}
function regisDisplay() {
	let welcome = document.getElementById("welcome");
	let logindis = document.getElementById("Userlogin");
	let adminlogin = document.getElementById("adminlogin");
	let regdis = document.getElementById("signup");
	welcome.style.filter = "blur('2px') ";
	regdis.style.display = "inline-block";
	adminlogin.style.display = "none";
	logindis.style.display = "none";
}

function loginAttempt() {
	var username = document.getElementById("userLoginUsername").value.trim();
	var password = document.getElementById("userLoginPassword").value.trim();
	if (usernameRegex.test(username) && passwordRegex.test(password)) {
		var req = new XMLHttpRequest();
		req.onreadystatechange = function() {
			if (req.readyState == 4) {
				var response = req.responseText;
				if (response == "false") {
					let toastBox = document.getElementById('toastbar');
					let failure = "<i class='fa-solid fa-circle-exclamation'></i> Username or Password is Invalid";
					let toast = document.createElement('div');
					toast.classList.add('alerttoast')
					toast.innerHTML = failure;
					toastBox.append(toast);

					toast.classList.add('error');

					setTimeout(() => {
						toast.remove();
					}, 4000);
				} else {
					window.location.href = "UserLogin.html";
				}
			}
		}
		req.open("POST", "userLoginServlet", true);
		req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		req.send("username=" + username + "&password=" + password);
	} else {
		let toastBox = document.getElementById('toastbar');
		let failure = "<i class='fa-solid fa-circle-exclamation'></i> Give a valid username or password";
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


function adminloginAttempt(){
	var username = document.getElementById("adminloginusername").value.trim();
	var password = document.getElementById("adminloginpassword").value.trim();
	if (usernameRegex.test(username) && passwordRegex.test(password)) {
		var req = new XMLHttpRequest();
		req.onreadystatechange = function() {
			if (req.readyState == 4) {
				var response = req.responseText;
				if (response == "false") {
					let toastBox = document.getElementById('toastbar');
					let failure = "<i class='fa-solid fa-circle-exclamation'></i> Username or Password is Invalid";
					let toast = document.createElement('div');
					toast.classList.add('alerttoast')
					toast.innerHTML = failure;
					toastBox.append(toast);

					toast.classList.add('error');

					setTimeout(() => {
						toast.remove();
					}, 4000);
				} else {
					window.location.href = "AdminLogin.html";
				}
			}
		}
		req.open("POST", "AdminLoginServlet", true);
		req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		req.send("username=" + username + "&password=" + password);
	} else {
		let toastBox = document.getElementById('toastbar');
		let failure = "<i class='fa-solid fa-circle-exclamation'></i> Give a valid username or password";
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
function validate() {

	let usertrim = usernameRegex.test(username.value.trim());
	let emailtrim = emailRegex.test(email.value.trim());
	let passtrim = passwordRegex.test(password.value.trim());
	let con = password.value.trim() != conform.value.trim();

	if (usertrim) {
		setSucces(username);
	} else {
		setError(username, 'Give a valid username');
	}
	if (emailtrim) {
		setSucces(email);
	} else {
		setError(email, 'Give valid mail id');
	}
	if (passtrim) {
		setSucces(password);


	} else {
		setError(password, 'Give a Valid Password');
	}
	if ((password.value.trim()) != conform.value.trim()) {
		setError(conform, 'Password Doesnt Match');

	} else {
		setSucces(conform);
	}


}

function popname() {
	const popoverTriggerList = document.querySelectorAll('[data-bs-toggle="popovername"]')
	const popoverList = [...popoverTriggerList].map(popoverTriggerEl => new bootstrap.Popover(popoverTriggerEl))
}
function poppass() {
	const popoverTriggerList = document.querySelectorAll('[data-bs-toggle="popoverpass"]')
	const popoverList = [...popoverTriggerList].map(popoverTriggerEl => new bootstrap.Popover(popoverTriggerEl))
}

function setError(element, errormessage) {
	const parent = element.parentElement;
	if (parent.classList.contains('success')) {
		parent.classList.remove('success');
	}
	parent.classList.add('error');

	const paragraph = parent.querySelector('p');
	paragraph.textContent = errormessage;
}
function setSucces(element) {
	const parent = element.parentElement;
	if (parent.classList.contains('error')) {
		parent.classList.remove('error');
	}
	parent.classList.add('success');

	const paragraph = parent.querySelector('p');
	paragraph.textContent = "";
}

function closeSuccessMessage() {
	const successMessage = document.querySelector('.success-message');
	successMessage.style.display = 'none';
}
function register() {
	let usertrim = usernameRegex.test(username.value.trim());
	let emailtrim = emailRegex.test(email.value.trim());
	let passtrim = passwordRegex.test(password.value.trim());
	let con = password.value.trim() != conform.value.trim();

	if (usertrim && emailtrim && passtrim && con == false) {
		registeration(username.value.trim(), email.value.trim(), password.value.trim());
	}

}

function registeration(username, email, hashedPassword) {
	var req = new XMLHttpRequest();
	var display = document.getElementById("alert");
	req.onreadystatechange = function() {
		if (req.readyState == 4) {
			var registered = req.responseText;
			console.log(registered);
			console.log(typeof (registered));
			if (registered === "true") {
				regisalert(true);

			} else {
				regisalert(false);
			}
		}

	}
	req.open("POST", "RegisterationServlet", true);
	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	req.send("username=" + username + "&email=" + email + "&password=" + hashedPassword);
}


function regisalert(option) {
	let toastBox = document.getElementById('toastbar');

	if (option) {
		let success = "<i class='fa-sharp fa-solid fa-circle-check'></i> Successfully Registered";

		let toast = document.createElement('div');
		toast.classList.add('alerttoast')
		toast.innerHTML = success;
		toastBox.append(toast);

		toast.classList.add('success');


		setTimeout(() => {
			toast.remove();
		}, 4000);
	} else {
		let failure = "<i class='fa-solid fa-circle-exclamation'></i> Already exist username or email";
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


