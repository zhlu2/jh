	var	editDedrugBasicInfo = {
		init : function() {
			// 初始化新增按钮
			editDedrugBasicInfo.initSaveBtnClickListener();
			editDedrugBasicInfo.initEditPage();
		},

		initEditPage : function(){
			var id = $("#aco-dedrugBasicInfo-id").val();
		    var strPath = window.document.location.pathname;
            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
            $.ajax({
                type : "POST",
                async : false,// 同步请求
                url : postPath + '/dedrugBasicInfo/view/'+id,
                dataType:"json",
                success : function(data) {         
                	$("#aco-fullname").val(data.fullname);
                	$("#aco-sex").val(data.sex);
                	$("#aco-certificatenum").val(data.certificatenum);
                	$("#aco-personid").val(data.personid);
                	$("#aco-drugabuse").val(data.drugabuse);
                	$("#aco-drugtype").val(data.drugtype);
                	$("#aco-abandonlimit").val(data.abandonlimit);
        			$("#aco-abandonmethod").val(data.abandonmethod);
        			$("#aco-abandonstartdate").val(data.abandonstartdate);
        			$("#aco-entryreason").val(data.entryreason);		
                },
                error : '请求异常，查询失败！'
            });
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
			postData.abandonstartdate = new Date($("#aco-abandonstartdate").val());
			postData.entryreason = $("#aco-entryreason").val();		
			postData.id=$("#aco-dedrugBasicInfo-id").val();
			postData.personsign=$("#aco-personsign").val();
			return postData;
		},

    	// 初始化保存新建任务按钮的click事件
		initSaveBtnClickListener : function() {
			$("#aco-dedrugBasicInfo-form-submit").on("click", function(event) {
				    event.preventDefault();
				    var strPath = window.document.location.pathname;
		            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
					var postData = editDedrugBasicInfo.getModalFormEleVal();
					$.ajax({
						type : "POST",
						async : false,// 同步请求
						url : postPath+ "/dedrugBasicInfo/edit",
						data : postData,
						success : function() {
							alert("误出所恢复成功！");
								parent.location.href=postPath+"/dedrugBasicInfo/outPrisonList";
						},
						error : '请求异常，新建考核登记失败！'
					});				
			});
		},

	};

	$( document ).ready(editDedrugBasicInfo.init);
