
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener {
    Choice cp;
    JTextField tp;
    String username;
    JButton check,bak,bpack;
    JLabel tph,id,no,user,pr;
    
    BookPackage(String username)
    {
         this.username= username;
        setBounds(300,100,890,490);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(890, 490, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 890, 490);
        add(image);
        
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(600, 10, 200, 30);
        text.setFont(new Font("raleway",Font.BOLD, 20));
        image.add(text);
        
        JLabel luser = new JLabel("Username");
        luser.setBounds(500, 50, 150, 25);
        luser.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(luser);
        
        user = new JLabel();
        user.setBounds(690, 50, 150, 25);
        user.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(user);
        
        JLabel sp= new JLabel("Select Package");
        sp.setBounds(500, 100, 150, 25);
        sp.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(sp);
        
        cp=new Choice();
        cp.add("Mumbai Darshan");
        cp.add("Kokan Darshan");
        cp.add("Fort Trekking ");
        cp.add("Nashik ");
        cp.add("Lonavla Package");
        cp.add("Ashtavinayk Darshan");
        cp.setBounds(670, 100, 200, 40);
        image.add(cp);
        
        JLabel ltp= new JLabel("Total Person");
        ltp.setBounds(500, 150, 150, 25);
        ltp.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(ltp);
        
        tp = new JTextField();
        tp.setBounds(670, 150, 150, 25);
        image.add(tp);
        
        JLabel lid= new JLabel("ID");
        lid.setBounds(500, 200, 150, 25);
        lid.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(lid);
        
        id= new JLabel();
        id.setBounds(690, 200, 150, 25);
        id.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(id);
        
        JLabel lno= new JLabel("Number");
        lno.setBounds(500, 250, 150, 25);
        lno.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(lno);
        
        no= new JLabel();
        no.setBounds(690, 250, 150, 25);
        no.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(no);
        
        JLabel p = new JLabel("Phone No.");
        p.setBounds(500, 300, 150, 25);
        p.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(p);
        
        tph = new JLabel();  
        tph.setBounds(690, 300, 150, 25);
        tph.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(tph);
        
        JLabel lpr= new JLabel("Total Price");
        lpr.setBounds(500, 350, 150, 25);
        lpr.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(lpr);
        
         JLabel lprs= new JLabel("Rs");
        lprs.setBounds(660, 350, 150, 25);
        lprs.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(lprs);
        
        pr= new JLabel();
        pr.setBounds(690, 350, 150, 25);
        pr.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(pr);
        
         try
        {
            Conn co = new Conn();
            ResultSet rs=co.s.executeQuery("select*from customer where username='"+username+"'");
            while(rs.next())
            {
                user.setText(rs.getString("username"));
                
                id.setText(rs.getString("id"));
                no.setText(rs.getString("number"));               
                tph.setText(rs.getString("phone"));
                
            }
        }
        catch (Exception E){}
         
        check = new JButton("Check Price");
        check.setBounds(400, 400, 120, 25);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.addActionListener(this);
        image.add(check);
        
        bak = new JButton("Back");
        bak.setBounds(750, 400, 100, 25);
        bak.setBackground(Color.black);
        bak.setForeground(Color.white);
        bak.addActionListener(this);
        image.add(bak);
        
        bpack = new JButton("Book Package");
        bpack.setBounds(550, 400, 150, 25);
        bpack.setBackground(Color.black);
        bpack.setForeground(Color.white);
        bpack.addActionListener(this);
        image.add(bpack);

        
        setResizable(false);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==check)
        {if(tp.getText().trim().isEmpty())
          {
              JOptionPane.showMessageDialog(null,"please enter  no. of persons");
          }else{
            String pack = cp.getSelectedItem();
            int cost =0;
            if(pack.equals("Mumbai Darshan"))
            {
                cost+=2500;
            }
            else if(pack.equals("Kokan Darshan"))
            {
                cost+=1500;
            } 
             else if(pack.equals("Fort Trekking"))
            {
                cost+=2000;
            } 
             else if(pack.equals("Nashik"))
            {
                cost+=1600;
            } 
            else if(pack.equals("Lonavla Package"))
            {
                cost+=1800;
            } 
            else
            {
                cost+=1500;
            }
            int persons = Integer.parseInt(tp.getText());
            
            cost*=persons;
            pr.setText(""+cost);
        }}
        else if(ae.getSource()==bpack)
        {
         try
         {Conn c= new Conn();
            c.s.executeUpdate("insert into bookpackage values('"+user.getText()+"','"+cp.getSelectedItem()+"','"+tp.getText()+"','"+id.getText()+"','"+no.getText()+"','"+tph.getText()+"','"+pr.getText()+"')");
            
            JOptionPane.showMessageDialog(null,"Pakage Booked Successfully");
         }catch(Exception e){}
        }
        else
        {
            setVisible(false);
        }
    }
    public static void main(String args[])
    {
        new BookPackage("");
        
    }
   
    
}
