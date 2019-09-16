<!DOCTYPE html>
<html>
<head>
<title>Welcome!</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body, h1 {
	font-family: "Raleway", Arial, sans-serif
}

h1 {
	letter-spacing: 6px
}

.w3-row-padding img {
	margin-bottom: 12px
}
</style>
<script>
	function showMovieList() {
		var xhttp = new XMLHttpRequest();

		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("view").innerHTML = this.responseText;
			}
		};
		xhttp.open("GET", "searchList.jsp", true);
		xhttp.send();
	}
</script>

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load('current', {
		'packages' : [ 'corechart' ]
	});

	function drawChart(chartData, head) {
		var data = google.visualization.arrayToDataTable(chartData);
		var options = {
			title : head
		};
		var chart = new google.visualization.PieChart(document
				.getElementById('view'));
		chart.draw(data, options);
	}

	function showChart() {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var chartData = this.responseText;
				chartData = eval(chartData);
				drawChart(chartData, 'YJ\'s Movie Taste');
			}
		};
		xhttp.open("GET", "dataMovie.jsp", true);
		xhttp.send();
	}
</script>

</head>
<body>
	<!-- !PAGE CONTENT! -->
	<div class="w3-content" style="max-width: 1500px">

		<!-- Header -->
		<div class="w3-opacity">
			<span class="w3-button w3-xxlarge w3-white w3-right"
				onclick="w3_open()"><i class="fa fa-bars"></i></span>
			<div class="w3-clear"></div>

			<header class="w3-panel w3-center w3-opacity"
				style="padding: 80px 16px">
				<h1 class="w3-xlarge">Your Movie Taste</h1>
				<h1>WATCHA</h1>
				<p class="w3-padding-16">
					<a class="w3-button w3-white">Who You Are!</a>
				</p>

				<div class="w3-padding-32">
					<div class="w3-bar w3-border">
						<button class="w3-bar-item w3-button w3-light-grey"
							onclick="showMovieList()">List</button>
						<button class="w3-bar-item w3-button" onclick="showChart()">Chart</button>
					</div>
				</div>
			</header>



		</div>
		<!-- End Page Content -->
	</div>
	<section>
		<div id="view" style="width: 900px; height: 500px; margin: auto"></div>
		
	</section>

</body>
</html>