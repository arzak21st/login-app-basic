<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dev.arzak21st.loginapp.models.UserCredential"%>

<!--
    - Replace "assets/" with "stisla/dist/assets/" for all JSPs
    - Replace ".html" with ".jsp" for all JSPs
-->

<%
    // Objects
    UserCredential userCredential = (UserCredential) session.getAttribute("userCredential");

    if(userCredential != null) {
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no" name="viewport">
        <title>Dashboard</title>

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
                                    <%= userCredential.getUsername() %>
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
                            <li class=active><a class="nav-link" href="index"><i class="far fa-square"></i> <span>Dashboard</span></a></li>
                        </ul>
                    </aside>
                </div>

                <!-- Main Content -->
                <div class="main-content">
                    <section class="section">

                        <!-- Body Bar -->
                        <div class="section-header">
                            <h1>Dashboard</h1>
                            <div class="section-header-breadcrumb">
                                <div class="breadcrumb-item">Dashboard</a></div>
                            </div>
                        </div>

                        <!-- Body -->
                        <div class="section-body">

                            <!-- Welcome Message -->
                            <h2 class="section-title">
                                Hi, <%= userCredential.getUsername() %>
                            </h2>
                            <p class="section-lead">
                                Go to the <a href="reset">profile</a> section and see what you can do.
                            </p>
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