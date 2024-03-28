<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // Messages
    String failMessage = (String) request.getAttribute("failMessage");
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no" name="viewport">
        <title>Login</title>

        <!-- General CSS Files -->
        <link rel="stylesheet" href="stisla/dist/assets/modules/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="stisla/dist/assets/modules/fontawesome/css/all.min.css">

        <!-- CSS Libraries -->
        <link rel="stylesheet" href="stisla/dist/assets/modules/bootstrap-social/bootstrap-social.css">

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

                        <div class="col-12 col-sm-8 offset-sm-2 col-md-6 offset-md-3 col-lg-6 offset-lg-3 col-xl-4 offset-xl-4">

                            <div class="login-brand">
                                <img src="stisla/dist/assets/img/avatar/avatar-5.png" alt="img" width="100" class="shadow-light rounded-circle">
                            </div>

                            <div class="card card-primary">
                                <div class="card-header"><h4>Login</h4></div>

                                <div class="card-body">

                                    <!-- Login Form -->
                                    <form action="login" method="POST" class="needs-validation" novalidate="">

                                        <div class="form-group">
                                            <label for="email">Email</label>
                                            <input id="email" type="email" class="form-control" name="email" tabindex="1" required autofocus>
                                            <div class="invalid-feedback">
                                                Please fill in your email
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="d-block">
                                                <label for="password" class="control-label">Password</label>
                                            </div>
                                            <input id="password" type="password" class="form-control" name="password" tabindex="2" required>
                                            <div class="invalid-feedback">
                                                please fill in your password
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <button type="submit" class="btn btn-primary btn-lg btn-block" tabindex="4">
                                                Login
                                            </button>
                                        </div>
                                    </form>

                                </div>
                            </div>

                            <div class="mt-3 text-muted text-center">
                                Don't have an account? <a href="register">Register</a>
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

        <!-- Page Specific JS File -->

        <!-- Template JS File -->
        <script src="stisla/dist/assets/js/scripts.js"></script>
        <script src="stisla/dist/assets/js/custom.js"></script>
    </body>
</html>