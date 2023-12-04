<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="category" class="com.ute.ecwebapp.beans.Category" scope="request" />

<t:main>
    <jsp:body>
        <form method="post">
            <div class="card">
                <h5 class="card-header">
                    Category
                </h5>
                <div class="card-body">
                    <div class="form-group">
                        <label for="txtCatID">#</label>
                        <input name="CatID" value="${category.catID}" type="text" class="form-control" id="txtCatID" readonly>
                    </div>
                    <div class="form-group">
                        <label for="txtCatName">Category</label>
                        <input name="CatName" value="${category.catName}" type="text" class="form-control" id="txtCatName" autofocus>
                    </div>
                </div>
                <div class="card-footer text-muted">
                    <a class="btn btn-outline-success" href="${pageContext.request.contextPath}/Admin/Category" role="button">
                        <i class="fa fa-backward" aria-hidden="true"></i>
                        Back
                    </a>
                    <button type="submit" class="btn btn-danger" formaction="${pageContext.request.contextPath}/Admin/Category/Delete">
                        <i class="fa fa-trash" aria-hidden="true"></i>
                        Delete
                    </button>
                    <button type="submit" class="btn btn-primary" formaction="${pageContext.request.contextPath}/Admin/Category/Update">
                        <i class="fa fa-check" aria-hidden="true"></i>
                        Save
                    </button>
                </div>
            </div>
        </form>
    </jsp:body>
</t:main>

