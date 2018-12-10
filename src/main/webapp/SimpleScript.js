
function sendMes(argument) 
{
	let to = document.getElementById("to").value;
	let subject = document.getElementById("subject").value;
	let message = document.getElementById("message").value;

	let xhr = new XMLHttpRequest();

    let body = "to="+encodeURIComponent(to)+
		"&subject="+encodeURIComponent(subject)+
		"&message="+encodeURIComponent(message);
                
    xhr.open("POST","/Sender/send" , false);
    xhr.setRequestHeader('Content-Type',
        'application/x-www-form-urlencoded');
    xhr.send(body);
    if(xhr.status === 200)
    {
        alert(xhr.responseText);
	  }//add data in table
}//end addData

let sendBut = document.getElementById("but");
sendBut.addEventListener("click", sendMes);

