	var	editUser = {
		init : function() {
			// 初始化新增按钮
			editUser.initSaveBtnClickListener();
			editUser.initEditPage();
		},

		initEditPage : function(){
			var id = $("#aco-user-idedit").val();
		    var strPath = window.document.location.pathname;
            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
            $.ajax({
                type : "POST",
                async : false,// 同步请求
                url : postPath + '/user/view/'+id,
                dataType:"json",
                success : function(data) {         
                	$("#aco-userPassword").val(data.password);
                    $("#aco-userName").val(data.username);
                    	
                },
                error : '请求异常，查询失败！'
            });
		},
		// 获取模式窗口表单元素值
		getModalFormEleVal : function() {
			var postData = {};		
			postData.username = $("#aco-userName").val();
			postData.password = $("#aco-userPassword").val();
			postData.id=$("#aco-user-idedit").val();
			return postData;
		},

    	// 初始化保存新建任务按钮的click事件
		initSaveBtnClickListener : function() {
			$("#aco-useredit-form-submit").on("click", function(event) {
				    event.preventDefault();
				    var strPath = window.document.location.pathname;
		            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
					var postData = editUser.getModalFormEleVal();
					$.ajax({
						type : "POST",
						async : false,// 同步请求
						url : postPath+ "/user/edit",
						data : postData,
						success : function() {
							alert("编辑用户成功！");
								parent.location.href=postPath+"/demoController/index";
						},
						error : '请求异常，新建考核登记失败！'
					});				
			});
		},

	};

	$( document ).ready(editUser.init);
