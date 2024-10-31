function loadGetMsg() {
    let operation = document.getElementById("operation").value;
    let inputList = document.getElementById("inputlist").value;
    let value = document.getElementById("valor").value;

    if (!operation.startsWith("/")) {
        operation = "/" + operation;
    }


    if (operation !== "/linearsearch" && operation !== "/binarysearch") {
        alert("Please enter either 'linearsearch' or 'binarysearch' as the operation.");
        return;
    }


    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        makeBeautiful(this.responseText);
    }
    
    xhttp.open("GET", `${operation}?list=${inputList}&value=${value}`, true);
    xhttp.send();
}


function makeBeautiful(response) {
    let json = JSON.parse(response);
    let table = '<table border="1">';
    for (let key in json) {
        table += '<tr>';
        table += '<td>' + key + '</td>';
        table += '<td>' + json[key] + '</td>';
        table += '</tr>';
    }
    table += '</table>';
    document.getElementById('getrespmsg').innerHTML = table;
}
