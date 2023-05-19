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
	<c:url value="/admin/order/item" var="deletelist"></c:url>
	<form role="form" action="${deletelist}" method="post"
		enctype="multipart/form-data">
		<div class="col-md-12 col-sm-12  ">
			<div class="x_panel">
				<div class="x_title">
					<h2>
						Danh sách các sản phẩm được đặt
					</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a href="<c:url value='/admin/order/detail?_id=${ido }'/>" class="btn btn-primary"><i class="fa fa-backward" style="margin-right:5px"></i>Back</a></li>
						<li><a href="<c:url value='/admin/order/item/add?ido=${ido}'/>"
							class="btn btn-success"><i class="fa fa-plus"
								style="margin-right: 5px"></i>Add</a></li>
						<li><input type="submit" value="Delete" class="btn btn-danger" /></li>
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
						
						<li><a class="close-link"><i class="fa fa-close"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<div class="row">
						<div class="col-sm-12">
							<div class="card-box table-responsive">
								
								<table id="datatable-checkbox"
									class="table table-striped jambo_table table-bordered bulk_action"
									style="width: 100%">
									<thead>
										<tr class="headings">
											<th><input type="checkbox" id="check-all" class="flat">
											</th>
											<th class="column-title">Product name</th>
											<th class="column-title">Quantity</th>
											<th class="column-title">Created at</th>
											<th class="column-title">Updated at</th>
											<th class="column-title no-link last"><span class="nobr">Action</span>
											</th>
											<th class="bulk-actions" colspan="8"><a class="antoo"
												style="color: #fff; font-weight: 500;">Bulk Actions ( <span
													class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
											</th>
										</tr>
									</thead>


									<tbody>
										<c:forEach items="${modelList}" var="item">
											<tr class="odd pointer">
												<td class="a-center "><input type="checkbox"
													class="flat" name="ids" id="ids" value="${item._id}"></td>
												<td class=" ">${item.product.name}</td>
												<td class=" ">${item.count_SP}</td>
												<td class=" ">${item.createdAt}</td>
												<td class=" ">${item.updatedAt}</td>
												<td class=" last"><a
													href="<c:url value='/admin/order/item/edit?_id=${item._id}'/>">Edit</a></td>
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
	</form>
</body>
</html>