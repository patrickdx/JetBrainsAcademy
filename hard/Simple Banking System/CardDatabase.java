package banking;


import java.sql.*;

/**
 *
 * @author https://www.sqlitetutorial.net/sqlite-java/
 * followed the tutorial :)
 */
public class CardDatabase {

    static String name;

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\Liwen Qu\\IdeaProjects\\Simple Banking System\\Simple Banking System\\task\\" + name;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    // query information

    public CreditCard searchCard(String number){      // minimum search parameter


        String sql = "SELECT id, number, pin, balance FROM card";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            // check if credit card details match database.
            while (rs.next()) {

                if (number.equals(rs.getString("number"))){
                    return new CreditCard(number, rs.getString("pin"), rs.getInt("id"), rs.getInt("balance"));
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return null;
    }




    /**
     * Insert a new row into the card table
     *
     */
    public void insert(String number, String pin) {     // id is generated, and balance default 0.
        String sql = "INSERT INTO card (number,pin) VALUES(?,?)";   // insert 4 columns into table, ? serving as placeholders.

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, number);
            pstmt.setString(2, pin);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String number) {
    String sql = "DELETE FROM card WHERE number = ?";       // deletes the row with id ? edit: should be card number not id, since from UI you will never obtain the ID of the card...

        try (Connection conn = this.connect();
    PreparedStatement pstmt = conn.prepareStatement(sql)) {

        // set the corresponding param
        pstmt.setString(1, number);
        // execute the delete statement
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

    public void updateBalance(int amount, String number) {

        String sql = "UPDATE card SET balance = ? WHERE number = ?";   //  UPDATE table with SET values ON row id.


        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param

            pstmt.setInt(1, amount);
            pstmt.setString(2, number);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }





    public static void createNewDatabase() {

        String url = "jdbc:sqlite:C:\\Users\\Liwen Qu\\IdeaProjects\\Simple Banking System\\Simple Banking System\\task\\" + name;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\Liwen Qu\\IdeaProjects\\Simple Banking System\\Simple Banking System\\task\\" + name;

        // SQL statement for creating a new table
          String sql = "CREATE TABLE card (\n"
                + "	id INTEGER PRIMARY KEY,\n"  // autoincrementing id col
                + "	number TEXT,\n"
                + "	pin TEXT,\n"
                + " balance INTEGER DEFAULT 0\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    // command line arg name

    public static void setup(String lul){
        name = lul;

        CardDatabase.createNewTable();
        CardDatabase app = new CardDatabase();
    }




}
