package ants.server;

import java.io.*;
import java.net.*;


public class gestore implements Runnable {
    
    private Socket conn;
    private static final String pathIPs="";
    private static final String pathPorts="";
    private String toSend="";
    
    BufferedReader brIPs;
    BufferedReader brPorts;
    PrintWriter out;
    
    public gestore(Socket mConn)
    {
        try{
            conn=mConn;
            brIPs=new BufferedReader(new FileReader(pathIPs));
            brPorts=new BufferedReader(new FileReader(pathPorts));
            out = new PrintWriter(conn.getOutputStream());
        }
        catch(IOException e)
        {
            
        }
    }
    
    @Override
    public void run()
    {
        try
        {
            if((toSend = brIPs.readLine())!= null)
            {
                out.println(toSend);
                out.flush();
            }

            if((toSend = brPorts.readLine())!= null)
            {
                out.println(toSend);
                out.flush();
            }
        out.close();
        conn.close();
        }
        
        catch(IOException e)
        {
        
        }
    }
}
