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
	<div class="">

		<div class="clearfix"></div>
		
		<div class="row ">
              <div class="x_panel">
                <div class="x_title">
                  <h2>Những sản phẩm nổi bật</h2>
                  <ul class="nav navbar-right panel_toolbox">
                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                    </li>
                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                    </li>
                  </ul>
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">
                  <table class="" style="width:100%">
                    <tr>
                      <th style="width:37%;">
                        <p>Top 5</p>
                      </th>
                      <th>
                        <div class="col-lg-7 col-md-7 col-sm-7 ">
                          <p class="">Tên sản phẩm</p>
                        </div>
                        <div class="col-lg-5 col-md-5 col-sm-5 ">
                          <p class="">Số lượng bán được</p>
                        </div>
                      </th>
                    </tr>
                    <tr>
                      <td>
                        <canvas id="canvasDoughnutTopSeller" height="140" width="140" style="margin: 15px 30px 10px 0"></canvas>
                      </td>
                      <td>
                        <table class="tile_info">
                          <tr>
                            <td>
                              <p><i class="fa fa-square " style="color: #455C73"></i>${topProduct[0].name } </p>
                            </td>
                            <td>${topPercent[0] }</td>
                          </tr>
                          <tr>
                            <td>
                              <p><i class="fa fa-square " style="color: #9B59B6"></i>${topProduct[1].name } </p>
                            </td>
                            <td>${topPercent[1] }</td>
                          </tr>
                          <tr>
                            <td>
                              <p><i class="fa fa-square " style="color: #BDC3C7"></i>${topProduct[2].name } </p>
                            </td>
                            <td>${topPercent[2] }</td>
                          </tr>
                          <tr>
                            <td>
                              <p><i class="fa fa-square " style="color: #26B99A"></i>${topProduct[3].name } </p>
                            </td>
                            <td>${topPercent[3] }</td>
                          </tr>
                          <tr>
                            <td>
                              <p><i class="fa fa-square " style="color: #3498DB"></i>${topProduct[4].name } </p>
                            </td>
                            <td>${topPercent[4] }</td>
                          </tr>
                          <tr>
                            <td>
                              <p><i class="fa fa-square " style="color: #f48225"></i>Khác </p>
                            </td>
                            <td>${topPercent[5] }</td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                </div>
              </div>
            </div>
		
	</div>
	<!-- Chart.js -->
    <script src="<c:url value='/assets/vendors/Chart.js/dist/Chart.min.js'/>"></script>
	<script>
	var ctx = document.getElementById("canvasDoughnutTopSeller");
	const percentList = []
	<c:forEach items="${topPercent}" var="percent">
	percentList.push(${percent})
	</c:forEach>
	
	const productList = []
	<c:forEach items="${topProduct}" var="product">
	productList.push("${product.name}")
	</c:forEach>
	productList.push("Khác")
    var data = {
        labels: productList,
        datasets: [{
            data: percentList,
            backgroundColor: [
                "#455C73",
                "#9B59B6",
                "#BDC3C7",
                "#26B99A",
                "#3498DB",
                "#f48225"
            ],
            hoverBackgroundColor: [
                "#34495E",
                "#B370CF",
                "#CFD4D8",
                "#36CAAB",
                "#49A9EA",
                "#f08c3b"
            ]

        }]
    };

    var canvasDoughnut = new Chart(ctx, {
        type: 'doughnut',
        tooltipFillColor: "rgba(51, 51, 51, 0.55)",
        data: data
    });
	</script>
</body>
</html>