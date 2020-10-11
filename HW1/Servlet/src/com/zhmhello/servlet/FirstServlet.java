package com.zhmhello.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


// url:127.0.0.1:8080/zhm/hello

public class FirstServlet extends HttpServlet {

    public void doGet(HttpServletRequest req,
                      HttpServletResponse resp)throws ServletException,IOException
    {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String contID = req.getParameter("ContID");
        String CountID = req.getParameter("CountID");
        DataSearch sea = new DataSearch(JDBCConnect.getConnection());
        ResultSet data = sea.getResult(contID, CountID);
        String ans = "{";
        try {
            data.next();
            ans += "\"All\": " + data.getString(1) + ", ";
            ans += "\"Add\": " + data.getString(2) + ", ";
            ans += "\"Dead\": " + data.getString(3) + ", ";
            if(data.getInt(2) > 1000){
                ans += "\"Level\": 5}";
            }else if(data.getInt(2) > 800){
                ans += "\"Level\": 4}";
            }else if(data.getInt(2) > 600){
                ans += "\"Level\": 3}";
            }else if(data.getInt(2) > 400){
                ans += "\"Level\": 2}";
            }else if(data.getInt(2) > 200){
                ans += "\"Level\": 1}";
            }else{
                ans += "\"Level\": 0}";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("获取数据错误");
        }
        System.out.println(ans);
        resp.setContentType("text/javascript");
        resp.getWriter().println(ans);
    }

    public void doPost(HttpServletRequest req,
                       HttpServletResponse resp)throws ServletException,IOException
    {
        PrintWriter out = resp.getWriter();
        out.println("<h1>Post access is not allowed for this page.</h1>");
    }
}
