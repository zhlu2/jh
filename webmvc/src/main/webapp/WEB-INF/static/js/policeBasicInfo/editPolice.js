	var	editPolice = {
		init : function() {
			// 初始化新增按钮
			editPolice.initSaveBtnClickListener();
			editPolice.initEditPage();
		},

		initEditPage : function(){
			var id = $("#aco-police-id").val();
		    var strPath = window.document.location.pathname;
            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
            $.ajax({
                type : "POST",
                async : false,// 同步请求
                url : postPath + '/policeBasicInfo/view/'+id,
                dataType:"json",
                success : function(data) {         
                	$("#aco-policenum").val(data.policenum);
                    $("#aco-policename").val(data.policename);
                    $("#aco-policesex").val(data.policesex);
                    $("#aco-politicaloutlook").val(data.politicaloutlook);
                    $("#aco-certificatenum").val(data.certificatenum);
                    	
                },
                error : '请求异常，查询失败！'
            });
		},
		// 获取模式窗口表单元素值
		getModalFormEleVal : function() {
			var postData = {};		
			postData.policenum = $("#aco-policenum").val();
			postData.policename = $("#aco-policename").val();
			postData.policesex = $("#aco-policesex").val();
			postData.politicaloutlook = $("#aco-politicaloutlook").val();
			postData.certificatenum = $("#aco-certificatenum").val();			
			postData.id=$("#aco-police-id").val();
			return postData;
		},

    	// 初始化保存新建任务按钮的click事件
		initSaveBtnClickListener : function() {
			$("#aco-police-form-submit").on("click", function(event) {
				    event.preventDefault();
				    var strPath = window.document.location.pathname;
		            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
					var postData = editPolice.getModalFormEleVal();
					$.ajax({
						type : "POST",
						async : false,// 同步请求
						url : postPath+ "/policeBasicInfo/edit",
						data : postData,
						success : function() {
							alert("编辑民警成功！");
								parent.location.href=postPath+"/policeBasicInfo/list";
						},
						error : '请求异常，新建考核登记失败！'
					});				
			});
		},

	};

	$( document ).ready(editPolice.init);
