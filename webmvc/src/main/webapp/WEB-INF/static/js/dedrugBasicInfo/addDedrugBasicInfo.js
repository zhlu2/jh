	var	addDedrugBasicInfo = {
		init : function() {
			// 初始化新增按钮
			addDedrugBasicInfo.initSaveBtnClickListener();
		},

		// 获取模式窗口表单元素值
		getModalFormEleVal : function() {
			var postData = {};		
			postData.fullname = $("#aco-fullname").val();
			postData.sex = $("#aco-sex").val();
			postData.certificatenum = $("#aco-certificatenum").val();
			postData.personid = $("#aco-personid").val();
			postData.drugabuse = $("#aco-drugabuse").val();
			postData.drugtype = $("#aco-drugtype").val();
			postData.abandonlimit = $("#aco-abandonlimit").val();
			postData.abandonmethod = $("#aco-abandonmethod").val();
			postData.abandonstartdate = $("#aco-abandonstartdate").val();
			postData.entryreason = $("#aco-entryreason").val();
			postData.abandonstartdate = new Date();
			postData.createTime=new Date();
			postData.personsign="5";
			return postData;
		},

    	// 初始化保存新建任务按钮的click事件
		initSaveBtnClickListener : function() {
			$("#aco-police-form-submit").on("click", function(event) {
				event.preventDefault();
				    var strPath = window.document.location.pathname;
		            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
					var postData = addDedrugBasicInfo.getModalFormEleVal();
					$.ajax({
						type : "POST",
						async : false,// 同步请求
						url : postPath+ "/dedrugBasicInfo/add",
						data : postData,
						success : function() {
							alert("新建戒毒人员成功！");
							parent.location.href=postPath+"/dedrugBasicInfo/list";
						},
						error : '请求异常，新建考核登记失败！'
					});				
			});
		},

	};

	$( document ).ready(addDedrugBasicInfo.init);
