
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class ViewCustomer extends JFrame implements ActionListener{
    JButton back;
    ViewCustomer(String username)
    {
        setBounds(400, 50, 850, 625);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel luser = new JLabel("Username");
        luser.setBounds(30, 50, 150, 25);
        luser.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(luser);
        
        JLabel user = new JLabel();
        user.setBounds(220, 50, 150, 25);
        user.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(user);
        
        JLabel lid= new JLabel("ID");
        lid.setBounds(30, 110, 150, 25);
        lid.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lid);
        
        JLabel id= new JLabel();
        id.setBounds(220, 110, 150, 25);
        id.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(id);
        
        JLabel lno= new JLabel("Number");
        lno.setBounds(30, 170, 150, 25);
        lno.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lno);
        
        JLabel no= new JLabel();
        no.setBounds(220, 170, 150, 25);
        no.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(no);
        
        JLabel lname= new JLabel("Name");
        lname.setBounds(30, 230, 150, 25);
        lname.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lname);
        
        JLabel name= new JLabel();
        name.setBounds(220, 230, 150, 25);
        name.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(name);
        
        JLabel lgender= new JLabel("Gender");
        lgender.setBounds(30, 290, 150, 25);
        lgender.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lgender);
        
        JLabel gender= new JLabel();
        gender.setBounds(220, 290, 150, 25);
        gender.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(gender);
        
        JLabel lcountry = new JLabel("Country");
        lcountry.setBounds(500, 50, 150, 25);
        lcountry.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lcountry);
        
        JLabel country = new JLabel();
        country.setBounds(690, 50, 150, 25);
        country.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(country);
        
        JLabel laddress= new JLabel("Address");
        laddress.setBounds(500, 110, 150, 25);
        laddress.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(laddress);
        
        JLabel address= new JLabel();
        address.setBounds(690, 110, 150, 25);
        address.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(address);
        
        JLabel lphone= new JLabel("Phone");
        lphone.setBounds(500, 170, 150, 25);
        lphone.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lphone);
        
        JLabel phone= new JLabel();
        phone.setBounds(690, 170, 150, 25);
        phone.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(phone);
        
        JLabel lemail= new JLabel("Email");
        lemail.setBounds(500, 230, 150, 25);
        lemail.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lemail);
             
        JLabel email= new JLabel();
        email.setBounds(690, 230, 150, 25);
        email.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(email);
        
        back = new JButton("back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 350, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(120, 400, 600, 200);
        add(image);
        
        try 
        {
            Conn c=new Conn();
            String query ="select* from customer where username='"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                user.setText(rs.getString("username"));
                id.setText(rs.getString("id"));
                no.setText(rs.getString("number"));
                name.setText(rs.getString("name"));
                gender.setText(rs.getString("gender"));
                country.setText(rs.getString("country"));
                address.setText(rs.getString("address"));
                phone.setText(rs.getString("phone"));
                email.setText(rs.getString("email"));
                
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
        new ViewCustomer("");
    }
}
