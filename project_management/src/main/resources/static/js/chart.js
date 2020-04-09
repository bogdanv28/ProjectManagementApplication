var decodedChartData = decodeHtml(chartData);
var chartJsonArray = JSON.parse(decodedChartData);

var numericData = [];
var labelData = [];

for(var i = 0; i < chartJsonArray.length; i++){
	numericData[i] = chartJsonArray[i].value;
	labelData[i] = chartJsonArray[i].label;
}

new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#75daad", "#00a8cc", "#dd2c00"],
            data: numericData
        }]
    },

    // Configuration options
    options: {
    	title : true,
    text: "Project Status"
    }
});

function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}