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
import dev.arzak21st.loginapp.services.ResetService;

@WebServlet(name = "ResetController", urlPatterns = {"/reset"})
public class ResetController extends HttpServlet {

    ResetService resetService;

    @Override
    public void init() throws ServletException {
        resetService = new ResetService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("features-profile.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get parameters
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
        String country = request.getParameter("country");

        String gender = request.getParameter("gender");

        // Get user id
        HttpSession session = request.getSession();
        UserCredential userCredential = (UserCredential) session.getAttribute("userCredential");
        Integer userId = userCredential.getUser().getUserId();

        // Reset proccess
        System.out.println("\n resetUser()");
        boolean userIsReset = resetService.resetUser(firstName, lastName, dateOfBirth, gender, country, userId);

        if(userIsReset) {

            // Update session and go back to profile page
            userCredential.getUser().setFirstName(firstName);
            userCredential.getUser().setLastName(lastName);
            userCredential.getUser().setDateOfBirth(dateOfBirth);
            userCredential.getUser().setGender(gender);
            userCredential.getUser().setCountry(country);
            session.setAttribute("userCredential", userCredential);

            String successMessage = "Reset succeeded";
            request.setAttribute("successMessage", successMessage);
        }
        request.getRequestDispatcher("features-profile.jsp").forward(request, response);
    }
}
