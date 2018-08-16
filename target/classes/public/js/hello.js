function getCustomers() {
		$.ajax({
	        url: "/customers",
	        dataType: 'json'
	    }).then(function(data) {
	    	//document.getElementById("json").innerHTML = data;
	    	var table = document.getElementById("results");
	    	for ( var k = 0; k < data.length; k++) {
	    		
	    		var row = table.insertRow(k + 1);
	    		var cell1 = row.insertCell(0);
	    		var cell2 = row.insertCell(1);
	    		cell1.innerHTML = data.fistName;
	    		cell2.innerHTML = data.lastName;
	    		
	    	}
	      
	    });
	}