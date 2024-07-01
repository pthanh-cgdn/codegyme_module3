<%--
  Created by IntelliJ IDEA.
  User: tphan
  Date: 28/6/24
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">QuickBuy</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/product">Product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Support</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<a href="/product?action=create">
    <p>
        <c:if test='${message} != null}'>
            <span class="message">${message}</span>
        </c:if>
    </p>
    <button class="btn btn-primary mt-4">Add new Product</button>
</a>
<table class="table table-hover">
    <thead>
    <tr>
        <th>Product ID</th>
        <th>Name</th>
        <th>Category</th>
        <th>Manufacture</th>
        <th>Price</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
    <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.categoryName}</td>
        <td>${product.manufacture}</td>
        <td>${product.price}</td>
        <td>
            <a href="/product?action=edit&id=${product.id}"><button class="btn btn-warning">Edit</button></a>
            <button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal${product.id}">Xóa
            </button>
            <div class="modal fade" id="deleteModal${product.id}" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Delete product</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            Do you want to delete product name: ${product.name}?
                            <p style="color: red">This action counldn't be revert</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                            <form method="post" action="/product?action=delete">
                                <button type="submit" class="btn btn-primary">Confirm</button>
                                <input type ="hidden" name="id" value="${product.id}">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </td>
        </c:forEach>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
