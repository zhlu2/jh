	var	editDedrugBasicInfo = {
		init : function() {
			// 初始化新增按钮
			editDedrugBasicInfo.initSaveBtnClickListener();
			editDedrugBasicInfo.initEditPage();
			editDedrugBasicInfo.getPerson();
		},

		initEditPage : function(){
			var id = $("#aco-socialRelations-id").val();
		    var strPath = window.document.location.pathname;
            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
            $.ajax({
                type : "POST",
                async : false,// 同步请求
                url : postPath + '/socialRelations/view/'+id,
                dataType:"json",
                success : function(data) {         
        			 $("#aco-relationname").val(data.relationname);
        			 $("#aco-relationsex").val(data.relationsex);
        			 $("#aco-relationphone").val(data.relationphone);
        			 $("#aco-address").val(data.address);
        			 $("#aco-relationship").val(data.relationship);
        			 $("#aco-relationcertificatenum").val(data.relationcertificatenum);		
                 	 $("#aco-dedrugBasicinfo-fullname").val(data.fullname);
                },
                error : '请求异常，查询失败！'
            });
		},
		
		getPerson : function(){
			$("#aco-dedrugBasicinfo-fullname").on("focus", function() {
				$("#dedrug-detain-prsFamilyMeetingBasicInfo-proposeMan-id").show();
			});
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
			postData.id=$("#aco-socialRelations-id").val();
			postData.fullname=$("#aco-dedrugBasicinfo-fullname").val();
			return postData;
		},

    	// 初始化保存新建任务按钮的click事件
		initSaveBtnClickListener : function() {
			$("#aco-socialRelations-form-submit").on("click", function(event) {
				    event.preventDefault();
				    var strPath = window.document.location.pathname;
		            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
					var postData = editDedrugBasicInfo.getModalFormEleVal();
					$.ajax({
						type : "POST",
						async : false,// 同步请求
						url : postPath+ "/socialRelations/edit",
						data : postData,
						success : function() {
							alert("编辑社会关系成功！");
								parent.location.href=postPath+"/socialRelations/list";
						},
						error : '请求异常，编辑社会关系失败！'
					});				
			});
		},

	};

	$( document ).ready(editDedrugBasicInfo.init);
