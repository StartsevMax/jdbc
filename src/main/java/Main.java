import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox?serverTimezone=UTC";
        String user = "root";
        String password = "58598532";
        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
//            statement.execute("UPDATE Courses SET name = 'Веб-разработчик с 0 до PRO' WHERE id = '1'");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Courses");
            while (resultSet.next())
            {
                String courseName = resultSet.getString("name");
                System.out.println(courseName);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
