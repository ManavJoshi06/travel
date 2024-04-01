
package travel.management.system;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Dashboard extends JFrame implements ActionListener{
    JPanel p1,p2;
    JMenuItem pd,upd,vpd,dpd,cpd,bpd,vh,bh,d,p,c,n,a,vp,vbh;
    JMenu pr,pk,h,o;
    JLabel header;
    String username;
    Dashboard(String username)
    {
        this.username = username;
    
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setLayout(null);
    
    
   JMenuBar mb = new JMenuBar();
   mb.setBackground(Color.white);
   mb.setBounds(0, 0, 1600, 30);
   mb.setLayout(null);
   setJMenuBar(mb);
   
    o = new JMenu(" ");      
    mb.add(o);
       
   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/file.png"));
    Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(5,0, 10, 10);
    mb.add(image);
    
    
    
   
       pr = new JMenu("Profiles    ");
       pr.setForeground(Color.black);
       pr.setFont(new Font("Tahona",Font.BOLD, 30));
       mb.add(pr);
    
       
       ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/dash2.jpg"));
    Image i5 = i4.getImage().getScaledInstance(1300, 630, Image.SCALE_DEFAULT);
    ImageIcon i6 = new ImageIcon(i5);
    JLabel image2 = new JLabel(i6);
    image2.setBounds(0,0, 1300, 630);
    add(image2);
    
       pd = new JMenuItem("Add Personal Details");
       pd.setBackground(new Color(0, 0, 102));
       pd.setBounds(0, 500, 300, 50);
       pd.setFont(new Font("Tahoma",Font.PLAIN, 20));
       pd.setBorder(new LineBorder(new Color(133, 193, 233)));
       pd.setForeground(Color.white);
       pd.addActionListener(this);
       pr.add(pd);
       
       upd = new JMenuItem("Update Personal Details");
       upd.setBounds(0, 400, 300, 50);
       upd.setBackground(new Color(0, 0, 102));
       upd.addActionListener(this);
       upd.setForeground(Color.white);
       upd.setBorder(new LineBorder(new Color(133, 193, 233)));
       upd.setBackground(new Color(0, 0, 102));
       upd.setFont(new Font("Tahoma",Font.PLAIN, 20));
       pr.add(upd);
       
       vpd = new JMenuItem("View Details");
       vpd.addActionListener(this);
       vpd.setForeground(Color.white);
       vpd.setBorder(new LineBorder(new Color(133, 193, 233)));
       vpd.setBackground(new Color(0, 0, 102));       
       vpd.setFont(new Font("Tahoma",Font.PLAIN, 20));
       pr.add(vpd);
        
        /*dpd = new JMenuItem("Delete Personal Details");
        dpd.addActionListener(this);
        dpd.setForeground(Color.white);
        dpd.setBackground(new Color(0, 0, 102));
        dpd.setBorder(new LineBorder(new Color(133, 193, 233)));
        dpd.setFont(new Font("Tahoma",Font.PLAIN, 20));
        pr.add(dpd);*/
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/package.png"));
        Image i8 = i7.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image3 = new JLabel(i9);
        mb.add(image3);
    
       pk = new JMenu("   Packages     ");
       pk.setForeground(Color.black);
       pk.setFont(new Font("Tahona",Font.BOLD, 30));
       mb.add(pk);
    
        cpd = new JMenuItem("Check Packages");       
        cpd.addActionListener(this);
        cpd.setForeground(Color.white);
        cpd.setBackground(new Color(0, 0, 102));   
        cpd.setBorder(new LineBorder(new Color(133, 193, 233)));
        cpd.setFont(new Font("Tahoma",Font.PLAIN, 20));
        pk.add(cpd);
   
        bpd = new JMenuItem("Book Package");
        bpd.setBounds(0, 200, 300, 50);
        bpd.addActionListener(this);
        bpd.setForeground(Color.white);
        bpd.setBackground(new Color(0, 0, 102));
        bpd.setBorder(new LineBorder(new Color(133, 193, 233)));
        bpd.setFont(new Font("Tahoma",Font.PLAIN, 20));
        pk.add(bpd);
    
        vp = new JMenuItem("View Book Package");
        vp.addActionListener(this);
        vp.setForeground(Color.white);
        vp.setBackground(new Color(0, 0, 102));
        vp.setBorder(new LineBorder(new Color(133, 193, 233)));
        vp.setFont(new Font("Tahoma",Font.PLAIN, 20));
        pk.add(vp);
        
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/review.png"));
        Image i11 = i10.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel image4 = new JLabel(i12);
        mb.add(image4);
     
       h = new JMenu("   Hotels     ");
       h.setForeground(Color.black);
       h.setFont(new Font("Tahona",Font.BOLD, 30));
       mb.add(h);
       
        vh = new JMenuItem("View Hotels");
        vh.addActionListener(this);
        vh.setForeground(Color.white);
        vh.setBackground(new Color(0, 0, 102));
        vh.setBorder(new LineBorder(new Color(133, 193, 233)));
        vh.setFont(new Font("Tahoma",Font.PLAIN, 20));
        h.add(vh);
        
         bh = new JMenuItem("Book Hotel");
        bh.addActionListener(this);
        bh.setForeground(Color.white);
        bh.setBackground(new Color(0, 0, 102));
        bh.setBorder(new LineBorder(new Color(133, 193, 233)));
        bh.setFont(new Font("Tahoma",Font.PLAIN, 20));
        h.add(bh);
        
        vbh= new JMenuItem("View Book Hotel");
        vbh.addActionListener(this);
        vbh.setForeground(Color.white);
        vbh.setBackground(new Color(0, 0, 102));
        vbh.setBorder(new LineBorder(new Color(133, 193, 233)));
        vbh.setFont(new Font("Tahoma",Font.PLAIN, 20));
        h.add(vbh);
        
        
      ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/worldwide.png"));
      Image i14 = i13.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
      ImageIcon i15 = new ImageIcon(i14);
      JLabel image5 = new JLabel(i15);
      mb.add(image5);
      
      image5.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent e)
            {
                 new  Destination();
                 
            }});
      
      
      o = new JMenu("    ");
       o.setForeground(Color.black);
       o.setFont(new Font("Tahona",Font.BOLD, 30));
       mb.add(o);
      
     ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("icons/payment.png"));
      Image i17 = i16.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
      ImageIcon i18 = new ImageIcon(i17);
      JLabel image6 = new JLabel(i18);
      mb.add(image6);
      
      image6.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent e)
            {
                 new  Payments(username);
                 
            }});
      
      
       o = new JMenu("              ");
       mb.add(o);
      ImageIcon i19 = new ImageIcon(ClassLoader.getSystemResource("icons/exit.png"));
      Image i20 = i19.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
      ImageIcon i21 = new ImageIcon(i20);
      JLabel image7 = new JLabel(i21);
      mb.add(image7);
      
      image7.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent e)
            {
                 new Login();
                 setVisible(false);
            }});
      
      o = new JMenu("              ");
       mb.add(o);
      ImageIcon i22 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
      Image i23 = i22.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
      ImageIcon i24 = new ImageIcon(i23);
      JLabel image8 = new JLabel(i24);
      mb.add(image8);
      
      image8.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent e)
            {
                new  DeleteDetails(username);
            }});
     
        
    setResizable(false);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ac)
    {
        if(ac.getSource()==pd)
        {
            new AddCustomer(username);
        }
        else if(ac.getSource()==vpd)
        {
            new ViewCustomer(username);
        }
        else if(ac.getSource()==upd)
        {
           new UpdateCustomer(username);
        }
        else if(ac.getSource()==cpd)
        {
           new CheckPackage();
        }
         else if(ac.getSource()==bpd)
        {
           new BookPackage(username);
        }
        else if(ac.getSource()==vp)
        {
           new ViewPackage(username);
        }
         else if(ac.getSource()==vh)
        {
            new  CheckHotels();
        }
        else if(ac.getSource()==d)
        {
            new  Destination();
        }
        else if(ac.getSource()==bh)
        {
            new  BookHotel(username);
        }
        else if(ac.getSource()==vbh)
        {
            new  ViewBookedHotel(username);
        }
        else if(ac.getSource()==p)
        {
            new  Payments(username);
        }
         else if(ac.getSource()==c)
        {
            setVisible(false);
        }
        
        else if(ac.getSource()==dpd)
        {
            new  DeleteDetails(username);
        }
    }
    public static void main(String arge[])
    {
        new Dashboard(""); 
    } 
    
}
