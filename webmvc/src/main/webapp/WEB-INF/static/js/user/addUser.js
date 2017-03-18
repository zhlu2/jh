	var	addUser = {
		init : function() {
			// 初始化新增按钮
			addUser.initSaveBtnClickListener();
		},

		// 获取模式窗口表单元素值
		getModalFormEleVal : function() {
			var postData = {};		
			postData.username = $("#aco-userName").val();
			postData.password = $("#aco-userPassword").val();
			postData.createTime=new Date();
			return postData;
		},

    	// 初始化保存新建任务按钮的click事件
		initSaveBtnClickListener : function() {
			$("#aco-useradd-form-submit").on("click", function(event) {
				event.preventDefault();
				    var strPath = window.document.location.pathname;
		            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
					var postData = addUser.getModalFormEleVal();
					$.ajax({
						type : "POST",
						async : false,// 同步请求
						url : postPath+ "/user/add",
						data : postData,
						success : function() {
							alert("新建用户成功！");
								parent.location.href=postPath+"/demoController/index";
						},
						error : '请求异常，新建考核登记失败！'
					});				
			});
		},

	};

	$( document ).ready(addUser.init);
