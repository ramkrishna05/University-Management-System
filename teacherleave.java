/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collagemanagment;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


/**
 *
 * @author ramkr
 */
public class teacherleave extends JFrame implements ActionListener {
    Choice cempid;
    JDateChooser dcdob;
    Choice tperiod;
    JButton submit;
    JButton cancel;
    
    teacherleave()
    {
        setSize(600,700);
        setLocation(600,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        //heading
        
        JLabel heading=new JLabel("Apply Leave (Teacher)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        JLabel lblrollno=new JLabel("search by Employee ID");
        lblrollno.setBounds(60,100,250,20);
         lblrollno.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblrollno);
        
        //add choice awt class
        cempid=new Choice();
        cempid.setBounds(60,130,200,20);
        add(cempid);
        
        try{
            conn c=new conn();
            String query="select * from teacher";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                cempid.add(rs.getString("empid"));
                
            }
            }
        catch(Exception e)
        {
           e.printStackTrace();
        }
        
        //which date leave 
        JLabel lbldate=new JLabel("Choose Date");
        lbldate.setBounds(60,180,250,20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbldate);
        
        dcdob=new JDateChooser();
        dcdob.setBounds(60,210,250,25);
        add(dcdob);
        
        //time period 
        
        JLabel time=new JLabel("Time Period ");
        time.setBounds(60,260,250,20);
         time.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(time);
        
        //add choice awt class
        tperiod=new Choice();
        tperiod.setBounds(60,290,200,20);
        tperiod.add("Full Day");
        tperiod.add("Half Day");
        add(tperiod);
        
        //submit button
        submit=new JButton("Submit");
        submit.setBounds(90,350,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif",Font.BOLD,15));
        add(submit);
        
        // cancel button
        cancel=new JButton("Cancel");
        cancel.setBounds(230,350,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
       cancel.addActionListener(this);
        cancel.setFont(new Font("serif",Font.BOLD,15));
        add(cancel);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
           String empid= cempid.getSelectedItem();
           String date=( (JTextField)dcdob.getDateEditor().getUiComponent()).getText();
           String duration=tperiod.getSelectedItem();
           
           String query="insert into teacherleave values('"+empid+"','"+date+"','"+duration+"')";
            try{
                conn c=new conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
                new landing();
                          
                 }
            catch(Exception e)
            {
                e.printStackTrace();
            }
           
        }
        else
        {
            setVisible(false);
            new landing();
            
        }
        
    }
    
    public static void main(String[] args)
    {
        new teacherleave();
    }
    
}

