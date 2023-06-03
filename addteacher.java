/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collagemanagment;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
//import java.util.Random;
import java.awt.event.*;
/**
 *
 * @author ramkr
 */

   
public class addteacher extends JFrame implements ActionListener {
    JTextField namet,addresst,phonenot,emailt,class10t,class12t;
    JTextField fnamet,aadharnot;
    JLabel labelempid;
    JDateChooser dcdob;
    JComboBox coursebox;
    JComboBox branchbox;
    JButton submit;
    JButton cancel;
           
   Random ran=new Random();
   long randomValue = ran.nextLong() % 9000L;
   long positiveValue = Math.abs(randomValue)+1000;
   

    addteacher()
    {
       // this.<error> = new Random();
        //set fram size and location
        setSize(900,700);
        setLocation(350,50);
        //choice layout 
        setLayout(null);
        
        //heading new student details 
        JLabel heading=new JLabel("New Teacher details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        //now i created a from help of label and trxtfield 
        //name 
        JLabel name=new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);
        
        namet=new JTextField();
        namet.setBounds(200,150,150,30);
        add(namet);
        
        //father name
        JLabel fname=new JLabel("Father Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);
        
        fnamet=new JTextField();
        fnamet.setBounds(600,150,150,30);
        add(fnamet);
        
        //roll no.
        JLabel empid=new JLabel("Employee Id");
        empid.setBounds(50,200,200,30);
        empid.setFont(new Font("serif",Font.BOLD,20));
        add(empid);
        
        labelempid =new JLabel("101"+positiveValue);
        labelempid.setBounds(200,200,200,30);
        labelempid.setFont(new Font("serif",Font.BOLD,20));
        add(labelempid);
        
        //dob
        JLabel dob=new JLabel("Date of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);
        
        dcdob=new JDateChooser();
        dcdob.setBounds(600,200,150,30);
        add(dcdob);
        
        //address
        JLabel address=new JLabel("Address");
        address.setBounds(50,250,200,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);
        
        addresst=new JTextField();
        addresst.setBounds(200,250,150,30);
        add(addresst);
        
        //phone no
        JLabel phoneno=new JLabel("Phone No.");
        phoneno.setBounds(400,250,200,30);
        phoneno.setFont(new Font("serif",Font.BOLD,20));
        add(phoneno);
        
        phonenot=new JTextField();
        phonenot.setBounds(600,250,150,30);
        add(phonenot);
        
        //email
        JLabel email=new JLabel("email");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);
        
        emailt=new JTextField();
        emailt.setBounds(200,300,150,30);
        add(emailt);
        
        //class 10th %
        JLabel class10=new JLabel("class10%");
        class10.setBounds(400,300,200,30);
        class10.setFont(new Font("serif",Font.BOLD,20));
        add(class10);
        
        class10t=new JTextField();
        class10t.setBounds(600,300,150,30);
        add(class10t);
        
        //class 12 th parcent 
        JLabel class12=new JLabel("Class 12%");
        class12.setBounds(50,350,200,30);
        class12.setFont(new Font("serif",Font.BOLD,20));
        add(class12);
        
        class12t=new JTextField();
        class12t.setBounds(200,350,150,30);
        add(class12t);
       
        // aadhar no.
        JLabel aadharno=new JLabel("Aadhar number");
        aadharno.setBounds(400,350,200,30);
        aadharno.setFont(new Font("serif",Font.BOLD,20));
        add(aadharno);
        
        aadharnot=new JTextField();
        aadharnot.setBounds(600,350,150,30);
        add(aadharnot);
        
        //course name drop down 
        
        JLabel coursename=new JLabel("Qualification");
        coursename.setBounds(50,400,200,30);
        coursename.setFont(new Font("serif",Font.BOLD,20));
        add(coursename);
        
        //deop down
        String courselist[]={"Btech","Mtech","Bsc","Msc","Ba","Ma","Msc","Bba","Mba"};
        coursebox=new JComboBox(courselist);
        coursebox.setBackground(Color.WHITE);
        coursebox.setBounds(200,400,150,30);
        add(coursebox);
        
        //branch drop down 
        JLabel branchname=new JLabel("Department");
        branchname.setBounds(400,400,200,30);
        branchname.setFont(new Font("serif",Font.BOLD,20));
        add(branchname);
        
        String branchlist[]={"Computer Science","Electronic","Mechanical","Civil","IT","Arts","Management"};
        branchbox=new JComboBox(branchlist);
        branchbox.setBackground(Color.WHITE);
        branchbox.setBounds(600,400,150,30);
        add(branchbox);
        
        //submit button
        submit=new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif",Font.BOLD,15));
        add(submit);
        
        // cancel button
        cancel=new JButton("Cancel");
        cancel.setBounds(400,550,120,30);
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
            String name=namet.getText();
            String fname=fnamet.getText();
            String empid=labelempid.getText();
            String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address=addresst.getText();
            String phone=phonenot.getText();
            String email=emailt.getText();
            String x=class10t.getText();
            String xii=class12t.getText();
            String aadhar=aadharnot.getText();
            String course=(String)coursebox.getSelectedItem();
            String branch= (String)branchbox.getSelectedItem();
            
            try{
                String query= "insert into teacher values('"+name+"','"+fname+"','"+empid+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";
                conn c= new conn();
                c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"Teacher details inserted Successfully");
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
        } 
        
    }
    public static void main(String[]args)
    {
        new addteacher();
    }
    
}

