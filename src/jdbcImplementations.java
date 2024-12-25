import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcImplementations {
    public static void main(String[] args) throws ClassNotFoundException{
        String jdbcURL = "jdbc:mysql://localhost:3306/students";
        String username = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection connect = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to Database");

            Statement statement = connect.createStatement();

            String selectQuery = "Select * from stud_details";
            ResultSet result = statement.executeQuery(selectQuery);

            while(result.next()){
                int roll_no = result.getInt("roll_no");
                String name = result.getString("name");
                int age = result.getInt("age");
                int marks = result.getInt("marks");
                System.out.println(roll_no+" "+name+" "+age+" "+marks);
            }

            connect.close();
            System.out.println("Connection closed");

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
