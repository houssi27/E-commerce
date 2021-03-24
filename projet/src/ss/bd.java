package ss;

import java.sql.*;

public class bd {

private static Connection con;

public bd() throws Exception {
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:8889/GL1", "root", "root");
}

public static Connection getCon() {
return con;
}
}