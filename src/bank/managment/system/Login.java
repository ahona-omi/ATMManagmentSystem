package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class Login extends JFrame  implements ActionListener {
    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1,button2,button3;
    Login(){
        super("ATM Management System by Ahona Rahman (SK-59)");
        // Load the icon image
        ImageIcon icon = new ImageIcon(getClass().getResource("/icon/icoon.png"));
        // Set the icon for the JFrame
        setIconImage(icon.getImage());

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));          //img store in i1
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);          //i1 scale in i2
        ImageIcon i3 = new ImageIcon(i2);          //img visible in frame(img not shown cause img shown by label)
        JLabel iimage = new JLabel(i3);          //img situation in frame
        iimage.setBounds(100,350,100,100);
        add(iimage);

        label1 = new JLabel("WELCOME TO ATM");      //show text on frame
        label1.setForeground(Color.WHITE);      //set color
        label1.setFont(new Font("AvantGarde", Font.BOLD, 28));
        label1.setBounds(80,25,450,40);         //text location according frame
        add(label1);

        label2 = new JLabel("Card No:");
        label2.setFont(new Font("Ralway", Font.BOLD, 18));
        label2.setForeground(Color.WHITE);
        label2.setBounds(50,90,375,30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(135,90,230,30);
        textField2.setFont(new Font("Arial", Font.BOLD,14));
        add(textField2);

        label3 = new JLabel("PIN: ");
        label3.setFont(new Font("Ralway", Font.BOLD, 18));
        label3.setForeground(Color.WHITE);
        label3.setBounds(50,140,375,30);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(135,140,230,30);
        passwordField3.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordField3);

        button1 = new JButton("LOG IN");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setForeground(Color.BLACK);
        button1.setBackground(Color.WHITE);
        button1.setBounds(120,200,100, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setForeground(Color.BLACK);
        button2.setBackground(Color.WHITE);
        button2.setBounds(250,200,100, 30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button3.setForeground(Color.BLACK);
        button3.setBackground(Color.WHITE);
        button3.setBounds(120,250,230, 30);
        button3.addActionListener(this);
        add(button3);

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0,0,850,480);
        add(iiimage);


        setLayout(null);          //default layout border which is null now
        setSize(850,480);        //frame size
        setLocation(450,200);          //frame location according window
        //setUndecorated(true);             //upper bar vanish
        setVisible(true);           //frame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if (e.getSource()==button1){
                Connection c = new Connection();
                String cardno = textField2.getText();
                String pin = passwordField3.getText();
                String q = "select * from login where card_no = '"+cardno+"' and  pin = '"+pin+"'";
                ResultSet resultSet = c.statement.executeQuery(q);      //query data stored
                if (resultSet.next()){
                    new main_Class(cardno);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }
            } else if (e.getSource() == button2){
                textField2.setText("");
                passwordField3.setText("");
            } else if (e.getSource() == button3){
                new Signup();
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}