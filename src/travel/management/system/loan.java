
package travel.management.system;

import java.awt.*;

import javax.swing.*;

public class loan extends JFrame{
     JLabel user,lname;
   JComboBox cid;
   JTextField tc,idno,tad,te,tp,ge,id2;
   JButton bak,add;
    loan()
    {
        setBounds(400, 100, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel(" EMI PAY CUSTOMER DETAILS");
        text.setBounds(150, 0, 350, 25);
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
        
        JLabel id = new JLabel("Pancard NO.");
        id.setBounds(30, 90, 150, 25);
        id.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(id);
        
        
        id2 = new JTextField();  
        id2.setBounds(220, 90, 150, 25);
        add(id2);
        
        
        JLabel idn = new JLabel("Salary");
        idn.setBounds(30, 130, 150, 25);
        idn.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(idn);
        
        idno = new JTextField();  
        idno.setBounds(220, 130, 150, 25);
        add(idno);
        
        JLabel name = new JLabel("Occupation");
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
        
        add = new JButton("Submit");
        add.setBounds(70, 430, 100, 25);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
     //   add.addActionListener(this);
        add(add);
        
        bak = new JButton("Back");
        bak.setBounds(220, 430, 100, 25);
        bak.setBackground(Color.black);
        bak.setForeground(Color.white);
     //   bak.addActionListener(this);
        add(bak);
        
        setVisible (true);
    }
    public static void main(String args[])
    {
        new loan();
          
    }
    
    
}
