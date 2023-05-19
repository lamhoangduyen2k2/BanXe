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
						Chỉnh sửa thông tin người dùng
					</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
						 
						<li><a class="close-link"><i class="fa fa-close"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<c:url value="/admin/user/edit" var="edit"></c:url>
					<form role="form" action="${edit}" method="post"
						enctype="multipart/form-data">
						 
						<input name="_id" value="${user._id }" hidden="">
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="firstname">First Name <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="firstname" name="firstname" required="required"
									class="form-control " value="${user.firstname}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="lastname">Last Name <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="lastname" name="lastname" required="required"
									class="form-control " value="${user.lastname}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="id_card">ID card <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="id_card" name="id_card" required="required"
									class="form-control " value="${user.id_card}" readonly="readonly"/>
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="salt">Salt <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="salt" name="salt" required="required"
									class="form-control " value="${user.salt}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="hashed_password">Password<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="hashed_password" name="hashed_password" required="required"
									class="form-control " value="${user.hashed_password}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="control-label col-md-3 col-sm-3 label-align">Role<span class="required">*</span></label>
							<div class="col-md-6 col-sm-6 ">
								<select class="form-control" name="_role" id="_role" required="required">
									<option>User</option>
									<option>Admin</option>
									<option>Staff</option>
								</select>
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="addresses">Addresses <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="addresses" name="addresses" required="required"
									class="form-control " value="${user.addresses}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="avatar">Avatar <span class="required">*</span>
							</label>
							<div class="col-md-3 col-sm-3 ">
								<c:url value="/image?fname=${user.avatar }" var="imgUrl"></c:url>
								<img class="img-responsive" width="100px" src="${imgUrl}" alt="">
							</div>
							<div class="col-md-3 col-sm-3 ">
								<input type="file" id="avatar" name="avatar" required="required"
									class="form-control " value="${user.avatar}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="point">Point <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="point" name="point" required="required"
									class="form-control " value="${user.point}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="e_wallet">E wallet <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="e_wallet" name="e_wallet" required="required"
									class="form-control " value="${user.e_wallet}" />
							</div>
						</div>
						<div class="ln_solid">
							<div class="form-group">
								<div class="col-md-6 offset-md-3">
									<a href="<c:url value='/admin/user/add'/>"
										class="btn btn-success"><i class="fa fa-plus"
										style="margin-right: 5px"></i>Add</a>
										<input type="submit" value="Edit" class="btn btn-warning" /> 
										 <a
										href="<c:url value='/admin/user/delete?_id=${user._id}'/>"
										class="btn btn-danger"><i class="fa fa-remove"
										style="margin-right: 5px"></i>Delete</a> 
										<a
										href="<c:url value='/admin/user'/>" class="btn btn-primary"><i
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