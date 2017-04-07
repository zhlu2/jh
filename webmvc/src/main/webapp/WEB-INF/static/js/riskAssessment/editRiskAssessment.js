	var	editDedrugBasicInfo = {
		init : function() {
			// 初始化新增按钮
			editDedrugBasicInfo.initSaveBtnClickListener();
			editDedrugBasicInfo.initEditPage();
		},

		initEditPage : function(){
			var id = $("#aco-riskAssessment-id").val();
		    var strPath = window.document.location.pathname;
            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
            $.ajax({
                type : "POST",
                async : false,// 同步请求
                url : postPath + '/riskAssessment/view/'+id,
                dataType:"json",
                success : function(data) {         
        			$("#aco-dedrugBasicinfo-personId").val(data.personId);
        			$("#aco-caseStatus").val(data.caseStatus);
        			$("#aco-PerStatusInPrison").val(data.perStatusInPrison);
        			$("#aco-remark").val(data.remark);	
                },
                error : '请求异常，查询失败！'
            });
		},
		// 获取模式窗口表单元素值
		getModalFormEleVal : function() {
			var postData = {};		
			postData.personId= $("#aco-dedrugBasicinfo-personId").val();
			postData.talkpolice = $("#aco-caseStatus").val();
			postData.talktype = $("#aco-PerStatusInPrison").val();
			postData.talkplace = $("#aco-remark").val();
			return postData;
		},

    	// 初始化保存新建任务按钮的click事件
		initSaveBtnClickListener : function() {
			$("#aco-riskAssessment-form-submit").on("click", function(event) {
				    event.preventDefault();
				    var strPath = window.document.location.pathname;
		            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
					var postData = editDedrugBasicInfo.getModalFormEleVal();
					$.ajax({
						type : "POST",
						async : false,// 同步请求
						url : postPath+ "/riskAssessment/edit",
						data : postData,
						success : function() {
							alert("编辑成功！");
								parent.location.href=postPath+"/riskAssessment/list";
						},
						error : '请求异常，新建考核登记失败！'
					});				
			});
		},

	};

	$( document ).ready(editDedrugBasicInfo.init);
