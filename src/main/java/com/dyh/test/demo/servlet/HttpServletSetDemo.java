package com.dyh.test.demo.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description:第一次请求属性赋值 servletContext.setAttribute
 * 需要配置 webapp/WEB-INF/web.xml（web项目）
 * author: dyh
 * date: 2022/10/31 15:06
 */
public class HttpServletSetDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        String name = "HttpServlet -> getServletContext -> setAttribute && getAttribute";
        servletContext.setAttribute("name", name);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
