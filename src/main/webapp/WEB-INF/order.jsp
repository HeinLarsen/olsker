<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Betaling
    </jsp:attribute>

    <jsp:body>
        <div class="row justify-content-center">
            <div class="col-8">
                <div class="row">
                    <div class="col-12">
                        <b>balance:</b>  ${sessionScope.user.balance}
                    </div>
                    <div class="col-12">
                        <form action="updatebalance" method="post">
                        <input class="form-control d-inline w-25" type="number" name="balance" value="${sessionScope.user.balance}">
                        <button class="btn btn-primary align-top">
                            Indsæt penge
                        </button>
                        </form>
                    </div>
                </div>
            </div>

        <div class="col-4">
                <div class="main-content">
                    <p>Kurv</p>
                </div>
                <div class="shopping-cart">
                    <c:forEach items="${sessionScope.shoppingcart.cupcakeList}" var="item">
                        <p> ${item.top.name}</p>
                        <p> ${item.bottom.name}</p>
                    </c:forEach>


                </div>
        </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-auto">
                <c:choose>
                    <c:when test="${requestScope.sum > sessionScope.user.balance}">
                        <p class="red">Ikke nok penge</p>
                        <button class="btn btn-primary" disabled>Betal</button>
                    </c:when>
                    <c:otherwise>
                        <form>
                            <button class="btn btn-primary" type="submit" formmethod="post" formaction="order">Betal</button>
                        </form>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>





    </jsp:body>

</t:pagetemplate>