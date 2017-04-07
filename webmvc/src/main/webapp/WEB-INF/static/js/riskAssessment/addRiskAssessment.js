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
			postData.personId= $("#aco-dedrugBasicinfo-personId").val();
			postData.caseStatus = $("#aco-caseStatus").val();
			postData.perStatusInPrison = $("#aco-PerStatusInPrison").val();
			postData.remark = $("#aco-remark").val();
			postData.createtime = new Date();
			return postData;
		},


		  
		getPerson : function(){
			$("#aco-dedrugBasicinfo-fullname").on("focus", function() {
				$("#dedrug-detain-prsFamilyMeetingBasicInfo-proposeMan-id").show();
			});
		},  
    	// 初始化保存新建任务按钮的click事件
		initSaveBtnClickListener : function() {
			$("#aco-riskAssessment-form-submit").on("click", function(event) {
				event.preventDefault();
				    var strPath = window.document.location.pathname;
		            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
					var postData = addDedrugBasicInfo.getModalFormEleVal();
					$.ajax({
						type : "POST",
						async : false,// 同步请求
						url : postPath+ "/riskAssessment/add",
						data : postData,
						success : function() {
							alert("新建戒风险评估成功！");
							parent.location.href=postPath+"/riskAssessment/list";
						},
						error : '请求异常，新建考核登记失败！'
					});				
			});
		},

	};

	$( document ).ready(addDedrugBasicInfo.init);
