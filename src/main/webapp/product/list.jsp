<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.asm.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: Ben
  Date: 12/30/2021
  Time: 1:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ArrayList<Product> listProduct = (ArrayList<Product>) request.getAttribute("list");
    request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/include/header.jsp">
        <jsp:param name="title" value="My admin page"/>
        <jsp:param name="description" value="Admin area"/>
        <jsp:param name="keywords" value="admin, page..."/>
    </jsp:include>
</head>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
    <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i> Â Menu</button>
    <span class="w3-bar-item w3-right">Admin page</span>
</div>

<!-- Sidebar/menu -->
<jsp:include page="/include/left-menu.jsp"/>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

    <!-- Header -->
    <header class="w3-container" style="padding-top:22px">
        <h5><b><i class="fa fa-list"></i> List product</b></h5>
    </header>

    <table class="w3-table-all">
        <tr>
            <th>Tên món ăn</th>
            <th>Hình Ảnh</th>


            <th>Giá</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        <%
            for (int i = 0; i < listProduct.size(); i++) {
        %>
        <tr>

            <th><%=listProduct.get(i).getName()%></th>
            <th>
                <img src="<%=listProduct.get(i).getThumbnail()%>" style="width: 70px" class="w3-border w3-padding" alt="Alps">
            </th>



            <th><%=listProduct.get(i).getPrice()%></th>
            <th><%=listProduct.get(i).getStatus()%></th>
            <th>
                <a href="/admin/product/detail?id=<%=listProduct.get(i).getName()%>">Detail</a>&nbsp;
                <a href="/admin/product/edit?id=<%=listProduct.get(i).getName()%>">Edit</a>&nbsp;
                <a href="/admin/product/delete?id=<%=listProduct.get(i).getName()%>">Delete</a>&nbsp;
            </th>
        </tr>
        <%
            }
        %>
    </table>

    <!-- Footer -->
    <jsp:include page="/include/footer.jsp"/>
    <!-- End page content -->
</div>