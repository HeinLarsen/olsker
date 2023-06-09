<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Lav din egen cupcake
    </jsp:attribute>


    <jsp:body>

        <div class="row">
            <h4 class="top mb-0">Top:</h4>
            <div class="col-lg-9 col-12">
                <form action="addtocart" method="post">
                    <div class="row">
                        <c:forEach items="${applicationScope.toppingList}" var="topping" varStatus="loop">
                            <div class="col-lg-2 col-md-4 col-6 mb-0">
                                <input type="radio" name="top" id="tp${topping.name}" value="${topping.id}" <c:if test="${loop.first}">checked</c:if>>
                                <div class="card">
                                    <label for="tp${topping.name}">
                                        <img src="images/topping/${topping.name}.JPG" draggable="false">
                                        <p class="p-1 mb-0">${topping.name}</p>
                                        <i class="p-1"> ${topping.price} kr,-</i>
                                    </label>
                                </div>
                            </div>

                        </c:forEach>
                    </div>

                    <div class="row">
                        <h5 class="bund mt-1 mb-0">Bund:</h5>
                        <c:forEach items="${applicationScope.bottomList}" var="bottom" varStatus="loop">
                            <div class="col-lg-2 col-md-4 col-6 mb-3">
                                <input type="radio" name="bottom" id="bm${bottom.name}" value="${bottom.id}" <c:if test="${loop.first}">checked</c:if>>

                                <div class="card">

                                    <label for="bm${bottom.name}">
                                        <img src="images/bottom/${bottom.name}.JPG" draggable="false">
                                        <p class="p-1 mb-0">${bottom.name}</p>
                                        <i class="p-1"> ${bottom.price} kr,-</i>
                                    </label>
                                </div>

                            </div>

                        </c:forEach>
                    </div>
                    <div class="row justify-content-center mb-2">
                    <div class="col-2">
                        <input type="hidden" name="quantity" value="1">
                        <button class="btn btn-success w-100" type="submit">+</button>
                    </div>
                    </div>


                </form>
            </div>

            <t:cart showQuantityBtns="true" url="order" type="get" btnText="Til kassen" prop="${sessionScope.shoppingcart}" showPaymentBtn="true" title="Kurv"/>

        </div>





        


    </jsp:body>

</t:pagetemplate>