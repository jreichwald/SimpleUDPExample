package jreichwald.dhbw.vs.assignment1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Implementation of a simple UDP server which accepts a message 
 * and prints the results to a console log
 * @author Prof. Dr. Julian Reichwald <julian.reichwald@dhbw-mannheim.de>
 *
 */
public class SimpleUDPServer {

	private static Logger _log = LogManager.getLogger(SimpleUDPServer.class);
	
	public static void main(String[] args) {
		
		DatagramSocket serverSocket = null; 
		
		int messageCounter = 0; 
		
		try {
			//Create server socket on port 11111
			serverSocket = new DatagramSocket(11111);
			
			while (true) {
				_log.debug("Server waiting for UDP datagrams ...");
				
				//Create Message Buffer 
				byte[] buffer = new byte[10];
				
				//Create a datagram packet using the message buffer
				DatagramPacket dp_request = new DatagramPacket(buffer, buffer.length);

				//wait for incoming datagram: blocking call
				serverSocket.receive(dp_request);
				messageCounter++; 
				_log.debug("Received Message #"+messageCounter);
				
				
				//extract message from datagram packet
				String str = new String(dp_request.getData());

				//Print Stringlength without trimming 
				_log.debug("Stringlength: " + str.length());

				//Trim string 
				str=str.trim(); 
			
				//Print Stringlength after trimming
				_log.debug("Trimmed stringlength: " + str.length());
				
				
				_log.debug("Message Content: " + str);
			}
			
		} catch (Exception e) {
			_log.error(e);
		}	
	}
}
