package bank.managment.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Signup extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,m1,m2,m3;
    JButton next, login;
    JTextField textName ,textFname, textEmail,textAdd,textcity,textState,textPin,textPhno;
    JDateChooser dateChooser;
    Random ran = new Random();
    long first4 =(ran.nextLong() % 9000L) +1000L;
    String first = " " + Math.abs(first4);
    Signup(){
        super ("ATM Management System by Ahona Rahman (SK-59)");

        ImageIcon icon = new ImageIcon(getClass().getResource("/icon/icoon.png"));
        setIconImage(icon.getImage());

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm1.png"));
        Image i2 = i1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,0,100,150);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO."+ first);
        label1.setBounds(160,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Ralway",Font.BOLD, 22));
        label2.setBounds(343,70,600,30);
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway", Font.BOLD,22));
        label3.setBounds(290,93,600,30);
        add(label3);

        JLabel labelName = new JLabel("*Name :");
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelName.setBounds(100,150,100,30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD, 14));
        textName.setBounds(300,150,400,30);
        add(textName);

        JLabel labelfName = new JLabel("Father's Name :");
        labelfName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelfName.setBounds(100,200,200,30);
        add(labelfName);

        textFname = new JTextField();
        textFname.setFont(new Font("Raleway",Font.BOLD, 14));
        textFname.setBounds(300,200,400,30);
        add(textFname);

        JLabel labelG = new JLabel("Gender");
        labelG.setFont(new Font("Raleway", Font.BOLD, 20));
        labelG.setBounds(100,250,200,30);
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD,14));
        r1.setBackground(new Color(222,255,228));
        r1.setBounds(300,250,60,30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(new Color(222,255,228));
        r2.setFont(new Font("Raleway", Font.BOLD,14));
        r2.setBounds(450,250,90,30);
        add(r2);

        r3 = new JRadioButton("Other");
        r3.setBackground(new Color(222,255,228));
        r3.setFont(new Font("Raleway", Font.BOLD,14));
        r3.setBounds(600,250,90,30);
        add(r3);

        ButtonGroup buttonGroup = new ButtonGroup();        //select only one
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);

        JLabel DOB = new JLabel("*Date of Birth");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(100,300,200,30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,300,400,30);
        add(dateChooser);

        JLabel labelPhno = new JLabel("*Phone no. :");
        labelPhno.setFont(new Font("Raleway", Font.BOLD, 20));
        labelPhno.setBounds(100,345,200,30);
        add(labelPhno);

        textPhno = new JTextField();
        textPhno.setFont(new Font("Raleway",Font.BOLD, 14));
        textPhno.setBounds(300,345,400,30);
        add(textPhno);

        JLabel labelEmail = new JLabel("*Email address :");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEmail.setBounds(100,390,200,30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway",Font.BOLD, 14));
        textEmail.setBounds(300,390,400,30);
        add(textEmail);

        JLabel labelMs = new JLabel("Marital Status :");
        labelMs.setFont(new Font("Raleway", Font.BOLD, 20));
        labelMs.setBounds(100,440,200,30);
        add(labelMs);

        m1 = new JRadioButton("Married");
        m1.setBounds(300,440,100,30);
        m1.setBackground(new Color(222,255,228));
        m1.setFont(new Font("Raleway", Font.BOLD,14));
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setBackground(new Color(222,255,228));
        m2.setBounds(450,440,100,30);
        m2.setFont(new Font("Raleway", Font.BOLD,14));
        add(m2);

        m3 = new JRadioButton("Other");
        m3.setBackground(new Color(222,255,228));
        m3.setBounds(635,440,100,30);
        m3.setFont(new Font("Raleway", Font.BOLD,14));
        add(m3);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(m1);
        buttonGroup1.add(m2);
        buttonGroup1.add(m3);

        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAdd.setBounds(100,490,200,30);
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setFont(new Font("Raleway",Font.BOLD, 14));
        textAdd.setBounds(300,490,400,30);
        add(textAdd);

        JLabel labelCity = new JLabel("City :");
        labelCity.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCity.setBounds(100,540,200,30);
        add(labelCity);

        textcity = new JTextField();
        textcity.setFont(new Font("Raleway",Font.BOLD, 14));
        textcity.setBounds(300,540,400,30);
        add(textcity);

        JLabel labelPin = new JLabel("Postal Code :");
        labelPin.setFont(new Font("Raleway", Font.BOLD, 20));
        labelPin.setBounds(100,590,200,30);
        add(labelPin);

        textPin = new JTextField();
        textPin.setFont(new Font("Raleway",Font.BOLD, 14));
        textPin.setBounds(300,590,400,30);
        add(textPin);

        JLabel labelstate = new JLabel("State :");
        labelstate.setFont(new Font("Raleway", Font.BOLD, 20));
        labelstate.setBounds(100,640,200,30);
        add( labelstate);

        textState = new JTextField();
        textState.setFont(new Font("Raleway",Font.BOLD, 14));
        textState.setBounds(300,640,400,30);
        add(textState);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD, 18));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,710,80,30);
        next.addActionListener(this);
        add(next);

        JLabel labelLogin = new JLabel("Already have an account?");
        labelLogin.setFont(new Font("Raleway", Font.ITALIC, 12));
        labelLogin.setBounds(100,690,200,30);
        add( labelLogin);

        login = new JButton("LogIn");
        login.setFont(new Font("Raleway",Font.BOLD, 16));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBounds(120,720,100,30);
        login.addActionListener(this);
        add(login);

        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(850,800);
        setLocation(360,10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==login){
            new Login();
            setVisible(false);
        } else{
            String formno = first;
            String name = textName.getText();
            String fname = textFname.getText();
            String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            String gender = null;
            if(r1.isSelected()){
                gender = "Male";
            } else if (r2.isSelected()){
                gender = "Female";
            } else if (r3.isSelected()){
                gender = "Other";
            }
            String phone = textPhno.getText();
            String email = textEmail.getText();
            String marital =null;
            if (m1.isSelected()){
                marital = "Married";
            } else if (m2.isSelected()) {
                marital = "Unmarried";
            } else if (m3.isSelected()) {
                marital = "Other";
            }
            String address = textAdd.getText();
            String city = textcity.getText();
            String pincode = textPin.getText();
            String state = textState.getText();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date birthDate = dateChooser.getDate();     // Get the birthdate from the date chooser
            if (birthDate == null) {
                JOptionPane.showMessageDialog(null, "Please select a valid Date of Birth");
                return;
            }

            String currentDate = sdf.format(new Date());    // Get the current date
            String enteredDate = sdf.format(birthDate);

            try{
                Date date1 = sdf.parse(enteredDate);
                Date date2 = sdf.parse(currentDate);
                long diff = date2.getTime() - date1.getTime();
                long age = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) / 365;

                if (textName.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill your Name");
                    return;
                } if (dob.equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill your Date of Birth");
                    return;
                } if (textPhno.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill your Phone no");
                    return;
                } if (textEmail.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill your Email address");
                    return;
                } if (age < 18) {
                    JOptionPane.showMessageDialog(null, "You must be at least 18 years old to sign up.");
                } else {
                    Connection c = new Connection();
                    String q = "insert into signup values('"+formno+"', '"+name+"','"+fname+"','"+gender+"','"+dob+"','"+phone+"','"+email+"','"+marital+"', '"+address+"', '"+city+"','"+pincode+"','"+state+"' )";
                    c.statement.executeUpdate(q);
                    new Signup2(formno);
                    setVisible(false);      //form 1 close
                }
            } catch (Exception E){
                E.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
