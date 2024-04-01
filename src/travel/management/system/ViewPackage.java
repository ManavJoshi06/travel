
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class ViewPackage extends JFrame implements ActionListener{
    JButton back;
    JLabel tph,id,no,user,pr,cp,tp;
    ViewPackage(String username)
    {
        setBounds(300, 200, 900, 450);
        setLayout(null);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/vpbook.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 450);
        add(image);
        
        
        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setBounds(60, 0, 300, 30);
        text.setForeground(Color.white);
        text.setFont(new Font("Tahoma",Font.BOLD, 20));
        image.add(text);
        
        JLabel luser = new JLabel("Username");
        luser.setBounds(30, 50, 150, 25);
        luser.setForeground(Color.white);
        luser.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(luser);
        
        user = new JLabel();
        user.setBounds(220, 50, 150, 25);
        user.setForeground(Color.white);
        user.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(user);
        
        JLabel sp= new JLabel("Package");
        sp.setBounds(30, 90, 150, 25);
        sp.setForeground(Color.white);
        sp.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(sp);
        
        cp= new JLabel();
        cp.setBounds(220, 90, 150, 25);
        cp.setForeground(Color.white);
        cp.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(cp);
        
        
        JLabel ltp= new JLabel("Total Persons");
        ltp.setBounds(30, 130, 150, 25);
        ltp.setForeground(Color.white);
        ltp.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(ltp);
        
        tp= new JLabel();
        tp.setBounds(220, 130, 150, 25);
        tp.setForeground(Color.white);
        tp.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(tp);
        
        
        JLabel lid= new JLabel("ID");
        lid.setBounds(30, 170, 150, 25);
        lid.setForeground(Color.white);
        lid.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(lid);
        
        id= new JLabel();
        id.setBounds(220, 170, 150, 25);
        id.setForeground(Color.white);
        id.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(id);
        
        JLabel lno= new JLabel("Number");
        lno.setBounds(30, 210, 150, 25);
        lno.setForeground(Color.white);
        lno.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(lno);
        
        no= new JLabel();
        no.setBounds(220, 210, 150, 25);
        no.setForeground(Color.white);
        no.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(no);
        
        JLabel p = new JLabel("Phone No.");
        p.setBounds(30, 250, 150, 25);
        p.setForeground(Color.white);
        p.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(p);
        
        tph = new JLabel();  
        tph.setBounds(220, 250, 150, 25);
        tph.setForeground(Color.white);
        tph.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(tph);
        
        JLabel lpr= new JLabel("Total Price");
        lpr.setBounds(30, 290, 150, 25);
        lpr.setForeground(Color.white);
        lpr.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(lpr);
        
        pr= new JLabel();
        pr.setForeground(Color.white);
        pr.setBounds(220, 290, 150, 25);
        pr.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(pr);
        
        back = new JButton("back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130, 360, 100, 25);
        back.addActionListener(this);
        image.add(back);
        
        
        try 
        {
            Conn c=new Conn();
            String query ="select* from bookpackage where username='"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                user.setText(rs.getString("username"));
                id.setText(rs.getString("id"));
                no.setText(rs.getString("number"));               
                tph.setText(rs.getString("phone"));
                tp.setText(rs.getString("persons"));   
                cp.setText(rs.getString("package"));
                pr.setText(rs.getString("price"));
           
                
            }
        }
        catch(Exception e){}
        
        setResizable(false);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    { 
        if(ae.getSource()==back)
        {
            setVisible(false);
        }
    }
    public static void main(String args[])
    {
        new ViewPackage("");
    }
}
