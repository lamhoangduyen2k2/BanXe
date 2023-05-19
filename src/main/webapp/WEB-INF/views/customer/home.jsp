<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
    <div class="row">
        <div class="col">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="https://cdn0.fahasa.com/media/magentothem/banner7/Branday_mainbanner_Slide_840x320.jpg" alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="https://cdn0.fahasa.com/media/magentothem/banner7/Trang_Manga-Comic_Mainbanner_T10_Slide_840x320.jpg" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="https://cdn0.fahasa.com/media/magentothem/banner7/Trangdochoi_mainbanner_840X320.jpg" alt="Third slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
        <div class="col-12 col-md-3">

            <div class="card">
                <div class="card-header bg-success text-white text-uppercase">
                    <i class="fa fa-heart"></i> Top product
                </div>
                
					<c:url value="/image?fname=${list1product.getImage() }" var="imgUrl"></c:url>
					<img class="img-fluid border-0" width="220px" src="${imgUrl}" alt="">
                <div class="card-body">
                    <h4 class="card-title text-center"><a href="product?pid=${list1product._id }" title="View Product">${list1product.name}</a></h4>
                    <div class="row">
                        <div class="col">
                            <p class="btn btn-danger btn-block">${list1product.price} $</p>
                        </div>
                        <div class="col">
                            <a href="product?pid=${list1product._id }"class="btn btn-success btn-block">View</a>
                        </div>
                    </div>
                </div>
               
            </div>
            
        </div>
    </div>
</div>

      
<div class="container mt-3">
    <div class="row">
        <div class="col-sm">
            <div class="card">
                <div class="card-header bg-primary text-white text-uppercase">
                    <i class="fa fa-star"></i> New products
                </div>
                <div class="card-body">
                    <div class="row">
                    	<c:forEach var="p" items="${list4product}">
                         <div class="col-sm">
                            <div class="card">
                            <c:url value="/image?fname=${p.getImage() }" var="imgUrl"></c:url>
						<img class="img-fluid border-0" width="150px" height="100px"
							src="${imgUrl}" alt="">
                                <div class="card-body">
                                    <h4 class="card-title"><a href="product?pid=${p._id }"title="View Product">${p.name}</a></h4>
                                    <p class="card-text">${p.description}</p>
                                    <div class="row">
                                        <div class="col">
                                            <p class="btn btn-danger btn-block">${p.price} $</p>
                                        </div>
                                        <%--  <div class="col">
                                            <p class="btn btn-danger btn-block">${p.categoryId} $</p>
                                        </div> --%>
                                        <div class="col">
                                            <a href="cart?productId=${p._id }&action=addToCart" class="btn btn-success btn-block">Add to cart</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="container mt-3">
    <div class="row">
        <div class="col-sm">
            <div class="card">
                <div class="card-header bg-primary text-white text-uppercase">
                    <i class="fa fa-star"></i> Best sales products
                </div>
                <div class="card-body">
                    <div class="row">
                    
                        <c:forEach items ="${list4last}" var = "p">
                         <div class="col-sm">
                            <div class="card">
                            <c:url value="/image?fname=${p.getImage() }" var="imgUrl"></c:url>
					<img class="img-fluid border-0" width="150px" src="${imgUrl}" alt="">
                                <%-- <img src="${p.images }" class="img-fluid border-0" /> --%>
                                <div class="card-body">
                                    <h4 class="card-title"><a href="product?pid=${p._id }"title="View Product">${p.name}</a></h4>
                                    <p class="card-text">${p.description}</p>
                                    <div class="row">
                                        <div class="col">
                                            <p class="btn btn-danger btn-block">${p.price} $</p>
                                        </div>
                                        <%--  <div class="col">
                                            <p class="btn btn-danger btn-block">${p.categoryId} $</p>
                                        </div> --%>
                                        <div class="col">
                                        
                                        <a href="cart?productId=${p._id }&action=addToCart" class="btn btn-success btn-block">Add to cart</a>
                                      
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</html>
    