package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class CheckPackage extends JFrame implements ActionListener{
    
    
     JButton A,M,N,K,F,L;
    CheckPackage ()
    {       setBounds(400,90,890,600);
    
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/checkpakage.jpg"));
    Image i2 = i1.getImage().getScaledInstance(890, 600, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(5,0, 890, 600);
    add(image);
    
     ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/ganesh3.jpg"));
    Image i5 = i4.getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT);
    ImageIcon i6 = new ImageIcon(i5);
    JLabel image1 = new JLabel(i6);
    image1.setBounds(100,120, 125, 125);
    image.add(image1);
    
    ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/mumbai.jpg"));
    Image i8 = i7.getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT);
    ImageIcon i9 = new ImageIcon(i8);
    JLabel image2 = new JLabel(i9);
    image2.setBounds(380,120, 125, 125);
    image.add(image2);
    
    ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/nashik.jpg"));
    Image i11 = i10.getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT);
    ImageIcon i12 = new ImageIcon(i11);
    JLabel image3 = new JLabel(i12);
    image3.setBounds(660,120, 125, 125);
    image.add(image3);
    
    ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/kokan.jpg"));
    Image i14 = i13.getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT);
    ImageIcon i15 = new ImageIcon(i14);
    JLabel image4 = new JLabel(i15);
    image4.setBounds(100,370, 125, 125);
    image.add(image4);
    
    ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("icons/fort.jpg"));
    Image i17 = i16.getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT);
    ImageIcon i18 = new ImageIcon(i17);
    JLabel image5 = new JLabel(i18);
    image5.setBounds(380,370, 125, 125);
    image.add(image5);
    
    ImageIcon i19 = new ImageIcon(ClassLoader.getSystemResource("icons/lonavala.jpg"));
    Image i20 = i19.getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT);
    ImageIcon i21 = new ImageIcon(i20);
    JLabel image6 = new JLabel(i21);
    image6.setBounds(660,370, 125, 125);
    image.add(image6);
    
        A = new JButton("ASHTAVINAYK");
        A.setBounds(100, 250, 125, 30);
        A.setForeground(Color.white);
        A.setBackground(new Color(0, 0, 0));
        A.addActionListener(this);
        A.setFocusable(false);
        A.setBorder(new LineBorder(new Color(133, 193, 233)));
        image.add(A);
        
        M = new JButton("MUMBAI");
        M.setBounds(380, 250, 125, 30);
        M.setForeground(Color.white);
        M.setBackground(new Color(0, 0, 0));
        M.setFocusable(false);
        M.addActionListener(this);
        M.setBorder(new LineBorder(new Color(133, 193, 233)));
        image.add(M);
        
        N = new JButton("NASHIK");
        N.setBounds(660, 250, 125, 30);
        N.setForeground(Color.white);
        N.setBackground(new Color(0, 0, 0));
        N.setFocusable(false);
        N.addActionListener(this);
        N.setBorder(new LineBorder(new Color(133, 193, 233)));
        image.add(N);
        
        K = new JButton("KOKAN");
        K.setBounds(100, 500, 125, 30);
        K.setForeground(Color.white);
        K.setFocusable(false);
        K.setBackground(new Color(0, 0, 0));
        K.addActionListener(this);
        K.setBorder(new LineBorder(new Color(133, 193, 233)));
        image.add(K);
        
         F = new JButton("FORT");
        F.setBounds(380, 500, 125, 30);
        F.setForeground(Color.white);
        F.setFocusable(false);
        F.setBackground(new Color(0, 0, 0));
        F.addActionListener(this);
        F.setBorder(new LineBorder(new Color(133, 193, 233)));
        image.add(F);
        
        L= new JButton("LONAVALA");
        L.setBounds(660, 500, 125, 30);
        L.setForeground(Color.white);
        L.setFocusable(false);
        L.setBackground(new Color(0, 0, 0));
        L.addActionListener(this);
        L.setBorder(new LineBorder(new Color(133, 193, 233)));
        image.add(L);
    
     JLabel text = new JLabel("CHECK PACKAGE");
     text.setBounds(300, 10, 300, 50);
     text.setFont(new Font("Tahoma",Font.BOLD, 30));
     image.add(text);
        
       
        
       setVisible (true);
       setResizable(true);
    }
     public void actionPerformed(ActionEvent ac)
    {
        if(ac.getSource()==A)
        {
           new Ashtavinaykf();
           setVisible (false);
        }
        else if(ac.getSource()==M)
        {
            setVisible (false);
            new mumbaif();
        }
        else if(ac.getSource()==N)
        {
            setVisible (false);
             new nashikf();
        }
        else if(ac.getSource()==K)
        {
             setVisible (false);
             new kokanf();
        }
         else if(ac.getSource()==F)
        {
             setVisible (false);
             new fortf();       
        }
        else if(ac.getSource()==L)
        {
            setVisible (false);
            new lonavalaf();
        }
        
    }
    
    public static void main(String args[])
    {
        new CheckPackage();
    }
    
}
