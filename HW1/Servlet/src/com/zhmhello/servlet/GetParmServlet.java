package com.zhmhello.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetParmServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req,
                      HttpServletResponse resp)throws ServletException, IOException {
        DataSearch sea = new DataSearch(JDBCConnect.getConnection());
        req.setAttribute("ContList", sea.getCont());
        req.getRequestDispatcher("/Search.jsp").forward(req, resp);
    }
}
