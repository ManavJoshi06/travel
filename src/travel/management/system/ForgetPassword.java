
package travel.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.*;
import java.awt.event.*;
public class ForgetPassword extends JFrame implements ActionListener {
    JTextField tfuser,tfname,tfpass,tfans,tfpas;
    JButton search,retrieve,bak;
    ForgetPassword()
    { setBounds(350, 200, 850, 380);
      getContentPane().setBackground(Color.white);
      setLayout(null);
      
        JPanel p1 = new JPanel();
       // p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(30, 30, 500, 280);
        p1.setLayout(null);
        add(p1);
        
        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 25);
        user.setFont(new Font("Tahoma",Font.BOLD, 14));
        p1.add(user);
        
        tfuser= new JTextField();
        tfuser.setBounds(220, 20, 150, 25);
        tfuser.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfuser);
        
        search = new JButton("Search");
        search.setBounds(380, 20, 100, 25);
        search.addActionListener(this);
        search.setForeground(Color.blue);
        search.setBorder(new LineBorder(new Color(133, 193, 233)));
        p1.add(search);
        
        JLabel name = new JLabel("Name");
        name.setBounds(40, 60, 125, 25);
        name.setFont(new Font("Tahoma",Font.BOLD, 14));
        p1.add(name);
        
        tfname= new JTextField();
        tfname.setBounds(220, 60, 150, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel pass = new JLabel("Security Question");
        pass.setBounds(40, 100, 150, 25);
        pass.setFont(new Font("Tahoma",Font.BOLD, 14));
        p1.add(pass);
        
        tfpass= new JTextField();
        tfpass.setBounds(220, 100, 150, 30);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpass);
        
        JLabel ans = new JLabel("Answer");
        ans.setBounds(40, 140, 150, 25);
        ans.setFont(new Font("Tahona",Font.BOLD, 14));
        p1.add(ans);
      
        tfans= new JTextField();
        tfans.setBounds(220, 140, 150, 25);
        tfans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfans);
        
        retrieve = new JButton("Retrieve");
        retrieve.setBounds(380, 140, 100, 25);
        retrieve.addActionListener(this);
        retrieve.setForeground(Color.blue);
        retrieve.setBorder(new LineBorder(new Color(133, 193, 233)));
        p1.add(retrieve);
        
        JLabel pas= new JLabel("Password");
        pas.setBounds(40, 180, 150, 25);
        pas.setFont(new Font("Tahona",Font.BOLD, 14));
        p1.add(pas);
      
        tfpas= new JTextField();
        tfpas.setBounds(220, 180, 150, 25);
        tfpas.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpas);
        
        bak = new JButton("Back");
        bak.setBounds(150, 230, 100, 25);
        bak.setForeground(Color.blue);
        bak.addActionListener(this);
        bak.setBorder(new LineBorder(new Color(133, 193, 233)));
        p1.add(bak);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70, 200, 200);
        add(image);
        
        setResizable(false);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ac)
    
    { if(ac.getSource() ==search)
     {  try{
         String query= "select * from account where username = '"+tfuser.getText()+"'";
         Conn c = new Conn();
         
         ResultSet rs= c.s.executeQuery(query);
         if(!rs.next())
         {
              JOptionPane.showMessageDialog(null, "username not found");
         }
         else
         {           
                tfname.setText(rs.getString("name"));
                tfpass.setText(rs.getString("security"));
         }
          }
       catch(Exception e){}
     }
    else if(ac.getSource() == retrieve)
     {
         try{
         String query= "select * from account where answer = '"+tfans.getText()+"'AND username = '"+tfuser.getText()+"'";
         Conn c = new Conn();
         
         ResultSet rs= c.s.executeQuery(query);
         if(!rs.next())
         {
             JOptionPane.showMessageDialog(null, "Please enter correct answer");
         }
         else
         {            
                tfpas.setText(rs.getString("password"));                  
         }
          }
       catch(Exception e){}
     }
      else 
      {
         setVisible(false);
         new Login();
     }
    }
    
    
public static void main(String args[])
    {
        new ForgetPassword();
    }
}

