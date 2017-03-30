	var	addPolice = {
		init : function() {
			// 初始化新增按钮
			addPolice.initSaveBtnClickListener();
		},

		// 获取模式窗口表单元素值
		getModalFormEleVal : function() {
			var postData = {};		
			postData.policenum = $("#aco-policenum").val();
			postData.policename = $("#aco-policename").val();
			postData.policesex = $("#aco-policesex").val();
			postData.politicaloutlook = $("#aco-politicaloutlook").val();
			postData.certificatenum = $("#aco-certificatenum").val();
			postData.worktime = new Date();
			postData.createTime=new Date();
			return postData;
		},

    	// 初始化保存新建任务按钮的click事件
		initSaveBtnClickListener : function() {
			$("#aco-police-form-submit").on("click", function(event) {
				event.preventDefault();
				    var strPath = window.document.location.pathname;
		            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
					var postData = addPolice.getModalFormEleVal();
					$.ajax({
						type : "POST",
						async : false,// 同步请求
						url : postPath+ "/policeBasicInfo/add",
						data : postData,
						success : function() {
							alert("新建民警成功！");
							parent.location.href=postPath+"/policeBasicInfo/list";
						},
						error : '请求异常，新建考核登记失败！'
					});				
			});
		},

	};

	$( document ).ready(addPolice.init);
