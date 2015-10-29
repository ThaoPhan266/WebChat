function defineMessage(){
    var text = document.getElementById("text");
    var name = document.getElementById("name");
    var date = new Date();
    var json = JSON.stringify({
       "name": name.value,
       "message": text.value,
       "sentDate": date.toString()
    });
    senText(json);
    displayMessage(json);
}

var send = document.getElementById("send");
send.addEventListener("click",defineMessage,false);

function displayMessage(msg){
    console.log("display message: " + msg.toString());
    var board = document.getElementById("board");
    var json = JSON.parse(msg);
    board.value += json.name + " said: " + json.message + "\n";
}