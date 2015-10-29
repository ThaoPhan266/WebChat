var wsUri = "ws://" + document.location.host + document.location.pathname + "chatboardendpoint";
var websocket = new WebSocket(wsUri);

websocket.onerror = function(evt) {onError(evt)};
function onError(evt){
    writeToScreen('<span style="color:red;">ERROR:</span>');
}

var output = document.getElementById("message");
websocket.onopen = function(evt) {onOpen(evt)};

function writeToScreen(message){
    output.innerHTML += message + "<br>";
}

function onOpen(){
    writeToScreen("Connected to " + wsUri);
}

websocket.onmessage = function(evt) {onMessage(evt)};

function senText(json){
    console.log("sending text: " + json);
    websocket.send(json);
}

function onMessage(evt){
    console.log("received: " + evt.data);
    if(typeof evt.data == "string"){
        displayMessage(evt.data);
    }
}