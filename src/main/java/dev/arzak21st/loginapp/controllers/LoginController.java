package dev.arzak21st.loginapp.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dev.arzak21st.loginapp.models.UserCredential;
import dev.arzak21st.loginapp.services.LoginService;

@WebServlet(name = "LoginController", urlPatterns = {"/login", "/logout"})
public class LoginController extends HttpServlet {

    LoginService loginService;

    @Override
    public void init() throws ServletException {
        loginService = new LoginService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Close session if exsists
        HttpSession session = request.getSession();
        if(session != null) { // Session exists
            session.invalidate();
        }
        response.sendRedirect("auth-login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get parameters
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Login proccess
        System.out.println("\n loginUser()");
        UserCredential userCredential = loginService.loginUser(email, password);

        if(userCredential != null) { // User is logged in

            // Open session and go to main page
            HttpSession session = request.getSession();
            session.setAttribute("userCredential", userCredential);

            response.sendRedirect("index.jsp");
        }
        else { // User is not logged in

            // Back to login page
            String failMessage = "Login failed: Wrong email or password!";
            request.setAttribute("failMessage", failMessage);
            request.getRequestDispatcher("auth-login.jsp").forward(request, response);
        }
    }
}
