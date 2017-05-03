	var	addSocialRelations = {
		init : function() {
			// 初始化新增按钮
			addSocialRelations.initSaveBtnClickListener();
			addSocialRelations.getPerson();
		},

		// 获取模式窗口表单元素值
		getModalFormEleVal : function() {
			var postData = {};		
			postData.relationname = $("#aco-relationname").val();
			postData.relationsex = $("#aco-relationsex").val();
			postData.relationphone = $("#aco-relationphone").val();
			postData.address = $("#aco-address").val();
			postData.relationship = $("#aco-relationship").val();
			postData.relationcertificatenum = $("#aco-relationcertificatenum").val();
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

			$("#aco-socialRelations-form-submit").on("click", function(event) {
				event.preventDefault();
				    var strPath = window.document.location.pathname;
		            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
					var postData = addSocialRelations.getModalFormEleVal();
					$.ajax({
						type : "POST",
						async : false,// 同步请求
						url : postPath+ "/socialRelations/add",
						data : postData,
						success : function() {
							alert("新建社会关系成功！");
							parent.location.href=postPath+"/socialRelations/list";
						},
						error : '请求异常，新建社会关系失败！'
					});				
			});
		},

	};

	$( document ).ready(addSocialRelations.init);
