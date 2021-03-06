
package tugas6;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Loginn extends JFrame {

    JLabel username = new JLabel("Username");
    JLabel password = new JLabel("Password");
    JTextField user = new JTextField(20);
    JPasswordField pass = new JPasswordField(20);
    JButton login = new JButton("Login");
    JButton cancel = new JButton("Cancel");

    Loginn() {
        setTitle("Halaman LogIn");
        setSize(350, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(username);
        add(user);
        add(password);
        add(pass);
        add(login);
        add(cancel);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username, password;
                username = user.getText();
                password = pass.getText();
                if (username.length() == 0 && password.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Username/Password tidak boleh kosong!");
                } 
                else if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("aa") ){
                    new ViewTugas();
                    dispose();
                }
                else
                    JOptionPane.showMessageDialog(null, "Username/Password anda salah!");

            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pass.setText(null);
            }
        });
        setVisible(true);
    }
}

