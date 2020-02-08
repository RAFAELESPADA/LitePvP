package me.rafael.litepvp.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mysql
{
  private final String bancodedados;
  private final String host;
  private final String porta;
  private final String senha;
  private final String usuario;
  
  public Mysql(String db, String host, String port, String pw, String user)
  {
    this.bancodedados = db;
    this.host = host;
    this.porta = port;
    this.senha = pw;
    this.usuario = user;
  }
  
  public synchronized Connection conectar()
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      return DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.porta + "/" + this.bancodedados, this.usuario, this.senha);
    }
    catch (SQLException|ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public synchronized void execute(String query)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 83	me/rafael/litepvp/Utils/Mysql:conectar	()Ljava/sql/Connection;
    //   4: astore_2
    //   5: aload_2
    //   6: aload_1
    //   7: invokeinterface 85 2 0
    //   12: invokeinterface 91 1 0
    //   17: pop
    //   18: goto +48 -> 66
    //   21: astore_3
    //   22: aload_3
    //   23: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   26: aload_2
    //   27: invokeinterface 97 1 0
    //   32: goto +50 -> 82
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 100	java/sql/SQLException:printStackTrace	()V
    //   42: goto +40 -> 82
    //   45: astore 4
    //   47: aload_2
    //   48: invokeinterface 97 1 0
    //   53: goto +10 -> 63
    //   56: astore 5
    //   58: aload 5
    //   60: invokevirtual 100	java/sql/SQLException:printStackTrace	()V
    //   63: aload 4
    //   65: athrow
    //   66: aload_2
    //   67: invokeinterface 97 1 0
    //   72: goto +10 -> 82
    //   75: astore 5
    //   77: aload 5
    //   79: invokevirtual 100	java/sql/SQLException:printStackTrace	()V
    //   82: return
    // Line number table:
    //   Java source line #39	-> byte code offset #0
    //   Java source line #41	-> byte code offset #5
    //   Java source line #42	-> byte code offset #18
    //   Java source line #43	-> byte code offset #22
    //   Java source line #46	-> byte code offset #26
    //   Java source line #47	-> byte code offset #32
    //   Java source line #48	-> byte code offset #37
    //   Java source line #44	-> byte code offset #45
    //   Java source line #46	-> byte code offset #47
    //   Java source line #47	-> byte code offset #53
    //   Java source line #48	-> byte code offset #58
    //   Java source line #50	-> byte code offset #63
    //   Java source line #46	-> byte code offset #66
    //   Java source line #47	-> byte code offset #72
    //   Java source line #48	-> byte code offset #77
    //   Java source line #52	-> byte code offset #82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	Mysql
    //   0	83	1	query	String
    //   4	63	2	con	Connection
    //   21	2	3	e	Exception
    //   45	19	4	localObject	Object
    //   35	3	5	e	SQLException
    //   56	3	5	e	SQLException
    //   75	3	5	e	SQLException
    // Exception table:
    //   from	to	target	type
    //   5	18	21	java/lang/Exception
    //   26	32	35	java/sql/SQLException
    //   5	26	45	finally
    //   47	53	56	java/sql/SQLException
    //   66	72	75	java/sql/SQLException
  }
  
  public synchronized ResultSet getQueryResult(String query)
  {
    Connection con = conectar();
    try
    {
      return con.prepareStatement(query).executeQuery();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
