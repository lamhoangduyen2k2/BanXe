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
		
		<div class="row  ">
			<div class="x_panel">
				<div class="x_title">
					<h2>
						Thống kê<small>Người dùng mới</small>
					</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
						<li><a class="close-link"><i class="fa fa-close"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<ul class="stats-overview">
                        <li>
                          <span class="name"> Tổng người dùng mới trong tháng </span>
                          <span class="value text-success"> ${totalOfMonth } </span>
                        </li>
                        <li>
                          <span class="name"> Tổng người dùng mới trong năm </span>
                          <span class="value text-success"> ${totalOfYear } </span>
                        </li>
                        <li class="hidden-phone">
                          <span class="name"> Tổng người dùng mới trong 5 năm </span>
                          <span class="value text-success"> ${totalOf5year } </span>
                        </li>
                      </ul>
				</div>
			</div>
		</div>

		<div class="row  ">
			<div class="x_panel">
				<div class="x_title">
					<h2>
						Biểu đồ người dùng mới tháng này
					</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
						<li><a class="close-link"><i class="fa fa-close"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<canvas id="lineChartDay"></canvas>
				</div>
			</div>
		</div>

		<div class="row  ">
			<div class="x_panel">
				<div class="x_title">
					<h2>
						Biểu đồ người dúng mới năm này
					</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
						<li><a class="close-link"><i class="fa fa-close"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<canvas id="lineChartMonth"></canvas>
				</div>
			</div>
		</div>

		<div class="row  ">
			<div class="x_panel">
				<div class="x_title">
					<h2>
						Biểu đồ người dùng mới trong 5 năm
					</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
						<li><a class="close-link"><i class="fa fa-close"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<canvas id="mybarChartyear"></canvas>
				</div>
			</div>
		</div>
	</div>
	<!-- Chart.js -->
    <script src="<c:url value='/assets/vendors/Chart.js/dist/Chart.min.js'/>"></script>
	<script>
	var ctxday = document.getElementById("lineChartDay");
	const dayList = []
	<c:forEach items="${dayList}" var="staff">
	dayList.push(${staff})
	</c:forEach>
    var lineChartDay = new Chart(ctxday, {
        type: 'line',
        data: {
            labels: ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31",],
            datasets: [{
                label: "Tài khoản",
                backgroundColor: "rgba(38, 185, 154, 0.31)",
                borderColor: "rgba(38, 185, 154, 0.7)",
                pointBorderColor: "rgba(38, 185, 154, 0.7)",
                pointBackgroundColor: "rgba(38, 185, 154, 0.7)",
                pointHoverBackgroundColor: "#fff",
                pointHoverBorderColor: "rgba(220,220,220,1)",
                pointBorderWidth: 1,
                data: dayList
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
    
    var ctxmonth = document.getElementById("lineChartMonth");
	const monthList = []
	<c:forEach items="${monthList}" var="staff">
	monthList.push(${staff})
	</c:forEach>
    var lineChartMonth = new Chart(ctxmonth, {
        type: 'line',
        data: {
            labels: ["Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"],
            datasets: [{
                label: "Tài khoản",
                backgroundColor: "rgba(38, 185, 154, 0.31)",
                borderColor: "rgba(38, 185, 154, 0.7)",
                pointBorderColor: "rgba(38, 185, 154, 0.7)",
                pointBackgroundColor: "rgba(38, 185, 154, 0.7)",
                pointHoverBackgroundColor: "#fff",
                pointHoverBorderColor: "rgba(220,220,220,1)",
                pointBorderWidth: 1,
                data: monthList
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
    
    var ctxyear = document.getElementById("mybarChartyear");
    const yearList = []
    const yearX = []
	<c:forEach items="${yearList}" var="staff">
	yearList.push(${staff})
	</c:forEach>
	var currentTime = new Date()
	var year = currentTime.getFullYear()
	for(let i = 4; i>-1; i--)
		yearX.push("Năm " + (year - i))
	console.log(yearX)
    var mybarChartYear = new Chart(ctxyear, {
        type: 'bar',
        data: {
            labels: yearX,
            datasets: [{
                label: 'Tài khoản',
                backgroundColor: "#26B99A",
                data: yearList
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });
	</script>
</body>
</html>