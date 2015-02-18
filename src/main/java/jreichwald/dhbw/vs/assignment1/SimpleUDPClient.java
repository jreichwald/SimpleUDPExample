package jreichwald.dhbw.vs.assignment1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Implementation of a simple UDP client wich sends messages to a UDP server
 * @author Prof. Dr. Julian Reichwald <julian.reichwald@dhbw-mannheim.de>
 *
 */
public class SimpleUDPClient {
	private static Logger _log = LogManager.getLogger(SimpleUDPClient.class);
	
	public static void main(String[] args) {
				
		DatagramSocket socket = null; 
		
		try {
			//create a message 
			byte[] msg = "0123456789".getBytes();
			
			//create clienet socket (no port number needed here!) 
			socket = new DatagramSocket(); 
			
			//create datagram packet using the message
			DatagramPacket p = new DatagramPacket(msg, msg.length);
		
			//create the destination and set it 
			InetAddress addr = InetAddress.getByName("localhost");
			p.setPort(11111);
			p.setAddress(addr);
			
			//send the message. This is NOT a blocking call! 
			socket.send(p);
			
			_log.debug("Message sent.");
			
			//close the socket
			socket.close();
			
		} catch (Exception e) {
			_log.error(e);
		}
	}
}
