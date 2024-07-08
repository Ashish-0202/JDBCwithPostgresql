import java.sql.SQLException;

public class DAOservice {
    public static void main(String[] args) {
        DAOimpl daOimpl= new DAOimpl();

        try {
            //daOimpl.create_table("demotable");
            //daOimpl.insert_record("demotable","Pen",50);
            daOimpl.read_data("demotable");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
