<%@page import="dev.arzak21st.loginapp.models.UserCredential"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // Messages
    String failMessage = (String) request.getAttribute("failMessage");
    String successMessage = (String) request.getAttribute("successMessage");

    // Objects
    UserCredential userCredential = (UserCredential) session.getAttribute("userCredential");

    if(userCredential != null) {
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no" name="viewport">
        <title>Reset Password</title>

        <!-- General CSS Files -->
        <link rel="stylesheet" href="stisla/dist/assets/modules/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="stisla/dist/assets/modules/fontawesome/css/all.min.css">

        <!-- CSS Libraries -->

        <!-- Template CSS -->
        <link rel="stylesheet" href="stisla/dist/assets/css/style.css">
        <link rel="stylesheet" href="stisla/dist/assets/css/components.css">

        <!-- Start GA -->
        <script async src="https://www.googletagmanager.com/gtag/js?id=UA-94034622-3"></script>
        <script>
            window.dataLayer = window.dataLayer || [];
            function gtag() {
                dataLayer.push(arguments);
            }
            gtag('js', new Date());

            gtag('config', 'UA-94034622-3');
        </script>
        <!-- /END GA --></head>

    <body>
        <div id="app">
            <section class="section">
                <div class="container mt-5">
                    <div class="row">

                        <!-- Fail alert -->
                        <%
                            if(failMessage != null) {
                        %>
                        <div class="col-12 col-md-12 col-lg-12">
                            <div class="alert alert-danger alert-dismissible show fade">
                                <div class="alert-body">
                                    <button class="close" data-dismiss="alert">
                                        <span>&times;</span>
                                    </button>
                                    <%= failMessage %>
                                </div>
                            </div>
                        </div>
                        <%
                            }
                        %>

                        <!-- Success alert -->
                        <%
                            if(successMessage != null) {
                        %>
                        <div class="col-12 col-md-12 col-lg-12">
                            <div class="alert alert-success alert-dismissible show fade">
                                <div class="alert-body">
                                    <button class="close" data-dismiss="alert">
                                        <span>&times;</span>
                                    </button>
                                    <%= successMessage %>
                                </div>
                            </div>
                        </div>
                        <%
                            }
                        %>


                        <div class="col-12 col-sm-8 offset-sm-2 col-md-6 offset-md-3 col-lg-6 offset-lg-3 col-xl-4 offset-xl-4">

                            <div class="login-brand">
                                <img src="stisla/dist/assets/img/avatar/avatar-5.png" alt="img" width="100" class="shadow-light rounded-circle">
                            </div>

                            <div class="card card-primary">
                                <div class="card-header"><h4>Reset Password</h4></div>

                                <div class="card-body">
                                    <form action="resetPassword" method="POST" class="needs-validation" novalidate="">

                                        <div class="form-group">
                                            <label for="oldPassword">Old Password</label>
                                            <input id="oldPassword" type="password" class="form-control" name="oldPassword" value=""  required>
                                            <div class="invalid-feedback">
                                                The old password is required : )
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="newPassword" class="d-block">New Password</label>
                                            <input id="newPassword" type="password" class="form-control pwstrength" data-indicator="pwindicator" name="newPassword" value="" required>
                                            <div id="pwindicator" class="pwindicator">
                                                <div class="bar col-md-12"></div>
                                                <div class="label"></div>
                                            </div>
                                            <div class="invalid-feedback">
                                                The new password is required : )
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="newPasswordConfirmation">New Password Confirmation</label>
                                            <input id="newPasswordConfirmation" type="password" class="form-control" name="newPasswordConfirmation" value=""  required>
                                            <div class="invalid-feedback">
                                                The new password confirmation is also required : )
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <button type="submit" class="btn btn-primary btn-lg btn-block" tabindex="4">
                                                Reset Password
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </div>

                            <div class="mt-3 text-muted text-center">
                                Back to <a href="reset">Profile</a>
                            </div>

                            <div class="simple-footer">

                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>

        <!-- General JS Scripts -->
        <script src="stisla/dist/assets/modules/jquery.min.js"></script>
        <script src="stisla/dist/assets/modules/popper.js"></script>
        <script src="stisla/dist/assets/modules/tooltip.js"></script>
        <script src="stisla/dist/assets/modules/bootstrap/js/bootstrap.min.js"></script>
        <script src="stisla/dist/assets/modules/nicescroll/jquery.nicescroll.min.js"></script>
        <script src="stisla/dist/assets/modules/moment.min.js"></script>
        <script src="stisla/dist/assets/js/stisla.js"></script>

        <!-- JS Libraies -->
        <script src="stisla/dist/assets/modules/jquery-pwstrength/jquery.pwstrength.min.js"></script>

        <!-- Page Specific JS File -->
        <script src="stisla/dist/assets/js/page/auth-register.js"></script>
        <script src="stisla/dist/assets/js/page/forms-advanced-forms.js"></script>

        <!-- Template JS File -->
        <script src="stisla/dist/assets/js/scripts.js"></script>
        <script src="stisla/dist/assets/js/custom.js"></script>
    </body>
</html>

<%
    }
    else {
        response.sendRedirect("login");
    }
%>