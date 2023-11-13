package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateProfile extends JFrame implements ActionListener {
    String cardno, formNo,mail,add, city, state, postal, phno,maritalStatus, seniorCity,inc, edu, occu, nid,passp;
    JRadioButton m1,m2,m3,r1,r2;
    JButton close,update, updateAcc;
    JLabel textName,textNid,textPassport;
    JTextField textEmail,textAdd, textcity, textState, textPin, textPhno;
    JComboBox comboBox2,comboBox3,comboBox4;
    UpdateProfile(String cardno){
        super("ATM Management System by Ahona Rahman (SK-59)");
        this.cardno =cardno;

        ImageIcon icon = new ImageIcon(getClass().getResource("/icon/icoon.png"));
        setIconImage(icon.getImage());

        JLabel label1 = new JLabel("Personal Information");
        label1.setBounds(250,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,36));
        add(label1);

        JLabel labelName = new JLabel("*Name :");
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelName.setBounds(100,80,100,30);
        add(labelName);

        textName = new JLabel();
        textName.setFont(new Font("Raleway",Font.BOLD, 14));
        textName.setBounds(300,80,400,30);
        add(textName);

        JLabel labelPhno = new JLabel("Phone no. :");
        labelPhno.setFont(new Font("Raleway", Font.BOLD, 20));
        labelPhno.setBounds(100,125,200,30);
        add(labelPhno);

        textPhno = new JTextField();
        textPhno.setFont(new Font("Raleway",Font.BOLD, 14));
        textPhno.setBounds(300,125,400,30);
        add(textPhno);

        JLabel labelEmail = new JLabel("Email address :");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEmail.setBounds(100,170,200,30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway",Font.BOLD, 14));
        textEmail.setBounds(300,170,400,30);
        add(textEmail);

        JLabel labelMs = new JLabel("Marital Status :");
        labelMs.setFont(new Font("Raleway", Font.BOLD, 20));
        labelMs.setBounds(100,215,200,30);
        add(labelMs);

        m1 = new JRadioButton("Married");
        m1.setBounds(300,215,100,30);
        m1.setBackground(new Color(222,255,228));
        m1.setFont(new Font("Raleway", Font.BOLD,14));
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setBackground(new Color(222,255,228));
        m2.setBounds(450,215,100,30);
        m2.setFont(new Font("Raleway", Font.BOLD,14));
        add(m2);

        m3 = new JRadioButton("Other");
        m3.setBackground(new Color(222,255,228));
        m3.setBounds(635,215,100,30);
        m3.setFont(new Font("Raleway", Font.BOLD,14));
        add(m3);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(m1);
        buttonGroup1.add(m2);
        buttonGroup1.add(m3);

        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAdd.setBounds(100,260,200,30);
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setFont(new Font("Raleway",Font.BOLD, 14));
        textAdd.setBounds(300,260,400,30);
        add(textAdd);

        JLabel labelCity = new JLabel("City :");
        labelCity.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCity.setBounds(100,305,200,30);
        add(labelCity);

        textcity = new JTextField();
        textcity.setFont(new Font("Raleway",Font.BOLD, 14));
        textcity.setBounds(300,305,400,30);
        add(textcity);

        JLabel labelPin = new JLabel("Postal Code :");
        labelPin.setFont(new Font("Raleway", Font.BOLD, 20));
        labelPin.setBounds(100,350,200,30);
        add(labelPin);

        textPin = new JTextField();
        textPin.setFont(new Font("Raleway",Font.BOLD, 14));
        textPin.setBounds(300,350,400,30);
        add(textPin);

        JLabel labelstate = new JLabel("State :");
        labelstate.setFont(new Font("Raleway", Font.BOLD, 20));
        labelstate.setBounds(100,395,200,30);
        add( labelstate);

        textState = new JTextField();
        textState.setFont(new Font("Raleway",Font.BOLD, 14));
        textState.setBounds(300,395,400,30);
        add(textState);

        JLabel l4 = new JLabel("Income(per year) : ");
        l4.setFont(new Font("Raleway", Font.BOLD,18));
        l4.setBounds(100,440,200,30);
        add(l4);

        String income [] = {"Null","<1,50,000","<2,50,000", "5,00,000", "Up-to 10,00,000","Above 10,00,000"};
        comboBox2 = new JComboBox(income);
        comboBox2.setBackground(new Color(222,255,228));
        comboBox2.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox2.setBounds(350,440,320,30);
        add(comboBox2);

        JLabel l5 = new JLabel("Educational : ");
        l5.setFont(new Font("Raleway", Font.BOLD,18));
        l5.setBounds(100,485,150,30);
        add(l5);

        String educational [] = {"Non-Graduate","Undergraduate","Graduate","Post-Graduate", "Doctorate", "Others"};
        comboBox3 = new JComboBox(educational);
        comboBox3.setBackground(new Color(222,255,228));
        comboBox3.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox3.setBounds(350,485,320,30);
        add(comboBox3);

        JLabel l6 = new JLabel("Occupation : ");
        l6.setFont(new Font("Raleway", Font.BOLD,18));
        l6.setBounds(100,530,150,30);
        add(l6);

        String Occupation [] = {"Student", "Salaried","Self-Employed","Business", "Retired", "Other"};
        comboBox4 = new JComboBox(Occupation);
        comboBox4.setBackground(new Color(222,255,228));
        comboBox4.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox4.setBounds(350,530,320,30);
        add(comboBox4);

        JLabel l7 = new JLabel("*NID Number : ");
        l7.setFont(new Font("Raleway", Font.BOLD,18));
        l7.setBounds(100,575,150,30);
        add(l7);

        textNid = new JLabel();
        textNid.setFont(new Font("Raleway", Font.BOLD,18));
        textNid.setBounds(350,575,320,30);
        add(textNid);

        JLabel l8 = new JLabel("*Passport Number : ");
        l8.setFont(new Font("Raleway", Font.BOLD,18));
        l8.setBounds(100,620,180,30);
        add(l8);

        textPassport = new JLabel();
        textPassport.setFont(new Font("Raleway", Font.BOLD,18));
        textPassport.setBounds(350,620,320,30);
        add(textPassport);

        JLabel l9 = new JLabel("Senior Citizen : ");
        l9.setFont(new Font("Raleway", Font.BOLD,18));
        l9.setBounds(100,665,180,30);
        add(l9);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD,14));
        r1.setBackground(new Color(222,255,228));
        r1.setBounds(350,665,100,30);
        add(r1);
        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD,14));
        r2.setBackground(new Color(222,255,228));
        r2.setBounds(460,665,100,30);
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel l11 = new JLabel("Form No:  ");
        l11.setFont(new Font("Raleway", Font.BOLD,14));
        l11.setBounds(650,10,100,30);
        add(l11);

        JLabel l12 = new JLabel();
        l12.setFont(new Font("Raleway", Font.BOLD,14));
        l12.setBounds(710,10,60,30);
        add(l12);

        try{
            Connection c = new Connection();
            String selectQuery = "SELECT s.name, s.phone_no, s.email, s.marital_status, s.address, s.city, " +
                    "s.pincode, s.state, s2.income, s2.education, s2.occupation, s2.senior_citizen, " +
                    "s2.NID, s2.passport, s3.form_no " +
                    "FROM signup s " +
                    "JOIN signup2 s2 ON s.form_no = s2.form_no " +
                    "JOIN signup3 s3 ON s.form_no = s3.form_no " +
                    "WHERE s3.card_no = '" + cardno + "'";

            ResultSet resultSet = c.statement.executeQuery(selectQuery);
            while (resultSet.next()){
                formNo = resultSet.getString("form_no");
                l12.setText(formNo);
                textName.setText(resultSet.getString("name"));

                mail = resultSet.getString("email");
                add = resultSet.getString("address");
                city = resultSet.getString("city");
                state = resultSet.getString("state");
                postal = resultSet.getString("pincode");
                phno = resultSet.getString("phone_no");

                textPhno.setText(phno);
                textEmail.setText(mail);

                maritalStatus = resultSet.getString("marital_status");
                if ("Married".equals(maritalStatus)) {
                    m1.setSelected(true);
                } else if ("Unmarried".equals(maritalStatus)) {
                    m2.setSelected(true);
                } else {
                    m3.setSelected(true);
                }
                textAdd.setText(add);
                textcity.setText(city);
                textPin.setText(postal);
                textState.setText(state);

                inc = resultSet.getString("income");
                edu = resultSet.getString("education");
                occu = resultSet.getString("occupation");
                nid = resultSet.getString("NID");
                passp = resultSet.getString("passport");
                seniorCity = resultSet.getString("senior_citizen");

                comboBox2.setSelectedItem(inc);
                comboBox3.setSelectedItem(edu);
                comboBox4.setSelectedItem(occu);

                if ("Yes".equals(seniorCity)) {
                    r1.setSelected(true);
                } else if ("No".equals(seniorCity)) {
                    r2.setSelected(true);
                }
                textNid.setText(nid);
                textPassport.setText(passp);
            }
        } catch (Exception e ){
            e.printStackTrace();
        }

        update = new JButton("Update");
        update.setBounds(60,720,100,25);
        update.addActionListener(this);
        update.setBackground(Color.WHITE);
        update.setForeground(Color.BLACK);
        add(update);

        updateAcc = new JButton("Update Account");
        updateAcc.setBounds(360,720,150,25);
        updateAcc.addActionListener(this);
        updateAcc.setBackground(Color.WHITE);
        updateAcc.setForeground(Color.BLACK);
        add(updateAcc);

        close = new JButton("Exit");
        close.setBounds(690,720,100,25);
        close.addActionListener(this);
        close.setBackground(Color.WHITE);
        close.setForeground(Color.BLACK);
        add(close);

        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(850,800);
        setLocation(360,10);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String phone = textPhno.getText();
            String mailAd = textEmail.getText();
            String address = textAdd.getText();
            String cit = textcity.getText();
            String postalPin = textPin.getText();
            String stat = textState.getText();
            String income = comboBox2.getSelectedItem().toString();
            String education = comboBox3.getSelectedItem().toString();
            String occupation = comboBox4.getSelectedItem().toString();

            String marital = "";
            if (m1.isSelected()) {
                marital = "Married";
            } else if (m2.isSelected()) {
                marital = "Unmarried";
            } else if (m3.isSelected()) {
                marital = "Other";
            }

            String senCity = "";
            if (r1.isSelected()) {
                senCity = "Yes";
            } else if (r2.isSelected()) {
                senCity = "No";
            }
            if (e.getSource()==update){
                if (phone.equals(phno) && mailAd.equals(mail) && maritalStatus.equals(marital) && address.equals(add) && city.equals(cit) && postalPin.equals(postal)
                        && stat.equals(state) && income.equals(inc) && education.equals(edu) && occupation.equals(occu) && senCity.equals(seniorCity) ){
                    JOptionPane.showMessageDialog(null,"There is no new information here.");
                } else if (phone.equals("")){
                    JOptionPane.showMessageDialog(null,"Please input your phone number.");
                } else if (mailAd.equals("")){
                    JOptionPane.showMessageDialog(null,"Please input your mail address.");
                } else{
                    Connection c = new Connection();
                    String q1 = "UPDATE signup SET " +
                            "phone_no = '" + phone + "', " +
                            "email = '" + mailAd + "', " +
                            "marital_status = '" + marital + "', " +
                            "address = '" + address + "', " +
                            "city = '" + cit + "', " +
                            "pincode = '" + postalPin + "', " +
                            "state = '" + stat + "' " +
                            "WHERE form_no = '" + formNo + "'";

                    String q2 = "UPDATE signup2 SET " +
                            "income = '" + income + "', " +
                            "education = '" + education + "', " +
                            "occupation = '" + occupation + "', " +
                            "senior_citizen = '" + senCity + "' " +
                            "WHERE form_no = '" + formNo + "'";

                    int rowsUpdated1 = c.statement.executeUpdate(q1);
                    int rowsUpdated2 = c.statement.executeUpdate(q2);

                    if (rowsUpdated1 > 0 && rowsUpdated2 > 0) {
                        JOptionPane.showMessageDialog(null, "Profile updated successfully");
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update profile");
                    }
                }
            } else if (e.getSource()==close) {
                setVisible(false);
            } else if (e.getSource()==updateAcc) {
                new UpdateAccount(cardno);
                setVisible(false);
            }
        } catch (Exception E){
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new UpdateProfile("");
    }
}
