package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener{
    JComboBox comboBox,comboBox2,comboBox3,comboBox4;
    JTextField textNid,textPassport;
    JRadioButton r1,r2, e1,e2;
    JButton next;
    String formno;
    Signup2(String formno){
        super("ATM Management System by Ahona Rahman (SK-59)");

        ImageIcon icon = new ImageIcon(getClass().getResource("/icon/icoon.png"));
        setIconImage(icon.getImage());

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/provider.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,0,100,150);
        add(image);

        this.formno = formno;

        JLabel l1 = new JLabel("Page 2 :-");
        l1.setFont(new Font("Raleway", Font.BOLD,22));
        l1.setBounds(250,30,600,40);
        add(l1);

        JLabel l2 = new JLabel("Additonal Details");
        l2.setFont(new Font("Raleway", Font.BOLD,22));
        l2.setBounds(250,60,600,40);
        add(l2);

        JLabel l3 = new JLabel("Religion :");
        l3.setFont(new Font("Raleway", Font.BOLD,18));
        l3.setBounds(100,150,100,30);
        add(l3);

        String religion[] = {"Islam","Hinduism","Buddhism", "Christianity", "Judaism" ,"Indigenous Religions", "Non-Religious People", "Other"};
        comboBox = new JComboBox(religion);
        comboBox.setBackground(new Color(211, 211, 159));
        comboBox.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox.setBounds(350,150,320,30);
        add(comboBox);

        JLabel l4 = new JLabel("Income(per year) : ");
        l4.setFont(new Font("Raleway", Font.BOLD,18));
        l4.setBounds(100,200,200,30);
        add(l4);

        String income [] = {"Null","<1,50,000","<2,50,000", "5,00,000", "Up-to 10,00,000","Above 10,00,000"};
        comboBox2 = new JComboBox(income);
        comboBox2.setBackground(new Color(211, 211, 159));
        comboBox2.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox2.setBounds(350,200,320,30);
        add(comboBox2);

        JLabel l5 = new JLabel("Educational : ");
        l5.setFont(new Font("Raleway", Font.BOLD,18));
        l5.setBounds(100,250,150,30);
        add(l5);

        String educational [] = {"Non-Graduate","Undergraduate","Graduate","Post-Graduate", "Doctorate", "Others"};
        comboBox3 = new JComboBox(educational);
        comboBox3.setBackground(new Color(211, 211, 159));
        comboBox3.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox3.setBounds(350,250,320,30);
        add(comboBox3);

        JLabel l6 = new JLabel("Occupation : ");
        l6.setFont(new Font("Raleway", Font.BOLD,18));
        l6.setBounds(100,300,150,30);
        add(l6);

        String Occupation [] = {"Student", "Salaried","Self-Employed","Business", "Retired", "Other"};
        comboBox4 = new JComboBox(Occupation);
        comboBox4.setBackground(new Color(211, 211, 159));
        comboBox4.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox4.setBounds(350,300,320,30);
        add(comboBox4);

        JLabel l7 = new JLabel("*NID Number : ");
        l7.setFont(new Font("Raleway", Font.BOLD,18));
        l7.setBounds(100,350,150,30);
        add(l7);

        textNid = new JTextField();
        textNid.setFont(new Font("Raleway", Font.BOLD,18));
        textNid.setBounds(350,350,320,30);
        add(textNid);

        JLabel l8 = new JLabel("Passport Number : ");
        l8.setFont(new Font("Raleway", Font.BOLD,18));
        l8.setBounds(100,400,180,30);
        add(l8);

        textPassport = new JTextField();
        textPassport.setFont(new Font("Raleway", Font.BOLD,18));
        textPassport.setBounds(350,400,320,30);
        add(textPassport);

        JLabel l9 = new JLabel("Senior Citizen : ");
        l9.setFont(new Font("Raleway", Font.BOLD,18));
        l9.setBounds(100,450,180,30);
        add(l9);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD,14));
        r1.setBackground(new Color(213, 213, 115));
        r1.setBounds(350,450,100,30);
        add(r1);
        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD,14));
        r2.setBackground(new Color(213, 213, 115));
        r2.setBounds(460,450,100,30);
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel l10 = new JLabel("Existing Account : ");
        l10.setFont(new Font("Raleway", Font.BOLD,18));
        l10.setBounds(100,500,180,30);
        add(l10);

        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("Raleway", Font.BOLD,14));
        e1.setBackground(new Color(213, 213, 115));
        e1.setBounds(350,500,100,30);
        add(e1);
        e2 = new JRadioButton("No");
        e2.setFont(new Font("Raleway", Font.BOLD,14));
        e2.setBackground(new Color(213, 213, 115));
        e2.setBounds(460,500,100,30);
        add(e2);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(e1);
        buttonGroup1.add(e2);

        JLabel l11 = new JLabel("Form No : ");
        l11.setFont(new Font("Raleway", Font.BOLD,14));
        l11.setBounds(650,10,100,30);
        add(l11);

        JLabel l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD,14));
        l12.setBounds(710,10,60,30);
        add(l12);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setBounds(550,570,100,30);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        setSize(850,750);
        setLocation(450,40);
        getContentPane().setBackground(new Color(213, 213, 115));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rel = (String) comboBox.getSelectedItem();
        String inc = (String) comboBox2.getSelectedItem();
        String edu = (String) comboBox3.getSelectedItem();
        String occ = (String) comboBox4.getSelectedItem();
        String nid = textNid.getText();
        String passport = textPassport.getText();

        String scitizen = " ";
        if ((r1.isSelected())){
            scitizen = "Yes";
        } else if (r2.isSelected()) {
            scitizen ="No";
        }
        String eAccount = " ";
        if ((r1.isSelected())){
            eAccount = "Yes";
        } else if (r2.isSelected()) {
            eAccount ="No";
        }
        try{
            if (textNid.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please fill NID number");
            } else {
                Connection c = new Connection();
                String q = "insert into signup2 values('"+formno+"', '"+rel+"','"+inc+"','"+edu+"','"+occ+"','"+nid+"','"+passport+"','"+scitizen+"','"+eAccount+"')";
                c.statement.executeUpdate(q);
                new Signup3(formno);
                setVisible(false);
            }
        } catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup2("");
    }
}
