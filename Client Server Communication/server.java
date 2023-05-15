import java.util.*;
import java.net.*;
import java.io.*;

class server{
	public static void main(String args[]){
		try {
			ServerSocket ss = new ServerSocket(8888);
			Socket s = ss.accept();
			PrintStream ps = new PrintStream(s.getOutputStream());
			Date d = new Date();
			ps.println(d);
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String inet = dis.readLine();
			System.out.println(inet);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}