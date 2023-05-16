package stopandwait;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class receiver {
    public static void main(String args[])throws IOException{
        ServerSocket ss= new ServerSocket(8000);
        Socket s = ss.accept();
        DataInputStream dis = new DataInputStream(s.getInputStream());
        Integer n=dis.read();
        for(int i = 0 ;i<n;i++)
        {
            ServerSocket ss2= new ServerSocket(9000+i);
            Socket s2= ss2.accept();
            DataInputStream dis2 = new DataInputStream(s2.getInputStream());
            String msg=dis2.readUTF();
            System.out.println(msg);
            System.out.println("Frame "+i + " received");
            DataOutputStream dos = new DataOutputStream(s2.getOutputStream());
            dos.write(i);
            System.out.println("Ack "+i + " sent");

        }
    }
}
    