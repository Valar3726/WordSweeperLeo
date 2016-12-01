package server.controller;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import server.ClientState;

import server.model.Model;
import server.model.Game;
import xml.Message;
public class ExitGameRequestController {

	Model model;
	public ExitGameRequestController (Model model) {
		this.model = model;
		
	}
	public Message process(ClientState client, Message request) {
		Node exitRequest = request.contents.getFirstChild();
		NamedNodeMap map = exitRequest.getAttributes();
		String ID = map.getNamedItem("gameId").getNodeValue();
		
		Game game = model.getGame(ID);
		
		String xmlString = Message.responseHeader(request.id()) +
				"<boardResponse gameId='"+ game.getGameID() +"'>" +
			  "</boardResponse>" +
			"</response>";
		// send this response back to the client which sent us the request.
		return new Message (xmlString);
	}
}
