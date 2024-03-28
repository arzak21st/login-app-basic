package dev.arzak21st.loginapp.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dev.arzak21st.loginapp.models.UserCredential;
import dev.arzak21st.loginapp.services.ResetPasswordService;

@WebServlet(name = "ResetPasswordController", urlPatterns = {"/resetPassword"})
public class ResetPasswordController extends HttpServlet {

    ResetPasswordService resetPasswordService;

    @Override
    public void init() throws ServletException {
        resetPasswordService = new ResetPasswordService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("auth-reset-password.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get parameters
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String newPasswordConfirmation = request.getParameter("newPasswordConfirmation");

        // Compare passwords
        if(!newPassword.equals(newPasswordConfirmation)) { // Password mismatch

            // Back to reset password page
            String failMessage = "Reset failed: Passwords missmatch!";
            request.setAttribute("failMessage", failMessage);
        }
        else { // Password match

            // Reset password proccess
            // Get user id
            HttpSession session = request.getSession();
            UserCredential userCredential = (UserCredential) session.getAttribute("userCredential");
            Integer userId = userCredential.getUser().getUserId();

            // Check if old password is correct
            System.out.println("\n checkOldPassword()");
            boolean oldPasswordIsCorrect = resetPasswordService.checkOldPassword(userId, oldPassword);

            if(oldPasswordIsCorrect) {

                // Reset password
                System.out.println("\n resetPassword()");
                boolean passwordIsReset = resetPasswordService.resetPassword(newPassword, userId);

                if(passwordIsReset) {

                    // Go back to reset password page
                    String successMessage = "Password Reset Succeeded: <a href=\"login\"><b>Login</b></a>?";
                    request.setAttribute("successMessage", successMessage);
                }
            }
            else {

                // Back to reset password page
                String failMessage = "Password Reset failed: Old password is not correct!";
                request.setAttribute("failMessage", failMessage);
            }
        }
        request.getRequestDispatcher("auth-reset-password.jsp").forward(request, response);
    }
}
