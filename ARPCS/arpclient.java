package ARPCS;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.text.AbstractDocument.BranchElement;

public class arpclient {

    public static void main(String args[])throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Socket s = new Socket("localhost",8888);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        System.out.println("Enter the Logical Address: ");
        String log = in.readLine();
        dos.writeBytes(log+"\n");
        String str=dis.readLine();
        System.out.println("The physical address is : "+str);

        s.close();

    }
    
}
