	    var PAGESIZE = 10;
        var options = {  
            currentPage: 1,  //当前页数
            totalPages: 10,  //总页数，这里只是暂时的，后头会根据查出来的条件进行更改
            size:"normal",  
            alignment:"center",  
            itemTexts: function (type, page, current) {  
                switch (type) {  
                    case "first":  
                        return "第一页";  
                    case "prev":  
                        return "前一页";  
                    case "next":  
                        return "后一页";  
                    case "last":  
                        return "最后页";  
                    case "page":  
                        return  page;  
                }                 
            },  
            onPageClicked: function (e, originalEvent, type, page) {  
            	var permissionId = $("#textInput").val(); //取内容
            	buildTable(permissionId,page,PAGESIZE);//默认每页最多10条
            }  
        }  

        //获取当前项目的路径
        var urlRootContext = (function () {
            var strPath = window.document.location.pathname;
            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
            return postPath;
        })();
        
        function jumpOnEditPage(id){
        	if(!!id){
        		window.location.href=urlRootContext+"/user/editPage/"+id;	
        	}        	
        }
        function deleEvent(permissionId) {        	
            	if (confirm("确定要删除吗？")) {
				    var strPath = window.document.location.pathname;
		            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
                    $.ajax({
                        url: postPath + "/permission/delete",
                        type: "POST",
                        async: false,// 同步请求
                        data:{"permissionId":permissionId},
                        success: function () {
                                alert("删除权限成功！");
                                window.location.reload();
                        },
                        error: '请求异常，删除伤情信息失败！'
                    });
            	}else{                    
            		return false;
            		}
                // 点击确认返回callback
     
        }
        //生成表格
        function buildTable(permissionId,pageNumber,pageSize) {
        	 var url =  urlRootContext + "/permission/findPermissionList"; //请求的网址
             var reqParams = {'id':permissionId, 'pageNumber':pageNumber,'pageSize':pageSize};//请求数据
             $(function () {   
             	  $.ajax({
             	        type:"POST",
             	        url:url,
             	        data:reqParams,
             	        async:false,
             	        dataType:"json",
             	        success: function(data){
             	            if(data.isError == false) {
             	           // options.totalPages = data.pages;
             	        var newoptions = {  
                        currentPage: 1,  //当前页数
                        totalPages: data.pages==0?1:data.pages,  //总页数
                        size:"normal",  
                        alignment:"center",  
                        itemTexts: function (type, page, current) {  
                        switch (type) {  
                            case "first":  
                            return "第一页";  
                            case "prev":  
                            return "前一页";  
                            case "next":  
                            return "后一页";  
                            case "last":  
                            return "最后页";  
                        case "page":  
                        return  page;  
                }                 
            },  
            onPageClicked: function (e, originalEvent, type, page) {  
            	var permissionId = $("#textInput").val(); //取内容
            	buildTable(permissionId,page,PAGESIZE);//默认每页最多10条
            }  
         }             	           
         $('#bottomTab').bootstrapPaginator("setOptions",newoptions); //重新设置总页面数目
         var dataList = data.dataList;
         $("#tableBody").empty();//清空表格内容
         if (dataList.length > 0 ) {
             $(dataList).each(function(){//重新生成
             	    $("#tableBody").append('<tr>');
                    $("#tableBody").append('<td>' + this.permissionId + '</td>');
                    $("#tableBody").append('<td>' + this.permissionName + '</td>');
                    $("#tableBody").append('<td>' + this.description + '</td>');
                    $("#tableBody").append("<a href=\"javascript:void(0);\" id=\"aco-user-role-deleteBtn" + this.permissionId + "\" onclick=\"deleEvent('"
                            + this.permissionId + "')\" class=\"btn default btn-xs red-stripe\">删除</a>");                   
                    $("#tableBody").append('</tr>');
             	    });  
             	    } else {             	            	
             	          $("#tableBody").append('<tr><th colspan ="6"><center>查询无数据</center></th></tr>');
             	    }
             	    }else{
             	          alert(data.errorMsg);
             	            }
             	      },
             	        error: function(e){
             	           alert("查询失败:" + e);
             	        }
             	    });
               });
        }
        
        //渲染完就执行
        $(function() {
        	
        	//生成底部分页栏
            $('#bottomTab').bootstrapPaginator(options);     
        	
        	buildTable("",1,10);//默认空白查全部
        	
            //创建结算规则
            $("#queryButton").bind("click",function(){
            	var userName = $("#textInput").val();	
            	buildTable(userName,1,PAGESIZE);
            });
        });