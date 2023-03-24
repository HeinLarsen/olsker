<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Bruger balance
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <h3>Transactions</h3>
            <table>
                <Tr>
                    <th>Balance</th>
                    <th>Dato</th>
                </Tr>

                 <c:forEach var="transaction" items="${requestScope.transactions}">
                     <td>${transaction.amount}</td>
                     <td>${transaction.timestamp}</td>

                 </c:forEach>
            </table>
            <form>
            <div class="col-lg-4 col-12">

                <input type="hidden" value="${requestScope.user.id}" name="id">
                <input type="number" name="balance" value="${requestScope.user.balance}" class="form-control">

            </div>
            <div class="col-auto col-12">
                    <button class="btn btn-success" formaction="balance" formmethod="post">Tilføj Balance</button>
                <button class="btn btn-danger" formaction="balance" formmethod="post">Fjern Balance</button>
                </div>
            </form>
        </div>

    </jsp:body>

</t:pagetemplate>