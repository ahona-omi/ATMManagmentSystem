package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;
    String cardno;
    Pin(String cardno){
        super("ATM Management System by Ahona Rahman (SK-59)");
        this.cardno =cardno;

        ImageIcon icon = new ImageIcon(getClass().getResource("/icon/icoon.png"));
        setIconImage(icon.getImage());

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(430,180,400,35);
        l3.add(label1);

        JLabel label2 = new JLabel("New PIN: ");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(430,220,150,35);
        l3.add(label2);

        p1 = new JPasswordField();
        p1.setBackground(new Color(32, 152, 152));
        p1.setForeground(Color.BLACK);
        p1.setBounds(600,220,180,30);
        p1.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(p1);

        JLabel label3 = new JLabel("Re-Enter New PIN: ");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System", Font.BOLD, 16));
        label3.setBounds(430,255,400,35);
        l3.add(label3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(32, 152, 152));
        p2.setForeground(Color.BLACK);
        p2.setBounds(600,260,180,30);
        p2.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(p2);

        b1 = new JButton("CHANGE");
        b1.setBounds(740,363,150,35);
        b1.setBackground(new Color(32, 152, 152));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(740,409,150,35);
        b2.setBackground(new Color(32, 152, 152));
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        l3.add(b2);

        setSize(1550,1080);
        setLayout(null);
        setLocation(0,0);
        setVisible(true);       //by default false
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if (e.getSource()==b1){
                if (p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New PIN");
                    return;
                }
                if (p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter New PIN");
                    return;
                }
                if (!pin1.equals(pin2)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }
                //System.out.println("Card Number: " + cardno); // Verify that the card number is correct
                try {
                    Connection c = new Connection();
                    String q1 = "update login set pin = '" + pin1 + "' where card_no = '" + cardno + "'";
                    String q2 = "update signup3 set pin = '" + pin1 + "' where card_no = '" + cardno + "'";

                    //System.out.println("Executing SQL statements...");

                    int rowsUpdatedInLogin = c.statement.executeUpdate(q1);
                    int rowsUpdatedInSignup3 = c.statement.executeUpdate(q2);

//                    System.out.println("Rows updated in login: " + rowsUpdatedInLogin);
//                    System.out.println("Rows updated in signup3: " + rowsUpdatedInSignup3);

                    if (rowsUpdatedInLogin > 0 && rowsUpdatedInSignup3 > 0) {
                        JOptionPane.showMessageDialog(null, "PIN changed successfully");
                        new main_Class(cardno);
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to change PIN. Please check your card number.");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "An error occurred while changing PIN.");
                }

            } else if (e.getSource()==b2) {
                new main_Class(cardno);
                setVisible(false);
            }
        } catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Pin("");
    }
}
