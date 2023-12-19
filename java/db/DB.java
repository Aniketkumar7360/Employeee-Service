package db;

import java.sql.Connection;

public class DB {
   private static Connection con = null;
   public static Connection getCon() { return con;  }
   public static void setCon(Connection con) { DB.con = con; }
   public static int ctr=0;
}
