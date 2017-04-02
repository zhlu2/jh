<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bootstrap分页实例</title>
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
	src="${pageContext.request.contextPath}/static/js/common/acoCommon.js"></script>	
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/conversationRecord/addConversationRecord.js"></script>


<style type="text/css">
#queryDiv {
	margin-right: auto;
	margin-left: auto;
	width: 600px;
}

#textInput {
	margin-top: 10px;
}

#tableResult {
	margin-right: auto;
	margin-left: auto;
	width: 600px;
}

td {
	width: 150px
}
</style>
</head>
<body>
	<form id="aco-conversationRecord-form">
		<div>
			犯罪人员姓名:<input type="text" id="aco-dedrugBasicinfo-fullname">
			<input type="hidden" id="aco-dedrugBasicinfo-personId"> <br>
		</div>
		<div>
			谈话民警:<input type="text" id="aco-talkPolice"><br>
		</div>
		<div>
			谈话类型:<input type="text" id="aco-talktype"><br>
		</div>
		<div>
			谈话地点:<input type="text" id="aco-talkplace"><br>
		</div>
		<div>
			提问:<input type="text" id="aco-ask"><br>
		</div>
		<div>
			回答:<input type="text" id="aco-answer"><br>
		</div>
		<div>
			内容:
			<textarea id="aco-talkcontent" rows="3"></textarea>
		</div>
		<input type="submit" id="aco-conversationRecord-form-submit"
			value="保存">
	</form>

	<div id="dedrug-detain-prsFamilyMeetingBasicInfo-proposeMan-id"
		class="modal" aria-hidden="true" tabindex="-1" data-backdrop="static"
		role="dialog" aria-labelledby="ModalLabel" data-width="650"
		style="display: none">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title">人员信息</h4>
				</div>
				<div class="modal-body" style="height: 100%; overflow-y: auto;">
					<div class="portlet box blue-hoki">
						<div class="portlet-body">
							<div class="row" id="resetid">
								<div class="col-md-3">
									<div class="form-group">
										<div class="input-icon">
											<input id="dedrugTextInput" type="text" placeholder="请输入用户名">
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
               data-dismiss="modal">关闭
            </button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>