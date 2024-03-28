<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // Messages
    String failMessage = (String) request.getAttribute("failMessage");
    String successMessage = (String) request.getAttribute("successMessage");

    // Parameters
    String username = request.getParameter("username");
    String email = request.getParameter("email");

    String password = request.getParameter("password");
    String passwordConfirmation = request.getParameter("passwordConfirmation");

    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");

    String dateOfBirth = request.getParameter("dateOfBirth");
    String country = request.getParameter("country");

    String gender = request.getParameter("gender");

    if(username == null || email == null || password == null || passwordConfirmation == null || firstName == null || lastName == null || dateOfBirth == null || country == null || gender == null || successMessage != null) {

        username = "";
        email = "";

        password = "";
        passwordConfirmation = "";

        firstName = "";
        lastName = "";

        dateOfBirth = "";
        country = "";

        gender = "";
    }
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no" name="viewport">
        <title>Register</title>

        <!-- General CSS Files -->
        <link rel="stylesheet" href="stisla/dist/assets/modules/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="stisla/dist/assets/modules/fontawesome/css/all.min.css">

        <!-- CSS Libraries -->
        <link rel="stylesheet" href="stisla/dist/assets/modules/bootstrap-daterangepicker/daterangepicker.css">
        <link rel="stylesheet" href="stisla/dist/assets/modules/jquery-selectric/selectric.css">

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
        <!-- /END GA -->
    </head>

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

                        <div class="col-12 col-sm-10 offset-sm-1 col-md-8 offset-md-2 col-lg-8 offset-lg-2 col-xl-8 offset-xl-2">

                            <div class="login-brand">
                                <img src="stisla/dist/assets/img/avatar/avatar-5.png" alt="img" width="100" class="shadow-light rounded-circle">
                            </div>

                            <div class="card card-primary">

                                <div class="card-header">
                                    <h4>Register</h4>
                                </div>

                                <div class="card-body">
                                    <form action="register" method="POST" class="needs-validation" novalidate="">

                                        <div class="form-divider">
                                            Credentials
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-6 col-12">
                                                <label for="username">Username</label>
                                                <input id="username" type="text" class="form-control" name="username" value="<%= username %>" required autofocus>
                                                <div class="invalid-feedback">
                                                    The username is required : )
                                                </div>
                                            </div>
                                            <div class="form-group col-md-6 col-12">
                                                <label for="email">Email</label>
                                                <input id="email" type="email" class="form-control" name="email" value="<%= email %>"  required>
                                                <div class="invalid-feedback">
                                                    The email is required : )
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-6 col-12">
                                                <label for="password" class="d-block">Password</label>
                                                <input id="password" type="password" class="form-control pwstrength" data-indicator="pwindicator" name="password" value="" required>
                                                <div id="pwindicator" class="pwindicator">
                                                    <div class="bar col-md-12"></div>
                                                    <div class="label"></div>
                                                </div>
                                                <div class="invalid-feedback">
                                                    The password is required : )
                                                </div>
                                            </div>
                                            <div class="form-group col-md-6 col-12">
                                                <label for="passwordConfirmation" class="d-block">Password Confirmation</label>
                                                <input id="passwordConfirmation" type="password" class="form-control" name="passwordConfirmation" value=""  required>
                                                <div class="invalid-feedback">
                                                    The password confirmation is also required : )
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-divider">
                                            Personal Information
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-6 col-12">
                                                <label for="firstName">First Name</label>
                                                <input id="firstName" type="text" class="form-control" name="firstName" value="<%= firstName %>"  required>
                                                <div class="invalid-feedback">
                                                    The first name is required : )
                                                </div>
                                            </div>
                                            <div class="form-group col-md-6 col-12">
                                                <label for="lastName">Last Name</label>
                                                <input id="lastName" type="text" class="form-control" name="lastName" value="<%= lastName %>"  required>
                                                <div class="invalid-feedback">
                                                    The last name is required : )
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-6 col-12">
                                                <label for="dateOfBirth">Date Of Birth</label>
                                                <input id="dateOfBirth" type="text" class="form-control datepicker" name="dateOfBirth" value="<%= dateOfBirth %>" >
                                            </div>
                                            <div class="form-group col-md-6 col-12">
                                                <label for="country">Country</label>
                                                <select id="country" class="form-control selectric" name="country" value="<%= country %>" >
                                                    <option>Morocco</option>
                                                    <option>Egypt</option>
                                                    <option>USA</option>
                                                    <option>UK</option>
                                                    <option>Japan</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-6 col-12">
                                                <div class="custom-control custom-radio custom-control-inline">
                                                    <input type="radio" id="gender1" name="gender" class="custom-control-input" value="Male" required>
                                                    <label class="custom-control-label" for="gender1">Male</label>
                                                </div>
                                                <div class="custom-control custom-radio custom-control-inline">
                                                    <input type="radio" id="gender2" name="gender" class="custom-control-input" value="Female" required>
                                                    <label class="custom-control-label" for="gender2">Female</label>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <button type="submit" class="btn btn-primary btn-lg btn-block">
                                                Register
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </div>

                            <div class="mt-3 text-muted text-center">
                                Already have an account? <a href="login">Login</a>
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
        <script src="stisla/dist/assets/modules/bootstrap-daterangepicker/daterangepicker.js"></script>
        <script src="stisla/dist/assets/modules/jquery-selectric/jquery.selectric.min.js"></script>

        <!-- Page Specific JS File -->
        <script src="stisla/dist/assets/js/page/auth-register.js"></script>
        <script src="stisla/dist/assets/js/page/forms-advanced-forms.js"></script>

        <!-- Template JS File -->
        <script src="stisla/dist/assets/js/scripts.js"></script>
        <script src="stisla/dist/assets/js/custom.js"></script>
    </body>
</html>