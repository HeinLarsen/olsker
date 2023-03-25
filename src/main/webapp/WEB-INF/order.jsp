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
                    <b>balance:</b>  ${sessionScope.user.balance}
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
                    ${requestScope.sum}
            </div>
            <div class="col-auto">
                <c:if test="${requestScope.sum > sessionScope.user.balance}">
                    <p>Ikke nok penge</p>
                </c:if>
                <form>
                    <button type="submit" formmethod="post" formaction="order">Betal</button>
                </form>
            </div>
        </div>





    </jsp:body>

</t:pagetemplate>