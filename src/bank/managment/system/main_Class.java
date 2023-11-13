package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_Class extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    String cardno;
    main_Class(String cardno){
        super("ATM Management System by Ahona Rahman (SK-59)");
        this.cardno = cardno;

        ImageIcon icon = new ImageIcon(getClass().getResource("/icon/icoon.png"));
        setIconImage(icon.getImage());

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label = new JLabel("Please Select Your Transaction");
        label.setBounds(430,180,700,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,28));
        l3.add(label);

        b1 = new JButton("DEPOSIT");
        b1.setForeground(Color.BLACK);
        b1.setBackground(new Color(32, 152, 152));
        b1.setBounds(340,270,150,35);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("FAST CASH");
        b2.setForeground(Color.BLACK);
        b2.setBackground(new Color(32, 152, 152));
        b2.setBounds(340,316,150,35);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("PIN CHANGE");
        b3.setForeground(Color.BLACK);
        b3.setBackground(new Color(32, 152, 152));
        b3.setBounds(340,362,150,35);
        b3.addActionListener(this);
        l3.add(b3);

        b8 = new JButton("UPDATE INFO");
        b8.setForeground(Color.BLACK);
        b8.setBackground(new Color(32, 152, 152));
        b8.setBounds(340,409,150,35);
        b8.addActionListener(this);
        l3.add(b8);

        b4 = new JButton("CASH WITHDRAWL");
        b4.setForeground(Color.BLACK);
        b4.setBackground(new Color(32, 152, 152));
        b4.setBounds(710,270,180,35);
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("TRANSACTION DETAILS");
        b5.setForeground(Color.BLACK);
        b5.setBackground(new Color(32, 152, 152));
        b5.setBounds(710,316,180,35);
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setForeground(Color.BLACK);
        b6.setBackground(new Color(32, 152, 152));
        b6.setBounds(710,363,180,35);
        b6.addActionListener(this);
        l3.add(b6);

        b7 = new JButton("EXIT");
        b7.setForeground(Color.BLACK);
        b7.setBackground(new Color(32, 152, 152));
        b7.setBounds(710,409,180,35);
        b7.addActionListener(this);
        l3.add(b7);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            new Deposit(cardno);       //cradno from login
            setVisible(false);
        } else if (e.getSource()==b2) {
            new FastCash(cardno);
            setVisible(false);
        } else if (e.getSource()==b3) {
            new Pin(cardno);
            setVisible(false);
        } else if (e.getSource()==b4) {
            new Withdrawal(cardno);
            setVisible(false);
        } else if (e.getSource()==b5) {
            new details(cardno);
        }else if (e.getSource()==b6) {
            new BalanceEnquriy(cardno);
            setVisible(false);      //only frame closed
        } else if (e.getSource()==b7){
            System.exit(0);     //full program closed
        } else if (e.getSource()==b8) {
            new UpdateProfile(cardno);
        }
    }

    public static void main(String[] args) {
        new main_Class("");
    }
}
