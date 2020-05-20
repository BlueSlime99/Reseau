package client;

import java.io.IOException;
import java.math.BigInteger;
import java.net.Socket;

import protocol.Protocol;

public class HandleServer implements Runnable, Protocol { /// RUNNABLE???
	private Socket s;
	private CInput ci;
	private COutput co;

	public HandleServer(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try (Socket s1 = s) {
			System.out.println("handleeeeeee");
			co = new COutput(s1.getOutputStream());
			ci = new CInput(s1.getInputStream(), this);
			ci.doRun();
		} catch (IOException ex) {

		}
	}

	public void findRSA(BigInteger n, BigInteger borneMin, BigInteger borneMax) throws IllegalArgumentException {
		System.out.println("on est ds findrsa handleserver");
		BigInteger i = borneMin;
		System.out.println("i = "+i);
		System.out.println("borneMax "+borneMax);
		System.out.println("i.compareTo(borneMax) "+i.compareTo(borneMax));
		while (i.compareTo(borneMax) == -1 || i.compareTo(borneMax) == 0) {
			System.out.println("i = "+i);
			if (i.isProbablePrime(1)) {
				System.out.println("i est 1er");
				if (n.mod(i) == BigInteger.ZERO) {
					System.out.println("on trouve une val");
					co.sendRSAFound(i);
					i=i.add(borneMax);//pour arreter while
				}
			}
			i=i.add(BigInteger.ONE);
		}
		System.out.println("on trouve pas de val");
		co.sendEndTask();
	}

	@Override
	public void sendAskRSATask() {
		System.out.println("co sendaskrsatask handleserver");
		co.sendAskRSATask();		
	}

}
