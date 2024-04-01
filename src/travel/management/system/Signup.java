
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
public class Signup extends JFrame implements ActionListener{
   JButton create,bak;
   JTextField tfans,tfpass,tfuser,tfname;
   Choice secu;
    Signup()
    {
        setBounds(350, 100, 800, 500);
        
        setLayout(null);
        
     
      
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/s3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 800, 500);
        add(image);
      
        JLabel user = new JLabel("Username");
        user.setBounds(50, 20, 125, 25);
        user.setFont(new Font("Tahona",Font.BOLD, 14));
        image.add(user);
        
        tfuser= new JTextField();
        tfuser.setBounds(190, 20, 180, 25);
        tfuser.setBorder(BorderFactory.createEmptyBorder());
        image.add(tfuser);
        
        JLabel name = new JLabel("Name");
        name.setBounds(50, 80, 125, 25);
        name.setFont(new Font("Tahona",Font.BOLD, 14));
        image.add(name);
        
        tfname= new JTextField();
        tfname.setBounds(190, 80, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        image.add(tfname);
        
        
        JLabel pass= new JLabel("Password");
        pass.setBounds(50, 140, 125, 25);
        pass.setFont(new Font("Tahona",Font.BOLD, 14));
        image.add(pass);
        
        tfpass= new JTextField();
        tfpass.setBounds(190, 140, 180, 25);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        image.add(tfpass);
        
        JLabel sec = new JLabel("security question");
        sec.setBounds(50, 200, 125, 25);
        sec.setFont(new Font("Tahona",Font.BOLD, 14));
        image.add(sec);
        
        
        secu= new Choice();
        secu.setBounds(190, 200, 180, 25);
        secu.add("Favourite place");
        secu.add("Lucky no.");
        secu.add("Your friend name");
        image.add(secu);
        
        JLabel ans = new JLabel("Answer");
        ans.setBounds(50, 260, 125, 25);
        ans.setFont(new Font("Tahona",Font.BOLD, 14));
        image.add(ans);
      
        tfans= new JTextField();
        tfans.setBounds(190, 260, 180, 25);
        tfans.setBorder(BorderFactory.createEmptyBorder());
        image.add(tfans);
        
        create = new JButton("Create");
        create.setBounds(200, 330, 125, 25);
        create.addActionListener(this);
        create.setBackground(new Color(0, 0, 0));
        create.setForeground(Color.WHITE);
        create.setBorder(new LineBorder(new Color(133, 193, 233)));
        image.add(create);
        
        bak = new JButton("Back");
        bak.setBounds(200, 380, 125, 25);
        bak.setForeground(Color.white);
        bak.setBackground(new Color(0, 0, 0));
        bak.addActionListener(this);
        bak.setBorder(new LineBorder(new Color(133, 193, 233)));
        image.add(bak);
        
        
        setResizable(false);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ac)
    { if(ac.getSource() == create)
    { if(tfuser.getText().trim().isEmpty() || tfname.getText().trim().isEmpty()|| tfpass.getText().trim().isEmpty() ||tfans.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"please fill your details");
        }
     else if(tfuser.getText().trim().isEmpty())
          {
              JOptionPane.showMessageDialog(null,"please set username");
          }
     else if(tfname.getText().trim().isEmpty())
          {
              JOptionPane.showMessageDialog(null,"please fill your name");
          }
      else if(tfpass.getText().trim().isEmpty())
          {
              JOptionPane.showMessageDialog(null,"please set password");
          }
       else if(tfans.getText().trim().isEmpty())
          {
              JOptionPane.showMessageDialog(null,"please fill your answer");
          }
    else
        {
        String username = tfuser.getText();
        String name = tfname.getText();
        String Password = tfpass.getText();
        String question = secu.getSelectedItem();
        String Answer= tfans.getText();
         if (isNumeric(name)) 
         {
                JOptionPane.showMessageDialog(null, "Please enter valid name");
         } 
         else if (!isStrongPassword(Password)) {
                JOptionPane.showMessageDialog(null, "Password must contain 1 number, 1 special character, 1 uppercase , 1 lowercase letter and minimum 6 character");
            }
         else
          { try{
               String query1= "select * from account where username = '"+username+"'";
            Conn c1 =new Conn();
            ResultSet rs= c1.s.executeQuery(query1);
            if(rs.next())
              {
               JOptionPane.showMessageDialog(null,"Username not available");
              }
            else{
                String query ="insert into account values('"+username+"','"+name+"','"+Password+"','"+question+"','"+Answer+"')";
              try{ 
                   Conn c =new Conn();
                   c.s.executeUpdate(query);
            
                   JOptionPane.showMessageDialog(null,"Account Created Successfully");
                   setVisible(false);
                   new Login();
        }
        catch(Exception e){}
         }}catch(Exception e){}
          }}}
    else if(ac.getSource() == bak)
     {
         setVisible(false);
         new Login();
     }
    }
    private boolean isNumeric(String str) 
    {
    return str.matches("\\d+");
    }
    
    private boolean isStrongPassword(String str)
    {
    return str.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{6,}$");
    }

    public static void main(String args[])
    {
          new Signup();
    }
}
