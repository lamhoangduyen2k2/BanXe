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
						Chỉnh sửa thông tin cửa hàng
					</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
						 
						<li><a class="close-link"><i class="fa fa-close"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<c:url value="/admin/store/edit" var="edit"></c:url>
					<form role="form" action="${edit}" method="post"
						enctype="multipart/form-data">
						 
						<input name="_id" value="${model._id }" hidden="">
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="_name">Store Name <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="_name" name="_name" required="required"
									class="form-control " value="${model._name}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="bio">Bio <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="bio" name="bio" required="required"
									class="form-control " value="${model.bio}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="avatar">Avatar <span class="required">*</span>
							</label>
							<div class="col-md-3 col-sm-3 ">
								<c:url value="/image?fname=${model.avatar }" var="imgUrl"></c:url>
								<img class="img-responsive" width="100px" src="${imgUrl}" alt="">
							</div>
							<div class="col-md-3 col-sm-3 ">
								<input type="file" id="avatar" name="avatar" required="required"
									class="form-control " value="${model.avatar}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="control-label col-md-3 col-sm-3 label-align">Is active<span class="required">*</span></label>
							<div class="col-md-6 col-sm-6 ">
								<select class="form-control" name="isActive" id="isActive" required="required">
									<option>False</option>
									<option>True</option>
								</select>
							</div>
						</div>
						<div class="field item form-group">
							<label class="control-label col-md-3 col-sm-3 label-align">Is open<span class="required">*</span></label>
							<div class="col-md-6 col-sm-6 ">
								<select class="form-control" name="isOpen" id="isOpen" required="required">
									<option>False</option>
									<option>True</option>
								</select>
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="point">Point <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="point" name="point" required="required"
									class="form-control " value="${model.point}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="e_wallet">E wallet <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="e_wallet" name="e_wallet" required="required"
									class="form-control " value="${model.e_wallet}" />
							</div>
						</div>
						<div class="col-md-12 col-sm-12  ">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										Chọn chủ cửa hàng
									</h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i
												class="fa fa-chevron-up"></i></a></li>
										<li><a class="close-link"><i class="fa fa-close"></i></a></li>
									</ul>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<div class="row">
										<div class="col-sm-12">
											<div class="card-box table-responsive">
												<p class="text-muted font-13 m-b-30">
												</p>
												<table id="datatable-checkbox"
													class="table table-striped jambo_table table-bordered bulk_action"
													style="width: 100%">
													<thead>
														<tr class="headings">
															<th><input type="checkbox" id="check-all"
																class="flat"></th>
															<th class="column-title">Firstname</th>
															<th class="column-title">Lastname</th>
															<th class="column-title">ID card</th>
															<th class="column-title">Email</th>
															<th class="column-title">Phone</th>
															<th class="column-title">Addresses</th>
														</tr>
													</thead>


													<tbody>
														<c:forEach items="${userList}" var="user">
															<tr class="odd pointer">
																<td class="a-center "><input type="checkbox"
																	class="flat" name="ids" id="ids" value="${user._id}"></td>
																<td class=" ">${user.firstname}</td>
																<td class=" ">${user.lastname}</td>
																<td class=" ">${user.id_card}</td>
																<td class=" ">${user.email}</td>
																<td class=" ">${user.phone}</td>
																<td class=" ">${user.addresses}</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="ln_solid">
							<div class="form-group">
								<div class="col-md-6 offset-md-3">
									<a href="<c:url value='/admin/store/add'/>"
										class="btn btn-success"><i class="fa fa-plus"
										style="margin-right: 5px"></i>Add</a>
										<input type="submit" value="Edit" class="btn btn-warning" /> 
										 <a
										href="<c:url value='/admin/store/delete?_id=${model._id}'/>"
										class="btn btn-danger"><i class="fa fa-remove"
										style="margin-right: 5px"></i>Delete</a> 
										<a
										href="<c:url value='/admin/store'/>" class="btn btn-primary"><i
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