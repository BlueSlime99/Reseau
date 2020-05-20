package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import server.ProtocolException;

public class CInput {
	HandleServer handler;
	InputStream is;
	
	public CInput(InputStream is, HandleServer handler) throws IOException {
		this.is = is;
		this.handler = handler;
	}
	
	public void doRun() throws IOException{
		BigInteger n, borneMin, borneMax;
			try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
				while (true) {
					System.out.println("whiiiiiiiile");
					String line = br.readLine();
					System.out.println(line+ "liiiiiiine");
					switch (line) {
					case "ARSATASK":
						System.out.println("caaaaaase");
						handler.sendAskRSATask();
						break;
					case "RSATASK":
						System.out.println("rsaaaataaaask cinput");
						n=new BigInteger(br.readLine());
		//				System.out.println(n);
						borneMin=new BigInteger(br.readLine());
						borneMax=new BigInteger(br.readLine());
						System.out.println("cinput borneMax="+borneMax);
						handler.findRSA(n,borneMin,borneMax);
						break;
//					case "DESTASK":
						
//						break;
					case "STOP":
						break;
					case "QUIT":
						notifyAll();
						break;
					default:
						System.out.println(line);
						throw new ProtocolException("Invalid input");
					}
				}
			}
		}
}
