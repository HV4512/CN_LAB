package stopandwait;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class send {
    public static void main(String args[])throws IOException
    {
        int p=9000,i,q=8000;
        String h="localhost";
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter No. Of Frames");
        int n=scanner.nextInt();
        if(n==0)
        System.out.println("No frame");
        else{

            Socket s= new Socket(h, q);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.write(n);
        }
        for(i=0;i<n;i++)
        {
            System.out.print("Enter Message :" );
            String msg=scanner.next();
            System.out.println("Frame sent "+i);
            Socket s2= new Socket(h,p+i);
            DataOutputStream dos = new DataOutputStream(s2.getOutputStream());
            dos.writeUTF(msg);
            DataInputStream dis = new DataInputStream(s2.getInputStream());
            Integer ack=dis.read();
            System.out.println("Ack received "+ack);
            
        }

    }
}
