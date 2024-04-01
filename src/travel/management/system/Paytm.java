
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Paytm extends JFrame implements Runnable{
     Thread thread;
    Paytm()
    {
        setBounds(400,100,800,600);
        
        JEditorPane pay=new JEditorPane();
        pay.setEditable(false);
        try
        {
            pay.setPage("https://paytm.com/rent-payment");
        }
        catch(Exception e)
        {
            pay.setContentType("text/html");
            pay.setText("<html>Could not load, error 404 </html>");
        }
        JScrollPane sb= new JScrollPane(pay);
        getContentPane().add(sb);
        
       
        
        setResizable(false);
        setVisible(true);
         thread =new Thread(this);
        thread.start();
    }
     public void run()
    {
        try{
            Thread.sleep(50000);
            setVisible(false);
            JOptionPane.showMessageDialog(null, "Payment Succesfully");
            new receipt("manav");
        }catch(Exception e){}
    
    }
    public static void main(String args[])
    {
        new Paytm();
    }
    
}
