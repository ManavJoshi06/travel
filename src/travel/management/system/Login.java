
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
public class Login extends JFrame implements ActionListener {
    JButton login,signup,password;
    JTextField tfuser;
    JPasswordField tfpass;
    Login()
    { 
        setSize(900, 400);
        setLocation(200, 200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
      /*  
        JLabel log = new JLabel("LOGIN");
        log.setBounds(170, 22, 100, 30);
        log.setFont(new Font("ROMAN_BASELINE",Font.BOLD, 30));
        p1.add(log);*/
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/log.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 900, 400);
        add(image);
        
      
        JLabel user = new JLabel("Username");
        user.setBounds(300, 20, 100, 25);
        user.setFont(new Font("SAN SERIF",Font.PLAIN, 20));
        image.add(user);
        
        tfuser= new JTextField();
        tfuser.setBounds(300, 60, 300, 30);
        tfuser.setBorder(BorderFactory.createEmptyBorder());
        image.add(tfuser);
        
        JLabel pass = new JLabel("Password");
      
        pass.setBounds(300, 110, 100, 25);
        pass.setFont(new Font("SAN SERIF",Font.PLAIN, 20));
        image.add(pass);
        
        tfpass= new JPasswordField();
        tfpass.setBounds(300, 150, 300, 30);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        image.add(tfpass);
        
        login = new JButton("Login");
        login.setBounds(300, 200, 130, 30);
        login.setBackground(new Color(0, 0, 0));
        login.getKeyListeners();
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        image.add(login);
        
        signup = new JButton("Signup");
        signup.setBounds(470, 200, 130, 30);
        signup.setBackground(new Color(0,0,0));
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        image.add(signup);
                
        password= new JButton("Forget Password");
        password.setBounds(370, 250, 130, 30);
        password.setBackground(new Color(0, 0, 0));
        password.setForeground(Color.WHITE);
        password.addActionListener(this);
        password.setBorder(new LineBorder(new Color(133, 193, 233)));
        image.add(password);
        
        JLabel text =new JLabel("Trouble in login...");
        text.setBounds(540, 250, 150, 20);
        text.setForeground(Color.red);
        image.add(text);
        
        setResizable(false);
        setVisible(true); 
    }
    public void actionPerformed(ActionEvent ac)
    
    { if(ac.getSource() ==login)
      {  try
        { 
            String username = tfuser.getText();
            String password = tfpass.getText();
            
            if (!isStrongPassword(password)) {
                JOptionPane.showMessageDialog(null, "please enter correct pasaword");
            }
            else{
            String query= "select * from account where username = '"+username+"'AND password = '"+password+"'";
            Conn c =new Conn();
            ResultSet rs= c.s.executeQuery(query);
            if(rs.next())
              {
               setVisible(false);
               new Loading(username);
              }
            else
              { 
                  
                  JOptionPane.showMessageDialog(null, "Incorrect username or password");
              }
        }}catch(Exception e){}
      }
      else if(ac.getSource() == signup)
      {   
         setVisible(false);
         new Signup();
      }
      else 
      {
         setVisible(false);
         new ForgetPassword();
      }
    }
    
     private boolean isStrongPassword(String str)
    {
    return str.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{6,}$");
    }
     
    public static void main(String args[])
    {
        Login l = new Login();
    }
    
}
