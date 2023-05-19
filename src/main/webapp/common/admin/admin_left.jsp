<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
	<div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="#" class="site_title"><i class="fa fa-paw"></i> <span>Xe Đạp</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
				<c:url value="/image?fname=${sessionScope.account.avatar }" var="imgUrl"></c:url>
				<img class="img-circle profile_img" src="${imgUrl}" alt="">
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <h2>${sessionScope.account.firstname } ${sessionScope.account.lastname }</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="/Trang_Web_Ban_Hang/admin/dashboard/revenue">Revenue</a></li>
                      <li><a href="/Trang_Web_Ban_Hang/admin/dashboard/user">User</a></li>
                      <li><a href="/Trang_Web_Ban_Hang/admin/dashboard/topseller">Top seller</a></li>
                    </ul>
                  </li>
                  <li><a href="/Trang_Web_Ban_Hang/admin/category"> Category </a>
                  </li>
                  <li><a href="/Trang_Web_Ban_Hang/admin/delivery"> Delivery </a>
                  </li>
                  <li><a href="/Trang_Web_Ban_Hang/admin/order"> Order </a>
                  </li>
                  <li><a href="/Trang_Web_Ban_Hang/admin/product"> Product </a>
                  </li>
                  <li><a href="/Trang_Web_Ban_Hang/admin/store"> Store </a>
                  </li>
                  <li><a href="/Trang_Web_Ban_Hang/admin/user"> User</a>
                  </li>
                </ul>
              </div>

            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>