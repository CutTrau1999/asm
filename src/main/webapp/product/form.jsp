<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.asm.entity.Product" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
%>



<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/include/header.jsp">
        <jsp:param name="title" value="Product form"/>
        <jsp:param name="description" value="Product form"/>
        <jsp:param name="keywords" value="admin, page...."/>
    </jsp:include>
    <style>
        .msg-error {
            color: red;
        }
    </style>
</head>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
    <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
    <span class="w3-bar-item w3-right">Admin page</span>
</div>

<jsp:include page="/include/left-menu.jsp"/>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

    <!-- Header -->
    <header class="w3-container" style="padding-top:22px">
        <h5><b><i class="fa fa-dashboard"></i> Product form</b></h5>
    </header>

    <div class="w3-padding w3-margin-bottom">
        <form action="/product/create" method="post" class="w3-container w3-padding w3-card-4 w3-margin">

            <div class="w3-margin">
                <label>Name</label>
                <input class="w3-input" type="text" name="name"  value="${product.getName()}">
                <c:if test="${errors != null && errors.containsKey('product')}">
                    <span class="msg-error"><c:out value="${errors.get('name')}"/></span>
                </c:if>
            </div>
           <div class="w3-margin">
               <label>Danh muc</label>
              <select class="w3-input" name="idDM">
                  <c:forEach var="category" items="${listCategory}">
                                    <option value="${category.getId()}"><c:out value="${category.getName()}"/></option>
                  </c:forEach>
              </select>
           </div>

            <div class="w3-margin">
                <label>Price</label>
                <input class="w3-input" type="number" name="price" required value="${product.getPrice()}">

            </div>
            <div class="w3-margin">
                <label>Description</label>
                <input class="w3-input" type="text" name="description" required  value="${product.getDescription()}">

            </div>
            <div class="w3-margin">
                <label>Thumbnail</label>
                <input class="w3-input" type="url" name="thumbnail"  value="${product.getThumbnail()}">

            </div>
            <div class="w3-margin">
                <label>Sell Day</label>
                <input class="w3-input" type="datetime-local" name="sellday" value="${product.getSellday()}">
            </div>
            <div class="w3-margin">
                <label>Edit Day</label>
                <input class="w3-input" type="datetime-local" name="editday" value="${product.getEditday()}">
            </div>
            <div class="w3-margin">
                <label>Status</label>
                <select class="w3-input" name="status">
                    <option>Đang bán</option>
                    <option>Dừng bán</option>
                    <option>Đã xóa</option>
                </select>
            </div>
            <button class="w3-btn w3-blue w3-margin" value="Save">Submit</button>
        </form>
    </div>
    <hr>
    <!-- Footer -->
    <jsp:include page="/include/footer.jsp"/>
    <!-- End page content -->
</div>
<jsp:include page="/include/script.jsp"/>
</body>
</html>

