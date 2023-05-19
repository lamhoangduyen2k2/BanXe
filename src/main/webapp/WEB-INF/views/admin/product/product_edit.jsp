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
						Chỉnh sửa sản phẩm
					</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
						
						<li><a class="close-link"><i class="fa fa-close"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<c:url value="/admin/product/edit" var="edit"></c:url>
					<form role="form" action="${edit}" method="post"
						enctype="multipart/form-data">
						
						<input name="_id" value="${model._id }" hidden="">
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="name">Product Name <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="name" name="name" required="required"
									class="form-control " value="${model.name}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="description">Description <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="description" name="description" required="required"
									class="form-control " value="${model.description}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="price">Price <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="price" name="price" required="required"
									class="form-control " value="${model.price}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="promotionalPrice">Promotional price <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="promotionalPrice" name="promotionalPrice" required="required"
									class="form-control " value="${model.promotionalPrice}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="quantity">Quantity <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="quantity" name="quantity" required="required"
									class="form-control " value="${model.quantity}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="sold">Sold <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="sold" name="sold" required="required"
									class="form-control " value="${model.sold}" />
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
								<select class="form-control" name="isSelling" id="isSelling" required="required">
									<option>False</option>
									<option>True</option>
								</select>
							</div>
						</div>
						<div class="field item form-group">
							<label class="control-label col-md-3 col-sm-3 label-align">Is open<span class="required">*</span></label>
							<div class="col-md-6 col-sm-6 ">
								<select class="form-control" name="isDeleted" id="isDeleted" required="required">
									<option>False</option>
									<option>True</option>
								</select>
							</div>
						</div>
						<div class="field item form-group">
							<label class="control-label col-md-3 col-sm-3 label-align">Category<span class="required">*</span></label>
							<div class="col-md-6 col-sm-6 ">
								<select class="form-control" name="categoryId" id="categoryId" required="required">
									<c:forEach items="${cateList}" var="cate">
										<option value="${cate._id}">${cate._name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-md-12 col-sm-12  ">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										Chọn cửa hàng bán
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
															<th class="column-title">Store name</th>
															<th class="column-title">Owner</th>
															<th class="column-title">Is active</th>
															<th class="column-title">Is open</th>
															<th class="column-title">Rating</th>
														</tr>
													</thead>


													<tbody>
														<c:forEach items="${storeList}" var="store">
															<tr class="odd pointer">
																<td class="a-center "><input type="checkbox"
																	class="flat" name="ids" id="ids" value="${store._id}"></td>
																<td class=" ">${store._name}</td>
																<td class=" ">${store._user.firstname}
																	${store._user.lastname}</td>
																<td class=" ">${store.isActive}</td>
																<td class=" ">${store.isOpen}</td>
																<td class=" ">${store.rating}</td>
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
									<a href="<c:url value='/admin/product/add'/>"
										class="btn btn-success"><i class="fa fa-plus"
										style="margin-right: 5px"></i>Add</a>
										<input type="submit" value="Edit" class="btn btn-warning" /> 
										 <a
										href="<c:url value='/admin/product/delete?_id=${model._id}'/>"
										class="btn btn-danger"><i class="fa fa-remove"
										style="margin-right: 5px"></i>Delete</a> 
										<a
										href="<c:url value='/admin/product'/>" class="btn btn-primary"><i
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