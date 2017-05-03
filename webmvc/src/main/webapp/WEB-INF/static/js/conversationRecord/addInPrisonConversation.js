   var  selectPersonCallback = function(data) {
		   $("#aco-dedrugBasicinfo-fullname").val(data.fullname);
		   $("#aco-dedrugBasicinfo-personId").val(data.personId);
		  }
   var	addDedrugBasicInfo = {
		init : function() {
			// 初始化新增按钮
			addDedrugBasicInfo.initSaveBtnClickListener();		
			addDedrugBasicInfo.getPerson();
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
			postData.talkstarttime = new Date();
			postData.fullname=$("#aco-dedrugBasicinfo-fullname").val();
			return postData;
		},


		  
		getPerson : function(){
			$("#aco-dedrugBasicinfo-fullname").on("focus", function() {
				$("#dedrug-detain-prsFamilyMeetingBasicInfo-proposeMan-id").show();
			});
		},  
    	// 初始化保存新建任务按钮的click事件
		initSaveBtnClickListener : function() {
			$("#aco-conversationRecord-form-submit").on("click", function(event) {
				event.preventDefault();
				    var strPath = window.document.location.pathname;
		            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
					var postData = addDedrugBasicInfo.getModalFormEleVal();
					$.ajax({
						type : "POST",
						async : false,// 同步请求
						url : postPath+ "/conversationRecord/add",
						data : postData,
						success : function() {
							alert("新建戒毒人员成功！");
							parent.location.href=postPath+"/conversationRecord/InPrisonConversationList";
						},
						error : '请求异常，新建考核登记失败！'
					});				
			});
		},

	};

	$( document ).ready(addDedrugBasicInfo.init);
