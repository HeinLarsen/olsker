<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to the frontpage
    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to the frontpage
    </jsp:attribute>

    <jsp:body>

        <p>Startcode for 2nd semester </p>

        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of "${sessionScope.user.role}".</p>
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. You can do it here: <a
                    href="login.jsp">Login</a></p>

            <!-- slideshow carousel toppings-->
                <div id="carouselExampleControls" class="carousel slide" data-interval="0">

                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-50" src="./images/Blue_cheeseTop.JPG" alt="First slide">
                    </div>

                    <div class="carousel-item">
                        <img class="d-block w-50" src="./images/BlueberryTop.JPG" alt="Second slide">
                    </div>

                    <div class="carousel-item">
                        <img class="d-block w-50" src="./images/ChocolateTop.JPG" alt="Third slide">

                    </div>

                    <div class="carousel-item">
                    <img class="d-block w-50" src="./images/CrispyTop.JPG" alt="Third slide">

                    </div>
                    <div class="carousel-item">
                    <img class="d-block w-50" src="./images/LemonTop.JPG" alt="Third slide">
                    </div>

                    <div class="carousel-item">
                    <img class="d-block w-50" src="./images/OrangeTop.JPG" alt="Third slide">
                    </div>

                    <div class="carousel-item">
                    <img class="d-block w-50" src="./images/RasberryTop.JPG" alt="Third slide">
                    </div>

                    <div class="carousel-item">
                    <img class="d-block w-50" src="./images/RumRaisinTop.JPG" alt="Third slide">
                    </div>

                    <div class="carousel-item">
                    <img class="d-block w-50" src="./images/StrawberryTop.JPG" alt="Third slide">
                    </div>
                    </div>


                <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>


            <!-- slideshow carousel Bottom-->
            <div id="carouselExampleControls2" class="carousel slide" data-interval="0">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-50" src="./images/AlmondBottom.JPG" alt="First slide">
                    </div>

                    <div class="carousel-item">
                        <img class="d-block w-50" src="./images/ChocolateBottom.JPG" alt="Second slide">
                    </div>

                    <div class="carousel-item">
                        <img class="d-block w-50" src="./images/NutmegBottom.JPG" alt="Third slide">

                    </div>

                    <div class="carousel-item">
                        <img class="d-block w-50" src="./images/PistacioBottom.JPG" alt="Third slide">

                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-50" src="./images/VanillaBottom.JPG" alt="Third slide">
                    </div>

                </div>





                <a class="carousel-control-prev" href="#carouselExampleControls2" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleControls2" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>



            <div>


            </div>

                 </c:if>

    </jsp:body>

</t:pagetemplate>