import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOimpl {


    PostgresqlConnection connection= new PostgresqlConnection();

    Connection con=connection.connection("Demo","postgres","null");;

    public void create_table(String tname) throws SQLException {

        if(con == null){
            System.out.println("Connection Failed..!");
        }else {
            System.out.println("Connection is successfull..!");
        }
        Statement st= con.createStatement();

        String query="drop table if exists "+tname +"; create table "+tname+" (id SERIAL,name varchar(200),quantity smallint ,primary key(id));";

        int rows= st.executeUpdate(query);

        System.out.println("Query executed and "+rows+" affected..!");
    }

    public void insert_record(String table_name,String name,int quantity) throws SQLException {

        if(con!=null) {
            System.out.println("Connected to database..!");
            Statement st = con.createStatement();

            String query=String.format("insert into %s (name,quantity) values ('%s',%d)",table_name,name,quantity);

            int rows = st.executeUpdate(query);

            System.out.println("Records Inserted "+rows+ "rows affected.!");

        }else {
            System.out.println("Connection Failed..!");
        }
    }

    public void read_data(String table_name) throws SQLException{
        Statement st= con.createStatement();

        if(con!=null){
            System.out.println("----------------------");
            System.out.println("Connected to database & reading data");
            String query = String.format("select * from %s",table_name);

            ResultSet set= st.executeQuery(query);

            while (set.next()){
                System.out.print(set.getString("id")+" ");
                System.out.print(set.getString("name")+" ");
                System.out.println(set.getString("quantity"));
            }
        }
    }
}
