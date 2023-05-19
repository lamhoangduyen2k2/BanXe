<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col-md-12 col-sm-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>
						Chỉnh sửa số lượng đặt
					</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
						
						<li><a class="close-link"><i class="fa fa-close"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<c:url value="/admin/order/item/edit" var="edit"></c:url>
					<form role="form" action="${edit}" method="post"
						enctype="multipart/form-data">
						
						<input name="ido" value="${model.orderId }" hidden="">
						<input name="productId" value="${model.productId }" hidden="">
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="product">Product name <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="product" name="product" readonly
									class="form-control " value="${model.product.name}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="count_SP">Quantity <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="count_SP" name="count_SP" required="required"
									class="form-control " value="${model.count_SP}" />
							</div>
						</div>
						<div class="ln_solid">
							<div class="form-group">
								<div class="col-md-6 offset-md-3">
									<input type="submit" value="Edit" class="btn btn-success" />
									<a href="<c:url value='/admin/order/item?ido=${model.orderId }'/>" class="btn btn-primary"><i class="fa fa-backward" style="margin-right:5px"></i>Back</a>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>