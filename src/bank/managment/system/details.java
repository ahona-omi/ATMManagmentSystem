package bank.managment.system;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;

public class details extends JFrame implements ActionListener {
    String cardno;
    JButton button;
    JTextArea textArea;
    JLabel depositCountLabel, withdrawalCountLabel,depositAmountLabel, withdrawalAmountLabel;
    details(String cardno){
        super("ATM Management System by Ahona Rahman (SK-59)");
        this.cardno = cardno;

        ImageIcon icon = new ImageIcon(getClass().getResource("/icon/icoon.png"));
        setIconImage(icon.getImage());

        getContentPane().setBackground(new Color(137, 207, 240));
        setSize(600,700);
        setLocation(450,100);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/trans.png"));
        Image i2 = i1.getImage().getScaledInstance(120,183,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel iimage = new JLabel(i3);
        iimage.setBounds(420,150,120,183);
        add(iimage);

        JLabel label1 = new JLabel("Date & Time"); // Label to display column names
        label1.setFont(new Font("System", Font.BOLD, 14));
        label1.setBounds(30, 120, 700, 20); // Adjust the bounds as necessary
        add(label1);

        JLabel llabel1 = new JLabel("Type"); // Label to display column names
        llabel1.setFont(new Font("System", Font.BOLD, 14));
        llabel1.setBounds(180, 120, 700, 20); // Adjust the bounds as necessary
        add(llabel1);

        JLabel lllabel1 = new JLabel("Amount\n"); // Label to display column names
        lllabel1.setFont(new Font("System", Font.BOLD, 14));
        lllabel1.setBounds(300, 120, 700, 20); // Adjust the bounds as necessary
        add(lllabel1);

        textArea = new JTextArea();
        textArea.setEditable(false);        // Set the text area as non-editable
        //set cursor invisible
        textArea.setCaret(new DefaultCaret() {
            @Override
            public int getBlinkRate() {
                return 0; // Makes the caret stop blinking
            }
        });
        textArea.setCaretColor(textArea.getBackground()); // Sets the caret color as the same as the background, effectively making it invisible

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20, 140, 400, 320);
        add(scrollPane);

        JLabel label2 = new JLabel("Your Transaction Details");
        label2.setFont(new Font("System", Font.BOLD,16));
        label2.setBounds(190,20,200,20);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20,80,300,20);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setFont(new Font("System", Font.BOLD,16));
        label4.setBounds(20,500,500,20);
        add(label4);

        try {
            Connection c = new Connection();

            // Get card details
            ResultSet cardResultSet = c.statement.executeQuery("select * from login where card_no = '" + cardno + "'");
            while (cardResultSet.next()) {
                label3.setText("Card Number:  " + cardResultSet.getString("card_no").substring(0, 4) + "XXXXXXXX" + cardResultSet.getString("card_no").substring(12));
            }

            // Count deposits
            ResultSet depositWithdrawalResultSet = c.statement.executeQuery("SELECT type, COUNT(*) as count, SUM(amount) as total FROM bank WHERE card_no = '" + cardno + "' GROUP BY type");
            while (depositWithdrawalResultSet.next()) {
                String type = depositWithdrawalResultSet.getString("type");
                int count = depositWithdrawalResultSet.getInt("count");
                BigDecimal total = depositWithdrawalResultSet.getBigDecimal("total");

                if (type.equals("Deposit")) {
                    depositCountLabel = new JLabel("Total Deposits: " + count+ " times");
                    depositAmountLabel= new JLabel("Total Deposit Amount: BDT. " + total);
                    depositCountLabel.setBounds(410, 540, 600, 20);
                    depositAmountLabel.setBounds(18, 540, 600, 20);
                    add(depositCountLabel);
                    add(depositAmountLabel);
                } else if (type.equals("Withdrawal")) {
                    withdrawalCountLabel = new JLabel("Total Withdrawals: " + count + " times");
                    withdrawalAmountLabel  = new JLabel("Total Withdrawal Amount: BDT. " + total);
                    withdrawalCountLabel.setBounds(410, 560, 600, 20);
                    withdrawalAmountLabel.setBounds(18, 560, 600, 20);
                    add(withdrawalCountLabel);
                    add(withdrawalAmountLabel);
                }
            }

            // Retrieve bank details
            ResultSet bankResultSet = c.statement.executeQuery("select * from bank where card_no ='" + cardno + "'");
            BigDecimal balance = BigDecimal.ZERO;

            while (bankResultSet.next()) {
                textArea.append(bankResultSet.getString("date") + "\t" +
                        bankResultSet.getString("type") + "\t" +
                        bankResultSet.getString("amount") + "\n\n");
                if (bankResultSet.getString("type").equals("Deposit")) {
                    BigDecimal amnt = bankResultSet.getBigDecimal("amount");
                    balance = balance.add(amnt);
                } else {
                    BigDecimal amnt = bankResultSet.getBigDecimal("amount");
                    balance = balance.subtract(amnt);
                }
            }
            label4.setText("Your Current Balance is BDT. " + balance);

        } catch (Exception e){
            e.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(450,600,100,25);
        button.addActionListener(this);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        add(button);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new details("");
    }
}
