<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="categoriesWithDetails" scope="request" type="java.util.List<com.ute.ecwebapp.beans.Category>"/>

<div class="card">
    <h4 class="card-header">
        Categories
    </h4>
    <div class="list-group list-group-flush">
        <c:forEach items="${categoriesWithDetails}" var="c">
            <a href="${pageContext.request.contextPath}/Product/ByCat?id=${c.catID}" class="list-group-item list-group-item-action">
                <i class="fa fa-caret-right" aria-hidden="true"></i>
                    ${c.catName}
            </a>
        </c:forEach>
        <%--<a href="#" class="list-group-item list-group-item-action active" aria-current="true">--%>
        <%--  The current link item--%>
        <%--</a>--%>
    </div>
</div>

<div class="card mt-3">
    <h4 class="card-header">
        Popular Brands <i class="fa fa-star" aria-hidden="true"></i>
    </h4>
    <div class="list-group list-group-flush">
        <a href="https://saigonswagger.com/" class="list-group-item list-group-item-action">SAIGONSWAGGER </a>
        <a href="https://dirtycoins.vn/" class="list-group-item list-group-item-action">DIRTYCOINS</a>
        <a href="https://www.uniqlo.com/vn/vi/" class="list-group-item list-group-item-action">UNIQLO</a>
    </div>
</div>