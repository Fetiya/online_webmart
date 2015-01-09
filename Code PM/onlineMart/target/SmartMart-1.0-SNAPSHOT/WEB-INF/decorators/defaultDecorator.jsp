<%-- 
    Document   : defaultdDecorator
    Created on : Jan 3, 2015, 8:02:45 AM
    Author     : Fetiya
--%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Cart | SmartMart E-Shopper</title>
        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/bootstrap/css/font-awesome.min.css" rel="stylesheet">
        <link href="resources/bootstrap/css/prettyPhoto.css" rel="stylesheet">
        <link href="resources/bootstrap/css/price-range.css" rel="stylesheet">
        <link href="resources/bootstrap/css/animate.css" rel="stylesheet">
        <link href="resources/bootstrap/css/main.css" rel="stylesheet">
        <link href="resources/bootstrap/css/responsive.css" rel="stylesheet">
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="resources/bootstrap/images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="resources/bootstrap/images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="resources/bootstrap/images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="resources/bootstrap/images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="resources/bootstrap/images/ico/apple-touch-icon-57-precomposed.png">

    </head>
    <body>
        <header id="header"><!--header-->
            <div class="header_top"><!--header_top-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="contactinfo">
                                <ul class="nav nav-pills">
                                    <li><a href="#"><i class="fa fa-phone"></i> +000000000</a></li>
                                    <li><a href="#"><i class="fa fa-envelope"></i> info@smartmart.com</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="social-icons pull-right">
                                <ul class="nav navbar-nav">
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header_top-->

            <div class="header-middle"><!--header-middle-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="logo pull-left">
                                <a href="${pageContext.request.contextPath}/index"><img src="resources/bootstrap/images/home/logo.png" alt="" /></a>
                            </div>

                        </div>
                        <div class="col-sm-8">
                            <div class="shop-menu pull-right">
                                <ul class="nav navbar-nav">
                                    <li class="dropdown register "><a href="#"><i class="fa fa-user"></i>Register<i class="fa fa-angle-down"></i></a>
                                        <ul  class="sub-menu">
                                            <li><a  href="addVendor">Vendor</a></li> 
                                            <li><a href="addCredential">Customer</a></li>
                                        </ul>
                                    </li>
                                    <!--                                    <li><a href="#"><i class="fa fa-user"></i> Account</a></li>-->

                                    <li><a href="${pageContext.request.contextPath}/checkout"><i class="fa fa-crosshairs"></i> Checkout</a></li>
                                    <li><a href="${pageContext.request.contextPath}/cart"><i class="fa fa-shopping-cart"></i> Cart</a></li>
                                        <c:choose>   
                                            <c:when test="${not empty loggedUser }">
                                            <li><a href="#"><i class="fa fa-user"></i> Account</a></li>
                                            <li>  ${loggedUser.firstName} ${loggedUser.lastName}</li>
                                            <li>  <a href="/SmartMart/j_spring_security_logout"><i class="fa fa-lock"></i> Logout</a>        </li>
                                            </c:when>
                                            <c:otherwise>
                                            <li><a href="${pageContext.request.contextPath}/addCustomer"><i class="fa fa-user"></i> Register</a></li>
                                            <li><a href="${pageContext.request.contextPath}/login"><i class="fa fa-lock"></i> Login</a></li>                                            
                                            </c:otherwise>
                                        </c:choose>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-middle-->

            <div class="header-bottom"><!--header-bottom-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-9">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                            </div>
                            <div class="mainmenu pull-left">
                                <ul class="nav navbar-nav collapse navbar-collapse">
                                    <li><a href="${pageContext.request.contextPath}/index" class="active">Home</a></li>
                                    <li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>
                                        <ul role="menu" class="sub-menu">
                                            <li><a href="products">Products</a></li>
                                            <li><a href="${pageContext.request.contextPath}/checkout">Checkout</a></li> 
                                            <li><a href="${pageContext.request.contextPath}/cart">Cart</a></li> 
                                            <li><a href="${pageContext.request.contextPath}/login">Login</a></li> 
                                        </ul>
                                    </li> 
                                   <!--<li><a href="contactUs">Contact </a></li>-->
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-3">

                            <c:import url="/searchProduct"/>

                        </div>
                    </div>
                </div><!--/header-bottom-->
        </header><!--/header-->
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="left-sidebar">
<!--                              <h2>Category</h2>
                                <div class="panel-group category-products" id="accordian">category-productsr
                                    < c:import  url="/navigation"/>

                                </div>

                                <div class="brands_products">brands_products
                                    <h2>Brands</h2>
                                    < c:import  url="/brands"/>
                                </div>/brands_products

                                <div class="shipping text-center">shipping
                                    <img src="resources/bootstrap/images/home/shipping.jpg" alt="" />
                                </div>/shipping-->

