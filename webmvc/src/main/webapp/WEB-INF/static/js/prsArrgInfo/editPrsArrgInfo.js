	var	editDedrugBasicInfo = {
		init : function() {
			// 初始化新增按钮
			editDedrugBasicInfo.initSaveBtnClickListener();
			editDedrugBasicInfo.initEditPage();
		},

		initEditPage : function(){
			var id = $("#aco-prsArrgInfo-id").val();
		    var strPath = window.document.location.pathname;
            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
            $.ajax({
                type : "POST",
                async : false,// 同步请求
                url : postPath + '/prsArrgInfo/view/'+id,
                dataType:"json",
                success : function(data) {         
        			  $("#aco-applypolice").val(data.applypolice);
        			  $("#aco-prsfullname").val(data.prsfullname);
        			  $("#aco-sex").val(data.sex);
        			  $("#aco-age").val(data.age);
        			  $("#aco-prsrelation").val(data.prsrelation);
        			  $("#aco-applyreason").val(data.applyreason);			
                },
                error : '请求异常，查询失败！'
            });
		},
		// 获取模式窗口表单元素值
		getModalFormEleVal : function() {
			var postData = {};		
			postData.applypolice = $("#aco-applypolice").val();
			postData.prsfullname = $("#aco-prsfullname").val();
			postData.sex = $("#aco-sex").val();
			postData.age = $("#aco-age").val();
			postData.prsrelation = $("#aco-prsrelation").val();
			postData.applyreason = $("#aco-applyreason").val();	
			postData.id=$("#aco-prsArrgInfo-id").val();
			return postData;
		},

    	// 初始化保存新建任务按钮的click事件
		initSaveBtnClickListener : function() {
			$("#aco-prsArrgInfo-form-submit").on("click", function(event) {
				    event.preventDefault();
				    var strPath = window.document.location.pathname;
		            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
					var postData = editDedrugBasicInfo.getModalFormEleVal();
					$.ajax({
						type : "POST",
						async : false,// 同步请求
						url : postPath+ "/prsArrgInfo/edit",
						data : postData,
						success : function() {
							alert("编辑临时探访成功！");
								parent.location.href=postPath+"/prsArrgInfo/list";
						},
						error : '请求异常，编辑临时探访失败！'
					});				
			});
		},

	};

	$( document ).ready(editDedrugBasicInfo.init);
