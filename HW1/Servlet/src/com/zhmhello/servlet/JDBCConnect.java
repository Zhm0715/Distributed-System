package com.zhmhello.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;

public class JDBCConnect {
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = "200715";
    private static final String MYSQL_DATABASE_SERVER = "localhost:3306";
    private static final String MYSQL_DATABASE_NAME = "CVoidData";

    private static Connection con;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + MYSQL_DATABASE_SERVER + "/" + MYSQL_DATABASE_NAME + "?serverTimezone=UTC&characterEncoding=utf-8";
            con = DriverManager.getConnection(url, MYSQL_USERNAME, MYSQL_PASSWORD);
        } catch (SQLException e) {
            System.err.println("Connect MySQL Service Error");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Deploy Error");
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return con;
    }

    public static void close() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void RandomData(){
        for(int i = 0;i < 30;++i){
            Random ran = new Random();
            int add = ran.nextInt(10000);
            int all = ran.nextInt(100000) + add;
            float deadrate = ran.nextFloat();
            if(deadrate > 0.5){
                deadrate -= 0.5;
            }
            int dead = (int)(deadrate * all);
            String sqlsente = String.format("insert into InfectInfo(InfecInfoID, DataTime, CountryID, AllInfect, AddInfect, DeadNum)" +
                    " value(%d, %s, %d, %d, %d, %d)", i + 1, "now()", i + 1, all, add, dead);
            try{
                Statement state = con.createStatement();
                state.executeUpdate(sqlsente);
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("随机数据错误");
            }
        }
    }
}

class DataSearch{

    private Connection conn;

    public DataSearch(Connection con){
        this.conn = con;
    }

    public ResultSet getResult(String cont, String country) {
        String sqlsente = String.format("select AllInfect, AddInfect, DeadNum " +
                                        "from InfectInfo inner join Country on InfectInfo.CountryID = Country.CountID and Country.CountName = \"%s\"", country);
        ResultSet set = null;
        try {
            Statement state = this.conn.createStatement();
            set = state.executeQuery(sqlsente);
        }catch(SQLException e){
            System.out.println("SQL Search Error");
            e.printStackTrace();
        }
        return set;
    }

    public String[] getCont(){
        String sqllen = "select Count(*) from Continent";
        String sqlresu = "select ContName from Continent";
        String []ans = null;
        try{
            Statement state = this.conn.createStatement();
            ResultSet len = state.executeQuery(sqllen);
            len.next();
            ans = new  String[len.getInt(1)];       // 从1开始
            ResultSet result = state.executeQuery(sqlresu);
            int i = 0;
            while(result.next()){
                ans[i] = result.getString(1);
                ++i;
            }
        }catch(SQLException e) {
            System.out.println("SQL Search Error");
            e.printStackTrace();
        }
        return ans;
    }

    public List<String> getCountry(String Cont){
        String sqlsente = "select CountName " +
                          "from Continent inner join Country on Continent.ContID = Country.ContID " +
                          "where ContName = '" + Cont + "'";
        List<String> ans = new ArrayList<String>();
        try{
            Statement state = this.conn.createStatement();
            ResultSet set = state.executeQuery(sqlsente);
            int i = 0;
            while(set.next()){
                ans.add(set.getString(1));
                ++i;
            }
        }catch(SQLException e) {
            System.out.println("SQL Search Error");
            e.printStackTrace();
        }
        return ans;
    }
}