logged user    ${not empty loggedUser}
                            <security:authorize access="hasRole('ROLE_ANONYMOUS')">
                                <h2>Category</h2>
                                <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                                    <c:import  url="/navigation"/>

                                </div>

                                <div class="brands_products"><!--brands_products-->
                                    <h2>Brands</h2>
                                    <c:import  url="/brands"/>
                                </div><!--/brands_products-->

                                <div class="shipping text-center"><!--shipping-->
                                    <img src="resources/bootstrap/images/home/shipping.jpg" alt="" />
                                </div><!--/shipping-->
                            </security:authorize>

                            <security:authorize access="hasRole('ROLE_CUSTOMER')">
                                <h2>Category</h2>
                                <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                                    <c:import  url="/navigation"/>

                                </div>

                                <div class="brands_products"><!--brands_products-->
                                    <h2>Brands</h2>
                                    <c:import  url="/brands"/>
                                </div><!--/brands_products-->

                                <div class="shipping text-center"><!--shipping-->
                                    <img src="resources/bootstrap/images/home/shipping.jpg" alt="" />
                                </div><!--/shipping-->
                            </security:authorize>


                            <security:authorize access="hasRole('ROLE_ADMIN')" >
                                <a href="viewPendingVendors" >View pending Vendor</a><br/>
                                <a href="VendorsForUnsubscribe" >Vendor Unsubscribe</a><br/>
                                <a href="addSetting">Add Setting</a><br/>
                                <a href="viewCategory" >View Product Category </a><br/>
                                <a href="addProductCategory" >Add Product Category</a><br/>
                                <a href="viewCategory" >View Product Category </a><br/>
                            </security:authorize>

                            <security:authorize access="hasRole('ROLE_VENDORADMIN')" >

                                <a href="insertProduct">Insert Product</a><br/>         

                                <a href="report" target="_blank" >View Vendor Sales Report Weekly</a><br/><br />

                            </security:authorize>


                        </div>
                    </div>

                    <div class="col-sm-9 padding-right">
                        <sitemesh:write property='body'/>
                    </div>
                </div>
            </div>

        </section>


        <footer id="footer"><!--Footer-->
            <div class="footer-top">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-2">
                            <div class="companyinfo">
                                <h2><span>S</span>MART MART</h2>
                                <p>Buy Your Stuff  easily. Free Shopping World Wide</p>
                            </div>
                        </div>
                        <div class="col-sm-7">
                            <div class="col-sm-3">
                                <div class="video-gallery text-center">
                                    <a href="#">
                                        <div class="iframe-img">
                                            <img src="resources/bootstrap/images/home/iframe1.png" alt="" />
                                        </div>
                                        <div class="overlay-icon">
                                            <i class="fa fa-play-circle-o"></i>
                                        </div>
                                    </a>
                                    <p>Circle of Hands</p>
                                    <h2>1 JAN 2015</h2>
                                </div>
                            </div>

                            <div class="col-sm-3">
                                <div class="video-gallery text-center">
                                    <a href="#">
                                        <div class="iframe-img">images
                                            <img src="resources/bootstrap/images/home/iframe2.png" alt="" />
                                        </div>
                                        <div class="overlay-icon">
                                            <i class="fa fa-play-circle-o"></i>
                                        </div>
                                    </a>
                                    <p>Circle of Hands</p>
                                    <h2>1 JAN 2015</h2>
                                </div>
                            </div>

                            <div class="col-sm-3">
                                <div class="video-gallery text-center">
                                    <a href="#">
                                        <div class="iframe-img">
                                            <img src="resources/bootstrap/images/home/iframe3.png" alt="" />
                                        </div>
                                        <div class="overlay-icon">
                                            <i class="fa fa-play-circle-o"></i>
                                        </div>
                                    </a>
                                    <p>Circle of Hands</p>
                                    <h2>1 JAN 2015</h2>
                                </div>
                            </div>

                            <div class="col-sm-3">
                                <div class="video-gallery text-center">
                                    <a href="#">
                                        <div class="iframe-img">
                                            <img src="resources/bootstrap/images/home/iframe4.png" alt="" />
                                        </div>
                                        <div class="overlay-icon">
                                            <i class="fa fa-play-circle-o"></i>
                                        </div>
                                    </a>
                                    <p>Circle of Hands</p>
                                    <h2>1 JAN 2015</h2>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="address">
                                <img src="resources/bootstrap/images/home/map.png" alt="" />
                                <p>FairField IA 52557</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="footer-widget">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-2">
                            <div class="single-widget">
                                <h2>Service</h2>
                                <ul class="nav nav-pills nav-stacked">
                                    <li><a href="">Online Help</a></li>
                                    <li><a href="">Contact Us</a></li>
                                    <li><a href="">Order Status</a></li>
                                    <li><a href="">Change Location</a></li>
                                    <li><a href="">FAQ’s</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="single-widget">
                                <h2>Quock Shop</h2>
                                <ul class="nav nav-pills nav-stacked">
                                    <li><a href="">T-Shirt</a></li>
                                    <li><a href="">Mens</a></li>
                                    <li><a href="">Womens</a></li>
                                    <li><a href="">Gift Cards</a></li>
                                    <li><a href="">Shoes</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="single-widget">
                                <h2>Policies</h2>
                                <ul class="nav nav-pills nav-stacked">
                                    <li><a href="">Terms of Use</a></li>
                                    <li><a href="">Privecy Policy</a></li>
                                    <li><a href="">Refund Policy</a></li>
                                    <li><a href="">Billing System</a></li>
                                    <li><a href="">Ticket System</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="single-widget">
                                <h2>About Shopper</h2>
                                <ul class="nav nav-pills nav-stacked">
                                    <li><a href="">Company Information</a></li>
                                    <li><a href="">Careers</a></li>
                                    <li><a href="">Store Location</a></li>
                                    <li><a href="">Affillate Program</a></li>
                                    <li><a href="">Copyright</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-3 col-sm-offset-1">
                            <div class="single-widget">
                                <h2>About Shopper</h2>
                                <form action="#" class="searchform">
                                    <input type="text" placeholder="Your email address" />
                                    <button type="submit" class="btn btn-default"><i class="fa fa-arrow-circle-o-right"></i></button>
                                    <p>Get the most recent updates from <br />our site and be updated your self...</p>
                                </form>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

            <div class="footer-bottom">
                <div class="container">
                    <div class="row">
                        <p class="pull-left">Copyright © 2015 SMART MART Inc. All rights reserved.</p>
                        <p class="pull-right">Designed by <span><a target="_blank" href="#">SMART MART</a></span></p>
                    </div>
                </div>
            </div>

        </footer><!--/Footer-->



        <script src="resources/bootstrap/js/jquery.js"></script>
        <script src="resources/bootstrap/js/bootstrap.min.js"></script>
        <script src="resources/bootstrap/js/jquery.scrollUp.min.js"></script>
        <script src="resources/bootstrap/js/jquery.prettyPhoto.js"></script>
        <script src="resources/bootstrap/js/main.js"></script>
    </body>
</html>