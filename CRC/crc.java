package CRC;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;

public class crc {
    public static void main(String args[])throws IOException{
        System.out.println("Enter Divisor");
        DataInputStream dis = new DataInputStream(System.in);
        String divs=dis.readLine();
        System.out.println("Enter Data");
        String data=dis.readLine();
        String code = data;
        for(int i = 1;i<divs.length();i++)
        {
            code+="0";
        }
       String tcode=data+bdiv(code,divs);
       System.out.println("Transmitted code is : "+tcode);
       System.out.println("Enter the received code:");
       String rec=dis.readLine();
       if(Integer.parseInt(bdiv(rec,divs))==0)
       System.out.println("No Error");
       else
       System.out.println("Error");

     }

     public static String bdiv(String num1,String num2)
     {
        int pointer=num2.length();
        String result=num1.substring(0, pointer);
        String remainder="";

        for(int i =0;i<num2.length();i++)
        {
            if(result.charAt(i)==num2.charAt(i))
            remainder+="0";
            else
            remainder+="1";
        }
        while(pointer<num1.length())
        {
            if(remainder.charAt(0)=='0')
            {
                remainder=remainder.substring(1,remainder.length());
                remainder=remainder+String.valueOf(num1.charAt(pointer));
                pointer++;
            }
            result=remainder;
            remainder="";
            for(int i =0;i<num2.length();i++)
        {
            if(result.charAt(i)==num2.charAt(i))
            remainder+="0";
            else
            remainder+="1";
        }
        }
        return remainder.substring(1,remainder.length());
    }
}
