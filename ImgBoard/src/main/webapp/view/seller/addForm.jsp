<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>��ǰ ���</h3>
<form action="${pageContext.request.contextPath }/seller/Add" method="post" 
enctype="multipart/form-data">
��ǰ��:<input type="text" name="name"><br>
���� : <input type="text" name="quantity"><br>
���� : <input type="text" name="price"><br>
��ǰ�̹������:<input type="file" name="file"><br>
�󼼼���:<textarea rows="10" cols="30" name="content"></textarea>
<br>
<input type="submit" value="���">
</form>
</body>
</html>