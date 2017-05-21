/**
 * 
 */

if (!jQuery) { throw new Error("This page requires jQuery") }


(function($) {

	function create() {
		var title = document.getElementById('title').value;
		var description = document.getElementById('description').value;
		var person = document.getElementById('person').value;
		var date = document.getElementById('date').value;      

		$.ajax({
			type: "POST",
			url: "/admin/done",
			data: {            
				"title": title,
				"description" : description,
				"person" : person,
				"date" : date
			},
			dataType: 'json',
			success : function(json) {  		
				window.alert(json.jobTitle + " created");	 
				window.location.href = '/admin';  		
			}
		}); 
	}

	$("#create").click(function(e){
		e.preventDefault();
		window.location.href = '/admin/create';   
	});

	$("#set").click(function(e){
		e.preventDefault();
		create();
	});

	$("#list").click(function(e){
		e.preventDefault();
		window.location.href = '/admin/list';   
	});
})(jQuery);