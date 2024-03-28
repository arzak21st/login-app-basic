package dev.arzak21st.loginapp.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dev.arzak21st.loginapp.models.UserCredential;
import dev.arzak21st.loginapp.services.RemoveService;

@WebServlet(name = "RemoveController", urlPatterns = {"/remove"})
public class RemoveController extends HttpServlet {

    RemoveService removeService;

    @Override
    public void init() throws ServletException {
        removeService = new RemoveService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Check if user exists
        HttpSession session = request.getSession();
        UserCredential userCredential = (UserCredential) session.getAttribute("userCredential");

        if(userCredential != null) { // User is logged in

            // Remove proccess
            System.out.println("\n removeUserById()");
            Integer userId = userCredential.getUser().getUserId();
            removeService.removeUserById(userId);

            // Close session and go to login page
            request.getSession().invalidate();
        }
        response.sendRedirect("auth-login.jsp");
    }
}
