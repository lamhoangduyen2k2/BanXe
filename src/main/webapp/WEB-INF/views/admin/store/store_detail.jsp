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
						Thông tin cửa hàng
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
							<label class="col-form-label col-md-3 col-sm-3  label-align">Store name</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model._name}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Bio</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.bio}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Slug</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.slug}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Owner</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model._user.firstname} ${model._user.lastname}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Is active</label>
							<div class="col-md-6 col-sm-6">
								<c:choose>
									<c:when test="${model.isActive}">
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
							<label class="col-form-label col-md-3 col-sm-3  label-align">Is open</label>
							<div class="col-md-6 col-sm-6">
								<c:choose>
									<c:when test="${model.isOpen}">
										<input class="form-control" readonly="readonly"
									value ="Is open" />
  									</c:when>
									<c:otherwise>
										<input class="form-control" readonly="readonly"
									value ="Isn't open" />
 									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Avatar</label>
							<div class="col-md-6 col-sm-6">
								<c:url value="/image?fname=${model.avatar }" var="imgUrl"></c:url>
								<img class="img-responsive" width="100px" src="${imgUrl}" alt="">
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Point</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.point}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Rating</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.rating}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">E wallet</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.e_wallet}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Created At</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.createdAt}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Updated At</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.updatedAt}" />
							</div>
						</div>
						<div class="col-md-12 col-sm-12  ">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										Nhân viên của cửa hàng
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
															<th class="column-title">Firstname</th>
															<th class="column-title">Lastname</th>
															<th class="column-title">ID card</th>
															<th class="column-title">Email</th>
															<th class="column-title">Phone</th>
															<th class="column-title">Addresses</th>
														</tr>
													</thead>


													<tbody>
														<c:forEach items="${stafflist}" var="staff">
															<tr class="odd pointer">
																<td class=" ">${staff._user.firstname}</td>
																<td class=" ">${staff._user.lastname}</td>
																<td class=" ">${staff._user.id_card}</td>
																<td class=" ">${staff._user.email}</td>
																<td class=" ">${staff._user.phone}</td>
																<td class=" ">${staff._user.addresses}</td>
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
						<div class="col-md-12 col-sm-12  ">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										Hình ảnh của của hàng
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
															<th class="column-title">Featured image</th>
														</tr>
													</thead>


													<tbody>
														<c:forEach items="${imageList}" var="image">
															<tr class="odd pointer">
																<td class=" "><c:url
																		value="/image?fname=${image.featured_image }"
																		var="imgUrl"></c:url> <img class="img-responsive"
																	width="100px" src="${imgUrl}" alt=""></td>
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
									<a href="<c:url value='/admin/store/add'/>" class="btn btn-success"><i class="fa fa-plus" style="margin-right:5px"></i>Add</a>
									<a href="<c:url value='/admin/store/edit?_id=${model._id}'/>" class="btn btn-warning"><i class="fa fa-edit" style="margin-right:5px"></i>Edit</a>
									<a href="<c:url value='/admin/store/delete?_id=${model._id}'/>" class="btn btn-danger"><i class="fa fa-remove" style="margin-right:5px"></i>Delete</a>
									<a href="<c:url value='/admin/store/staff?_id=${model._id}'/>" class="btn btn-info">Staff</a>
									<a href="<c:url value='/admin/store/image?_id=${model._id}'/>" class="btn btn-info">Image</a>
									<a href="<c:url value='/admin/store'/>" class="btn btn-primary"><i class="fa fa-backward" style="margin-right:5px"></i>Back</a>
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