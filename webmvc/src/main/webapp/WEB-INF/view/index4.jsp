<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  	
<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->

<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

<meta charset="utf-8" />

<title>戒毒管理信息系统</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport" />

<meta content="" name="description" />

<meta content="" name="author" />

<!-- BEGIN GLOBAL MANDATORY STYLES -->
<script src="<%=request.getContextPath()%>/static/js/jQuery/jquery-2.1.4.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap/js/bootstrap.min.js"></script>

<link
	href="<%=request.getContextPath()%>/static/media/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />

<link
	href="<%=request.getContextPath()%>/static/media/css/bootstrap-responsive.min.css"
	rel="stylesheet" type="text/css" />

<link
	href="<%=request.getContextPath()%>/static/media/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />

<link
	href="<%=request.getContextPath()%>/static/media/css/style-metro.css"
	rel="stylesheet" type="text/css" />

<link href="<%=request.getContextPath()%>/static/media/css/style.css"
	rel="stylesheet" type="text/css" />

<link
	href="<%=request.getContextPath()%>/static/media/css/style-responsive.css"
	rel="stylesheet" type="text/css" />

<link href="<%=request.getContextPath()%>/static/media/css/default.css"
	rel="stylesheet" type="text/css" id="style_color" />

<link
	href="<%=request.getContextPath()%>/static/media/css/uniform.default.css"
	rel="stylesheet" type="text/css" />

<!-- END GLOBAL MANDATORY STYLES -->

<!-- BEGIN PAGE LEVEL STYLES -->

<link
	href="<%=request.getContextPath()%>/static/media/css/jquery.gritter.css"
	rel="stylesheet" type="text/css" />

<link
	href="<%=request.getContextPath()%>/static/media/css/daterangepicker.css"
	rel="stylesheet" type="text/css" />

<link
	href="<%=request.getContextPath()%>/static/media/css/fullcalendar.css"
	rel="stylesheet" type="text/css" />

<link href="<%=request.getContextPath()%>/static/media/css/jqvmap.css"
	rel="stylesheet" type="text/css" media="screen" />

<link
	href="<%=request.getContextPath()%>/static/media/css/jquery.easy-pie-chart.css"
	rel="stylesheet" type="text/css" media="screen" />

<!-- END PAGE LEVEL STYLES -->

