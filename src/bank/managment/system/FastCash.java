package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String cardno;
    FastCash(String cardno){
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

        JLabel label = new JLabel("SELECT WITHDRAWL AMOUNT");
        label.setBounds(445,180,700,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,23));
        l3.add(label);

        b1 = new JButton("BDT. 100");
        b1.setForeground(Color.BLACK);
        b1.setBackground(new Color(32, 152, 152));
        b1.setBounds(340,270,150,35);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BDT. 1000");
        b2.setForeground(Color.BLACK);
        b2.setBackground(new Color(32, 152, 152));
        b2.setBounds(340,316,150,35);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("BDT. 10000");
        b3.setForeground(Color.BLACK);
        b3.setBackground(new Color(32, 152, 152));
        b3.setBounds(340,362,150,35);
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("BDT. 500");
        b4.setForeground(Color.BLACK);
        b4.setBackground(new Color(32, 152, 152));
        b4.setBounds(740,270,150,35);
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("BDT. 2000");
        b5.setForeground(Color.BLACK);
        b5.setBackground(new Color(32, 152, 152));
        b5.setBounds(740,316,150,35);
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("BDT. 5000");
        b6.setForeground(Color.BLACK);
        b6.setBackground(new Color(32, 152, 152));
        b6.setBounds(740,363,150,35);
        b6.addActionListener(this);
        l3.add(b6);

        b7 = new JButton("BACK");
        b7.setForeground(Color.BLACK);
        b7.setBackground(new Color(32, 152, 152));
        b7.setBounds(740,409,150,35);
        b7.addActionListener(this);
        l3.add(b7);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b7) {
            new main_Class(cardno);
            setVisible(false);
        } else {
            String amount = ((JButton)e.getSource()).getText().substring(5);    //retrieve button text from index 5
            Connection c = new Connection();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = dateFormat.format(new Date());

            try{
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
                if (e.getSource() != b7) {
                    if (balance.compareTo(new BigDecimal(amount)) < 0) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                }
                c.statement.executeUpdate("insert into bank values('"+cardno+"','"+date+"', 'Withdrawal', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "BDT. "+amount+" Debited Successfully");
            } catch (Exception E){
                E.printStackTrace();
            }
            new main_Class(cardno);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
