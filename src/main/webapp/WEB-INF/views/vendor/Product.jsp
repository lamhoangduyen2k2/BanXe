<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp"%>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
<div class="container-fluid">
      <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item">
                <a class="nav-link active" href="#">
                  <span data-feather="home"></span>
                  Dashboard <span class="sr-only">(current)</span>
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="order">
                  <span data-feather="file"></span>
                  Orders
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="product">
                  <span data-feather="shopping-cart"></span>
                  Products
                </a>
              </li>
            </ul>
          </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
          <!-- <canvas class="my-4" id="myChart" width="900" height="380"></canvas> -->
			
          <div class="page-content-wrapper">
				<div class="page-content">
					<div class="row">
						<div class="col-md-12">
							<!-- BEGIN EXAMPLE TABLE PORTLET-->
							<div class="portlet box grey-cascade">
								<div class="portlet-title">
									<div class="text-center" style="font-size: 20px">
										<i class="fa fa-globe"></i><strong>Quản lý Sản Phẩm</strong>           
									</div>
									<div class="tools">
										<a href="javascript:;" class="collapse"> </a> <a
											href="#portlet-config" data-toggle="modal" class="config"> </a>
										<a href="javascript:;" class="reload"> </a> <a
											href="javascript:;" class="remove"> </a>
									</div>
								</div>
								<div class="portlet-body">
									<div class="table-toolbar">
										<!-- Kết thúc hiển thị thông báo -->
										
											<div class="table-responsive" >
													<table class="table table-striped table-bordered table-hover"
														id="sample_2">
														<thead>
															<tr class="text-center">
																<th>Mã sản phẩm</th>
																<th>Tên sản phẩm</th>
																<th>Số lượng</th>
																<th>Hành động</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach var="p" items="${listallProduct}">
																<c:forEach items="${listallImages}" var="i">
																	<c:if test="${p._id == i._id}">
																		<form action="product" method="post" enctype="multipart/form-data">
																	<tr class="odd gradeX">
																		<%-- <td><c:url value="/image?fname=category/${item.images!=null?item.images:'uploads/abc.jpg'}" var="imgUrl"></c:url> <img width="50px" height="50px" src="${imgUrl}"></td> --%>
																		<input name="id" value="${p._id}" hidden="">
																		<td class="text-center">${p._id}</td>
																		<td><c:url value="/image?fname=${i.image}"
																				var="imgUrl"></c:url> <img class="img-responsive"
																			width="100px" src="${imgUrl}" alt="">${p.name}</td>
																		<td><input type="text" name="quantity"
																			value="${p.quantity}" /></td>
																		<td><button class="btn btn-lg btn-success"
																				type="submit">
																				<i class="glyphicon glyphicon-ok-sign"></i>Save
																			</button></td>
																	</tr>
																</form>
																	</c:if>
																</c:forEach>
															</c:forEach>
														</tbody>
													</table>
										</div>
									</div>
								</div>
							</div>
							<!-- END EXAMPLE TABLE PORTLET-->
						</div>
					</div>
				</div>
			</div>
        </main>
 	</div>
</div>






