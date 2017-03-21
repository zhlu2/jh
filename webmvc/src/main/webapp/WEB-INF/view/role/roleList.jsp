<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bootstrap分页实例</title>
<link href="<%=request.getContextPath()%>/static/js/bootstrap//css/bootstrap.min.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/static/js/jQuery/jquery-2.1.4.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap/js/bootstrap-paginator.min.js"></script>
<style type="text/css">
#queryDiv {
 margin-right: auto;
 margin-left: auto;
 width:600px;
}
#textInput {
 margin-top: 10px;
}
#tableResult {
 margin-right: auto;
 margin-left: auto;
 width:600px;
}
td {
 width:150px
}
</style>
</head>
<body>
            <div class="actions">
                <div class="btn-group">
                    <a class="btn btn-default btn-sm"
                     href="<%=request.getContextPath()%>/userRole/addPage/${id}"
                    >
                    <input type="hidden" id="aco-user-id" value="${id}">
                        <i class="fa fa-plus-square"></i> 新增
                    </a>
                </div>
            </div>
	<div id = "queryDiv">
		<input id = "textInput" type="text" placeholder="请输入用户名" >
		<button id = "queryButton" class="btn btn-primary" type="button">查询</button>
	</div>
	<form id="form1">
		<table class="table table-bordered" id = 'tableResult'>
			<caption>查询用户结果</caption>
			<thead>
				<tr>
					<th>序号</th>
					<th>角色名</th>
					<th>角色描述</th>				
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="tableBody">
			</tbody>
		</table>
		<!-- 底部分页按钮 -->
		<div id="bottomTab"></div>
		<input type="submit" id="aco-useredit-form-submit" value="保存">  
	</form>
	<script type='text/javascript'>    
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
            	var roleId = $("#textInput").val(); //取内容
            	buildTable(roleId,page,PAGESIZE);//默认每页最多10条
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
        function deleEvent(roleId) {
            $("#aco-user-role-deleteBtn" + roleId).smoothConfirm("确定要删除伤情信息？", {
                okVal: "删除",
                // 点击确认返回callback
                ok: function () {
                    $.jc.utils.ajax({
                        url: $.jc.expand.getContextPath() + "/management/dedrug/Detain/juryRegis/delete/" + roleId,
                        type: "POST",
                        async: false,// 同步请求
                        success: function () {
                                $.Toast.success("删除伤情信息成功！");
                                // 查询伤情
                                $.jc.dedrug.detain.juryRegis.initdataTable();
                        },
                        error: '请求异常，删除伤情信息失败！'
                    });
                },
                // 点击取消返回callback
                cancel: function () {
                    return false;
                }
            });
        }
        //生成表格
        function buildTable(roleId,pageNumber,pageSize) {
        	 var url =  urlRootContext + "/user/findRoleList"; //请求的网址
             var reqParams = {'id':roleId, 'pageNumber':pageNumber,'pageSize':pageSize};//请求数据
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
            	var roleId = $("#textInput").val(); //取内容
            	buildTable(roleId,page,PAGESIZE);//默认每页最多10条
            }  
         }             	           
         $('#bottomTab').bootstrapPaginator("setOptions",newoptions); //重新设置总页面数目
         var dataList = data.dataList;
         $("#tableBody").empty();//清空表格内容
         if (dataList.length > 0 ) {
             $(dataList).each(function(){//重新生成
             	    $("#tableBody").append('<tr>');
                    $("#tableBody").append('<td>' + this.id + '</td>');
                    $("#tableBody").append('<td>' + this.roleName + '</td>');
                    $("#tableBody").append('<td>' + this.description + '</td>');
                    $("#tableBody").append("<a href=\"javascript:void(0);\" id=\"aco-user-role-deleteBtn" + id + "\" onclick=\"deleEvent('"
                            + id + "')\" class=\"btn default btn-xs red-stripe\">删除</a>");                   
                    $("#tableBody").append('</tr>');
             	    });  
             	    } else {             	            	
             	          $("#tableBody").append('<tr><th colspan ="4"><center>查询无数据</center></th></tr>');
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
        	
        	buildTable($("#aco-user-id").val(),1,10);//默认空白查全部
        	

        });
    </script>
</body>
</html>