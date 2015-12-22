package seller.dao;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbcommon
{
  String mysql_driver = "com.mysql.jdbc.Driver";
  String mysql_database = "parknshop";
  String mysql_url = "jdbc:mysql://localhost/" + this.mysql_database;
  String mysql_userName = "root";
  String mysql_password = "791142007";
  private Connection con = null;
  private Statement st = null;
  protected ResultSet rs = null;
  
  public Connection getMysqlConn()
  {
    try
    {
      Class.forName(this.mysql_driver);
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    try
    {
      this.con = DriverManager.getConnection(this.mysql_url, this.mysql_userName, this.mysql_password);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    System.out.println("Database connected successfully.");
    
    return this.con;
  }
  
  public void CloseConnection(Connection con, ResultSet rs, Statement st)
  {
    if (rs != null) {
      try
      {
        rs.close();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
    if (st != null) {
      try
      {
        st.close();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
    if (con != null) {
      try
      {
        con.close();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public void noResultSet(String sqlstring)
  {
    getMysqlConn();
    try
    {
      this.st = this.con.createStatement();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    try
    {
      this.st.executeUpdate(sqlstring);
      System.out.println("successed");
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    //CloseConnection(this.con, this.rs, this.st);
  }
  
  public void returnResultSet(String sqlstring)
  {
    getMysqlConn();
    try
    {
      this.st = this.con.createStatement();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    try
    {
      this.rs = this.st.executeQuery(sqlstring);
      System.out.println("successed");
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
  
  public Connection getCon()
  {
    return this.con;
  }
  
  public void setCon(Connection con)
  {
    this.con = con;
  }
  
  public Statement getSt()
  {
    return this.st;
  }
  
  public void setSt(Statement st)
  {
    this.st = st;
  }
  
  public ResultSet getRs()
  {
    return this.rs;
  }
  
  public void setRs(ResultSet rs)
  {
    this.rs = rs;
  }
}
