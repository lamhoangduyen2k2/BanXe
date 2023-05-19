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
						Thông tin người dùng
					</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
						
						<li><a class="close-link"><i class="fa fa-close"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<form class="" action="" method="post" novalidate>
						
					 
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Firstname</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${user.firstname}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Lastname</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${user.lastname}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Slug</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${user.slug}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">ID card</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${user.id_card}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Email</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${user.email}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Phone</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${user.phone}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Email Active</label>
							<div class="col-md-6 col-sm-6">
								<c:choose>
									<c:when test="${user.isEmalActive}">
										<input class="form-control" readonly="readonly"
									value ="Is active" />
  									</c:when>
									<c:otherwise>
										<input class="form-control" readonly="readonly"
									value ="Isn't active" />
 									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Phone Active</label>
							<div class="col-md-6 col-sm-6">
								<c:choose>
									<c:when test="${user.isPhoneActive}">
										<input class="form-control" readonly="readonly"
									value ="Is active" />
  									</c:when>
									<c:otherwise>
										<input class="form-control" readonly="readonly"
									value ="Isn't active" />
 									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Salt</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${user.salt}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Password</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${user.hashed_password}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Role</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${user._role}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Addresses</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${user.addresses}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Avatar</label>
							<div class="col-md-6 col-sm-6">
								<c:url value="/image?fname=${user.avatar }" var="imgUrl"></c:url>
								<img class="img-responsive" width="100px" src="${imgUrl}" alt="">
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Cover</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${user.cover}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Point</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${user.point}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">E_wallet</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${user.e_wallet}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Created At</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${user.createdAt}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Updated At</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${user.updatedAt}" />
							</div>
						</div>
						<div class="ln_solid">
							<div class="form-group">
								<div class="col-md-6 offset-md-3">
									<a href="<c:url value='/admin/user/add'/>" class="btn btn-success"><i class="fa fa-plus" style="margin-right:5px"></i>Add</a>
									<a href="<c:url value='/admin/user/edit?_id=${user._id}'/>" class="btn btn-warning"><i class="fa fa-edit" style="margin-right:5px"></i>Edit</a>
									<a href="<c:url value='/admin/user/delete?_id=${user._id}'/>" class="btn btn-danger"><i class="fa fa-remove" style="margin-right:5px"></i>Delete</a>
									<a href="<c:url value='/admin/user'/>" class="btn btn-primary"><i class="fa fa-backward" style="margin-right:5px"></i>Back</a>
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