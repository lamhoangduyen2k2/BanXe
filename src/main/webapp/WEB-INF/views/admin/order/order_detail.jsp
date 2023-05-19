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
						Thông tin đơn hàng
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
							<label class="col-form-label col-md-3 col-sm-3  label-align">Customer name</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model._user.firstname} ${model._user.lastname}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Store name</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.store._name}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Delivery name</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.delivery.name}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Address</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.address}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Phone</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.phone}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Amount from User</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.amountFromUser}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Amount from Store</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.amountFromStore}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Amount to Store</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.amountToStore}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Amount to GD</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.amountToGD}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Is paid before</label>
							<div class="col-md-6 col-sm-6">
								<c:choose>
									<c:when test="${model.isPaidBefore}">
										<input class="form-control" readonly="readonly"
									value ="Paid" />
  									</c:when>
									<c:otherwise>
										<input class="form-control" readonly="readonly"
									value ="Unpaid" />
 									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3  label-align">Status</label>
							<div class="col-md-6 col-sm-6">
								<input class="form-control" readonly="readonly"
									value ="${model.status}" />
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
										Sản phẩm trong đơn hàng
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
															<th class="column-title">Product name</th>
															<th class="column-title">Quantity</th>
														</tr>
													</thead>


													<tbody>
														<c:forEach items="${itemList}" var="item">
															<tr class="odd pointer">
																<td class=" ">${item.product.name}</td>
																<td class=" ">${item.count_SP}</td>
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
									<a href="<c:url value='/admin/order/add'/>" class="btn btn-success"><i class="fa fa-plus" style="margin-right:5px"></i>Add</a>
									<a href="<c:url value='/admin/order/edit?_id=${model._id}'/>" class="btn btn-warning"><i class="fa fa-edit" style="margin-right:5px"></i>Edit</a>
									<a href="<c:url value='/admin/order/delete?_id=${model._id}'/>" class="btn btn-danger"><i class="fa fa-remove" style="margin-right:5px"></i>Delete</a>
									<a href="<c:url value='/admin/order/item?ido=${model._id}'/>" class="btn btn-info">Item</a>
									<a href="<c:url value='/admin/order'/>" class="btn btn-primary"><i class="fa fa-backward" style="margin-right:5px"></i>Back</a>
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