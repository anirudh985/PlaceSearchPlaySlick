function initialize(lat,lon) {
			var userLatLng = new google.maps.LatLng(lat,lon)
			var mapProp = {
				center : userLatLng,
				zoom : 16,
				mapTypeId : google.maps.MapTypeId.ROADMAP
			};
			var mapObject = new google.maps.Map(document.getElementById("googleMap"), mapProp);
			new google.maps.Marker({map: mapObject, position: userLatLng });

		}
	        google.maps.event.addDomListener(window, 'load', initialize(51.508742,-0.120850));