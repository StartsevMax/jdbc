import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox?serverTimezone=UTC";
        String user = "root";
        String password = "58598532";
        String SqlQuery = "SELECT   EXTRACT(MONTH FROM subscription_date) AS month," +
                                   "COUNT(student_name) AS purchases " +
                          "FROM     PurchaseList " +
                          "GROUP BY EXTRACT(MONTH FROM subscription_date) " +
                          "ORDER BY month;";
        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while (resultSet.next())
            {
                String month = resultSet.getString("month");
                String purchases = resultSet.getString("purchases");
                System.out.println(month + " - " + purchases);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
