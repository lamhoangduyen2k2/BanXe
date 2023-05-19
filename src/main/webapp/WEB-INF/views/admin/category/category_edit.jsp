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
						Chỉnh sửa danh mục
					</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
						<li><a class="close-link"><i class="fa fa-close"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<c:url value="/admin/category/edit" var="edit"></c:url>
					<form role="form" action="${edit}" method="post"
						enctype="multipart/form-data">
						<input name="_id" value="${cate._id }" hidden="">
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="_name">Category Name <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="_name" name="_name" required="required"
									class="form-control " value="${cate._name}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="control-label col-md-3 col-sm-3 label-align">Category father<span class="required">*</span></label>
							<div class="col-md-6 col-sm-6 ">
								<select class="form-control" name="categoryId" id="categoryId" required="required">
									<option value="0">None</option>
									<c:forEach items="${cateList}" var="_cate">
										<option value="${_cate._id}">${_cate._name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="_image">Image <span class="required">*</span>
							</label>
							<div class="col-md-3 col-sm-3 ">
								<c:url value="/image?fname=${cate._image }" var="imgUrl"></c:url>
								<img class="img-responsive" width="100px" src="${imgUrl}" alt="">
							</div>
							<div class="col-md-3 col-sm-3 ">
								<input type="file" id="_image" name="_image" required="required"
									class="form-control " value="${user.avatar}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="control-label col-md-3 col-sm-3 label-align">Is deleted<span class="required">*</span></label>
							<div class="col-md-6 col-sm-6 ">
								<select class="form-control" name="isDeleted" id="isDeleted" required="required">
									<option>False</option>
									<option>True</option>
								</select>
							</div>
						</div>
						<div class="ln_solid">
							<div class="form-group">
								<div class="col-md-6 offset-md-3">
									<a href="<c:url value='/admin/category/add'/>"
										class="btn btn-success"><i class="fa fa-plus"
										style="margin-right: 5px"></i>Add</a>
										<input type="submit" value="Edit" class="btn btn-warning" /> 
										 <a
										href="<c:url value='/admin/category/delete?_id=${cate._id}'/>"
										class="btn btn-danger"><i class="fa fa-remove"
										style="margin-right: 5px"></i>Delete</a> 
										<a
										href="<c:url value='/admin/category'/>" class="btn btn-primary"><i
										class="fa fa-backward" style="margin-right: 5px"></i>Back</a>
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