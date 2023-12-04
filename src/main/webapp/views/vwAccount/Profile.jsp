<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main>
    <jsp:body>
        <div class="card">
            <h4 class="card-header">
                Profile
            </h4>
            <div class="card-body">
                <c:if test="${not empty sessionScope.authUser}">
                    <p>Xin chào, ${sessionScope.authUser.username}!</p>
                    <!-- Hiển thị thông tin cá nhân khác của người dùng -->
                    <p> Tên người dùng : ${sessionScope.authUser.name} </p>
                    <p> Email đăng ký:     ${sessionScope.authUser.email} </p>
                    <p> Ngày sinh:     ${sessionScope.authUser.dob} </p>
                </c:if>
                <c:if test="${empty sessionScope.authUser}">
                    <p>Người dùng chưa đăng nhập.</p>
                    <!-- Hoặc thực hiện các hành động khác nếu người dùng chưa đăng nhập -->
                </c:if>
            </div>
        </div>
    </jsp:body>
</t:main>