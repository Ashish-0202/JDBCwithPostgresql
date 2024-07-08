import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresqlConnection {

    Connection con1=null;

    public Connection connection(String dbname,String dbuser, String dbpassword){

        String URL="jdbc:postgresql://localhost:5432/"+dbname;

        //String username="postgres";

        try {
            con1= DriverManager.getConnection(URL,dbuser,dbpassword);
            if(con1!=null){
                System.out.println("Connection Established");
            }else {
                System.out.println("Connection Failed");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return con1;
    }
}
