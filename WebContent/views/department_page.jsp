<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 
<!DOCTYPE html>  
<html>  
<head>  
    <title>Department Add</title> 
    <style>  
.error{color:red}  
</style>  
</head>  
<h3>Department Form</h3>  
<body>  
    <form:form action="save_new_dept" modelAttribute="DepartmentModel">  
        Branch Name: <form:input path="BranchCode" />  
        <form:errors path="BranchCode" cssClass="error"/>        
        <br><br>
        Department Code: <form:input path="DepartmentCode" />  
        <form:errors path="DepartmentCode" cssClass="error"/> 
        <br><br> 
        Department Name: <form:input path="DepartmentName" /> 
        <form:errors path="DepartmentName" cssClass="error"/>   
        <br><br> 
        <input type="submit" value="Submit" />      
    </form:form> 
    
<table border="2" width="70%" cellpadding="2">  
		<tr><th>Branch</th><th>Code</th><th>Name</th></tr>  
			   <c:forEach var="department" items="${department_list}">   
			   <tr>  
			   <td>${department.branchCode}</td>  
			   <td>${department.departmentCode}</td>  
			   <td>${department.departmentName}</td>    
			   </tr>  
			   </c:forEach>  
</table> 
</body>  
</html>  