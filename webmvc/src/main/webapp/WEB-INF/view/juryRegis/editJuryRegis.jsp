<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>	
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>戒毒管理信息系统</title>
<link
	href="<%=request.getContextPath()%>/static/js/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="<%=request.getContextPath()%>/static/js/jQuery/jquery-2.1.4.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/js/bootstrap/js/bootstrap.js"></script>
<script
	src="<%=request.getContextPath()%>/static/js/bootstrap/js/bootstrap-paginator.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/juryRegis/editJuryRegis.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/common/acoCommonInprison.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/conversationRecord/addConversationRecord.js"></script>
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

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/media/css/select2_metro.css" />

<!-- END PAGE LEVEL SCRIPTS -->

<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/static/media/image/favicon.ico" />

</head>
<body class="page-header-fixed">

	<!-- BEGIN HEADER -->

	<div class="header navbar navbar-inverse navbar-fixed-top">

		<!-- BEGIN TOP NAVIGATION BAR -->

		<div class="navbar-inner">

			<div class="container-fluid">

				<!-- BEGIN RESPONSIVE MENU TOGGLER -->

				<a href="javascript:;" class="btn-navbar collapsed"
					data-toggle="collapse" data-target=".nav-collapse"> <img
					src="media/image/menu-toggler.png" alt="" />

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
										src="media/image/avatar3.jpg" alt="" /></span> <span class="subject">

										<span class="from">Richard Doe</span> <span class="time">16
											mins</span>

								</span> <span class="message"> Vivamus sed congue nibh auctor
										nibh congue nibh. auctor nibh auctor nibh... </span>

							</a></li>

							<li><a href="inbox.html?a=view"> <span class="photo"><img
										src="media/image/avatar1.jpg" alt="" /></span> <span class="subject">

										<span class="from">Bob Nilson</span> <span class="time">2
											hrs</span>

								</span> <span class="message"> Vivamus sed nibh auctor nibh
										congue nibh. auctor nibh auctor nibh... </span>

							</a></li>

							<li class="external"><a href="inbox.html">See all
									messages <i class="m-icon-swapright"></i>
							</a></li>

						</ul></li>
						<li class="dropdown user">

						<a href="#" class="dropdown-toggle" data-toggle="dropdown">

						<span class="username">${user.username}</span>

						<i class="icon-angle-down"></i>

						</a>

						<ul class="dropdown-menu">

							<li><a href="${pageContext.request.contextPath }/user/logout"><i class="icon-key"></i> 退出</a></li>

						</ul>

					</li>
						

					<!-- END INBOX DROPDOWN -->

				</ul>

				<!-- END TOP NAVIGATION MENU -->

			</div>

		</div>

		<!-- END TOP NAVIGATION BAR -->

	</div>

	<!-- END HEADER -->

	<!-- BEGIN CONTAINER -->
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

			<li class="start active "><a
				href="${pageContext.request.contextPath }/user/index"> <i
					class="icon-home"></i> <span class="title">主界面</span> <span
					class="selected"></span>

			</a></li>
			<shiro:hasRole name="admin">
				<li class=""><a
					href="${pageContext.request.contextPath }/user/index2"> <i
						class="icon-cogs"></i> <span class="title">用户权限管理</span> <span
						class="arrow "></span>

				</a>

					<ul class="sub-menu">

						<li><a href="layout_horizontal_sidebar_menu.html">

								Horzontal & Sidebar Menu</a></li>

						<li><a href="layout_horizontal_menu1.html"> Horzontal
								Menu 1</a></li>

						<li><a href="layout_horizontal_menu2.html"> Horzontal
								Menu 2</a></li>

						<li><a href="layout_promo.html"> Promo Page</a></li>

						<li><a href="layout_email.html"> Email Templates</a></li>

						<li><a href="layout_ajax.html"> Content Loading via Ajax</a>

						</li>

						<li><a href="layout_sidebar_closed.html"> Sidebar Closed
								Page</a></li>

						<li><a href="layout_blank_page.html"> Blank Page</a></li>

						<li><a href="layout_boxed_page.html"> Boxed Page</a></li>

						<li><a href="layout_boxed_not_responsive.html">

								Non-Responsive Boxed Layout</a></li>

					</ul></li>
			</shiro:hasRole>
				<li class=""><a href="${pageContext.request.contextPath }/user/index3"> <i class="icon-bookmark-empty"></i>

						<span class="title">入所流程 </span> <span class="arrow "></span>

				</a></li>
				<li class=""><a href="${pageContext.request.contextPath }/user/index4"> <i class="icon-table"></i>

						<span class="title">风险分析流程 </span> <span class="arrow "></span>

				</a></li>
				<li class=""><a href="${pageContext.request.contextPath }/user/index5"> <i class="icon-coffee"></i>

						<span class="title">出所流程 </span> <span class="arrow "></span>

				</a></li>	
		</ul>

		<!-- END SIDEBAR MENU -->

	</div>

	<div class="page-container row-fluid">

		<!-- BEGIN PAGE -->

		<div class="page-content">

			<!-- BEGIN PAGE CONTENT-->

			<div class="row-fluid">

				<div class="span12">

					<div class="tabbable tabbable-custom boxless">

						<div class="tab-content">

							<div class="tab-pane active" id="tab_1">

								<div class="portlet box blue">

									<div class="portlet-body form">

										<!-- BEGIN FORM-->

										<form action="#" id="aco-juryRegis-form"
											class="horizontal-form">

											<h3 class="form-section">伤情登记编辑页面</h3>

											<div class="row-fluid">

												<div class="span6 ">

													<div class="control-group">

														<label class="control-label" for="firstName">犯罪人员姓名</label>

														<div class="controls">

															<input type="text" id="aco-dedrugBasicinfo-fullname"
																class="m-wrap span12" > <span
																class="help-block"></span> <input
																type="hidden" id="aco-dedrugBasicinfo-personId">
															<br>
														</div>

													</div>

												</div>

												<!--/span-->

												<div class="span6 ">

													<div class="control-group">

														<label class="control-label" for="firstName">受伤情况</label>

														<div class="controls">

															<input type="text" id="aco-injurysitu"
																class="m-wrap span12" > <span
																class="help-block"></span>

														</div>

													</div>

												</div>

												<!--/span-->

											</div>

											<!--/row-->

											<div class="row-fluid">

												<div class="span6 ">

													<div class="control-group">

														<label class="control-label">自述受伤情况</label>

														<div class="controls">

															<textarea id="aco-selfinjuryreason" rows="3"
																class="m-wrap span12">
                                                            </textarea>
														</div>

													</div>

												</div>

												<!--/span-->

												<div class="span6 ">

													<div class="control-group">

														<label class="control-label">病史情况</label>

														<div class="controls">

															<input type="text" id="aco-medicalhistorysitu"
																class="m-wrap span12">

														</div>

													</div>

												</div>

												<!--/span-->

											</div>

											<!--/row-->

											<div class="row-fluid">

												<div class="span6 ">

													<div class="control-group">

														<label class="control-label" for="firstName">民警陈述原因</label>

														<div class="controls">

															<textarea id="aco-policestatementreason"
																class="m-wrap span12" rows="3" ></textarea>
															<span class="help-block"></span>

														</div>

													</div>

												</div>

												<!--/span-->

												<div class="span6 ">

													<div class="control-group">

														<label class="control-label" for="firstName">登记人</label>

														<div class="controls">

															<input type="text" id="aco-detainedpolice"
																class="m-wrap span12" > <span
																class="help-block"></span>

														</div>

													</div>

												</div>

												<!--/span-->

											</div>

											<!--/row-->
											<div class="row-fluid">

												<div class="span6 ">

													<div class="control-group">

														<label class="control-label" for="firstName">送押民警</label>

														<div class="controls">

															<input type="text" id="aco-scpolice"
																class="m-wrap span12" > <span
																class="help-block"></span>

														</div>

													</div>

												</div>

												<div class="span6 ">

													<div class="control-group">

														<label class="control-label" for="firstName">备注</label>

														<div class="controls">

															<textarea id="aco-remark" rows="3" class="m-wrap span12"> </textarea>
															<span class="help-block"></span>


														</div>

													</div>

												</div>

											</div>

											<div class="form-actions">
		                                        <input type="hidden" id="aco-juryRegis-id" value="${id}" >
												<button type="submit"
													id="aco-juryRegis-form-submit" class="btn blue">
													<i class="icon-ok"></i> 保存
												</button>

												<a class="btn"
													href="${pageContext.request.contextPath }/juryRegis/list">
													取消 </a>

											</div>

										</form>

										<!-- END FORM-->
										<div
											id="dedrug-detain-prsFamilyMeetingBasicInfo-proposeMan-id"
											class="modal" aria-hidden="true" tabindex="-1"
											data-backdrop="static" role="dialog"
											aria-labelledby="ModalLabel" data-width="650"
											style="display: none">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true"></button>
														<h4 class="modal-title">人员信息</h4>
													</div>
													<div class="modal-body"
														style="height: 100%; overflow-y: auto;">
														<div class="portlet box blue-hoki">
															<div class="portlet-body">
																<div class="row" id="resetid">
																	<div class="col-md-3">
																		<div class="form-group">
																			<div class="input-icon">
																				<input id="dedrugTextInput" type="text"
																					placeholder="请输入用户名">
																				<button id="queryButton" class="btn btn-primary"
																					type="button">查询</button>
																			</div>
																		</div>
																	</div>

																</div>
															</div>
														</div>
														<!-- BEGIN FORM-->
														<div class="portlet-body">
															<form id="form1">
																<table class="table table-bordered" id='tableResult'>
																	<caption>查询用户结果</caption>
																	<thead>
																		<tr>
																			<th>序号</th>
																			<th>姓名</th>
																			<th>性别</th>
																			<th>拘留开始日期</th>
																			<th>入所原因</th>
																			<th>操作</th>
																		</tr>
																	</thead>
																	<tbody id="dedrugTableBody">
																	</tbody>
																</table>
																<!-- 底部分页按钮 -->
																<div id="bottomTab"></div>
															</form>
														</div>
														<!-- END FORM-->
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal">关闭</button>
													</div>
												</div>
											</div>
										</div>

									</div>

								</div>

							</div>

						</div>

					</div>

				</div>

			</div>

			<!-- END PAGE CONTENT-->

		</div>

		<!-- END PAGE CONTAINER-->

	</div>

	<!-- END PAGE -->

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	<div class="footer">

		<div class="footer-inner">

			 &copy; Metronic by keenthemes.Collect from <a
				href="http://www.cssmoban.com/" title="" target="_blank"></a>
			- More Templates <a href="http://www.cssmoban.com/" target="_blank"
				title=""></a>

		</div>

		<div class="footer-tools">

			<span class="go-top"> <i class="icon-angle-up"></i>

			</span>

		</div>

	</div>



	<!-- END JAVASCRIPTS -->

</body>
</html>