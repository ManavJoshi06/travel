package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class Payments  extends JFrame implements ActionListener{
    JButton back,pay,gp,ap;
    JLabel user,id,no,pr;
     String username;
     int cost,cost1;
             double total=0,total1=0,total2=0;
     
    Payments(String username)
    {
         this.username= username;
        setBounds(400,100,800,600);
        setLayout(null);
         JLabel luser = new JLabel("Username");
        luser.setBounds(30, 50, 150, 25);
        luser.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(luser);
        
        user = new JLabel();
        user.setBounds(220, 50, 150, 25);
        user.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(user);
        
         JLabel lid= new JLabel("ID");
        lid.setBounds(30, 100, 150, 25);
        lid.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lid);
        
        id= new JLabel();
        id.setBounds(200, 100, 200, 40);
        id.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(id);
        
        JLabel lno= new JLabel("Id Number");
        lno.setBounds(30, 150, 150, 25);
        lno.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lno);
        
        no= new JLabel();
        no.setBounds(200, 150, 150, 25);
        no.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(no);
        
         JLabel lpr= new JLabel("Total Price");
        lpr.setBounds(30, 190, 150, 25);
        lpr.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lpr);
        
        pr= new JLabel();
        pr.setBounds(200, 190, 150, 25);
        pr.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(pr);
        
       
        
       
        try
        {
            Conn co = new Conn();
            ResultSet rs=co.s.executeQuery("select*from customer where username='"+username+"'");
            while(rs.next())
            {
                user.setText(rs.getString("username"));
                
                id.setText(rs.getString("id"));
                no.setText(rs.getString("number"));               
                
               
            }
        }
        
        catch (Exception E){}
         try
        {
            Conn co2 = new Conn();
            ResultSet rs1=co2.s.executeQuery("select*from bookhotel where username='"+username+"'");
            while(rs1.next())
            {
              
                 cost = Integer.parseInt(rs1.getString("price"));
                  
             
            }
        }
        catch (Exception E){}
         
         try
        {
            Conn co2 = new Conn();
            ResultSet rs1=co2.s.executeQuery("select*from bookpackage where username='"+username+"'");
            while(rs1.next())
            {
              
                 cost1 = Integer.parseInt(rs1.getString("price"));
                  
             
            }
        }
        catch (Exception E){}
        double gst =0.16;
          total1+=cost+cost1;
          total2=total1*gst;
          total=total1+total2;
          
                pr.setText("Rs"+total);  
        
        
        
         
          ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm2.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 600);
        add(image);
        back = new JButton("back");
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK );
        back.setBounds(560, 500, 100, 40);
        back.addActionListener(this);
        image.add(back);
        
       pay = new JButton("Paytm");
        pay.setBackground(Color.white);
        pay.setForeground(Color.BLACK);
        pay.setBounds(200, 500, 150, 40);
        pay.addActionListener(this);
        image.add(pay);
        
         gp = new JButton("Google pay");
        gp.setForeground(Color.black);
        gp.setBackground(Color.white);
        gp.setBounds(380, 500, 150, 40);
        gp.addActionListener(this);
       image.add(gp);

       
        
        setResizable(false);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    { 
        if(ae.getSource()==pay)
        {
           new Paytm(); 
           setVisible(false);

        }
        if(ae.getSource()==gp)
        {
           new Gpay(""); 

        }
        else
        {
            setVisible(false);
        }
    }
    public static void main(String args[])
    {
        new Payments("manav");
    }    
}
