package ants.server;

import java.io.*;
import java.net.*;

public class AntsServer {

    public static void main(String[] args) throws ClassNotFoundException 
    {
        ServerSocket sconn=null;
        Socket conn=null;
        gestore now;
        Thread thread;
        
        int port=3355;
        
        while(true)
        {
            try
            {
                sconn=new ServerSocket(port);
                conn=sconn.accept();
                now=new gestore(conn);
                thread=new Thread(now);
                thread.start();
            }
            catch(IOException e)
            {
                
            }
        }
    }   
    
}
