	var	addJuryRegis = {
		init : function() {
			// 初始化新增按钮
			addJuryRegis.initSaveBtnClickListener();
		},

		// 获取模式窗口表单元素值
		getModalFormEleVal : function() {
			var postData = {};		
			postData.injurysitu = $("#aco-injurysitu").val();
			postData.selfinjuryreason = $("#aco-selfinjuryreason").val();
			postData.medicalhistorysitu = $("#aco-medicalhistorysitu").val();
			postData.policestatementreason = $("#aco-policestatementreason").val();
			postData.detainedpolice = $("#aco-detainedpolice").val();
			postData.scpolice = $("#aco-scpolice").val();
			postData.remark = $("#aco-remark").val();
			postData.fullname=$("#aco-dedrugBasicinfo-fullname").val();			
			return postData;
		},

    	// 初始化保存新建任务按钮的click事件
		initSaveBtnClickListener : function() {
			$("#aco-juryRegis-form-submit").on("click", function(event) {
				event.preventDefault();
				    var strPath = window.document.location.pathname;
		            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
					var postData = addJuryRegis.getModalFormEleVal();
					$.ajax({
						type : "POST",
						async : false,// 同步请求
						url : postPath+ "/juryRegis/add",
						data : postData,
						success : function() {
							alert("新建伤情登记成功！");
							parent.location.href=postPath+"/juryRegis/list";
						},
						error : '请求异常，新建考核登记失败！'
					});				
			});
		},

	};

	$( document ).ready(addJuryRegis.init);
