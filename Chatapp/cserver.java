package Chatapp;

import java.io.*;
import java.net.*;

class cserver{

    public static DatagramSocket ds;
    public static byte buffer[]=new byte[1024];
    public static int clientport=789,serverport=790;

    public static void main(String args[]) throws IOException
    {
        ds = new DatagramSocket(clientport);
        System.out.println("Ctrl+c for exit");
        BufferedReader dis = new BufferedReader(new InputStreamReader(System.in));
        InetAddress ia =InetAddress.getLocalHost();
        while(true)
        {
            DatagramPacket p = new DatagramPacket(buffer,buffer.length);
            ds.receive(p);
            String psx = new String(p.getData(),0,p.getLength());
            System.out.println("Client : "+psx);
            System.out.println("Server : ");
            String str=dis.readLine();
            if(str.equals("end"))
            break;
            buffer=str.getBytes();
            ds.send(new DatagramPacket(buffer,str.length(),ia,serverport));
        }
    }
}
