/**
 * 
 */


if (!jQuery) { throw new Error("This page requires jQuery") }


(function($) {
	
	function createCookie(name, value, days) {
	    var expires;

	    if (days) {
	        var date = new Date();
	        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
	        expires = "; expires=" + date.toGMTString();
	    } else {
	        expires = "";
	    }
	    document.cookie = encodeURIComponent(name) + "=" + encodeURIComponent(value) + expires + "; path=/";
	}

	function readCookie(name) {
		var nameEQ = encodeURIComponent(name) + "=";
		var ca = document.cookie.split(';');
		for (var i = 0; i < ca.length; i++) {
			var c = ca[i];
			while (c.charAt(0) === ' ') c = c.substring(1, c.length);
			if (c.indexOf(nameEQ) === 0) return decodeURIComponent(c.substring(nameEQ.length, c.length));
		}
		return null;
	}

	function eraseCookie(name) {
		createCookie(name, "", -1);
	}

	function logout() {		
		eraseCookie("username");
		
		location.reload();
	}

	$(document).ready(function () {
		$(function () {		
			if(readCookie("username") != null){
				$("#username").text(readCookie("username"));
			}
			else{
				$("#username").text("Guest");
			}
			
		});

		$(function () {	
			var userName = $("#username").text();			
			if(userName.trim() != "Guest"){
				$("#userImage").attr("src", "/images/admin.png")
				$("#adminPage").css('display', 'inherit');    
				$("#signOut").css('display', 'inherit');
				$("#loginArea").css('display', 'none');
			}
			else{
				$("#adminPage").css('display', 'none');       
				$("#signOut").css('display', 'none');
				$("#loginArea").css('display', 'inherit');
			}
		});

	}); 

	$("#signOut").click(function(e){
		e.preventDefault();
		logout();
	});

	$("#loginArea").click(function(e){
		e.preventDefault();
		document.location.href = "/login";
	});
	
	$("#adminPage").click(function(e){
		e.preventDefault();
		document.location.href = "/admin";
	});

	
	

})(jQuery);