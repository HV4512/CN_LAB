import java.net.*;
import java.io.*;
import java.util.*;

class client{
	public static void main(String args[]) {
		try {
			InetAddress ia = InetAddress.getLocalHost();
			Socket s = new Socket(ia,8888);
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String d = dis.readLine();
			System.out.println("Date is :" +d);
			PrintStream ps = new PrintStream(s.getOutputStream());
			ps.println(ia);
			
		} catch (Exception e) {
			// TODO: handle exception
		}


	}
}