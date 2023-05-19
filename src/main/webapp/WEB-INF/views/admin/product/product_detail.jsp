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
						Thông tin sản phẩm
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
							<label class="col-form-label col-md-3 col-sm-3  label-align">Product name</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.name}" />
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
							<label class="col-form-label col-md-3 col-sm-3  label-align">Description</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.description}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Price</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.price}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Promotional price</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.promotionalPrice}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Quantity</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.quantity}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Sold</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.sold}" />
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
							<label class="col-form-label col-md-3 col-sm-3  label-align">Is selling</label>
							<div class="col-md-6 col-sm-6">
								<c:choose>
									<c:when test="${model.isSelling}">
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
							<label class="col-form-label col-md-3 col-sm-3  label-align">Is deleted</label>
							<div class="col-md-6 col-sm-6">
								<c:choose>
									<c:when test="${model.isDeleted}">
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
							<label class="col-form-label col-md-3 col-sm-3  label-align">Category</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.category._name}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Store</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.store._name}" />
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
										Ảnh của sản phẩm
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
															<th class="column-title">Image</th>
														</tr>
													</thead>


													<tbody>
														<c:forEach items="${imageList}" var="img">
															<tr class="odd pointer">
																<td class=" "><c:url
																		value="/image?fname=${img.image }"
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
									<a href="<c:url value='/admin/product/add'/>" class="btn btn-success"><i class="fa fa-plus" style="margin-right:5px"></i>Add</a>
									<a href="<c:url value='/admin/product/edit?_id=${model._id}'/>" class="btn btn-warning"><i class="fa fa-edit" style="margin-right:5px"></i>Edit</a>
									<a href="<c:url value='/admin/product/delete?_id=${model._id}'/>" class="btn btn-danger"><i class="fa fa-remove" style="margin-right:5px"></i>Delete</a>
									<a href="<c:url value='/admin/product/image?_id=${model._id}'/>" class="btn btn-info">Image</a>
									<a href="<c:url value='/admin/product'/>" class="btn btn-primary"><i class="fa fa-backward" style="margin-right:5px"></i>Back</a>
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