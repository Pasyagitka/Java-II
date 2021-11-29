function GetVideoListAdmin() {
    alert("!!");
    fetch('http://localhost:8080/adminmain/getVideoList')
        .then((response) => {
            let data = response.json();
            let tr = '';
            data.forEach(function (value) {
                tr += `<tr><td>${data.id}</td></tr>`;
            });
            document.querySelector('#table_id tbody').innerHTML = tr; //Append the data
        }).catch(error => {
        console.log(error);
    });
}