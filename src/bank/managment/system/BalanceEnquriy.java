package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;

public class BalanceEnquriy extends JFrame implements ActionListener {
    String cardno;
    JLabel label2;
    JButton b1;
    BalanceEnquriy(String cardno){
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

        JLabel label1 = new JLabel("Your Current Balance is BDT. ");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(430,180,700,35);
        l3.add(label1);

        label2 = new JLabel();
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(430,220,400,40);
        l3.add(label2);

        b1 = new JButton("Back");
        b1.setBounds(740,409,150,35);
        b1.setBackground(new Color(32, 152, 152));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l3.add(b1);

        BigDecimal balance = BigDecimal.ZERO;
        try{
            Connection c = new Connection();
            String query = "SELECT SUM(CASE WHEN type = 'Deposit' THEN amount ELSE -amount END) AS balance FROM bank WHERE card_no = '" + cardno + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            if (resultSet.next()) {
                balance = resultSet.getBigDecimal("balance");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        label2.setText(balance.toString());

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new main_Class(cardno);
        setVisible(false);
    }

    public static void main(String[] args) {
        new BalanceEnquriy("");
    }
}
