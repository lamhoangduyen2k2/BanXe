<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<%@include file="/common/taglib.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="home">Home</a></li>
						<!-- <li class="breadcrumb-item"><a href="category?cid=0">Category</a></li> -->
						<li class="breadcrumb-item active" aria-current="page">Sub-category</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-12 col-sm-3">
				<div class="card bg-light mb-3">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-list"></i> Categories
					</div>
					<ul class="list-group category_block">
						<c:forEach items="${listcate }" var="p">
						<c:url var="editUrl" value="/category">
						<c:param name="cid" value="${p._id}"/>
						</c:url>
						
							<li class="list-group-item ${tag==p._id ? "active":""}">
							
							<%-- <a href="category?cid=${p._id }&tag=${tag}&index1=-2"> ${p._name }</a></li> --%>
							<a href="${editUrl }&tag=${tag}&index1=-2"> ${p._name }</a></li>
						</c:forEach>

					</ul>
				</div>
			<%-- 	<div class="card bg-light mb-3">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-list"></i> Số lượng sản phẩm : 
					<c:if test="${tag1==-1 }">${tag1 }</c:if>
					<c:if test="${tag1!=-1 }">${tag1+2 }</c:if>
					</div>
					<ul class="list-group category_block">
							<li class="list-group-item"><a href="${pageContext.request.contextPath}/category?index=${tag}&index1=-1">All</a></li>
							<li class="list-group-item"><a href="${pageContext.request.contextPath}/category?index=${tag}&index1=8">10</a></li>
							<li class="list-group-item"><a href="${pageContext.request.contextPath}/category?index=${tag}&index1=3">5</a></li>
							<li class="list-group-item"><a href="${pageContext.request.contextPath}/category?index=${tag}&index1=1">3</a></li>

					</ul>
				</div> --%>
				<div class="card bg-light mb-3">
					<div class="card-header bg-success text-white text-uppercase">Last
						product</div>

					<div class="card-body">
						<c:url value="/image?fname=${list1product.getImage() }" var="imgUrl"></c:url>
						<img class="img-fluid border-0" width="200px" height="100px"
							src="${imgUrl}" alt="">
						<h5 class="card-title">${list1product.name}</h5>
						<p class="card-text">${list1product.description}</p>
						<p class="bloc_left_price">${list1product.price}$</p>
					</div>

				</div>
			</div>
			
			<div class="col">
				<div id="content" class="row">
					<c:forEach items="${listall}" var="p">
						<div class="col-12 col-md-6 col-lg-4">
							<div class="card">
								<c:url value="/image?fname=${p.getImage() }" var="imgUrl"></c:url>
								<img class="img-fluid border-0" width="200px" height="100px"
									src="${imgUrl}" alt="">
								<div class="card-body">
									<h4 class="card-title">
										<a href="product?pid=${p._id }" title="View Product">${p.name }</a>
									</h4>
									<p class="card-text">${p.description }</p>
									<div class="row">
										<div class="col">
											<p class="btn btn-danger btn-block">${p.price}$</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					<c:if test="${indexP2!=-1 and indexP2!=-2}">
						<div class="col-12">
							<nav aria-label="...">
								<ul class="pagination">
									<c:if test="${tag>1 }">
										<li class="page-item"><a class="page-link"
											href="${pageContext.request.contextPath}/category?index=${tag-1}&index1=${tag1}"></a></li>
									</c:if>
									<c:forEach begin="1" end="${endPage}" var="i">
										<li class="page-item ${tag==i? "active":""}"><a
											class="page-link"
											href="${pageContext.request.contextPath}/category?index=${i}&index1=${tag1}">${i}</a></li>
									</c:forEach>
									<c:if test="${tag<endPage }">
										<li class="page-item"><a class="page-link"
											href="${pageContext.request.contextPath}/category?index=${tag+1}&index1=${tag1}"></a></li>

									</c:if>
								</ul>
							</nav>
						</div>
					</c:if>
				</div>


			</div>
		</div>

	</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
		function loadMore() {
			//var amount = document.getElementsByClassName("product").length;
			$.ajax({
				url : "/BanHang/load", //send to Controller
				type : "get", //send it through get method
				success : function(data) {
					//$("#content").append(data);
					var row = document.getElementsById("content");
					row.innerHTML += data;
				},
				error : function(xhr) {
					//Do Something to handle error
				}
			});
		};
}
	</script>

