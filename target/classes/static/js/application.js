/**
 * 
 */

if (!jQuery) { throw new Error("This page requires jQuery") }


(function($) {

	function create() {
		var name = document.getElementById('name').value;
		var email = document.getElementById('email').value;
		var phone = document.getElementById('phone').value;
		var address = document.getElementById('address').value;  
		var thoughts = document.getElementById('thoughts').value;  
		var jobID = $("#jobID").text(); 
		
		$.ajax({
			type: "POST",
			url: "/app/set",
			data: {            
				"name": name,
				"email" : email,
				"phone" : phone,
				"address" : address,
				"thoughts" : thoughts,
				"jobID" : jobID
			},
			dataType: 'json',
			success : function(json) {  
				window.alert("Apply success to " + json.jobTitle);	 
				window.location.href = '/';  		
			}
		}); 
	}

	$("#set").click(function(e){
		e.preventDefault();
		create();
	});

})(jQuery);