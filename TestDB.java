import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {
    public static void main(String[] args) {
        String pass = "Root@1234";
        System.out.println("Testing with password: '" + pass + "'");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dcare", "root", pass);
            System.out.println("SUCCESS: Connected with password: '" + pass + "'");
            con.close();
        } catch (Exception e) {
            System.out.println("FAILED: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
