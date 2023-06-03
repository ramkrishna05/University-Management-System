/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collagemanagment;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
/**
 *
 * @author ramkr
 */
public class entermarks  extends JFrame implements ActionListener{
    Choice crollnum;
    JComboBox cbsemester;
    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfmark1,tfmark2,tfmark3,tfmark4,tfmark5;
    JButton submit,cancel;
    entermarks()
    {
        setSize(1350,800);
        setLocation(300,150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
         ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg")) ;
        Image i2=i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        //ImageIcon i3=new ImageIcon(i2);
        image.setBounds(800,20,400,300);
        add(image);
        
        //heading new student details 
        JLabel heading=new JLabel("Enter Marks Of Student");
        heading.setBounds(40,10,400,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        JLabel lblrollno=new JLabel("Select Roll Number");
        lblrollno.setBounds(40,80,150,25);
    //    lblrollno.setFont(new Font("serif",Font.PLAIN,35));
        add(lblrollno);
        
        crollnum=new Choice();
        crollnum.setBounds(190,80,150,20);
        //crollnum.setFont(new Font("serif",Font.PLAIN,20));
        add(crollnum);
        try{
            conn c=new conn();
            String query="select*from student";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
            crollnum.add(rs.getString("rollno"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        JLabel lblsemester=new JLabel("Select Semester");
        lblsemester.setBounds(40,120,150,20);
      //  lblsemester.setFont(new Font("serif",Font.PLAIN,35));
        add(lblsemester);
      
        String sem[]={"1st semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};
        cbsemester=new JComboBox(sem);
        cbsemester.setBounds(190,120,150,20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel lblentersub=new JLabel("Enter Subject");
        lblentersub.setBounds(100,250,200,30);
      //  lblsemester.setFont(new Font("serif",Font.PLAIN,35));
        add(lblentersub);
        
        JLabel lblentermarks=new JLabel("Enter Marks");
        lblentermarks.setBounds(350,250,200,30);
      //  lblsemester.setFont(new Font("serif",Font.PLAIN,35));
        add(lblentermarks);
        
        tfsub1=new JTextField();
        tfsub1.setBounds(50,300,200,20);
        add(tfsub1);
        
        tfmark1=new JTextField();
        tfmark1.setBounds(260,300,200,20);
        add(tfmark1);
        
        tfsub2=new JTextField();
        tfsub2.setBounds(50,350,200,20);
        add(tfsub2);
        
        tfmark2=new JTextField();
        tfmark2.setBounds(260,350,200,20);
        add(tfmark2);
        
        tfsub3=new JTextField();
        tfsub3.setBounds(50,400,200,20);
        add(tfsub3);
        
        tfmark3=new JTextField();
        tfmark3.setBounds(260,400,200,20);
        add(tfmark3);
        
        tfsub4=new JTextField();
        tfsub4.setBounds(50,450,200,20);
        add(tfsub4);
        
        tfmark4=new JTextField();
        tfmark4.setBounds(260,450,200,20);
        add(tfmark4);
        
        tfsub5=new JTextField();
        tfsub5.setBounds(50,500,200,20);
        add(tfsub5);
        
        tfmark5=new JTextField();
        tfmark5.setBounds(260,500,200,20);
        add(tfmark5);
        
        submit=new JButton("Submit");
        submit.setBounds(100,550,120,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(cbsemester);
        submit.addActionListener(this);
        add(submit);  
        
        cancel=new JButton("Cancel");
        cancel.setBounds(230,550,120,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(cbsemester);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
        
        setVisible(true);
        
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
           String rollno=crollnum.getSelectedItem();
           String semester=cbsemester.getSelectedItem().toString();
           String sub1=tfsub1.getText();
           String sub2=tfsub2.getText();
           String sub3=tfsub3.getText();
           String sub4=tfsub4.getText();
           String sub5=tfsub5.getText();
           String mark1=tfmark1.getText();
           String mark2=tfmark2.getText();
           String mark3=tfmark3.getText();
           String mark4=tfmark4.getText();
           String mark5=tfmark5.getText();
           try
           {
               conn c=new conn();
               String query="insert into subject values('"+rollno+"','"+semester+"','"+sub1+"','"+sub2+"','"+sub3+"','"+sub4+"','"+sub5+"')";
               String query2="insert into marks values('"+rollno+"','"+semester+"','"+mark1+"','"+mark2+"','"+mark3+"','"+mark4+"','"+mark5+"')";
               c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Marks Inserted Sucessfully");
                setVisible(false);
                new landing();
           }
           catch (Exception e){
               e.printStackTrace();
           }
        }
        else
        {
            setVisible(true);
            new landing();
        }
    }
    public static void main(String[] args)
    {
        new entermarks();
    }
    
}
