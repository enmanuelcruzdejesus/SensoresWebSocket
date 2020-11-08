$.ajax({
    url: '/sensordata/getall',
    success: function(result){
        var data =  JSON.parse(result);
        var temperatures1 = data.temperatures1;
        var humidities1 = data.humidities1;
        var temperatures2 = data.temperatures2;
        var humidities2 = data.humidities2;
        drawLineChart1(temperatures1,humidities1);
        drawLineChart2(temperatures2,humidities2);
    }
});

function drawLineChart1(temperatures, humidities){

Highcharts.chart('container1', {
	    chart: {
	        type: 'line',
	        width: 500
	    },

	    title: {
	        text: 'Humedad vs Temperatura'
	    },

	    xAxis: {
	        categories: temperatures
	    },

	    tooltip: {
	        formatter: function() {
	          return '<strong>'+this.x+': </strong>'+ this.y;
	        }
	    },

	    series: [{
	        data: humidities
	    }]
	});
}


function drawLineChart2(temperatures, humidities){

Highcharts.chart('container2', {
	    chart: {
	        type: 'line',
	        width: 500
	    },

	    title: {
	        text: 'Humedad vs Temperatura'
	    },

	    xAxis: {
	        categories: temperatures
	    },

	    tooltip: {
	        formatter: function() {
	          return '<strong>'+this.x+': </strong>'+ this.y;
	        }
	    },

	    series: [{
	        data: humidities
	    }]
	});
}