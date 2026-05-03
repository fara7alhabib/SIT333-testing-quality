package web.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.RegistrationService;

/**
 * HTTP end-point to handle registration request.
 */
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        System.out.println("[RegistrationServlet] GET");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        System.out.println("[RegistrationServlet] POST");

        String fName = req.getParameter("fname");
        String lName = req.getParameter("lname");
        String email = req.getParameter("email");
        String dob = req.getParameter("dob");

        boolean result = RegistrationService.register(fName, lName, email, dob);

        resp.setContentType("application/json");

        if (result) {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println("{\"status\": \"success\", \"message\": \"Registration successful\"}");
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("{\"status\": \"failed\", \"message\": \"Invalid registration details\"}");
        }
    }
}