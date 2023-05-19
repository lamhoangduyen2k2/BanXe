<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Site meta -->
<meta charset="utf-8">
<meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Free Bootstrap 4 Ecommerce Template</title>
<!-- CSS -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600"
	rel="stylesheet" type="text/css">
<link href="<c:url value = "/assets/templates/css/style.css" />" rel="stylesheet" type="text/css">
</head>
<body>
<link href="${pageContext.request.contextPath}/assets/templates/css/order.css" rel="stylesheet" type="text/css">
<div class="container">
    <div class="title">
        <h2>Đặt hàng</h2>
    </div>
    <div class="d-flex">
        <form action="order" method="post" enctype="multipart/form-data">
            <label>
                <span class="fname">Họ tên<!-- <span class="required">*</span> --></span>
                <input type="text" name="name" value="${sessionScope.account.firstname}">
            </label>
            <label>
                <span class="fname">Địa chỉ<span class="required">*</span></span>
                <input type="text" name="address" required>
            </label>
         
            <label>
                <span class="fname">Số điện thoại<span class="required">*</span></span>
                <input type="text" name="phone" required>
            </label>

            <div class="delivery">
                <h4>Phương thức giao hàng</h4>
                <c:forEach items="${deliveries}" var="del">
                    <div>
                        <input type="radio" name="delivery" value="${del._id}" checked> ${del.name}
                    </div>
                </c:forEach>
            </div>

            <input type="text" name="uid" value="${sessionScope.account._id}" hidden="">
            <input type="text" name="total" value="${total}" hidden="">
            <button type="submit">Đặt hàng</button>
        </form>
        <div class="Yorder">
            <table>
                <tr>
                    <th colspan="2">Đơn hàng</th>
                </tr>
                <c:forEach items="${listcartitems}" var="i">
                    <tr>
                        <td>${i.product.name} x ${i.count_SP}</td>
                        <td>
                            <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${i.count_SP*i.product.price}"/> đ
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td>Subtotal</td>
                    <td>
                        <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${total}"/> đ
                    </td>
                </tr>
            </table><br>

        </div>
        </div><!-- Yorder -->
    </div>
	<%-- <div class="container">
		<div class="card">
			<div class="card-header">
				Invoice
				<%
			LocalDateTime currDate = java.time.LocalDateTime.now();
			out.print("<strong> <class='font-monospace text-sm-left'>Date: " + currDate + "</strong>");
			%>
				<span class="float-right"> <strong>Status:</strong> Pending
				</span>
			</div>
			<div class="card-body">
				<div class="row mb-4">
					<div class="col-sm-6">
						<h6 class="mb-3">Customer:${sessionScope.account.firstname}
								${sessionScope.account.lastname}</h6>
						<div>Address: ${sessionScope.account.addresses}</div>
						<div>Phone: ${sessionScope.account.phone}</div>
						<div>Email: ${sessionScope.account.email}@gmail.com</div>
					</div>

				</div>

				<div class="table-responsive-sm">
					<table class="table table-striped">
						<thead>
							<tr>

								<th>Item</th>
								<th>Description</th>

								<th class="right">Unit Cost</th>
								<th class="center">Qty</th>
								<th class="right">Total</th>
							</tr>
						</thead>
						<c:set var="finalPrice" value="0" />
						<c:forEach items="${cart}" var="cartItem">
							<c:set var="productPrice"
								value="${cartItem.product.price*cartItem.getCount_SP()}" />
							<c:set var="finalPrice" value="${finalPrice + productPrice }" />
							<tbody>
								<tr>

									<td class="left strong">${cartItem.product.name}</td>
									<td class="left">${cartItem.product.description}</td>

									<td class="right">${cartItem.product.price}</td>
									<td class="center">${cartItem.count_SP}</td>
									<td class="right">${productPrice}0</td>
								</tr>
						</c:forEach>

						<div class="row">
							<div class="col-lg-4 col-sm-5"></div>

							<div class="col-lg-4 col-sm-5 ml-auto">
								<table class="table table-clear">
									<tbody>
										<tr>
											<td class="left"><strong>Subtotal</strong></td>
											<td class="right">$8.497,00</td>
										</tr>
										<tr>
											<td class="left"><strong>Discount (20%)</strong></td>
											<td class="right">$1,699,40</td>
										</tr>
										<tr>
											<td class="left"><strong>VAT (10%)</strong></td>
											<td class="right">$679,76</td>
										</tr>
										<tr>
											<td class="left"><strong>Total</strong></td>
											<td class="right"><strong>$7.477,36</strong></td>
										</tr>
									</tbody>
								</table>

							</div>

						</div>
				</div>
			</div>
		</div>
		 <form action="order" method="post">
		<div class="col-sm-12 col-md-6 text-right">
						<button class="btn btn-lg btn-block btn-success text-uppercase"> Confirm</button>
					</div>
		</form> --%>
</body>
</html>