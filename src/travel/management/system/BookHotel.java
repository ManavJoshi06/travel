
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {
    Choice ch,cac,cfi,cvn;
    JTextField nd,tp;
    String username;
    JButton check,bak,bpack;
    JLabel tph,id,no,user,pr;
    
    
    BookHotel(String username)
    {
        
         this.username= username;
        setBounds(400,100,890,600);
        setLayout(null);
        getContentPane().setBackground(new Color(51, 160, 255));
        
        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(100, 10, 200, 30);
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
        
        JLabel sp= new JLabel("Select Hotel");
        sp.setBounds(30, 100, 150, 25);
        sp.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(sp);
        
        ch=new Choice();
        ch.setBounds(200, 100, 200, 40);
        add(ch);
        
        try 
        {
            Conn cn= new Conn();
            ResultSet rs =cn.s.executeQuery("select * from hotel");
            while(rs.next())
            {
                ch.add(rs.getString("name"));
            }
        }catch(Exception e){}
        
        JLabel ltp= new JLabel("Total Person");
        ltp.setBounds(30, 150, 150, 25);
        ltp.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(ltp);
        
        tp = new JTextField();
        tp.setBounds(200, 150, 150, 25);
        add(tp);
        
        JLabel lnd= new JLabel("No. of Days");
        lnd.setBounds(30, 190, 150, 25);
        lnd.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lnd);
        
        nd = new JTextField();
        nd.setBounds(200, 190, 150, 25);
        add(nd);
        
        JLabel lac= new JLabel("AC/ Non-AC");
        lac.setBounds(30, 230, 150, 25);
        lac.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lac);
        
        cac=new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(200, 230, 200, 40);
        add(cac);
        
        JLabel lfi= new JLabel("Food Included");
        lfi.setBounds(30, 270, 150, 25);
        lfi.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lfi);
        
        cfi=new Choice();
        cfi.add("No");
        cfi.add("Veg");
        cfi.add("Non-veg");
        cfi.setBounds(200, 270, 200, 40);
        add(cfi);
        
      
         
        JLabel lid= new JLabel("ID");
        lid.setBounds(30, 310, 150, 25);
        lid.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lid);
        
        id= new JLabel();
        id.setBounds(220, 310, 150, 25);
        id.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(id);
        
        JLabel lno= new JLabel("Number");
        lno.setBounds(30, 350, 150, 25);
        lno.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lno);
        
        no= new JLabel();
        no.setBounds(220, 350, 150, 25);
        no.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(no);
        
        JLabel p = new JLabel("Phone No.");
        p.setBounds(30, 390, 150, 25);
        p.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(p);
        
        tph = new JLabel();  
        tph.setBounds(200, 390, 150, 25);
        tph.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(tph);
        
        JLabel lpr= new JLabel("Total Price");
        lpr.setBounds(30, 430, 150, 25);
        lpr.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lpr);
        
        JLabel lprs= new JLabel("Rs");
        lprs.setBounds(190, 430, 150, 25);
        lprs.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lprs);
        
        pr= new JLabel();
        pr.setBounds(220, 430, 150, 25);
        pr.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(pr);
        
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
        check.setBounds(60, 490, 120, 25);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.addActionListener(this);
        add(check);
        
        bak = new JButton("Back");
        bak.setBounds(220, 490, 100, 25);
        bak.setBackground(Color.black);
        bak.setForeground(Color.white);
        bak.addActionListener(this);
        add(bak);
        
        bpack = new JButton("Book Hotel");
        bpack.setBounds(360, 490, 150, 25);
        bpack.setBackground(Color.black);
        bpack.setForeground(Color.white);
        bpack.addActionListener(this);
        add(bpack);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(410, 60, 450, 300);
        add(image);
        
        setResizable(false);
        setVisible(true);
       
       
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getSource()==check)
        {
             
            try{Conn c2 = new Conn();
            ResultSet rs=c2.s.executeQuery("select*from hotel where name='"+ch.getSelectedItem()+"'");
            while(rs.next())
            {
                int cost = Integer.parseInt(rs.getString("costperperson"));
                int food = Integer.parseInt(rs.getString("vegfood"));
                int nvfood = Integer.parseInt(rs.getString("nonvegfood"));
                int  ac= Integer.parseInt(rs.getString("acroom"));
                
                int persons = Integer.parseInt(tp.getText());
                int days = Integer.parseInt(nd.getText());
                String acselected = cac.getSelectedItem();
                String foodselected = cfi.getSelectedItem();
                
                if(persons*days>0)
                {
                    int total=0;
                    total+=acselected.equals("AC")?ac :0;
                    total+=foodselected.equals("Veg")?food:0;
                    total+=foodselected.equals("Non-Veg")?nvfood:0;
                    total+=cost;
                    total = total*persons * days;
                    pr.setText(""+total);
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "please enter a valid no.");
                }
                
            }
           }catch(Exception x){}}
        else if(ae.getSource()==bpack)
        {
         try
         {Conn c= new Conn();
            c.s.executeUpdate("insert into bookhotel values('"+user.getText()+"','"+ch.getSelectedItem()+"','"+tp.getText()+"','"+nd.getText()+"','"+cac.getSelectedItem()+"','"+cfi.getSelectedItem()+"','"+id.getText()+"','"+no.getText()+"','"+tph.getText()+"','"+pr.getText()+"')");
            
            JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
         }catch(Exception e){}
        }
        else
        {
            setVisible(false);
        }
    }
    public static void main(String args[])
    {
        new BookHotel("");
    }
   
    
}
