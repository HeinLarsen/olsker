<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Lav din egen cupcake
    </jsp:attribute>


    <jsp:body>

        <!-- slideshow carousel toppings-->
        <div id="carouselExampleControls" class="carousel slide" data-interval="0">
            <div class="carousel-inner">
                <c:forEach items="${requestScope.cupcakeTop}" var="topping" varStatus="status">
                    <div class="carousel-item ${status.index == 0 ? 'active' : ''}">
                        <img class="d-block w-50" src="./images/topping/${topping.name}.JPG">
                    </div>

                </c:forEach>
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
                <c:forEach items="${requestScope.cupcakeBottom}" var="bottom" varStatus="status">
                    <div class="carousel-item ${status.index == 0 ? 'active' : ''}">
                        <img class="d-block w-50" src="./images/bottom/${bottom.name}.JPG">
                    </div>
                </c:forEach>
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
            <form action="addtocart" method="post">
                <input type="hidden" name="top" value="3">
                <input type="hidden" name="bottom" value="2">
                <input type="hidden" name="quantity" value="1">
                <button type="submit">+</button>
            </form>

        </div>


    </jsp:body>

</t:pagetemplate>