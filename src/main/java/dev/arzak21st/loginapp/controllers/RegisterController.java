package dev.arzak21st.loginapp.controllers;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dev.arzak21st.loginapp.models.UserCredential;
import dev.arzak21st.loginapp.services.RegisterService;

@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    RegisterService registerService;

    @Override
    public void init() throws ServletException {
        registerService = new RegisterService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Close session if exsists
        HttpSession session = request.getSession();
        if(session != null) { // Session exists
            session.invalidate();
        }
        response.sendRedirect("auth-register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get parameters
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("passwordConfirmation");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
        String country = request.getParameter("country");

        String gender = request.getParameter("gender");

        // Compare passwords
        if(!password.equals(passwordConfirmation)) { // Passwords mismatch

            // Back to register page
            String failMessage = "Register failed: Passwords missmatch!";
            request.setAttribute("failMessage", failMessage);
        }
        else { // Passwords match

            // Register proccess
            // Check if user credentials (username & email) were already used
            System.out.println("\n checkUserCredential()");
            UserCredential userCredential = registerService.checkUserCredential(username, email);

            if(userCredential == null) { // User credentials were not already used

                // Register the user
                System.out.println("\n registerUser()");
                boolean userIsRegistered = registerService.registerUser(firstName, lastName, dateOfBirth, gender, country);

                if(userIsRegistered) {

                    // Register user credentials
                    System.out.println("\n getRegisteredUserId()");
                    Integer registeredUserId = registerService.getRegisteredUserId();

                    System.out.println("\n registerUserCredential()");
                    boolean userCredentialIsRegistered = registerService.registerUserCredential(registeredUserId, username, email, password);

                    if(userCredentialIsRegistered) {

                        // Go back to register page
                        String successMessage = "Register succeeded: <a href=\"login\"><b>Login</b></a>?";
                        request.setAttribute("successMessage", successMessage);
                    }
                }
            }
            else { // User credentials were already used

                // Back to register page
                String failMessage = "Register failed: Username or Email were already used!";
                request.setAttribute("failMessage", failMessage);
            }
        }
        request.getRequestDispatcher("auth-register.jsp").forward(request, response);
    }
}
