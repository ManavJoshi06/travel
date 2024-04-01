package travel.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.regex.*;
public class AddCustomer extends JFrame implements ActionListener {
   JLabel user,lname;
   JComboBox cid;
   JTextField tc,idno,tad,te,tp;
   JRadioButton GM,GF;
   JButton bak,add;
    AddCustomer(String username)
    {
        setBounds(400, 100, 850, 550);
        setLayout(null);
        getContentPane().setBackground(new Color(255,255,140));
        
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
        
        
        cid= new JComboBox(new String[]{"Passport","Aadhar Card","Pan Card","Ration Card"});
        cid.setBounds(220, 90, 150, 25);
        cid.setBackground(Color.white);
        add(cid);
        
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
        
        GM=new JRadioButton("Male");
        GM.setBounds(220, 210, 70, 25);
        GM.setBackground(Color.white);
        add(GM);
        
        GF=new JRadioButton("Female");
        GF.setBounds(300, 210, 70, 25);
        GF.setBackground(Color.white);
        add(GF);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(GM);
        bg.add(GF);
        
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
        
        add = new JButton("Add");
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
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/addc.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);
        
        try
        {
            Conn co = new Conn();
            ResultSet rs=co.s.executeQuery("select*from account where username='"+username+"'");
            while(rs.next())
            {
                user.setText(rs.getString("username"));
                lname.setText(rs.getString("name"));
            }
        }
        catch (Exception E){}
        
        
        setResizable(false);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {  if(idno.getText().trim().isEmpty()&&tc.getText().trim().isEmpty()&&tad.getText().trim().isEmpty()&&tp.getText().trim().isEmpty()&&te.getText().trim().isEmpty())
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
       else if(te.getText().trim().isEmpty())
          {
              JOptionPane.showMessageDialog(null,"please enter your email");
          }
       else if(tp.getText().trim().isEmpty())
          {
              JOptionPane.showMessageDialog(null,"please enter your phone no.");
          }
       
        else
       {   String id =(String) cid.getSelectedItem();
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
          //  String id =(String) cid.getSelectedItem();
           // String number = idno.getText();
            String name = lname.getText();
            String gender= null;
            if(GM.isSelected())
            {
                gender = "Male";
            }
            else
            {
                gender = "Female";
            }
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
            
            }
            else
            {
            try
            {
                Conn co = new Conn();
                String query = "insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
                co.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Details Added Succesfully");
                setVisible(false);
            }
            catch(Exception E){}
             }
        }}
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
        String emailRegex = "^[a-z0-9+_.-]+@(.+\\.com)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static void main(String args[])
    {
        new AddCustomer("mj");
    }
}
