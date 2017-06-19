package ants.server;

import java.io.*;
import java.net.*;

public class AntsServer {

    public static void main(String[] args) throws ClassNotFoundException, IOException 
    {
        ServerSocket sconn=null;
        Socket conn=null;
        gestore now;
        Thread thread;
        
        int port=3355;
        sconn=new ServerSocket(port);

        while(true)
        {
            conn=sconn.accept();
            now=new gestore(conn);
            thread=new Thread(now);
            thread.start();
        }
<<<<<<< HEAD
    }
=======
    }   
>>>>>>> 0bb064b470fb058f755b9b4bf639a4fd7ce7f444
}
