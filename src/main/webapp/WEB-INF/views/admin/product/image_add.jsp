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
						Thêm hình ảnh
					</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
						
						<li><a class="close-link"><i class="fa fa-close"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<c:url value="/admin/product/image/add" var="add"></c:url>
					<form role="form" action="${add}" method="post"
						enctype="multipart/form-data">
						<input name="_id" value="${productId }" hidden="">
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="image">Image <span class="required">*</span>
							</label>
							<div class="col-md-3 col-sm-3 ">
								<input type="file" id="image" name="image" required="required"
									class="form-control " />
							</div>
						</div>
						<div class="ln_solid">
							<div class="form-group">
								<div class="col-md-6 offset-md-3">
									<input type="submit" value="Add" class="btn btn-success" />
									<a href="<c:url value='/admin/product/image?_id=${productId }'/>" class="btn btn-primary"><i class="fa fa-backward" style="margin-right:5px"></i>Back</a>
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