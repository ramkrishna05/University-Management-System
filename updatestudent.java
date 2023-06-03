/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collagemanagment;
import javax.swing.*;
import java.awt.*;
//import java.util.Random;
import java.awt.event.*;
import java.sql.ResultSet;

/**
 *
 * @author ramkr
 */

   
public class updatestudent extends JFrame implements ActionListener {
    JTextField tfcourse,addresst,phonenot,emailt ,tfbranch;
    
    JLabel rollonolabel;
    //JDateChooser dcdob;
    //JComboBox coursebox;
    //JComboBox branchbox;
    JButton submit;
    JButton cancel;
    Choice crollnum;
           
   

    updatestudent()
    {
       // this.<error> = new Random();
        //set fram size and location
        setSize(900,700);
        setLocation(350,50);
        //choice layout 
        setLayout(null);
        
        //heading new student details 
        JLabel heading=new JLabel("Update Student Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        add(heading);
        
        JLabel lblrollno=new JLabel("Search by Roll Number");
        lblrollno.setBounds(50,100,400,30);
        lblrollno.setFont(new Font("serif",Font.ITALIC,35));
        add(lblrollno);
        
        crollnum=new Choice();
        crollnum.setBounds(450,100,200,20);
        crollnum.setFont(new Font("Tahoma",Font.BOLD,18));
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
        
        //now i created a from help of label and trxtfield 
        //name 
        JLabel name=new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);
        
        JLabel lblname=new JLabel();
        lblname.setBounds(200,150,150,30);
        lblname.setFont(new Font("Tahoma",Font.BOLD,18));

        add(lblname);
        
        //father name
        JLabel fname=new JLabel("Father Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);
        
        JLabel lblfname=new JLabel();
        lblfname.setBounds(600,150,150,30);
        lblfname.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lblfname);
        
        //roll no.
        JLabel rollno=new JLabel("Roll no.");
        rollno.setBounds(50,200,200,30);
        rollno.setFont(new Font("serif",Font.BOLD,20));
        add(rollno);
        
        rollonolabel=new JLabel();
        rollonolabel.setBounds(200,200,200,30);
        rollonolabel.setFont(new Font("Tahoma",Font.BOLD,18));
        add(rollonolabel);
        
        //dob
        JLabel dob=new JLabel("Date of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);
        
        JLabel lbldob=new JLabel();
        lbldob.setBounds(600,200,150,30);
        lbldob.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lbldob);
        
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
        
        JLabel lblx=new JLabel();
        lblx.setBounds(600,300,150,30);
        lblx.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lblx);
        
        //class 12 th parcent 
        JLabel class12=new JLabel("Class 12%");
        class12.setBounds(50,350,200,30);
        class12.setFont(new Font("serif",Font.BOLD,20));
        add(class12);
        
        JLabel lblxii=new JLabel();
        lblxii.setBounds(200,350,150,30);
        lblxii.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lblxii);
       
        // aadhar no.
        JLabel aadharno=new JLabel("Aadhar number");
        aadharno.setBounds(400,350,200,30);
        aadharno.setFont(new Font("serif",Font.BOLD,20));
        add(aadharno);
        
        JLabel lblaadhar=new JLabel();
        lblaadhar.setBounds(600,350,150,30);
        lblaadhar.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lblaadhar);
        
        //course name drop down 
        
        JLabel coursename=new JLabel("Course");
        coursename.setBounds(50,400,200,30);
        coursename.setFont(new Font("serif",Font.BOLD,20));
        add(coursename);
        
        //deop down
        tfcourse=new JTextField();
        //tfcourse.setBackground(Color.WHITE);
        tfcourse.setBounds(200,400,150,30);
        add(tfcourse);
        
        //branch drop down 
        JLabel branchname=new JLabel("Branch");
        branchname.setBounds(400,400,200,30);
        branchname.setFont(new Font("serif",Font.BOLD,20));
        add(branchname);
        
        tfbranch=new JTextField();
        tfbranch.setBackground(Color.WHITE);
        tfbranch.setBounds(600,400,150,30);
        add(tfbranch);
        
        
        
        //submit button
        try {
            conn c= new conn();
            String query ="select *from student where rollno='"+crollnum.getSelectedItem()+"'";
                    ResultSet rs=c.s.executeQuery(query);
                  while(rs.next())
                  {
                     lblname.setText(rs.getString("name"));
                     lblfname.setText(rs.getString("fname"));
                     lbldob.setText(rs.getString("dob"));
                     addresst.setText(rs.getString("address"));
                     phonenot.setText(rs.getString("phone"));
                     emailt.setText(rs.getString("email"));  
                     lblx.setText(rs.getString("class_10"));
                     lblxii.setText(rs.getString("class_12"));
                     lblaadhar.setText(rs.getString("aadhar"));
                     rollonolabel .setText(rs.getString("rollno"));
                     tfcourse.setText(rs.getString("course"));
                     tfbranch .setText(rs.getString("branch"));
                     

                  }
                    
            
            
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
        crollnum.addItemListener(new ItemListener()
        {
          public void itemStateChanged(ItemEvent ie)
          {
              try {
            conn c= new conn();
            String query ="select *from student where rollno='"+crollnum.getSelectedItem()+"'";
                    ResultSet rs=c.s.executeQuery(query);
                       while(rs.next())
                  {
                        lblname.setText(rs.getString("name"));
                        lblfname.setText(rs.getString("fname"));
                        lbldob.setText(rs.getString("dob"));
                        addresst.setText(rs.getString("address"));
                        phonenot.setText(rs.getString("phone"));
                        emailt.setText(rs.getString("email"));  
                        lblx.setText(rs.getString("class_10"));
                        lblxii.setText(rs.getString("class_12"));
                        lblaadhar.setText(rs.getString("aadhar"));
                        rollonolabel .setText(rs.getString("rollno"));
                        tfcourse.setText(rs.getString("course"));
                         tfbranch .setText(rs.getString("branch"));
                     

                  }
                    
            
            
                     }
        catch(Exception e)
        {
          e.printStackTrace();
        }
          }
        });
        submit=new JButton("Update");
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
            String rollno=rollonolabel.getText();
            String address=addresst.getText();
            String phone=phonenot.getText();
            String email=emailt.getText();
            String course=tfcourse.getText();
            String branch=tfbranch.getText();
            
            try{
                String query= "update student set address='"+address+"',phone='"+phone+"',email='"+email+"',course='"+course+"',branch='"+branch+"' where rollno='"+rollno+"'";
                conn c= new conn();
                c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"Student details Updated Successfully");
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
        new updatestudent();
    }
    
}

