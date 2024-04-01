package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class receipt  extends JFrame {
    JButton back,pay,gp,ap;
    JLabel user,id,no,pr,phno,bpl,hpl,gstl,n;
    String username;
    int cost,cost1;
    double total=0,total1=0,total2=0;
     
    receipt(String username)
    {
         this.username= username;
        setBounds(400,100,400,600);
       getContentPane().setBackground(Color.white);
        setLayout(null);
        
         JLabel r= new JLabel("RECEIPT");
        r.setBounds(90, 30, 250, 30);
        r.setFont(new Font("Tahoma",Font.BOLD, 35));
        add(r);
        
         JLabel luser = new JLabel("Username");
        luser.setBounds(30, 90, 150, 25);
        luser.setFont(new Font("series",Font.BOLD, 14));
        add(luser);
        
        user = new JLabel();
        user.setBounds(220, 90, 150, 25);
        user.setFont(new Font("series",Font.BOLD, 14));
        add(user);
        
         JLabel nm = new JLabel("Name");
        nm.setBounds(30, 125, 150, 25);
        nm.setFont(new Font("series",Font.BOLD, 14));
        add(nm);
        
        n = new JLabel();
        n.setBounds(220, 125, 150, 25);
        n.setFont(new Font("series",Font.BOLD, 14));
        add(n);
        
         JLabel lid= new JLabel("ID");
        lid.setBounds(30, 160, 150, 25);
        lid.setFont(new Font("series",Font.BOLD, 14));
        add(lid);
        
        id= new JLabel();
        id.setBounds(200, 160, 200, 40);
        id.setFont(new Font("series",Font.BOLD, 14));
        add(id);
        
        JLabel lno= new JLabel("Id Number");
        lno.setBounds(30, 210, 150, 25);
        lno.setFont(new Font("series",Font.BOLD, 14));
        add(lno);
        
        no= new JLabel();
        no.setBounds(200, 210, 150, 25);
        no.setFont(new Font("series",Font.BOLD, 14));
        add(no);
        
        JLabel pno= new JLabel("phone Number");
        pno.setBounds(30, 260, 150, 25);
        pno.setFont(new Font("series",Font.BOLD, 14));
        add(pno);
        
        phno= new JLabel();
        phno.setBounds(200, 260, 150, 25);
        phno.setFont(new Font("series",Font.BOLD, 14));
        add(phno);
        
         JLabel a= new JLabel("****Amount Calculation*****");
        a.setBounds(50, 290, 250, 25);
        a.setFont(new Font("series",Font.BOLD, 14));
        add(a);
        
        
        JLabel bp= new JLabel("package price");
        bp.setBounds(30, 325, 150, 25);
        bp.setFont(new Font("series",Font.BOLD, 14));
        add(bp);
        
        bpl= new JLabel();
        bpl.setBounds(200, 325, 150, 25);
        bpl.setFont(new Font("series",Font.BOLD, 14));
        add(bpl);
        
        JLabel hp= new JLabel("hotel price");
        hp.setBounds(30, 375, 150, 25);
        hp.setFont(new Font("series",Font.BOLD, 14));
        add(hp);
        
        hpl= new JLabel();
        hpl.setBounds(200, 375, 150, 25);
        hpl.setFont(new Font("series",Font.BOLD, 14));
        add(hpl);
        
        JLabel st= new JLabel("GST");
        st.setBounds(30, 425, 150, 25);
        st.setFont(new Font("series",Font.BOLD, 14));
        add(st);
        
        gstl= new JLabel();
        gstl.setBounds(200, 425, 150, 25);
        gstl.setFont(new Font("series",Font.BOLD, 14));
        add(gstl);
        
         JLabel l= new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        l.setBounds(30, 450, 300, 25);
        add(l);
        
         JLabel lpr= new JLabel("Total Price");
        lpr.setBounds(30, 475, 150, 25);
        lpr.setFont(new Font("series",Font.BOLD, 14));
        add(lpr);
        
        pr= new JLabel();
        pr.setBounds(200, 475, 150, 25);
        pr.setFont(new Font("series",Font.BOLD, 14));
        add(pr);
        
       
        
       
        try
        {
            Conn co = new Conn();
            ResultSet rs=co.s.executeQuery("select*from customer where username='"+username+"'");
            while(rs.next())
            {
                user.setText(rs.getString("username"));
                 n.setText(rs.getString("name"));
                id.setText(rs.getString("id"));
                no.setText(rs.getString("number"));  
                phno.setText(rs.getString("phone"));
                
                
               
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
         hpl.setText("Rs"+cost1);  
          bpl.setText("Rs"+cost);  
           gstl.setText("Rs"+total2);  
        
        
         
//          ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm2.jpeg"));
//        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(0, 0, 800, 600);
//        add(image);
//       
      

       
        
        setResizable(false);
        setVisible(true);
    }
   
    public static void main(String args[])
    {
        new receipt("");
    }    
}
