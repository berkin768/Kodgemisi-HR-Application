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
	
	function readInput() {
        var username = document.getElementById('username').value;
        var password = document.getElementById('password').value;
        $.ajax({
            type: "POST",
            url: "/login/continue",
            data: {            
                "username": username,
                "password": password
            },
            dataType: 'json',
            success : function(json) {
                if(json.isLogged === true){      
                	createCookie("username",json.username,100);
                    window.location.replace("/");             
                }
                else{
                    window.alert("Wrong password or username")
                }
            },
        }); 
    }
	
	$("#login").click(function(e){
        e.preventDefault();
        readInput();
    });
})(jQuery);