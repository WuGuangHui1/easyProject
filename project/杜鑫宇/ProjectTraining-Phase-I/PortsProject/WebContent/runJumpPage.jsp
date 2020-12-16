<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>运行跳转界面</title>
</head>
<body>
	<%
		//获得请求方法(get/post)
		String input_method = request.getAttribute("method").toString();
		//获得输入参数
		String textContent = request.getAttribute("body").toString();
		//获得url，并切割
		String input_Url = request.getAttribute("url").toString();
		String[] urlname = input_Url.split("/");
		String name=null;
        for(int i=4;i<urlname.length;i++){
        	//获得接口连接(name)
	    	if(urlname.length==5){
	    		name=urlname[i];
	    	}
	    	else if(name==null){
	    		name=urlname[i]+"/";
	    	}
	    	else if(i==(urlname.length-1)){
	    		name=name+urlname[i];
	    	}
	    	else{
	    		name=name+urlname[i]+"/";
	    	}
	    }
        
	    System.out.println(name);
	    //接口name
	    request.setAttribute("url_path", name);
	    //url
	    request.setAttribute("url", input_Url);
	    //方法
		request.setAttribute("method", input_method);
		//参数
		request.setAttribute("content",textContent);
		
		//跳转
	    request.getRequestDispatcher(name).forward(request, response);
	%>
</body>
</html>