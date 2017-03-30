	var	addPermission = {
		init : function() {
			// 初始化新增按钮
			addPermission.initSaveBtnClickListener();
		},

		// 获取模式窗口表单元素值
		getModalFormEleVal : function() {
			var postData = {};		
			postData.permissionName = $("#aco-permissionName").val();
			postData.permissionSign = $("#aco-permissionSign").val();			
			postData.description=$("#aco-description").val();	
			return postData;
		},

    	// 初始化保存新建任务按钮的click事件
		initSaveBtnClickListener : function() {
			$("#aco-permission-form-submit").on("click", function(event) {
				event.preventDefault();
				    var strPath = window.document.location.pathname;
		            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
					var postData = addPermission.getModalFormEleVal();
					$.ajax({
						type : "POST",
						async : false,// 同步请求
						url : postPath+ "/permission/add",
						data : postData,
						success : function() {
							alert("新建权限成功！");
							parent.location.href=postPath+"/permission/list";
						},
						error : '请求异常，新建考核登记失败！'
					});				
			});
		},

	};

	$( document ).ready(addPermission.init);
