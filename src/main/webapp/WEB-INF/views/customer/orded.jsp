<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<h1>Các đơn hàng của bạn</h1>
          <div class="table-responsive">
            <table class="table table-striped table-bordered table-hover" id="sample_2">
				<thead>
					<tr>
						<th>Mã đơn hàng</th>
						<th>Tổng tiền</th>
						<th>Ngày đặt</th>
						<th>Trạng thái</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="order" items="${listordered}">
						<tr class="odd gradeX">
							<%-- <td><c:url value="/image?fname=category/${item.images!=null?item.images:'uploads/abc.jpg'}" var="imgUrl"></c:url> <img width="50px" height="50px" src="${imgUrl}"></td> --%>
							<td>${order._id }</td>
							<td>${order.amountFromUser}</td>
							<td>${order.createdAt}</td>
							<td>${order.status}</td>
							<td><a href="<c:url value="/donhangdetail?oid=${order._id}"/>" class="center">Chi tiết</a> </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
          </div>