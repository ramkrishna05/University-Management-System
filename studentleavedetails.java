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
public class studentleavedetails extends JFrame implements ActionListener {
    Choice crollnum;
    JButton print,search,cancel;
    JTable table;
    
    studentleavedetails()
    {
        setSize(1050,800);
        setLocation(500,150);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //heading 
        JLabel heading=new JLabel("Search by Roll Number");
        heading.setBounds(20,20,250,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        crollnum=new Choice();
        crollnum.setBounds(280,20,150,20);
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
            String query="select *from studentleave";
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
               String query="select * from studentleave where roono='"+crollnum.getSelectedItem()+"'";
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
        new studentleavedetails();
    }
}
