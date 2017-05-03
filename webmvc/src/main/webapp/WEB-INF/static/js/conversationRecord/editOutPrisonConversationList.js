	var	editDedrugBasicInfo = {
		init : function() {
			// 初始化新增按钮
			editDedrugBasicInfo.initSaveBtnClickListener();
			editDedrugBasicInfo.initEditPage();
		},

		initEditPage : function(){
			var id = $("#aco-conversationRecord-id").val();
		    var strPath = window.document.location.pathname;
            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
            $.ajax({
                type : "POST",
                async : false,// 同步请求
                url : postPath + '/conversationRecord/view/'+id,
                dataType:"json",
                success : function(data) {         
                	$("#aco-talkPolice").val(data.talkpolice);
                	$("#aco-talktype").val(data.talktype);
                	$("#aco-talkplace").val(data.talkplace);
                	$("#aco-ask").val(data.ask);
                	$("#aco-answer").val(data.answer);
                	$("#aco-talkcontent").val(data.talkcontent);	
                	$("#aco-dedrugBasicinfo-fullname").val(data.fullname);
                },
                error : '请求异常，查询失败！'
            });
		},
		// 获取模式窗口表单元素值
		getModalFormEleVal : function() {
			var postData = {};		
			postData.talkpolice = $("#aco-talkPolice").val();
			postData.talktype = $("#aco-talktype").val();
			postData.talkplace = $("#aco-talkplace").val();
			postData.ask = $("#aco-ask").val();
			postData.answer = $("#aco-answer").val();
			postData.talkcontent = $("#aco-talkcontent").val();	
			postData.id=$("#aco-conversationRecord-id").val();
			postData.fullname=$("#aco-dedrugBasicinfo-fullname").val();
			return postData;
		},

    	// 初始化保存新建任务按钮的click事件
		initSaveBtnClickListener : function() {
			$("#aco-conversationRecord-form-submit").on("click", function(event) {
				    event.preventDefault();
				    var strPath = window.document.location.pathname;
		            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
					var postData = editDedrugBasicInfo.getModalFormEleVal();
					$.ajax({
						type : "POST",
						async : false,// 同步请求
						url : postPath+ "/conversationRecord/edit",
						data : postData,
						success : function() {
							alert("编辑用户成功！");
								parent.location.href=postPath+"/conversationRecord/OutPrisonConversationList";
						},
						error : '请求异常，新建考核登记失败！'
					});				
			});
		},

	};

	$( document ).ready(editDedrugBasicInfo.init);
