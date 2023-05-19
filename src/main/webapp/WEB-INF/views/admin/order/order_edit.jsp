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
						Chỉnh sửa đơn hàng
					</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
						
						<li><a class="close-link"><i class="fa fa-close"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<c:url value="/admin/order/edit" var="edit"></c:url>
					<form role="form" action="${edit}" method="post"
						enctype="multipart/form-data">
						
						<input name="_id" value="${model._id }" hidden="">
						<div class="field item form-group">
							<label class="control-label col-md-3 col-sm-3 label-align">Store<span class="required">*</span></label>
							<div class="col-md-6 col-sm-6 ">
								<select class="form-control" name="storeId" id="storeId" required="required">
									<c:forEach items="${storeList}" var="store">
										<option value="${store._id}">${store._name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="field item form-group">
							<label class="control-label col-md-3 col-sm-3 label-align">Delivery<span class="required">*</span></label>
							<div class="col-md-6 col-sm-6 ">
								<select class="form-control" name="deliveryId" id="deliveryId" required="required">
									<c:forEach items="${deliveryList}" var="delivery">
										<option value="${delivery._id}">${delivery.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="address">Address <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="address" name="address" required="required"
									class="form-control " value="${model.address}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="phone">phone <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="phone" name="phone" required="required"
									class="form-control " value="${model.phone}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="status">Status <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="status" name="status" required="required"
									class="form-control " value="${model.status}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="control-label col-md-3 col-sm-3 label-align">Is paid before<span class="required">*</span></label>
							<div class="col-md-6 col-sm-6 ">
								<select class="form-control" name="isPaidBefore" id="isPaidBefore" required="required">
									<option>False</option>
									<option>True</option>
								</select>
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="amountFromUser">Amount from User <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="amountFromUser" name="amountFromUser" required="required"
									class="form-control " value="${model.amountFromUser}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="amountFromStore">Amount from Store <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="amountFromStore" name="amountFromStore" required="required"
									class="form-control " value="${model.amountFromStore}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="amountToStore">Amount to Store <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="amountToStore" name="amountToStore" required="required"
									class="form-control " value="${model.amountToStore}" />
							</div>
						</div>
						<div class="field item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="amountToGD">Amount to GD <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<input type="text" id="amountToGD" name="amountToGD" required="required"
									class="form-control " value="${model.amountToGD}" />
							</div>
						</div>
						<div class="col-md-12 col-sm-12  ">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										Chọn khách hàng
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
															<th class="column-title">Customer name</th>
															<th class="column-title">ID card</th>
															<th class="column-title">Email</th>
															<th class="column-title">Phone</th>
														</tr>
													</thead>


													<tbody>
														<c:forEach items="${userList}" var="user">
															<tr class="odd pointer">
																<td class="a-center "><input type="checkbox"
																	class="flat" name="ids" id="ids" value="${user._id}"></td>
																<td class=" ">${user.firstname}
																	${user.lastname}</td>
																<td class=" ">${user.id_card}</td>
																<td class=" ">${user.email}</td>
																<td class=" ">${user.phone}</td>
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
									<a href="<c:url value='/admin/order/add'/>"
										class="btn btn-success"><i class="fa fa-plus"
										style="margin-right: 5px"></i>Add</a>
										<input type="submit" value="Edit" class="btn btn-warning" /> 
										 <a
										href="<c:url value='/admin/order/delete?_id=${model._id}'/>"
										class="btn btn-danger"><i class="fa fa-remove"
										style="margin-right: 5px"></i>Delete</a> 
										<a
										href="<c:url value='/admin/order'/>" class="btn btn-primary"><i
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