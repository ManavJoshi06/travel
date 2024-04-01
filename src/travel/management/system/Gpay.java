
package travel.management.system;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;


public class Gpay extends JFrame implements Runnable{
        Thread thread;

     Gpay(String username)
    {
         setSize(400, 600);
        setLocation(200, 0);
        setLayout(null);
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/gpay.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 400, 600);
        add(image);
         setVisible(true); 
          thread =new Thread(this);
        thread.start();
    
    }
     
      public void run()
    {
        try{
            Thread.sleep(15000);
            setVisible(false);
            JOptionPane.showMessageDialog(null, "Payment Succesfully");
            new receipt("manav");
        }catch(Exception e){}
    
    }
    
    public static void main(String arge[])
    {
        new Gpay(""); 
    } 
    
}
