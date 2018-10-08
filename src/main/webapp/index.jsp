<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
</head>
<body>
<form id="fileUploadForm" method="post" action="fileUploadServlet">
	            <div class="form_group">
	                <label>Upload File</label><span id="colon">: </span><input type="file" name="fileUpload" />
	                <span id="fileUploadErr">Please Upload A File!</span>
	            </div>
	            <button id="uploadBtn" type="submit" class="btn btn_primary">Upload</button>
</form>
</body>
</html>

