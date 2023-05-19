<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<h1>Chi tiết đơn hàng</h1>
          <div class="row">
          	<div class="col-6">
          		<address>
          		<strong style="font-size:18px">Tên người nhận:</strong>
          	    <label for="fullname" style="font-size:18px">${order._user.lastname} ${order._user.firstname}</label>
          	    <br>
          	    <strong style="font-size:18px">Địa chỉ người nhận:</strong>
          	    <label for="address" style="font-size:18px">${order.address}</label>
          	    <br>
          	    <strong style="font-size: 18px">Số điện thoại:</strong>
          	    <label for="phone" style="font-size: 18px">${order.phone}</label>
          		</address>
          	</div>
          	<div class="col-6 text-right">
          	<address>
          	<strong style="font-size: 18px">Phương thức vận chuyển:</strong>
          	<label for="delivery" style="font-size: 18px">${order.delivery.name}</label>
          	<br>
          	<strong style="font-size: 18px">Phí vận chuyển:</strong>
          	<label for="price" style="font-size: 18px">${order.delivery.price}</label> 
          	<br>
          	<strong style="font-size: 18px">Tình trạng:</strong>
          	<label for="status" style="font-size: 18px">${order.status}</label> 
          	</address>
          	</div>
          	<div class="col-6">
          	<address>
          	<strong style="font-size: 18px">Phương thức thanh toán:</strong>
          	<label for="thanhtoan" style="font-size: 18px">Thanh toán khi nhận hàng</label>
          	<br>
          	<strong style="font-size: 18px">Tình trạng thanh toán:</strong>
          	<c:if test="${order.isPaidBefore == false}">
          	<label for="tinhtrang" style="font-size: 18px">Chưa thanh toán</label>
          	</c:if>
          	<c:if test="${order.isPaidBefore == true}">
          	<label for="tinhtrang" style="font-size: 18px">Đã thanh toán</label>
          	</c:if>
          	<br>
          	</address>
          	</div>
          	<div class="col-6 text-right">
          	<address>
          	<strong style="font-size: 18px">Ngày đặt:</strong>
          	<label for="ngaydat" style="font-size: 18px">${order.createdAt}</label>
          	<br>
          	<strong style="font-size: 18px">Tổng tiền:</strong>
          	<label for="total" style="font-size: 18px">${order.amountFromUser} VNĐ</label>
          	</address>
          	</div>
          </div>
          
          <div class="table-responsive">
            <table class="table table-striped table-bordered table-hover" id="sample_2">
				<thead>
					<tr>
						<th>Mã sản phẩm</th>
						<th>Thông tin sản phẩm</th>
						<th>Số lượng</th>
					</tr>
				</thead>
				<tbody>
						<c:forEach var="odetail" items="${orderItems}">
							<tr class="odd gradeX">
								<%-- <td><c:url value="/image?fname=category/${item.images!=null?item.images:'uploads/abc.jpg'}" var="imgUrl"></c:url> <img width="50px" height="50px" src="${imgUrl}"></td> --%>
								<td>${odetail.productId }</td>
								<td><%-- <c:url value="/image?fname=${odetail.image}" var="imgUrl"></c:url>
									<img class="img-responsive" width="100px" src="${imgUrl}"
									alt=""> --%> ${odetail.product.name}</td>
								<td>${odetail.count_SP}</td>
							</tr>
						</c:forEach>
					</tbody>
			</table>
          </div>