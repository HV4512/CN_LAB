package ARPCS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class arpserver {

    public static void main(String args[])throws IOException {

        ServerSocket ss= new ServerSocket(8888);
        Socket s= ss.accept();
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        String ip[]={"165.164.78.80","165.156.85.46"};
        String mac[]={"AC:6A:BC:C3","AB:B2:C5:AB"};
        String str=dis.readLine();
        for (int i =0;i<ip.length;i++)
        {
            if(str.equals(ip[i]))
            {
                dos.writeBytes(mac[i]+'\n');
                break;
            }
        }
        ss.close();
    }

    
}
