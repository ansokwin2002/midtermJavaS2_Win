import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowProductItems {

    public static void main(String[] args) {
        // Database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/javaS2";
        String user = "username";
        String password = "password";

        String selectSQL = "SELECT * FROM Product";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price_per_unit");
                boolean active = resultSet.getBoolean("active_for_sell");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Price per unit: " + price);
                System.out.println("Active for sell: " + active);
                System.out.println("---------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
