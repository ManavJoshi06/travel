package travel.management.system;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class YourClass {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Your Frame");
        JMenuBar mb = new JMenuBar();

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/profile.jpg"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(5, 0, 70, 70);

        // Add MouseListener to the JLabel
        image.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle mouse click event here
                // You can perform actions or open dialogs, etc.
                 new AddCustomer("");
            }
        });

        mb.add(image);
        frame.setJMenuBar(mb);

        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
