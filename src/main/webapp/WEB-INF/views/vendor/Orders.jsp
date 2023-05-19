<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
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
                <a class="nav-link" href="product?cid=0">
                  <span data-feather="shopping-cart"></span>
                  Products
                </a>
            </ul>
          </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
          <h2>Đơn Hàng Chưa Xử Lí</h2>
          <div class="table-responsive">
            <table class="table table-striped table-bordered table-hover" id="sample_2">
				<thead>
					<tr>
						<th>Mã đơn hàng</th>
						<th>Họ</th>
						<th>Tên</th>
						<th>Trạng thái</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="order" items="${listAllViewOrder}">
						<tr class="odd gradeX">
							<%-- <td><c:url value="/image?fname=category/${item.images!=null?item.images:'uploads/abc.jpg'}" var="imgUrl"></c:url> <img width="50px" height="50px" src="${imgUrl}"></td> --%>
							<td>${order._id }</td>
							<td>${order.lastname}</td>
							<td>${order.firstname}</td>
							<td>${order.status}</td>
							<td><a href="<c:url value='/seller/orderdetail?oid=${order._id}'/>" class="center">Xử lý</a> </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
          </div>
        </main>
      </div>
    </div>