/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collagemanagment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author ramkr
 */
public class landing extends JFrame implements ActionListener {
    
    landing()
    {
        setSize(1540,850);
       
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg")) ;
        Image i2=i1.getImage().getScaledInstance(1950,1080,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        //ImageIcon i3=new ImageIcon(i2);
        //image.setBounds(350,0,200,200);
        add(image);
        
        //this is menu bar mb
        JMenuBar mb=new JMenuBar();
        
        // first menu new information 
        JMenu new_information=new JMenu("New Information");
        new_information.setForeground(Color.RED);
        mb.add(new_information);
        
        //inside new info iteam faculty info
        JMenuItem facultyinfo=new JMenuItem("New faculty info");
        facultyinfo.setBackground(Color.white);
        facultyinfo.addActionListener(this);
        new_information.add(facultyinfo);
        
        
        //iteam second inside new information 
        JMenuItem studentinfo=new JMenuItem("New student info");
        studentinfo.setBackground(Color.WHITE);
        studentinfo.addActionListener(this);
        new_information.add(studentinfo);
        
        //new menu view details(second menu)
        JMenu view_details=new JMenu("view details");
        view_details.setForeground(Color.BLUE);
        mb.add(view_details);
        
        //inside view details iteam faculty details
        JMenuItem facultydetails=new JMenuItem("facultydetail");
        facultydetails.setBackground(Color.white);
        facultydetails.addActionListener(this);
        view_details.add(facultydetails);
        
        
        //iteam second inside view details, student details
        JMenuItem studentdetails=new JMenuItem("studentdetail");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        view_details.add(studentdetails);
        
        // new menu for apply leave 
        JMenu leave=new JMenu("Apply Leave");
        leave.setForeground(Color.RED);
        mb.add(leave);
        
        // add iteam student leave and Faculty leave
        JMenuItem f_leave=new JMenuItem("Faculty leave");
        f_leave.addActionListener(this);
        f_leave.setBackground(Color.WHITE);
        leave.add(f_leave);
        
         JMenuItem s_leave=new JMenuItem("Student leave");
         s_leave.setBackground(Color.WHITE);
         s_leave.addActionListener(this);
         leave.add(s_leave);
         
         //new menu for leave details 
         JMenu leavedetails=new JMenu("Leave Details");
         leavedetails.setForeground(Color.blue);
         mb.add(leavedetails);
         
         // add menu iteam student leave details and faculty leave details
         
          JMenuItem f_leave_details=new JMenuItem("Faculty leave details");
          f_leave_details.setBackground(Color.WHITE);
          f_leave_details.addActionListener(this);
          leavedetails.add(f_leave_details);
        
         JMenuItem s_leave_details=new JMenuItem("Student leave details");
         s_leave_details.setBackground(Color.WHITE);
         s_leave_details.addActionListener(this);
         leavedetails.add(s_leave_details);
         
         // new menu for examination 
         JMenu examination=new JMenu("Examination");
         examination.setForeground(Color.blue);
         mb.add(examination);
         
         // add in examination menu iteam , examination result && enter marks
         JMenuItem examination_result=new JMenuItem("Examination result");
          examination_result.setBackground(Color.WHITE);
          examination.add(examination_result);
        
         JMenuItem enter_marks=new JMenuItem("Enter Marks");
         enter_marks.setBackground(Color.WHITE);
         examination.add(enter_marks);
         
         // new menu update details
         JMenu updateinfo=new JMenu("Update Details");
         updateinfo.setForeground(Color.blue);
         mb.add(updateinfo);
         
         //add iteam in update details menu ,update student details update facultydetails
         
         JMenuItem updatestudentinfo=new JMenuItem("Update Student Details");
          updatestudentinfo.setBackground(Color.WHITE);
          updatestudentinfo.addActionListener(this);
         updateinfo.add(updatestudentinfo);
        
         JMenuItem updatefacultyinfo=new JMenuItem("Update Faculty Details");
         updatefacultyinfo.setBackground(Color.WHITE);
         updatefacultyinfo.addActionListener(this);
         updateinfo.add(updatefacultyinfo);
         
         //fee
         JMenu feeinfo=new JMenu("Fee Details");
         feeinfo.setForeground(Color.red);
         mb.add(feeinfo);
         
          JMenuItem feestructure=new JMenuItem("Fee Structure");
          feestructure.setBackground(Color.WHITE);
         feeinfo.add(feestructure);
        
         JMenuItem studenfeeform=new JMenuItem("Student Fee Form");
         studenfeeform.setBackground(Color.WHITE);
         feeinfo.add(studenfeeform);
         
         //utility
         JMenu utility=new JMenu("Utility");
         utility.setForeground(Color.red);
         mb.add(utility);
         
         JMenuItem notepad=new JMenuItem("Notepad");
          notepad.setBackground(Color.WHITE);
          notepad.addActionListener(this);
         utility.add(notepad);
        
         JMenuItem calculater=new JMenuItem("Calculater");
         calculater.setBackground(Color.WHITE);
         calculater.addActionListener(this);
         utility.add(calculater);
         
         //exit
         JMenu exit=new JMenu("Exit");
         exit.setForeground(Color.red);
         mb.add(exit);
         
          JMenuItem ex=new JMenuItem("Exit");
         ex.setBackground(Color.WHITE);
         ex.addActionListener(this);
         exit.add(ex);
         
         
         
         
         
         
         
         
         
         
           
         
         
           
        
       
        
        //setmenu bar
        setJMenuBar(mb);
        
        
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
       String msg=ae.getActionCommand();
       if(msg.equals("Exit"))
       {
           setVisible(false);
       }
       else if(msg.equals("Calculater"))
       {
           try{
               Runtime.getRuntime().exec("calc.exe");
               
           }
           catch(Exception e){
               
           }
       }
       else if(msg.equals("Notpad"))
       {
           try{
               Runtime.getRuntime().exec("notpad.exe");
               
           }
           catch(Exception e){
               
           }
       }
       else if(msg.equals("New faculty info"))
       {
           new addteacher();
       }
       else if(msg.equals("New student info"))
       {
           new addstudent();
       }
       else if(msg.equals("facultydetail"))
       {
           new teacherdetails();
       }
       else if(msg.equals("studentdetail"))
               {
                  new studentdetails(); 
               }
       else if(msg.equals("Faculty leave details"))
       {
           new teacherleavedetails();
       }
       else if(msg.equals("Student leave details"))
       {
           new studentleavedetails();
       }
       else if(msg.equals("Update Faculty Details"))
       {
           new updateteacher();
       }
       else if( msg.equals("Update Student Details"))
       {
           new updatestudent();
           
       }
       else if(msg.equals("Faculty leave"))
       {
           new studentleave();
       }
       else if(msg.equals("Student leave"))
       {
           new teacherleave();
       }
    }
    public static void main(String[] args)
    {
        new landing();
    }
}
