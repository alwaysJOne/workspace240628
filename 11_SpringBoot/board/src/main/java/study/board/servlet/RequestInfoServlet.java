package study.board.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RequestInfoServlet", urlPatterns = "/request-info")
public class RequestInfoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("요청 url : " + req.getRequestURI());
        System.out.println("요청 method :" + req.getMethod());

        System.out.println("contentType : " + req.getContentType());
        System.out.println("locale : " + req.getLocale());

        System.out.println("username :" + req.getParameter("username"));

        resp.getWriter().write("ok");
    }
}
