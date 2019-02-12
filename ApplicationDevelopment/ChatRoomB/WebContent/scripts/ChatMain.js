"use strict";

var Chat = Chat || {}

Chat.sendMessage = function() {
	var userName = document.getElementById('userName').textContent
	var text = $('#usertextentry');
	var msg = userName.trim() + ':-> ';
	var message = msg.concat(text.val());
	if (message != '') {
		Chat.socket.send(message);
		text.val('');
	}

};
Chat.GetUsers = function() {
	Chat.socket.send("X#$$#X "
			+ document.getElementById('userName').textContent.trim());
}

Chat.connect = function(host) {
	if ('WebSocket' in window) {
		Chat.socket = new WebSocket(host);
	} else if ('MozWebSocket' in window) {
		socket = new MozWebSocket(host);
	} else {
		console.log('Error: WebSocket is not supported by this browser.');
		return;
	}

	Chat.socket.onopen = function() {
		console.log("Info: connection opened");
		Chat.GetUsers();
		$('#usertextentry').keydown(function(evt) {
			if (evt.keyCode == 13) {
				Chat.sendMessage();
			}
		});

	};

	Chat.socket.onclose = function() {
		console.log("Info: connection closed");
	};

	Chat.socket.onmessage = function(message) {
		if (message.data.includes("X#$$#X")) {
			var msg = message.data;
			var temp = msg.replace(/X#$$#X/, " ");//not replacing all in the String 
			$('#onlineUsers').text(temp);
		} else {
			$('#messagelist').text(message.data);
		}
	};

	// Chat.socket.onmessage = function(getlist) {
	// }

};

Chat.initialize = function() {
	var ep = '/SmallChatRoom/endpoint';
	if (window.location.protocol == 'http:') {
		Chat.connect('ws://' + window.location.host + ep);
	} else {
		connect('wss://' + window.location.host + ep);
	}
};

Chat.initialize();
