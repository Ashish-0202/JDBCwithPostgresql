import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//This is a direct method access jdbc in main method
public class JDBC {
    public static void main(String[] args) {

        String sql = "select book_name from books where id=4";

        String sql1 = "Insert into books values(4,'React')";

        String sql3="Update books set book_name='Java 8' where id=2";

        //But this method is not correct because we are not suppose to hardcode the jdbc username password here
        //To avoid this we can create a connection in separate class and call the method in DAO class
        String URL = "jdbc:postgresql://localhost:5432/Demo";

        String username = "postgres";

        String password = "";

        Connection con = null;
        try {
            System.out.println("triggering connection");
            con = DriverManager.getConnection(URL, username, password);
            System.out.println("Connection successful..!");
            //PreparedStatement statement= con.prepareStatement(sql);
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(sql);
            set.next();
            System.out.println(set.getString(1));
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}