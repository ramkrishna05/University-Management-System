/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collagemanagment;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
//import net.proteanit.sql.DbUtils;
import java.awt.event.*;


/**
 *
 * @author ramkr
 */
public class teacherleavedetails extends JFrame implements ActionListener {
    Choice cempid;
    JButton print,search,cancel;
    JTable table;
    
    teacherleavedetails()
    {
        setSize(1050,800);
        setLocation(500,150);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //heading 
        JLabel heading=new JLabel("Search by Employee ID");
        heading.setBounds(20,20,250,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        cempid=new Choice();
        cempid.setBounds(280,20,150,20);
        add(cempid);
        try{
            conn c=new conn();
            String query="select*from teacher";
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
        
        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        //print button
        print =new JButton("Print");
        print.setBounds(110,70,80,20);
        print.addActionListener(this);
        add(print);
        
        //cancel
        cancel=new JButton("Cancel");
        cancel.setBounds(200,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
        
        
        //create table 
        table=new JTable();
        JScrollPane jsp= new JScrollPane(table);
        jsp.setBounds(10,150,1050,700);
        add(jsp);
        
        try
        {
            conn c=new conn();
            String query="select *from teacherleave";
            ResultSet rs=c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        
        
        
        
        
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==search)
        {
           try{
               conn c=new conn();
               String query="select * from teacherleave where empid='"+cempid.getSelectedItem()+"'";
               ResultSet rs=c.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
               
           } 
           catch(Exception e)
           {
               e.printStackTrace();
           }
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
    public static void main(String[] args)
    {
        new teacherleavedetails();
    }
}
