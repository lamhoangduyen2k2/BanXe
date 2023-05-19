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
						Thêm sản phẩm 
					</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
						
						<li><a class="close-link"><i class="fa fa-close"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<c:url value="/admin/order/item/add" var="add"></c:url>
					<form role="form" action="${add}" method="post"
						enctype="multipart/form-data">
						
						<input name="ido" value="${ido }" hidden="">
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="count_SP">Quantity <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="count_SP" name="count_SP" required="required"
									class="form-control " />
							</div>
						</div>
						<div class="col-md-12 col-sm-12  ">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										Chọn một sản phẩm
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
															<th class="column-title">Product name</th>
															<th class="column-title">Price</th>
															<th class="column-title">Promotional price</th>
															<th class="column-title">Is active</th>
															<th class="column-title">Is selling</th>
															<th class="column-title">Is deleted</th>
															<th class="column-title">Rating</th>
														</tr>
													</thead>


													<tbody>
														<c:forEach items="${productList}" var="model">
															<tr class="odd pointer">
																<td class="a-center "><input type="checkbox"
																	class="flat" name="ids" id="ids" value="${model._id}"></td>
																<td class=" ">${model.name}</td>
																<td class=" ">${model.price}</td>
																<td class=" ">${model.promotionalPrice}</td>
																<td class=" ">${model.isActive}</td>
																<td class=" ">${model.isSelling}</td>
																<td class=" ">${model.isDeleted}</td>
																<td class=" ">${model.rating}</td>
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
									<input type="submit" value="Add" class="btn btn-success" />
									<a href="<c:url value='/admin/order/item?ido=${ido }'/>" class="btn btn-primary"><i class="fa fa-backward" style="margin-right:5px"></i>Back</a>
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