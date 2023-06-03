 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collagemanagment;
import javax.swing.*;
import java.awt.*;
//import static java.awt.Color.WHITE;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author ramkr
 */
public class Login extends JFrame implements ActionListener {
   JButton loginbutton;
   JButton close;
   JTextField taxt;
   JPasswordField pass;
    Login()
    {
         
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel username=new JLabel("USERNAME");
        username.setBounds(40,20,100,20);
        add(username);
        //add(username);
        taxt=new JTextField( );
        taxt.setBounds(150,20,150,20);
        add(taxt);
        
        JLabel password=new JLabel("PASSWORD");
        password.setBounds(40,70,100,20);
        add(password);
        pass=new JPasswordField();
        pass.setBounds(150,70,150,20);
        add(pass);
        
        loginbutton=new JButton("Log in");
        loginbutton.setBounds(40,140,120,30);
        loginbutton.setBackground(Color.BLACK);
        loginbutton.setForeground(Color.WHITE);
        loginbutton.addActionListener(this);
        loginbutton.setFont(new Font("serif",Font.BOLD,15));
        add(loginbutton);
        
        close=new JButton("CLOSE");
        close.setBounds(180,140,120,30);
        close.setBackground(Color.BLACK);
        close.setForeground(Color.WHITE);
        close.addActionListener(this);
        close.setFont(new Font("serif",Font.BOLD,15));
        add(close);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg")) ;
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        //ImageIcon i3=new ImageIcon(i2);
        image.setBounds(350,0,200,200);
        add(image);
        
        
        
        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
        
     
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==loginbutton)
        {
            String username=taxt.getText();
            String password=pass.getText();
            String  query="select*from login where username='"+username+"'and password='"+password+"'";
            
            try{
                conn c=new conn();
              ResultSet rs=  c.s.executeQuery(query);
              if(rs.next())
              {
                  setVisible(false);
                new  landing();
                  
              }
              else
              {
                 JOptionPane.showMessageDialog(null,"Invalid username or password");
                 setVisible(false);
               }
              
            }
            catch(Exception e)
            {
              e.printStackTrace();
            }
        }    
        else if(ae.getSource()==close)
        {
            setVisible(false);
        }
        
    }
    public static void main(String[] args)
    {
        new Login();
    }
    
}
