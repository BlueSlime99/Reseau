package client;

import java.util.Scanner;

public class InputHandleClient extends Thread{
	private HandleServer handler;
	
	public InputHandleClient(HandleServer handler) {
		this.handler=handler;
	}
	
	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String line = scanner.nextLine();
//			if (line == null)
//				line = "QUIT";
			switch (line) {
			case "ARSATASK":
				handler.sendAskRSATask();
				break;
			default:
				System.out.println(line);
				System.out.println("Invalid input");
			}
		}
	}
}
