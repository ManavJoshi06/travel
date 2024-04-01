
package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class mumbaif extends JFrame implements ActionListener {
    JButton v,A;
    mumbaif(){
          setBounds(400,90,800,550);
        getContentPane().setBackground(Color.cyan);
        setLayout(null);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/mumbai.jpg"));
    Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(380,70, 400, 400);
    add(image);
        image.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent e)
            {
                new  mumbai();       
            }});
     JLabel text = new JLabel("MUMBAI DARSHAN");
     text.setBounds(150, 10, 650, 50);
     text.setFont(new Font("Tahoma",Font.BOLD, 50));
     add(text);
     
     JLabel text1 = new JLabel("5 days 4 night ");
     text1.setBounds(50, 80, 250, 50);
     text1.setFont(new Font("Tahoma",Font.BOLD, 30));
     add(text1);
     
    JLabel text2 = new JLabel("(All Launguages Speaking Guide) ");
     text2.setBounds(50, 120, 250, 50);
     text2.setFont(new Font("Tahoma",Font.BOLD, 14));
     add(text2);
     
     JLabel text3 = new JLabel("wax museum free pass");
     text3.setBounds(50, 220, 250, 50);
     text3.setFont(new Font("Tahoma",Font.BOLD, 30));
     add(text3);
     
      JLabel text4= new JLabel("Price  2500/- ");
     text4.setBounds(50, 300, 250 , 50);
     text4.setFont(new Font("Tahoma",Font.BOLD, 30));
     add(text4);
        
        
         A = new JButton("Back");
        A.setBounds(50, 400, 125, 30);
        A.setForeground(Color.white);
        A.setBackground(new Color(0, 0, 0));
        A.addActionListener(this);
        A.setFocusable(false);
        A.setBorder(new LineBorder(new Color(133, 193, 233)));
        add(A);
        
          v = new JButton("Book Now");
        v.setBounds(200, 400, 125, 30);
        v.setForeground(Color.white);
        v.setBackground(new Color(0, 0, 0));
        v.addActionListener(this);
        v.setFocusable(false);
        v.setBorder(new LineBorder(new Color(133, 193, 233)));
        add(v);
        setResizable(false);
         setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ac)
    {
        if(ac.getSource()==v)
        {
        new BookPackage("");
        }
        else
        {
            new CheckPackage();
            setVisible(false);
        }
    }
    
    public static void main(String args[])
    {
        new mumbaif();
    }
}
