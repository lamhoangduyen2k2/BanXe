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
	<c:url value="/admin/store" var="deletelist"></c:url>
	<form role="form" action="${deletelist}" method="post"
		enctype="multipart/form-data">
		<div class="col-md-12 col-sm-12  ">
			<div class="x_panel">
				<div class="x_title">
					<h2>
						Danh sách cửa hàng
					</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a href="<c:url value='/admin/store/add'/>"
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
											<th class="column-title">Store name</th>
											<th class="column-title">Owner</th>
											<th class="column-title">Is active</th>
											<th class="column-title">Is open</th>
											<th class="column-title">Rating</th>
											<th class="column-title no-link last"><span class="nobr">Action</span>
											</th>
											<th class="bulk-actions" colspan="8"><a class="antoo"
												style="color: #fff; font-weight: 500;">Bulk Actions ( <span
													class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
											</th>
										</tr>
									</thead>


									<tbody>
										<c:forEach items="${modelList}" var="model">
											<tr class="odd pointer">
												<td class="a-center "><input type="checkbox"
													class="flat" name="ids" id="ids" value="${model._id}"></td>
												<td class=" ">${model._name}</td>
												<td class=" ">${model._user.firstname} ${model._user.lastname}</td>
												<td class=" ">${model.isActive}</td>
												<td class=" ">${model.isOpen}</td>
												<td class=" ">${model.rating}</td>
												<td class=" last"><a
													href="<c:url value='/admin/store/detail?_id=${model._id}'/>">View</a></td>
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