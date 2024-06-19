public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/javaS2";
    String user = "username";
    String password = "password";

    String createTableSQL = "CREATE TABLE Product ("
            + "id INT AUTO_INCREMENT PRIMARY KEY,"
            + "name VARCHAR(255) NOT NULL,"
            + "price_per_unit DOUBLE NOT NULL,"
            + "active_for_sell BOOLEAN NOT NULL)";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         Statement statement = conn.createStatement()) {

        statement.executeUpdate(createTableSQL);
        System.out.println("Product table created successfully.");

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
