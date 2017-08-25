<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.10.2.min.js" ></script>
</head>
<body>

<script type="text/javascript">
//var url="/test-dubbo-web1/test/testAjax.do";
var url="/test-dubbo-web1/testController/testDubbo.do";
	$(function(){
		$.ajax({
			url:url,
			type:"post",
			//contentType : 'application/json',  
			data:{"inputStr":"赵安华"},
		 	success:function(data){
		 		alert(data);
		 	},
		 	error:function(data) {
		 		alert("出错了");
		 	}
			
			
		});
		
	});

</script>

</body>
</html>