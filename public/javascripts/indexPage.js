    $("#searchInput").keyup(function(event){
	        if(event.keyCode == 13){
	            $("#fetchPlaces").click();
	        }
	    });

	    $("#fetchPlaces").bind("click", function() {

	    	$("#dataTable > tbody").empty();

	    	var searchInput = $("#searchInput").val()
	    	if(jQuery.trim(searchInput).length > 0){
	    		jQuery.ajax(
					{
	    				url : "/searchMulti",
	    				type: 'POST',
	    				contentType : "application/json",
	    				data: JSON.stringify({'locName':searchInput, 'category':searchInput}),
	    				success:function(data) {
	    					$.each(data, function(i, place) {
	    		                $(".data-contacts-js").append(
	    		                    "<tr><td>" + place.locName + "</td>" +
	    		                    "<td>" + place.category + "</td>" +
	    		                    "<td>" + place.rating + "</td>" +
	    		                    "<td> <p id='map' onClick=initialize("+place.latitude+","+place.longitude+")> Map </p> </td></tr>");
	    		            });
	    				},
	    				error: function() {}
	    			}
	    		);
	    	}
	    	else{
	    		$.get("/list", function(data) {

		            $.each(data, function(i, place) {

		                $(".data-contacts-js").append(
		                    "<tr><td>" + place.locName + "</td>" +
		                    "<td>" + place.category + "</td>" +
		                    "<td>" + place.rating + "</td>" +
		                    "<td> <p id='map' onClick=initialize("+place.latitude+","+place.longitude+")> Map </p> </td></tr>");
		            });
		        });
	    	}
	    });



	    $("#dataTable").ready(function() {
	        $.get("/list", function(data) {

	            $.each(data, function(i, place) {
	                $(".data-contacts-js").append(
	                    "<tr><td>" + place.locName + "</td>" +
	                    "<td>" + place.category + "</td>" +
	                    "<td>" + place.rating + "</td>" +
	                    "<td> <p id='map' onClick=initialize("+place.latitude+","+place.longitude+")> Map </p> </td></tr>");
	            });
	        });
	    });


	    $("#totalCount").ready(function(){
            		$.get("/count", function(data) {
            			$("#totalCount").append("<span class=\"label label-default\">" + data + "</span>");
            		});
            	});