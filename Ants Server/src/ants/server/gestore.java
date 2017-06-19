package ants.server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class gestore implements Runnable
{
    private Socket conn;
    private Connection db;
    Statement smt;
    String query;
    ResultSet rset;
    
    String IP;
    String Port;
    PrintWriter out;
    
    public gestore(Socket mConn) throws ClassNotFoundException
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            db=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ants", "root", "");
            smt=db.createStatement();
            conn=mConn;
            query="";
            out = new PrintWriter(conn.getOutputStream());
            
            IP="";
            Port="";
        }
        catch(IOException e)
        {
            
        }
        catch(SQLException e)
        {
            
        }
    }
    
    @Override
    public void run()
    {
        try
        {
            query = "SELECT * FROM blIP";
            
            rset=smt.executeQuery(query);
            
            if(rset.next())
                IP=rset.getString("IP");
            while(rset.next())
            {
                IP+=","+rset.getString("IP");
            }

            query = "SELECT * FROM blPort";
            
            rset=smt.executeQuery(query);
            
            if(rset.next())
                Port=rset.getString("Port");
            
            while(rset.next())
            {
                Port+=","+rset.getString("Port");
            }
            out.println(IP);
            out.flush();
            out.println(Port);
            out.flush();
            out.close();
            conn.close();
        }
        
        catch(IOException e)
        {
        
        } catch (SQLException ex) {
            Logger.getLogger(gestore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
