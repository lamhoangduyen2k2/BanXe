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
              </li>
            </ul>
          </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
          <h2>Chi tiết đơn hàng</h2>
          <c:forEach items="${listOrderInfoByID}" var="Info">
          <div class="row">
          	<div class="col-6">
          		<address>
          		<strong style="font-size:18px">Tên người nhận:</strong>
          	    <label for="fullname" style="font-size:18px">${Info.lastname} ${Info.firstname}</label>
          	    <br>
          	    <strong style="font-size:18px">Địa chỉ người nhận:</strong>
          	    <label for="address" style="font-size:18px">${Info.address}</label>
          	    <br>
          	    <strong style="font-size: 18px">Số điện thoại:</strong>
          	    <label for="phone" style="font-size: 18px">${Info.phone}</label>
          		</address>
          	</div>
          	<div class="col-6 text-right">
          	<address>
          	<strong style="font-size: 18px">Phương thức vận chuyển:</strong>
          	<label for="delivery" style="font-size: 18px">${Info.name}</label>
          	<br>
          	<strong style="font-size: 18px">Phí vận chuyển:</strong>
          	<label for="price" style="font-size: 18px">${Info.price}</label> 
          	<br>
          	<strong style="font-size: 18px">Tình trạng:</strong>
          	<label for="status" style="font-size: 18px">${Info.status}</label> 
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
          	<label for="ngaydat" style="font-size: 18px">${Info.createdAt}</label>
          	<br>
          	<strong style="font-size: 18px">Tổng tiền:</strong>
          	<label for="total" style="font-size: 18px">${Info.amountFromUser} VNĐ</label>
          	</address>
          	</div>
          </div>
          </c:forEach>
          <div class="table-responsive">
            <table class="table table-striped table-bordered table-hover" id="sample_2">
				<thead>
					<tr>
						<th>Mã sản phẩm</th>
						<th>Thông tin sản phẩm</th>
						<th>Số lượng</th>
						<th>Tồn kho</th>
					</tr>
				</thead>
				<tbody>
						<c:forEach var="odetail" items="${listOrderDetailByID}">
							<tr class="odd gradeX">
								<%-- <td><c:url value="/image?fname=category/${item.images!=null?item.images:'uploads/abc.jpg'}" var="imgUrl"></c:url> <img width="50px" height="50px" src="${imgUrl}"></td> --%>
								<td>${odetail.productId }</td>
								<td><c:url value="/image?fname=${odetail.image}" var="imgUrl"></c:url>
									<img class="img-responsive" width="100px" src="${imgUrl}"
									alt=""> ${odetail.name}</td>
								<td>${odetail.count_SP}</td>
								<td>${odetail.quantity}</td>
							</tr>
						</c:forEach>
					</tbody>
			</table>
          </div>
          		<c:url value="/seller/orderdetail" var="edit"></c:url>
                  <form class="form" action="${edit}" method="post" id="registrationForm" enctype="multipart/form-data">
                    <input name="id" value="${order._id}" hidden="">
                    
                      <div class="form-group">

                              <input id="not_precessed" type="radio" name="status" ${order.status == 'not precessed'? 'checked':''} value="not precessed"><label for="not_precessed">Not precessed  </label>
                              <input id="precessed" type="radio" name="status" ${order.status == 'precessed'? 'checked':''} value="precessed"><label for="precessed">Precessed  </label>
                              <input id="shipping" type="radio" name="status" ${order.status == 'shipping'? 'checked':''} value="shipping"><label for="shipping">Shipping  </label>
                              <input id="delivered" type="radio" name="status" ${order.status == 'delivered'? 'checked':''} value="delivered"><label for="delivered">Delivered  </label>
                              <input id="cancel" type="radio" name="status" ${order.status == 'cancel'? 'checked':''} value="cancel"><label for="cancel">Cancel</label>
                    
                      </div>
          
                      <div class="form-group">
                           <div class="col-xs-12">
                                <br>
                              	<button class="btn btn-lg btn-success" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Save</button>
                            </div>
                      </div>
              	</form>
        </main>
      </div>
    </div>