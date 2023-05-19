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
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
						<li><a class="close-link"><i class="fa fa-close"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<form class="" action="" method="post" novalidate>
						<span class="section">Thông tin danh mục</span>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Category name</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${cate._name}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Slug</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${cate.slug}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Category father</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${cate.category._name}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Is deleted</label>
							<div class="col-md-6 col-sm-6">
								<c:choose>
									<c:when test="${cate.isDeleted}">
										<input class="form-control" readonly="readonly"
									value ="Is deleted" />
  									</c:when>
									<c:otherwise>
										<input class="form-control" readonly="readonly"
									value ="Isn't deleted" />
 									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Image</label>
							<div class="col-md-6 col-sm-6">
								<c:url value="/image?fname=${cate._image }" var="imgUrl"></c:url>
								<img class="img-responsive" width="100px" src="${imgUrl}" alt="">
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Created At</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${cate.createdAt}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Updated At</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${cate.updatedAt}" />
							</div>
						</div>
						<div class="ln_solid">
							<div class="form-group">
								<div class="col-md-6 offset-md-3">
									<a href="<c:url value='/admin/category/add'/>" class="btn btn-success"><i class="fa fa-plus" style="margin-right:5px"></i>Add</a>
									<a href="<c:url value='/admin/category/edit?_id=${cate._id}'/>" class="btn btn-warning"><i class="fa fa-edit" style="margin-right:5px"></i>Edit</a>
									<a href="<c:url value='/admin/category/delete?_id=${cate._id}'/>" class="btn btn-danger"><i class="fa fa-remove" style="margin-right:5px"></i>Delete</a>
									<a href="<c:url value='/admin/category'/>" class="btn btn-primary"><i class="fa fa-backward" style="margin-right:5px"></i>Back</a>
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