<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Formulaire Spécialite</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
         <%@ include file="/menu.jsp" %>
         <div class="contanier">

           <div class="container mt-4">
             <c:if test="${!empty messageSuppression }">
                 <p  class="alert alert-success mt-3" role="alert">
                  <c:out value="${messageSuppression }"></c:out>
                </p>
              </c:if>
          </div>
        <script>
            setTimeout(function () {
                window.location.href = "<%= request.getContextPath() %>/specialites";
            }, 3000); // Redirect after 3 seconds (adjust the delay as needed)
        </script>
    </div>
</body>
</html>
