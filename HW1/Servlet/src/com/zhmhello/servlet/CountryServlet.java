package com.zhmhello.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountryServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req,
                      HttpServletResponse resp)throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String parm = (String) req.getParameter("ContID");
        DataSearch sea = new DataSearch(JDBCConnect.getConnection());
        List<String> retdata = sea.getCountry(parm);
        String DataStr = retdata.stream().map(i -> "\""+ i +"\"").collect(Collectors.joining(","));
        String ans = String.format("{\"country\": [%s]}", DataStr);
        resp.setContentType("text/javascript");
        resp.getWriter().println(ans);
    }

}
