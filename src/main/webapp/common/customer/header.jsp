<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Site meta -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Free Bootstrap 4 Ecommerce Template</title>
<!-- CSS -->

<link href="<c:url value = "templates/css/style.css" />"
	rel="stylesheet" type="text/css">


</head>
<body>

	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
		<a class="navbar-brand" href="#">Xe Đạp</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">

				<li class="nav-item active"><a class="nav-link" href="<c:url value="/home" />">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="/category?index=1&index1=-1"/>">Product</a>
				</li>

				
			</ul>

			<form method="post" action="search" class="form-inline my-2 my-lg-0">
				<c:if test="${sessionScope.account ==null }">
					<li class="nav-item"><a aria-haspopup="true"
						aria-expanded="false" style='font-size: 16px; color: white'
						href="login"> Sign in | Sign up </a></li>
				</c:if>
				<c:if test="${sessionScope.account !=null }">
					<li class="nav-item dropdown"><a class="fa fa-fw fa-user"
						href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"
						style='font-size: 32px; color: #28A745'> </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown"
							style="float: right;">

							<a class="dropdown-item " href="profile">Your profile</a>
							<a class="dropdown-item " href="<c:url value = "/dondat?uid=${sessionScope.account._id}"/>">Your Order</a> 
							<a class="dropdown-item " href="reset-password">Reset</a> 
							<a class="dropdown-item " href="logout">Logout</a>

						</div></li>
				</c:if>
				<div class="input-group input-group-sm">
					<input value="${txtS}" name="txt" type="text" class="form-control">
					<div class="input-group-append">
						<button type= "submit" class="btn btn-secondary btn-number">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
				<a class="btn btn-success btn-sm ml-3" href="<c:url value="/cart/cart-list?uid=${sessionScope.account._id}"/>"> <i
					class="fa fa-shopping-cart"></i>Cart <span
					class="badge badge-light">3</span>
				</a>

			</form>


		</div>
	</nav>
	<section class="jumbotron text-center">
		<div class="container">
			<h1 class="jumbotron-heading">E-COMMERCE BOOTSTRAP THEME</h1>
			<p class="lead text-muted mb-0">Simple theme for e-commerce buid
				with Bootstrap 4.0.0. Pages available : home, category, product,
				cart & contact</p>
		</div>
	</section>
</body>