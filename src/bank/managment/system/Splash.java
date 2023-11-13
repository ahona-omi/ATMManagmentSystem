package bank.managment.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    JLabel label1, label2, label3, label4, label5;
    Thread t;
    Splash(){
        super("ATM Management System by Ahona Rahman (SK-59)");

        ImageIcon icon = new ImageIcon(getClass().getResource("/icon/icoon.png"));
        setIconImage(icon.getImage());

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/screen.png"));
        Image iii2 = i1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0,0,850,480);
        add(iiimage);

        label1 = new JLabel("ATM MANAGEMENT SYSTEM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 28));
        label1.setBounds(80,25,850,400);
        add(label1);

        label2 = new JLabel("Developed by:");
        label2.setFont(new Font("Ralway", Font.BOLD, 16));
        label2.setForeground(Color.WHITE);
        label2.setBounds(50, 90, 375, 30);
        add(label2);

        label3 = new JLabel("Ahona Rahman");
        label3.setFont(new Font("Ralway", Font.BOLD, 18));
        label3.setForeground(Color.WHITE);
        label3.setBounds(50, 140, 375, 30);
        add(label3);

        label4 = new JLabel("CSE, University of Dhaka");
        label4.setFont(new Font("Ralway", Font.BOLD, 17));
        label4.setForeground(Color.WHITE);
        label4.setBounds(50, 190, 375, 30);
        add(label4);

        label5 = new JLabel("Roll: SK-59");
        label5.setFont(new Font("Ralway", Font.BOLD, 17));
        label5.setForeground(Color.WHITE);
        label5.setBounds(50, 240, 375, 30);
        add(label5);

        t = new Thread(this);
        t.start();

        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
        setVisible(true);

    }

    public void run(){
        try{
            Thread.sleep(2000);
            new Login();
            setVisible(false);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Splash s = new Splash();
    }
}