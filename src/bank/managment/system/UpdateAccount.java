package bank.managment.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateAccount extends JFrame implements ActionListener {
    String cardno, facility;
    JButton close,update,pinB;
    JLabel textName, textAcc, textCard, textPin,textExistAcc,textDate,labelFormNo;
    JCheckBox c1,c2,c3,c4,c5,c6;
    JRadioButton r1,r2;
    JTable table;
    DefaultTableModel model;
    public UpdateAccount(String cardno) {
        super("ATM Management System by Ahona Rahman (SK-59)");
        this.cardno =cardno;

        ImageIcon icon = new ImageIcon(getClass().getResource("/icon/icoon.png"));
        setIconImage(icon.getImage());

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/accnt.png"));
        Image i2 = i1.getImage().getScaledInstance(100,110,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel iimage = new JLabel(i3);
        iimage.setBounds(120,10,100,100);
        add(iimage);

        JLabel label1 = new JLabel("Account Information");
        label1.setBounds(250,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,36));
        add(label1);

        JLabel labelForm = new JLabel("Form No:  ");
        labelForm.setFont(new Font("Raleway", Font.BOLD,14));
        labelForm.setBounds(650,10,100,30);
        add(labelForm);

        labelFormNo = new JLabel();
        labelFormNo.setFont(new Font("Raleway", Font.BOLD,14));
        labelFormNo.setBounds(710,10,60,30);
        add(labelFormNo);

        JLabel labelName = new JLabel("*Name :");
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelName.setBounds(100,115,100,30);
        add(labelName);

        textName = new JLabel();
        textName.setFont(new Font("Raleway",Font.BOLD, 14));
        textName.setBounds(400,115,400,30);
        add(textName);

        JLabel labelCard = new JLabel("*Card no. :");
        labelCard.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCard.setBounds(100,160,200,30);
        add(labelCard);

        textCard = new JLabel();
        textCard.setFont(new Font("Raleway",Font.BOLD, 14));
        textCard.setBounds(400,160,400,30);
        add(textCard);

        JLabel labelPin = new JLabel("*Pin :");
        labelPin.setFont(new Font("Raleway", Font.BOLD, 20));
        labelPin.setBounds(100,205,200,30);
        add(labelPin);

        textPin = new JLabel();
        textPin.setFont(new Font("Raleway",Font.BOLD, 14));
        textPin.setBounds(400,205,400,30);
        add(textPin);

        JLabel labelAcc = new JLabel("*Account Type :");
        labelAcc.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAcc.setBounds(100,250,200,30);
        add(labelAcc);

        textAcc = new JLabel();
        textAcc.setFont(new Font("Raleway",Font.BOLD, 14));
        textAcc.setBounds(400,250,400,30);
        add(textAcc);

        JLabel l11 = new JLabel("*Services Required:");
        l11.setFont(new Font("Raleway",Font.BOLD,20));
        l11.setBounds(100,300,200,30);
        add(l11);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(new Color(227, 227, 163));
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,350,200,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(new Color(227, 227, 163));
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,350,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(227, 227, 163));
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,400,200,30);
        add(c3);

        c4 = new JCheckBox("E-mail Alerts");
        c4.setBackground(new Color(227, 227, 163));
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,400,200,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(new Color(227, 227, 163));
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,450,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(new Color(227, 227, 163));
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,450,200,30);
        add(c6);

        JLabel labelDate = new JLabel("*Date of Creating Account:");
        labelDate.setFont(new Font("Raleway", Font.BOLD, 20));
        labelDate.setBounds(100,500,300,30);
        add(labelDate);

        textDate = new JLabel();
        textDate.setFont(new Font("Raleway",Font.BOLD, 14));
        textDate.setBounds(400,500,400,30);
        add(textDate);

        JLabel labelExistAcc = new JLabel("*Existing Account :");
        labelExistAcc.setFont(new Font("Raleway", Font.BOLD, 20));
        labelExistAcc.setBounds(100,550,200,30);
        add(labelExistAcc);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD,14));
        r1.setBackground(new Color(227, 227, 163));
        r1.setBounds(350,550,100,30);
        add(r1);
        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD,14));
        r2.setBackground(new Color(227, 227, 163));
        r2.setBounds(460,550,100,30);
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        // Create a table to display previous accounts
        model = new DefaultTableModel();
        model.addColumn("Account Number");
        model.addColumn("Account Type");
        model.addColumn("Create Date");

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 600, 600, 100);
        add(scrollPane);
        textExistAcc = new JLabel();
        textExistAcc.setFont(new Font("Raleway",Font.BOLD, 14));
        textExistAcc.setBounds(400,550,400,30);
        add(textExistAcc);

        try {
            Connection c = new Connection();

            // SQL Query to fetch data from multiple tables using JOIN
            String query = "SELECT s.form_no, s.name, s3.account_type, s3.card_no, s3.pin, s3.facility, s3.signup_time, s2.NID, s2.prev_account " +
                    "FROM signup s " +
                    "JOIN signup3 s3 ON s.form_no = s3.form_no " +
                    "JOIN signup2 s2 ON s.form_no = s2.form_no " +
                    "JOIN login l ON s3.card_no = l.card_no " +
                    "JOIN bank b ON s3.card_no = b.card_no " +
                    "WHERE s3.card_no = '" + cardno + "'";

            ResultSet resultSet = c.statement.executeQuery(query);
            if (resultSet.next()) {
                labelFormNo.setText(resultSet.getString("form_no"));
                textName.setText(resultSet.getString("name"));
                textAcc.setText(resultSet.getString("account_type"));
                textCard.setText(resultSet.getString("card_no"));
                textPin.setText(resultSet.getString("pin"));
                textExistAcc.setText(resultSet.getString("prev_account"));
                textDate.setText(resultSet.getString("signup_time"));

                String existingAccountValue = resultSet.getString("prev_account");
                if ("Yes".equals(existingAccountValue)) {
                    r1.setSelected(true);
                } else if ("No".equals(existingAccountValue)) {
                    r2.setSelected(true);
                }

                facility = resultSet.getString("facility");
                //System.out.println("Facility from database: " + facility);
                String[] facilities = facility.split(","); // Assuming facilities are separated by a comma

                // Loop through the facilities and check the corresponding checkboxes
                for (String f : facilities) {
                    //System.out.println("Facility: " + f);
                    // Adjust the comparison logic to set checkboxes based on retrieved facilities
                    if (f.trim().contains("ATM CARD")) {
                        c1.setSelected(true);
                    } else if (f.trim().contains("Internet Banking")) {
                        c2.setSelected(true);
                    } else if (f.trim().contains("Mobile Banking")) {
                        c3.setSelected(true);
                    } else if (f.trim().contains("Email Alerts")) {
                        c4.setSelected(true);
                    } else if (f.trim().contains("Cheque Book")) {
                        c5.setSelected(true);
                    } else if (f.trim().contains("E-Statement")) {
                        c6.setSelected(true);
                    }
                }
                String currentNID = resultSet.getString("NID");

                // Fetch the account number and type of the existing account based on the current account's NID number
                String queryAllPreviousAccounts = "SELECT s3.card_no, s3.account_type, s3.signup_time FROM signup3 s3 JOIN signup2 s2 ON s3.form_no= s2.form_no WHERE s2.NID = '" + currentNID + "'";
                ResultSet resultSetAllPreviousAccounts = c.statement.executeQuery(queryAllPreviousAccounts);

                // Populate the table with previous accounts
                while (resultSetAllPreviousAccounts.next()) {
                    String[] rowData = {
                            resultSetAllPreviousAccounts.getString("card_no"),
                            resultSetAllPreviousAccounts.getString("account_type"),
                            resultSetAllPreviousAccounts.getString("signup_time")
                    };
                    model.addRow(rowData);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        update = new JButton("Update");
        update.setBounds(60,720,100,25);
        update.addActionListener(this);
        update.setBackground(Color.WHITE);
        update.setForeground(Color.BLACK);
        add(update);

        pinB = new JButton("Change Pin?");
        pinB.setBounds(550,205,120,25);
        pinB.addActionListener(this);
        pinB.setBackground(new Color(227, 227, 163));
        pinB.setForeground(Color.BLACK);
        add(pinB);

        close = new JButton("Exit");
        close.setBounds(690,720,100,25);
        close.addActionListener(this);
        close.setBackground(Color.WHITE);
        close.setForeground(Color.BLACK);
        add(close);

        getContentPane().setBackground(new Color(227, 227, 163));
        setLayout(null);
        setSize(850,800);
        setLocation(360,10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String existingAccountValue = r1.isSelected() ? "Yes" : "No";

        String fac = "";
        if(c1.isSelected()){
            fac += "ATM CARD,";
        } if (c2.isSelected()) {
            fac += "Internet Banking,";
        } if (c3.isSelected()) {
            fac += "Mobile Banking,";
        } if (c4.isSelected()) {
            fac += "Email Alerts,";
        } if (c5.isSelected()) {
            fac += "Cheque Book,";
        } if (c6.isSelected()) {
            fac += "E-Statement,";
        }

        try{
            if (e.getSource() == update) {
                if (fac.equals("")){
                    JOptionPane.showMessageDialog(null,"Please select at-least one Services type");
                    return;
                } if(fac.equals(facility) && existingAccountValue.equals(textExistAcc.getText())){
                    JOptionPane.showMessageDialog(null,"There is no new information here.");
                } else {
                    Connection c1 = new Connection();
                    String q1 = "UPDATE signup3 SET facility = '" + fac + "' WHERE card_no = '" + cardno + "'";
                    int rowsUpdated1 = c1.statement.executeUpdate(q1);


                    String q2 = "UPDATE signup2 SET prev_account = '" + existingAccountValue + "' WHERE form_no = (SELECT form_no FROM signup3 WHERE card_no = '" + cardno + "')";
                    int rowsUpdated2 = c1.statement.executeUpdate(q2);

                    if (rowsUpdated1 > 0 && rowsUpdated2 > 0) {
                        JOptionPane.showMessageDialog(null, "Account updated successfully");
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update account");
                    }
                }
            } else if (e.getSource() == pinB) {
                new Pin(cardno);
                setVisible(false);
            } else if (e.getSource() == close) {
                setVisible(false);
            }
        } catch (Exception E){
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new UpdateAccount("");
    }
}
