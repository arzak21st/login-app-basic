<%@page import="dev.arzak21st.loginapp.models.User"%>
<%@page import="dev.arzak21st.loginapp.models.UserCredential"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // Messages
    String failMessage = (String) request.getAttribute("failMessage");
    String successMessage = (String) request.getAttribute("successMessage");

    // Objects
    UserCredential userCredential = (UserCredential) session.getAttribute("userCredential");

    if(userCredential != null) {

        // Parameters
        String username = userCredential.getUsername();
        String email = userCredential.getEmail();

        String firstName = userCredential.getUser().getFirstName();
        String lastName = userCredential.getUser().getLastName();

        Date dateOfBirth = userCredential.getUser().getDateOfBirth();
        String country = userCredential.getUser().getCountry();

        String gender = userCredential.getUser().getGender();

        // Arrays
        String[] countries = {"Morocco", "Egypt", "USA", "UK", "Japan"};
        String[] genders = {"Male", "Female"};
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no" name="viewport">
        <title>Profile</title>

        <!-- General CSS Files -->
        <link rel="stylesheet" href="stisla/dist/assets/modules/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="stisla/dist/assets/modules/fontawesome/css/all.min.css">

        <!-- CSS Libraries -->
        <link rel="stylesheet" href="stisla/dist/assets/modules/bootstrap-social/bootstrap-social.css">
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

    <body class="sidebar-mini">
        <div id="app">
            <div class="main-wrapper main-wrapper-1">

                <!-- Top Bar -->
                <div class="navbar-bg"></div>
                <nav class="navbar navbar-expand-lg main-navbar">

                    <!-- Sidebar Toggle -->
                    <form class="form-inline mr-auto">
                        <ul class="navbar-nav mr-3">
                            <li><a href="#" data-toggle="sidebar" class="nav-link nav-link-lg"><i class="fas fa-bars"></i></a></li>
                        </ul>
                    </form>

                    <!-- User Toggle -->
                    <ul class="navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" data-toggle="dropdown" class="nav-link dropdown-toggle nav-link-lg nav-link-user">

                                <!-- User Image -->
                                <img alt="image" src="stisla/dist/assets/img/avatar/avatar-5.png" class="rounded-circle mr-1">

                                <!-- User Full Name -->
                                <div class="d-sm-none d-lg-inline-block">
                                    <%= username %>
                                </div>
                            </a>

                            <!-- User Dropdown Menu -->
                            <div class="dropdown-menu dropdown-menu-right">
                                <div class="dropdown-title">Logged in 5 min ago</div>
                                <a href="reset" class="dropdown-item has-icon">
                                    <i class="far fa-user"></i> Profile
                                </a>
                                <div class="dropdown-divider"></div>
                                <a href="logout" class="dropdown-item has-icon text-danger" data-confirm="Are you sure you want to logout?" data-confirm-yes="window.location.href = 'logout';">
                                    <i class="fas fa-sign-out-alt"></i> Logout
                                </a>
                            </div>
                        </li>
                    </ul>
                </nav>

                <!-- Side Bar -->
                <div class="main-sidebar sidebar-style-2">
                    <aside id="sidebar-wrapper">

                        <!-- Side Bar Title -->
                        <div class="sidebar-brand">
                            <a href="index">HOME</a>
                        </div>
                        <div class="sidebar-brand sidebar-brand-sm">
                            <a href="index">HM</a>
                        </div>

                        <!-- Side Bar Menu -->
                        <ul class="sidebar-menu">

                            <!-- Menu Header -->
                            <li class="menu-header">Dashboard</li>

                            <!-- Menu Item -->
                            <li><a class="nav-link" href="index"><i class="far fa-square"></i> <span>Dashboard</span></a></li>
                        </ul>
                    </aside>
                </div>

                <!-- Main Content -->
                <div class="main-content">
                    <section class="section">

                        <!-- Body Bar -->
                        <div class="section-header">
                            <h1>Profile</h1>
                            <div class="section-header-breadcrumb">
                                <div class="breadcrumb-item active"><a href="index">Dashboard</a></div>
                                <div class="breadcrumb-item">Profile</div>
                            </div>
                        </div>

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

                        <!-- Body -->
                        <div class="section-body">

                            <!-- Welcome Message -->
                            <h2 class="section-title">
                                Hi, <%= username %>
                            </h2>
                            <p class="section-lead">
                                Change your profile information.
                            </p>

                            <!-- User Profile -->
                            <div class="row mt-sm-4">

                                <!-- User Profile Info -->
                                <div class="col-12 col-md-12 col-lg-12">
                                    <div class="card profile-widget">

                                        <div class="profile-widget-header">
                                            <img alt="image" src="stisla/dist/assets/img/avatar/avatar-5.png" class="rounded-circle profile-widget-picture">
                                            <div class="profile-widget-items">
                                                <div class="profile-widget-item">
                                                    <div class="profile-widget-item-label">Gender</div>
                                                    <div class="profile-widget-item-value"><%= gender %></div>
                                                </div>
                                                <div class="profile-widget-item">
                                                    <div class="profile-widget-item-label">Date of Birth</div>
                                                    <div class="profile-widget-item-value"><%= dateOfBirth %></div>
                                                </div>
                                                <div class="profile-widget-item">
                                                    <div class="profile-widget-item-label">Country</div>
                                                    <div class="profile-widget-item-value"><%= country %></div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="profile-widget-description">
                                            <div class="profile-widget-name">
                                                <div class="text-muted d-inline font-weight-normal">
                                                    <%= username %> <div class="slash"></div> <%= firstName + " " + lastName %>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <!-- Edit User Profile Info -->
                                <div class="col-12 col-md-12 col-lg-12">
                                    <div class="card">

                                        <div class="card-header">
                                            <h4>Edit Profile</h4>
                                        </div>

                                        <div class="card-body">
                                            <form action="reset" method="POST" class="needs-validation" novalidate="">

                                                <div class="form-divider">
                                                    Credentials
                                                </div>

                                                <div class="row">
                                                    <div class="form-group col-md-6 col-12">
                                                        <label for="username">Username (Unchangeable)</label>
                                                        <input id="username" type="text" class="form-control" name="username" value="<%= username %>" disabled>
                                                        <div class="invalid-feedback">
                                                            The username is required : )
                                                        </div>
                                                    </div>
                                                    <div class="form-group col-md-6 col-12">
                                                        <label for="email">Email (Unchangeable)</label>
                                                        <input id="email" type="email" class="form-control" name="email" value="<%= email %>"  disabled>
                                                        <div class="invalid-feedback">
                                                            The email is required : )
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="form-group col-md-6 col-12">
                                                        <a href="resetPassword" class="btn btn-primary col-md-12 col-12">Reset Password</a>
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
                                                        <select id="country" class="form-control selectric" name="country">
                                                            <%
                                                                for(int i = 1; i <= countries.length; i++) {

                                                                    if(country.equals(countries[i - 1])){
                                                                        out.print("<option selected>" + countries[i - 1] + "</option>");
                                                                    }
                                                                    else{
                                                                        out.print("<option>" + countries[i - 1] + "</option>");
                                                                    }
                                                                }
                                                            %>
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="form-group col-md-6 col-12">
                                                        <%
                                                            for(int i = 1; i <= genders.length; i++) {
                                                        %>
                                                        <div class="custom-control custom-radio custom-control-inline">
                                                        <%
                                                            if(genders[i - 1].equals(gender)){
                                                                out.print("<input type=\"radio\" id=\"gender" + i + "\" name=\"gender\" class=\"custom-control-input\" value=\"" + genders[i - 1] + "\" required checked>");
                                                            }
                                                            else{
                                                                out.print("<input type=\"radio\" id=\"gender" + i + "\" name=\"gender\" class=\"custom-control-input\" value=\"" + genders[i - 1] + "\" required>");
                                                            }
                                                        %>
                                                            <label class="custom-control-label" for="gender<%= i %>"><%= genders[i - 1] %></label>
                                                        </div>
                                                        <%
                                                            }
                                                        %>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="form-group col-md-6 col-12">
                                                        <button type="submit" class="btn btn-primary col-md-12 col-12">Save Changes</button>
                                                    </div>
                                                    <div class="form-group col-md-6 col-12">
                                                        <a href="remove" class="btn btn-outline-primary col-md-12 col-12" data-confirm="Are you sure you want to remove your account?" data-confirm-yes="window.location.href = 'remove';">Delete Account</a>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>

                <!-- Footer -->
                <footer class="main-footer">
                </footer>
            </div>
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
        <script src="stisla/dist/assets/modules/bootstrap-daterangepicker/daterangepicker.js"></script>
        <script src="stisla/dist/assets/modules/jquery-selectric/jquery.selectric.min.js"></script>

        <!-- Page Specific JS File -->

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