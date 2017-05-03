   var  selectPersonCallback = function(data) {
		   $("#aco-dedrugBasicinfo-fullname").val(data.fullname);
		   $("#aco-dedrugBasicinfo-personId").val(data.personId);
		  }	
   var	addPrsArrgInfo = {
		init : function() {
			// 初始化新增按钮
			addPrsArrgInfo.initSaveBtnClickListener();
			addPrsArrgInfo.getPerson();
		},

		// 获取模式窗口表单元素值
		getModalFormEleVal : function() {
			var postData = {};		
			postData.applydate =  new Date();
			postData.applypolice = $("#aco-applypolice").val();
			postData.prsfullname = $("#aco-prsfullname").val();
			postData.sex = $("#aco-sex").val();
			postData.age = $("#aco-age").val();
			postData.prsrelation = $("#aco-prsrelation").val();
			postData.applyreason = $("#aco-applyreason").val();
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
			$("#aco-prsArrgInfo-form-submit").on("click", function(event) {
				event.preventDefault();
				    var strPath = window.document.location.pathname;
		            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
					var postData = addPrsArrgInfo.getModalFormEleVal();
					$.ajax({
						type : "POST",
						async : false,// 同步请求
						url : postPath+ "/prsArrgInfo/add",
						data : postData,
						success : function() {
							alert("新建临时探访成功！");
							parent.location.href=postPath+"/prsArrgInfo/list";
						},
						error : '请求异常，新建临时探访失败！'
					});				
			});
		},

	};

	$( document ).ready(addPrsArrgInfo.init);
