
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class ViewBookedHotel extends JFrame implements ActionListener{
    JButton back;
    JLabel tph,id,no,user,pr,cp,tp,days,ac,fi;
    ViewBookedHotel(String username)
    {
        setBounds(250, 100, 900, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/vboo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 550);
        add(image);
        
        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setBounds(500, 0, 400, 30);
        text.setFont(new Font("Tahoma",Font.BOLD, 20));
        image.add(text);
        
        JLabel luser = new JLabel("Username");
        luser.setBounds(440, 50, 150, 25);
        luser.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(luser);
        
        user = new JLabel();
        user.setBounds(610, 50, 150, 25);
        user.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(user);
        
        JLabel sp= new JLabel("Hotel Name");
        sp.setBounds(440, 90, 150, 25);
        sp.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(sp);
        
        cp= new JLabel();
        cp.setBounds(610, 90, 150, 25);
        cp.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(cp);
        
        
        JLabel ltp= new JLabel("Total Persons");
        ltp.setBounds(440, 130, 150, 25);
        ltp.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(ltp);
        
        tp= new JLabel();
        tp.setBounds(610, 130, 150, 25);
        tp.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(tp);
        
        JLabel ldays= new JLabel("Total Days");
        ldays.setBounds(440, 170, 150, 25);
        ldays.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(ldays);
        
        days= new JLabel();
        days.setBounds(610, 170, 150, 25);
        days.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(days);
        
        JLabel lac= new JLabel("AC/Non-AC");
        lac.setBounds(440, 210, 150, 25);
        lac.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(lac);
        
        ac= new JLabel();
        ac.setBounds(610, 210, 150, 25);
        ac.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(ac);
        
        JLabel lfi= new JLabel("Food Included");
        lfi.setBounds(440, 250, 150, 25);
        lfi.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(lfi);
        
        fi= new JLabel();
        fi.setBounds(610, 250, 150, 25);
        fi.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(fi);
        
        JLabel lid= new JLabel("ID");
        lid.setBounds(440, 290, 150, 25);
        lid.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(lid);
        
        id= new JLabel();
        id.setBounds(610, 290, 150, 25);
        id.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(id);
        
        JLabel lno= new JLabel("Number");
        lno.setBounds(440, 330, 150, 25);
        lno.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(lno);
        
        no= new JLabel();
        no.setBounds(610, 330, 150, 25);
        no.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(no);
        
        JLabel p = new JLabel("Phone No.");
        p.setBounds(440, 370, 150, 25);
        p.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(p);
        
        tph = new JLabel();  
        tph.setBounds(610, 370, 150, 25);
        tph.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(tph);
        
        JLabel lpr= new JLabel("Total Cost");
        lpr.setBounds(440, 410, 150, 25);
        lpr.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(lpr);
        
        pr= new JLabel();
        pr.setBounds(610, 410, 150, 25);
        pr.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(pr);
        
        back = new JButton("back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(610, 460, 100, 25);
        back.addActionListener(this);
        image.add(back);
        
        
        
        try 
        {
            Conn c=new Conn();
            String query ="select* from bookhotel where username='"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                user.setText(rs.getString("username"));
                id.setText(rs.getString("id"));
                no.setText(rs.getString("number"));               
                tph.setText(rs.getString("phone"));
                tp.setText(rs.getString("persons"));   
                cp.setText(rs.getString("name"));
                pr.setText(rs.getString("price"));
                days.setText(rs.getString("days"));
                ac.setText(rs.getString("ac"));
                fi.setText(rs.getString("food"));
           
                
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
        new ViewBookedHotel("mj");
    }
}
