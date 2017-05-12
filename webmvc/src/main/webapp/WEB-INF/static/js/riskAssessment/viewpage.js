	var	editDedrugBasicInfo = {
		init : function() {
			// 初始化新增按钮
			editDedrugBasicInfo.initSaveBtnClickListener();
			editDedrugBasicInfo.initEditPage();
		},

		initEditPage : function(){
			var id = $("#aco-riskAssessment-id").val();
		    var strPath = window.document.location.pathname;
            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
            $.ajax({
                type : "POST",
                async : false,// 同步请求
                url : postPath + '/riskAssessment/view/'+id,
                dataType:"json",
                success : function(data) {         
        			$("#aco-dedrugBasicinfo-personId").val(data.personId);
        			$("#aco-caseStatus").val(data.caseStatus);
        			$("#aco-PerStatusInPrison").val(data.perStatusInPrison);
        			$("#aco-remark").val(data.remark);	
                    $("#aco-dedrugBasicinfo-fullname").val(data.fullname);
                    $("#aco-directorApprovalMark").val(data.directorApprovalMark);
                    $("#aco-departmentApprovalMark").val(postData.departmentApprovalMark);
                },
                error : '请求异常，查询失败！'
            });
		},

	};

	$( document ).ready(editDedrugBasicInfo.init);
