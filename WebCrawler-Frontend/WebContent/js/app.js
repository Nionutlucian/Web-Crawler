var app = angular.module("myApp", []);
app.controller("registerController", function ($scope, $http, $window) {

	var verifyIfLogin = function () {
		if ($window.sessionStorage.getItem("userLoged") != null) {
			window.location.href = "D:\MyWorkspace/WebCrawler-Frontend/WebContent/401.html"
		}
	};
	verifyIfLogin();

	$scope.registerFunction = function (name, email, password, adress) {
		var obj = {
			name: name,
			email: email,
			password: password,
			adress: adress
		};

		console.log(JSON.stringify(obj));
		$http({
			method: 'POST',
			url: 'http://localhost:8091/webcrawler/register',
			data: JSON.stringify(obj),
			headers: { 'Content-type': 'application/json' }
		})
			.then(function (response) {
				window.alert("Contul a fost creat cu succes!Va rugam sa va logati.")
				window.location.href = "D:\MyWorkspace/WebCrawler-Frontend/WebContent/login.html"
			}).catch(function (error) {
				window.alert("A aparut o eroare : " + error);
				console.log(error);
			});
	};
});

app.controller("loginController", function ($scope, $http, $window) {

	var verifyIfLogin = function () {
		if ($window.sessionStorage.getItem("userLoged") != null) {
			window.location.href = "D:\MyWorkspace/WebCrawler-Frontend/WebContent/401.html"
		}
	};
	verifyIfLogin();

	$scope.loginFunction = function (email, password) {
		var obj = {
			email: email,
			password: password
		};

		console.log(JSON.stringify(obj));
		$http({
			method: 'POST',
			url: 'http://localhost:8091/webcrawler/login',
			data: JSON.stringify(obj),
			headers: { 'Content-type': 'application/json' }
		})
			.then(function (response) {
				if (response.data.email == "Username or password incorect!") {
					window.alert('Email sau parola incorecte!Va rugam sa incercati din nou.');
				} else {
					$window.sessionStorage.setItem("userLoged", JSON.stringify(response.data));
					if ((JSON.parse($window.sessionStorage.getItem("userLoged")).roles[0].name) == "ADMIN") {
						window.location.href = "D:\MyWorkspace/WebCrawler-Frontend/WebContent/admin-homepage.html"
					}
					if ((JSON.parse($window.sessionStorage.getItem("userLoged")).roles[0].name) == "USER") {
						window.location.href = "D:\MyWorkspace/WebCrawler-Frontend/WebContent/homepage.html"
					}
				}
			}).catch(function (error) {
				window.alert("A aparut o eroare : " + error);
				console.log(error);
			});
	};
});


