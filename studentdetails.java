/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collagemanagment;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


/**
 *
 * @author ramkr
 */
public class studentdetails extends JFrame implements ActionListener {
    Choice crollnum;
    JTable table;
    JButton search,print,update,add,cancel;
    
    studentdetails()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //heading
        JLabel heading=new JLabel("search by Roll number");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        //add choice awt class
        crollnum=new Choice();
        crollnum.setBounds(180,20,150,20);
        add(crollnum);
        
        try{
            conn c=new conn();
            String query="select * from student";
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
         table=new JTable();
         JScrollPane jsp=new JScrollPane(table);
         jsp.setBounds(20,100,1050,700);
         try{
            conn c=new conn();
            String query="select * from student";
            ResultSet rs=c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
           
            }
        catch(Exception e)
        {
           e.printStackTrace();
        }
         add(jsp);
         
         search=new JButton("Search");
         search.setBounds(40,70,80,20);
         search.addActionListener(this);
         add(search);
         
         //update 
         update=new JButton("Update");
         update.setBounds(130,70,80,20);
         update.addActionListener(this);
         add(update);
         
         //add
         add=new JButton("Add");
         add.setBounds(220,70,80,20);
         add.addActionListener(this);
         add(add);
         
         //print
         print=new JButton("print");
         print.setBounds(310,70,80,20);
         print.addActionListener(this);
         add(print);
         
         //cancel
         cancel=new JButton("Cancel");
         cancel.setBounds(400,70,80,20);
         cancel.addActionListener(this);
         add(cancel);
         
         
         
         
        
        setSize(1050,800);
        setLocation(300,100);
        
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==search)
        {
          String query="select*from student where rollno='"+crollnum.getSelectedItem()+"' "  ; 
          try{
              conn c=new conn();
              ResultSet rs=c.s.executeQuery(query);
              table.setModel(DbUtils.resultSetToTableModel(rs));

              
              
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
        }
        else if(ae.getSource()==update)
        {
            
        }
        else if(ae.getSource()==add)
        {
            new addstudent();
            
        }
        else if(ae.getSource()==print)
        {
           try{
               table.print();
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
    
    public static void main(String[] args){
        new studentdetails();
        
    }
    
}
