<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String path=request.getContextPath();%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="<%=path %>/js/jquery-1.10.2.min.js" ></script>
<title>Insert title here</title>
</head>
<body>
	<input type="button" id="testButton" value="测试dubbo协议接口" />
</body>
	<script type="text/javascript">
		$(function(){
			$("#testButton").click(function(){
				var url="/test-dubbo-web1/testController/testDubbo.do";
				var obj={};
				obj['id'] = "111";
				obj['name'] = "测试";
				var data={};
				//data['reqContent']=obj;
				data['reqContent']=JSON.stringify(obj);
				//data['reqContent']=11111;
				//alert(JSON.stringify(data));
				$.ajax({
					url:url,
					type:'post',
					//dataType:'json',
					//data:JSON.stringify(data),
					data:data,
					success:function(data) {
						alert(data);
					},
					error:function(data) {
						alert("出错了");						
					}
				}); 
			});
		});
	</script>
</html>