package travel.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.*;
import javax.swing.*;
public class UpdateCustomer extends JFrame implements ActionListener {
   JLabel user,lname;
   JComboBox cid;
   JTextField tc,idno,tad,te,tp,ge,id2;
   JButton bak,add;
   
    UpdateCustomer(String username)
    {
        setBounds(400, 100, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50, 0, 300, 25);
        text.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(text);
        
        JLabel luser = new JLabel("Username");
        luser.setBounds(30, 50, 150, 25);
        luser.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(luser);
        
        user = new JLabel();
        user.setBounds(220, 50, 150, 25);
        user.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(user);
        
        JLabel id = new JLabel("Id");
        id.setBounds(30, 90, 150, 25);
        id.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(id);
        
        
        id2 = new JTextField();  
        id2.setBounds(220, 90, 150, 25);
        add(id2);
        
        
        JLabel idn = new JLabel("ID Number");
        idn.setBounds(30, 130, 150, 25);
        idn.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(idn);
        
        idno = new JTextField();  
        idno.setBounds(220, 130, 150, 25);
        add(idno);
        
        JLabel name = new JLabel("Name");
        name.setBounds(30, 170, 150, 25);
        name.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(name);
        
        lname = new JLabel();
        lname.setBounds(220, 170, 150, 25);
        lname.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lname);
        
        JLabel g = new JLabel("Gender");
        g.setBounds(30, 210, 150, 25);
        g.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(g);
        
        ge = new JTextField();  
        ge.setBounds(220, 210, 150, 25);
        add(ge);
        
        JLabel c = new JLabel("Country");
        c.setBounds(30, 250, 150, 25);
        c.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(c);
        
        tc = new JTextField();  
        tc.setBounds(220, 250, 150, 25);
        add(tc);
        
        JLabel ad = new JLabel("Address");
        ad.setBounds(30, 290, 150, 25);
        ad.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(ad);
        
        tad = new JTextField();  
        tad.setBounds(220, 290, 150, 25);
        add(tad);
        
        JLabel e = new JLabel("Email ID");
        e.setBounds(30, 330, 150, 25);
        e.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(e);
        
        te = new JTextField();  
        te.setBounds(220, 330, 150, 25);
        add(te);
        
        JLabel p = new JLabel("Phone No.");
        p.setBounds(30, 370, 150, 25);
        p.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(p);
        
        tp = new JTextField();  
        tp.setBounds(220, 370, 150, 25);
        add(tp);
        
        add = new JButton("Update");
        add.setBounds(70, 430, 100, 25);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);
        
        bak = new JButton("Back");
        bak.setBounds(220, 430, 100, 25);
        bak.setBackground(Color.black);
        bak.setForeground(Color.white);
        bak.addActionListener(this);
        add(bak);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/u.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 450, 400);
        add(image);
        
        try
        {
            Conn co = new Conn();
            ResultSet rs=co.s.executeQuery("select*from customer where username='"+username+"'");
            while(rs.next())
            {
                user.setText(rs.getString("username"));
                lname.setText(rs.getString("name"));
                id2.setText(rs.getString("id"));
                idno.setText(rs.getString("number"));
                ge.setText(rs.getString("gender"));
                te.setText(rs.getString("email"));
                tp.setText(rs.getString("phone"));
                tad.setText(rs.getString("address"));
                tc.setText(rs.getString("country"));
            }
        }
        catch (Exception E){}
        
        
        setResizable(false);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        { 
           /* String username = user.getText();
            String id = id2.getText();
            String number = idno.getText();
            String name = lname.getText();
            String gender= ge.getText();
            String country = tc.getText();
            String address = tad.getText();
            String phone = tp.getText();
            String email = te.getText();*/
            if(idno.getText().trim().isEmpty()&&tc.getText().trim().isEmpty()&&tad.getText().trim().isEmpty()&&tp.getText().trim().isEmpty()&&te.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"please fill your details");
        }
    else if(idno.getText().trim().isEmpty())
          {
              JOptionPane.showMessageDialog(null,"please enter id no.");
          }
     else if(tc.getText().trim().isEmpty())
          {
              JOptionPane.showMessageDialog(null,"please enter country");
          }
      else if(tad.getText().trim().isEmpty())
          {
              JOptionPane.showMessageDialog(null,"please enter address");
          }
      else if(ge.getText().trim().isEmpty())
          {
              JOptionPane.showMessageDialog(null,"please enter gender");
          }
       else if(te.getText().trim().isEmpty())
          {
              JOptionPane.showMessageDialog(null,"please enter your email");
          }
       else if(tp.getText().trim().isEmpty())
          {
              JOptionPane.showMessageDialog(null,"please enter your phone no.");
          }
       
        else
       {   String id = id2.getText();
            String number = idno.getText();
           boolean isValidIdNumber = false;
            
            
            if ("Passport".equals(id)) {
                isValidIdNumber = isValidPassportNumber(number);
            } else if ("Aadhar Card".equals(id)) {
                isValidIdNumber = isValidAadharCardNumber(number);
            } else if ("Pan Card".equals(id)) {
                isValidIdNumber = isValidPanCardNumber(number);
            } else if ("Ration Card".equals(id)) {
                isValidIdNumber = isValidRationCardNumber(number);
            }

            
            
            String username = user.getText();
         
           
            String name = lname.getText();
            String gender= ge.getText();
            String country = tc.getText();
            String address = tad.getText();
            String phone = tp.getText();
            String email = te.getText();
            if (!isValidEmail(email)) 
            {
                    JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
            }
            else if (!isValidPhoneNumber(phone)) 
            {
               JOptionPane.showMessageDialog(null, "Please enter a valid phone number.");
            }
            if (!isValidIdNumber) 
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid " + id + " number.");
            
            }else{
                try{
                
            try
            {
                Conn co = new Conn();
                String query = "update customer set id = '"+id+"', number ='"+number+"', name = '"+name+"', gender = '"+gender+"', country ='"+country+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"' where username = '"+username+"'";
                co.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Details Updated Succesfully");
                setVisible(false);
            }
            catch(Exception E){}
        }catch(Exception E){}}}}
        else
        {
            setVisible(false);
            
                }
    }
    
     private boolean isValidRationCardNumber(String rationCardNumber) 
    {
    String rationCardRegex = "^[0-9]{12}$";
    return rationCardNumber.matches(rationCardRegex);
    }
    private boolean isValidPassportNumber(String passportNumber) 
    {
    String passportRegex = "^[A-Z]\\d{7}$";
    return passportNumber.matches(passportRegex);
    }
    
    private boolean isValidPanCardNumber(String panCardNumber)
    {
    String panCardRegex = "^[A-Z]{5}\\d{4}[A-Z]$";
    return panCardNumber.matches(panCardRegex);
    }
    
    private boolean isValidAadharCardNumber(String aadharCardNumber)
    {
    
    String aadharCardRegex = "^[0-9]{12}$";
    return aadharCardNumber.matches(aadharCardRegex);
    }
    private boolean isValidPhoneNumber(String phone) 
    {
     String phoneRegex = "^[0-9]{10}$";
     return phone.matches(phoneRegex);
    }
    
    private boolean isValidEmail(String email) 
    {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+\\.com)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static void main(String args[])
    {
        new UpdateCustomer("");
    }
}
