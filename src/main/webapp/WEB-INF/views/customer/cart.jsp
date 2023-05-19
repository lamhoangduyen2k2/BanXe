<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="vn.models.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="fr">
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

	<div class="container mb-4">
		<div class="row">
			<div class="col-12">
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">Image</th>
								<th scope="col">Name Product</th>
								<th scope="col" class="text-center">Quantity</th>
								<th scope="col" class="text-right">Price</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listcartitems}" var="cartItem" varStatus="STT">
								<tr>
									<td><c:url value="/image?fname=${ cartItem.product.getImage()}" var="imgUrl"></c:url>
                    					<img src="${imgUrl}" alt="" class="rounded-circle" width="150"></td>
									<td>${cartItem.product.name}</td>
									<td class="text-center">
									
									<!-- <form action="#" method="post" enctype="multipart/form-data"> -->
										<%-- <input name="uid" value="${sessionScope.account._id}" type="text" hidden="">
										<input name="caItemId" value="${cartItem._id}" type="text" hidden=""> --%>
										<button>
											<a href="<c:url value="cart-delete?uid=${sessionScope.account._id}&caItemId=${cartItem._id}"/>">-</a>
										</button> ${cartItem.count_SP}
										<button>
											<a href="<c:url value="cart-increase?uid=${sessionScope.account._id}&caItemId=${cartItem._id}"/>">+</a>
										</button>
									<!-- </form> -->
									</td>
									<td class="text-right">${cartItem.product.price}$</td>
									<td class="text-right"><%-- <a class="btn btn-sm btn-danger"
										href="<%=request.getContextPath() %>/cart?action=remove&productId=${cartItem.product._id}"><i
											class="fa fa-trash"></i> </a> --%></td>
								</tr>
							</c:forEach>
							<%-- <tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>Sub-Total</td>
								<td class="text-right"><%=totalPrice%></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>Shipping</td>
								<td class="text-right">10 $</td>
							</tr> --%>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td><strong>Total</strong></td>
								<td class="text-right"><strong>${total}</strong></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col mb-2">
				<div class="row">
					<div class="col-sm-12  col-md-6">
						<button class="btn btn-block btn-light">
							<a href="<c:url value="/home"/>">Continue Shopping</a>
						</button>
					</div>
					<div class="col-sm-12 col-md-6 text-right">
						<button class="btn btn-lg btn-block btn-success text-uppercase"> <a href="<c:url value="/order?uid=${sessionScope.account._id}"/>">Checkout</a></button>
					</div>
				</div>

			</div>

		</div>
	</div>
	<!-- </form> -->




	

</body>
</html>
