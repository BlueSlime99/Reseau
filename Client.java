package client;

import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
			Socket s=new Socket("localhost",1234);
			HandleServer handler=new HandleServer(s);
			new Thread(handler).start();
			new InputHandleClient(handler).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
