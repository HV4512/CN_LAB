
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;

public class client {

    public static void main(String args[])throws IOException {
        Socket s = new Socket("localhost", 5000);
        System.out.println("connec");
        System.out.println("connec");
        BufferedImage img = ImageIO.read(new File("dog.jpg"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "jpg", baos);
        baos.flush();
        byte bytes[]=baos.toByteArray();
        baos.close();
        DataOutputStream dos  = new DataOutputStream(s.getOutputStream());
        dos.writeInt(bytes.length);
        dos.write(bytes,0,bytes.length);
        
    }
    
}
