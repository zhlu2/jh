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
		
        IdentityCodeValid :function(code) { 
            var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};
            var tip = "";
            var pass= true;
            
            if(!code || !/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i.test(code)){
                tip = "身份证号格式错误";
                pass = false;
            }
            
           else if(!city[code.substr(0,2)]){
                tip = "地址编码错误";
                pass = false;
            }
            else{
                //18位身份证需要验证最后一位校验位
                if(code.length == 18){
                    code = code.split('');
                    //∑(ai×Wi)(mod 11)
                    //加权因子
                    var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
                    //校验位
                    var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
                    var sum = 0;
                    var ai = 0;
                    var wi = 0;
                    for (var i = 0; i < 17; i++)
                    {
                        ai = code[i];
                        wi = factor[i];
                        sum += ai * wi;
                    }
                    var last = parity[sum % 11];
                    if(parity[sum % 11] != code[17]){
                        tip = "校验位错误";
                        pass =false;
                    }
                }
            }
            if(!pass) alert(tip);
            return pass;
        },
        
    	// 初始化保存新建任务按钮的click事件
		initSaveBtnClickListener : function() {
			$("#aco-socialRelations-form-submit").on("click", function(event) {
				event.preventDefault();
	            if($("#aco-relationsex").val()=="男"&&$("#aco-sex").val()=="男"){
	            	if($("#aco-relationship").val()=="母"||$("#aco-relationship").val()=="女"||$("#aco-relationship").val()=="侄女"){
	            		alert("关系冲突，不能选择");
	            		return false;
	            	}
	            }else if($("#aco-relationsex").val()=="女"&&$("#aco-sex").val()=="女"){
	            	if($("#aco-relationship").val()=="父"||$("#aco-relationship").val()=="子"||$("#aco-relationship").val()=="女婿"){
	            		alert("关系冲突，不能选择");
	            		return false;
	            	}
	            }else if($("#aco-relationsex").val()=="男"&&$("#aco-sex").val()=="女"){
	            	if($("#aco-relationship").val()=="父"||$("#aco-relationship").val()=="子"||$("#aco-relationship").val()=="女婿"){
	            		alert("关系冲突，不能选择");
	            		return false;
	            	}
	            }else if($("#aco-relationsex").val()=="女"&&$("#aco-sex").val()=="男"){
	            	if($("#aco-relationship").val()=="父"||$("#aco-relationship").val()=="子"||$("#aco-relationship").val()=="女婿"){
	            		alert("关系冲突，不能选择");
	            		return false;
	            	}
	            }
	            
			    var code=$("#aco-relationcertificatenum").val();
			    var pass=addSocialRelations.IdentityCodeValid(code);
			    if(pass==false){
			    	return false;
			    }
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