<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/static/media/image/favicon.ico" />

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed">

	<!-- BEGIN HEADER -->

	<div class="header navbar navbar-inverse navbar-fixed-top">

		<!-- BEGIN TOP NAVIGATION BAR -->

		<div class="navbar-inner">

			<div class="container-fluid">

				<!-- BEGIN RESPONSIVE MENU TOGGLER -->

				<a href="javascript:;" class="btn-navbar collapsed"
					data-toggle="collapse" data-target=".nav-collapse"> <img
					src="<%=request.getContextPath()%>/static/media/image/menu-toggler.png"
					alt="" />

				</a>

				<!-- END RESPONSIVE MENU TOGGLER -->

				<!-- BEGIN TOP NAVIGATION MENU -->

				<ul class="nav pull-right">

					<!-- BEGIN NOTIFICATION DROPDOWN -->

					<li class="dropdown" id="header_notification_bar"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"> <i
							class="icon-warning-sign"></i> <span class="badge">6</span>

					</a>

						<ul class="dropdown-menu extended notification">

							<li>

								<p>You have 14 new notifications</p>

							</li>

							<li><a href="#"> <span class="label label-success"><i
										class="icon-plus"></i></span> New user registered. <span class="time">Just
										now</span>

							</a></li>

							<li><a href="#"> <span class="label label-important"><i
										class="icon-bolt"></i></span> Server #12 overloaded. <span
									class="time">15 mins</span>

							</a></li>

							<li><a href="#"> <span class="label label-warning"><i
										class="icon-bell"></i></span> Server #2 not respoding. <span
									class="time">22 mins</span>

							</a></li>

							<li><a href="#"> <span class="label label-info"><i
										class="icon-bullhorn"></i></span> Application error. <span
									class="time">40 mins</span>

							</a></li>

							<li><a href="#"> <span class="label label-important"><i
										class="icon-bolt"></i></span> Database overloaded 68%. <span
									class="time">2 hrs</span>

							</a></li>

							<li><a href="#"> <span class="label label-important"><i
										class="icon-bolt"></i></span> 2 user IP blocked. <span class="time">5
										hrs</span>

							</a></li>

							<li class="external"><a href="#">See all notifications <i
									class="m-icon-swapright"></i></a></li>

						</ul></li>

					<!-- END NOTIFICATION DROPDOWN -->

					<!-- BEGIN INBOX DROPDOWN -->

					<li class="dropdown" id="header_inbox_bar"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"> <i
							class="icon-envelope"></i> <span class="badge">5</span>

					</a>

						<ul class="dropdown-menu extended inbox">

							<li>

								<p>You have 12 new messages</p>

							</li>

							<li><a href="inbox.html?a=view"> <span class="photo"><img
										src="media/image/avatar2.jpg" alt="" /></span> <span class="subject">

										<span class="from">Lisa Wong</span> <span class="time">Just
											Now</span>

								</span> <span class="message"> Vivamus sed auctor nibh congue
										nibh. auctor nibh auctor nibh... </span>

							</a></li>

							<li><a href="inbox.html?a=view"> <span class="photo"><img
										src="./media/image/avatar3.jpg" alt="" /></span> <span
									class="subject"> <span class="from">Richard Doe</span> <span
										class="time">16 mins</span>

								</span> <span class="message"> Vivamus sed congue nibh auctor
										nibh congue nibh. auctor nibh auctor nibh... </span>

							</a></li>

							<li><a href="inbox.html?a=view"> <span class="photo"><img
										src="./media/image/avatar1.jpg" alt="" /></span> <span
									class="subject"> <span class="from">Bob Nilson</span> <span
										class="time">2 hrs</span>

								</span> <span class="message"> Vivamus sed nibh auctor nibh
										congue nibh. auctor nibh auctor nibh... </span>

							</a></li>

							<li class="external"><a href="inbox.html">See all
									messages <i class="m-icon-swapright"></i>
							</a></li>

						</ul></li>

					<!-- END INBOX DROPDOWN -->

					<!-- BEGIN TODO DROPDOWN -->

					<li class="dropdown" id="header_task_bar"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"> <i
							class="icon-tasks"></i> <span class="badge">5</span>

					</a>

						<ul class="dropdown-menu extended tasks">

							<li>

								<p>You have 12 pending tasks</p>

							</li>

							<li><a href="#"> <span class="task"> <span
										class="desc">New release v1.2</span> <span class="percent">30%</span>

								</span> <span class="progress progress-success "> <span
										style="width: 30%;" class="bar"></span>

								</span>

							</a></li>

							<li><a href="#"> <span class="task"> <span
										class="desc">Application deployment</span> <span
										class="percent">65%</span>

								</span> <span class="progress progress-danger progress-striped active">

										<span style="width: 65%;" class="bar"></span>

								</span>

							</a></li>

							<li><a href="#"> <span class="task"> <span
										class="desc">Mobile app release</span> <span class="percent">98%</span>

								</span> <span class="progress progress-success"> <span
										style="width: 98%;" class="bar"></span>

								</span>

							</a></li>

							<li><a href="#"> <span class="task"> <span
										class="desc">Database migration</span> <span class="percent">10%</span>

								</span> <span class="progress progress-warning progress-striped">

										<span style="width: 10%;" class="bar"></span>

								</span>

							</a></li>

							<li><a href="#"> <span class="task"> <span
										class="desc">Web server upgrade</span> <span class="percent">58%</span>

								</span> <span class="progress progress-info"> <span
										style="width: 58%;" class="bar"></span>

								</span>

							</a></li>

							<li><a href="#"> <span class="task"> <span
										class="desc">Mobile development</span> <span class="percent">85%</span>

								</span> <span class="progress progress-success"> <span
										style="width: 85%;" class="bar"></span>

								</span>

							</a></li>

							<li class="external"><a href="#">See all tasks <i
									class="m-icon-swapright"></i></a></li>

						</ul></li>

					<!-- END TODO DROPDOWN -->

					<!-- BEGIN USER LOGIN DROPDOWN -->

                        <li class="dropdown user">

						<a href="#" class="dropdown-toggle" data-toggle="dropdown">

						<span class="username">${user.username}</span>

						<i class="icon-angle-down"></i>

						</a>

						<ul class="dropdown-menu">

							<li><a href="${pageContext.request.contextPath }/user/logout"><i class="icon-key"></i> 退出</a></li>

						</ul>

					</li>

					<!-- END USER LOGIN DROPDOWN -->

				</ul>

				<!-- END TOP NAVIGATION MENU -->

			</div>

		</div>

		<!-- END TOP NAVIGATION BAR -->

	</div>

	<!-- END HEADER -->
	<div class="copyrights">
		Collect from <a href="http://www.cssmoban.com/">网页模板</a>
	</div>

	<!-- BEGIN CONTAINER -->

	<div class="page-container">

		<!-- BEGIN SIDEBAR -->

		<div class="page-sidebar nav-collapse collapse">

			<!-- BEGIN SIDEBAR MENU -->

			<ul class="page-sidebar-menu">

				<li>
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->

					<div class="sidebar-toggler hidden-phone"></div> <!-- BEGIN SIDEBAR TOGGLER BUTTON -->

				</li>

				<li>
					<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->

					<form class="sidebar-search">

						<div class="input-box">

							<a href="javascript:;" class="remove"></a> <input type="text"
								placeholder="查找" /> <input type="button" class="submit"
								value=" " />

						</div>

					</form> <!-- END RESPONSIVE QUICK SEARCH FORM -->

				</li>

				<li class="start "><a href="${pageContext.request.contextPath }/user/index"> <i
						class="icon-home"></i> <span class="title">主界面</span> 

				</a></li>

				<li class=""><a href="${pageContext.request.contextPath }/user/index2"> <i class="icon-cogs"></i>

						<span class="title">用户权限管理 </span> <span class="arrow "></span>

				</a></li>
				
				<li class=""><a href="${pageContext.request.contextPath }/user/index3"> <i class="icon-bookmark-empty"></i>

						<span class="title">入所流程 </span> <span class="arrow "></span>

				</a></li>
				<li class=""><a href="${pageContext.request.contextPath }/user/index4"> <i class="icon-table"></i>

						<span class="title">风险分析流程 </span> <span class="arrow "></span>

				</a></li>
				<li class=""><a href="${pageContext.request.contextPath }/user/index5"> <i class="icon-coffee"></i>

						<span class="title">风险分析流程 </span> <span class="arrow "></span>

				</a></li>				


			</ul>

			<!-- END SIDEBAR MENU -->

		</div>

		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->

		<div class="page-content">



			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<!-- BEGIN PAGE CONTAINER-->

			<div class="container-fluid">

				<!-- BEGIN PAGE HEADER-->

				<div class="row-fluid">

					<div class="span12">


						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							风险分析流程 <small>模块展示页面</small>

						</h3>

						<ul class="breadcrumb">

							<li><i class="icon-home"></i> <a href="${pageContext.request.contextPath }/user/index4">风险分析流程 </a>

								<i class="icon-angle-right"></i></li>

							<li><a href="#">模块展示页面</a></li>

							<li class="pull-right no-text-shadow">

								<div id="dashboard-report-range"
									class="dashboard-date-range tooltips no-tooltip-on-touch-device responsive"
									data-tablet="" data-desktop="tooltips" data-placement="top"
									data-original-title="Change dashboard date range">

									<i class="icon-calendar"></i> <span></span> <i
										class="icon-angle-down"></i>

								</div>

							</li>

						</ul>

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<div id="dashboard">

					<!-- BEGIN DASHBOARD STATS -->

					<div class="row-fluid">

						<div class="span3 responsive" data-tablet="span6"
							data-desktop="span3">

							<div class="dashboard-stat green">

								<div class="visual">

									<i class="icon-bar-chart"></i>

								</div>

								<div class="details">

									<div class="number">风险评估</div>

									<div class="desc">申请</div>

								</div>

								<a class="more"
									href="${pageContext.request.contextPath }/riskAssessment/list">
									查看更多 <i class="m-icon-swapright m-icon-white"></i>
								</a>

							</div>

						</div>

						<div class="span3 responsive" data-tablet="span6"
							data-desktop="span3">

							<div class="dashboard-stat purple">

								<div class="visual">

									<i class="icon-bar-chart"></i>

								</div>

								<div class="details">

									<div class="number">风险评估</div>

									<div class="desc">科室审批</div>

								</div>

								<a class="more"
									href="${pageContext.request.contextPath }/riskAssessment/riskDirectorList">
									查看更多 <i class="m-icon-swapright m-icon-white"></i>
								</a>

							</div>

						</div>

						<div class="span3 responsive" data-tablet="span6"
							data-desktop="span3">

							<div class="dashboard-stat blue">

								<div class="visual">

									<i class="icon-bar-chart"></i>

								</div>

								<div class="details">

									<div class="number">风险评估</div>

									<div class="desc">所长审批</div>

								</div>

								<a class="more"
									href="${pageContext.request.contextPath }/riskAssessment/riskDepartmentList">
									查看更多 <i class="m-icon-swapright m-icon-white"></i>
								</a>

							</div>

						</div>

					</div>
					
				</div>

			</div>

		</div>

		<!-- END PAGE CONTAINER-->

	</div>

	<!-- END PAGE -->

	</div>

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	<div class="footer">

		<div class="footer-inner">

			 &copy; Metronic by keenthemes.Collect from <a>戒毒人员管理信息系统</a>
		</div>

		<div class="footer-tools">

			<span class="go-top"> <i class="icon-angle-up"></i>

			</span>

		</div>

	</div>

</body>

<!-- END BODY -->

</html>