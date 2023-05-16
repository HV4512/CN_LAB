import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;

public class server{
    public static void main(String args[])throws IOException
    {

        ServerSocket ss= new ServerSocket(5000);
        System.out.println("wait");
        Socket s= ss.accept();
        System.out.println("conne");
        DataInputStream dis = new DataInputStream(s.getInputStream());
        int len = dis.readInt();
        System.out.println(len);
        byte data[]= new byte[len];
        dis.readFully(data);
        InputStream ian = new ByteArrayInputStream(data);
        BufferedImage bImage = ImageIO.read(ian);
        JFrame f = new JFrame("Server");
        ImageIcon icon = new ImageIcon(bImage);
        JLabel l= new JLabel();
        l.setIcon(icon);
        f.add(l);
        f.pack();
        f.setVisible(true);



    
    }    
}
