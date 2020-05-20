package client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;

import protocol.Protocol;

public class COutput implements Protocol{
	PrintWriter pw;
	
	public COutput(OutputStream out)throws IOException{
		this.pw=new PrintWriter(out,true);
	}
	
	@Override
	public void sendAskRSATask() {
		pw.println("ARSATASK");
	}
	
	public void sendAskDESTask() {
		pw.println("ADESTASK");
	}
	
	@Override
	public void sendRSAFound(BigInteger p) {
		pw.println("RSAFOUND");
		pw.println(p);
	}
	
	//sendDESFound
	
	@Override
	public void sendEndTask() {
		pw.println("END");
	}
	
	
	
}
