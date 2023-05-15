
import java.io.*;
import java.net.*;

class pingserver{
    public static void main(String Args[])
    {
        try {
          System.out.println("Enter the address to be pinged");
          DataInputStream dis = new DataInputStream(System.in);
          String ip = dis.readLine();
          Runtime h = Runtime.getRuntime();
          Process p = h.exec("ping "+ip);
          InputStream in =p.getInputStream();
          DataInputStream buf2 = new DataInputStream(in);
          String str;
          while((str=buf2.readLine())!=null)
          {
            System.out.println(" " +str);
          }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        }
    }
}