 
package collagemanagment;
import java.sql.*;

/**
 *
 * @author ramkr
 */
public class conn {
    Connection c;
    Statement s;
    
    conn()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           c=DriverManager.getConnection("jdbc:mysql:///universitydatabase","root","ram@6250A");
           s=c.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
