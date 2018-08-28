import java.sql.*;


public class JdbcTest {
    //数据库驱动
    static final String JdbcDriver = "com.mysql.jdbc.Driver";
    //数据库地址
    static final String URL="jdbc:mysql://localhost:3306/sqltest";
    //用户名
    static final String User = "root";
    //密码
    static final String Password ="1234";
    public static void main(String[] args) throws ClassNotFoundException,SQLException{

        Connection conn =null;
        Statement stmt = null;
        //注册驱动
        Class.forName(JdbcDriver);
        //打开链接
        System.out.println("Connecting mysql db...");
        conn = DriverManager.getConnection(URL,User,Password);

        //执行查询
        System.out.println("Instance is ...");
        stmt = conn.createStatement();

        String sql;
        sql="select * from employee";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("id: "+" name: "+" salary:"+" deptid: ");
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int salary = rs.getInt("salary");
            int deptid = rs.getInt("deptid");

            //输出结果
            System.out.print(id+"    "+name+"    "+salary+"     "+deptid);
            System.out.print("\n");
        }
        rs.close();
        stmt.close();
        conn.close();

    }
}