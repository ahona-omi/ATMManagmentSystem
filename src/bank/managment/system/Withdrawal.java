package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {
    String cardno;
    TextField textField;
    JButton b1, b2;
    Withdrawal(String cardno){
        super("ATM Management System by Ahona Rahman (SK-59)");
        this.cardno=cardno;

        ImageIcon icon = new ImageIcon(getClass().getResource("/icon/icoon.png"));
        setIconImage(icon.getImage());

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL IS BDT.10,000");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460,180,700,35);
        l3.add(label1);

        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(460,220,400,35);
        l3.add(label2);


        textField = new TextField();
        textField.setBackground(Color.WHITE);
        textField.setForeground(Color.BLACK);
        textField.setBounds(460,260,320,25);
        textField.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(textField);

        b1 = new JButton("WITHDRAW");
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

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1) {
            try {
                String amount = textField.getText();

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = dateFormat.format(new Date());

                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
                } else {
                    Connection c = new Connection();
                    ResultSet resultSet = c.statement.executeQuery("select * from bank where card_no ='"+cardno+"'");
                    BigDecimal balance = BigDecimal.ZERO;
                    while (resultSet.next()){
                        if (resultSet.getString("type").equals("Deposit")) {
                            BigDecimal amnt = resultSet.getBigDecimal("amount");
                            balance = balance.add(amnt);
                        } else {
                            BigDecimal amnt = resultSet.getBigDecimal("amount");
                            balance = balance.subtract(amnt);
                        }
                    }
                    if (balance.compareTo(new BigDecimal(amount)) < 0) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    if (new BigDecimal(amount).compareTo(new BigDecimal("10000")) > 0) {
                        JOptionPane.showMessageDialog(null, "Cannot withdraw more than BDT.10,000");
                        return;
                    }
                    c.statement.executeUpdate("insert into bank values('" + cardno + "', '" + date + "', 'Withdrawal', '" + amount + "' )");
                    JOptionPane.showMessageDialog(null, "BDT. " + amount + " Debited Successfully");
                    new main_Class(cardno);
                    setVisible(false);
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource()==b2) {
            setVisible(false);
            new main_Class(cardno);
        }
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}
