package web.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.LoginService;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        String username = req.getParameter("username");
        String password = req.getParameter("passwd");
        String dob = req.getParameter("dob");

        String status = "fail";

        if (LoginService.login(username, password, dob)) {
            status = "success";
        }

        resp.setContentType("text/html");

        String html = "<html>"
                + "<head><title>" + status + "</title></head>"
                + "<body>"
                + "<h2>Login status: " + status + "</h2>"
                + "</body>"
                + "</html>";

        PrintWriter out = resp.getWriter();
        out.println(html);
        out.close();
    }
}