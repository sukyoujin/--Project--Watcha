function search() {
	var xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("view").innerHTML = this.responseText;
		}
	};
	xhttp.open("GET", "../searchPalette.jsp", true);
	xhttp.send();
}
function searchResult(hexCode) {
	var xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("view").innerHTML = this.responseText;
		}
	};
	xhttp.open("GET", "../searchResult.jsp?hexCode=" + hexCode, true);
	xhttp.send();
}