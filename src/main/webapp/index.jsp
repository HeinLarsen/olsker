<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Lav din egen cupcake
    </jsp:attribute>


    <jsp:body>

        <div class="wrapper">
            <div class="main-content">
                <p>Kurv</p>
            </div>
            <div class="shopping-cart">

                <c:forEach items="${sessionScope.shoppingcart.cupcakeList}" var="item">
                    <p> ${item.top.name}</p>
                    <p> ${item.bottom.name}</p>
                </c:forEach>

                <form action="order" method="get">
                    <button type="submit">Kassen</button>
                </form>

            </div>
        </div>

        <form action="addtocart" method="post">
            <div class="dropdown">
                <select name="top">Topping
                    <c:forEach items="${applicationScope.toppingList}" var="topping">
                        <option value="${topping.id}" class="top">${topping.name}</option>

                    </c:forEach>
                </select>
            </div>

            <div class="dropdown">
                <select name="bottom">Bottom
                    <c:forEach items="${applicationScope.bottomList}" var="bottom">
                        <option value="${bottom.id}" class="bottom">${bottom.name  }</option>
                    </c:forEach>
                </select>
            </div>

            <input type="number" name="quantity" value="1">

            <button type="submit">+</button>
        </form>


    </jsp:body>

</t:pagetemplate>