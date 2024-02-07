<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<title>Formulaire Spécialite</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
             <%@ include file="/menu.jsp" %>
              <div class="container">

                <c:if test="${!empty message }">
    		           <p  class="alert alert-danger mt-3" role="alert">
    				     <c:out value="${message }"></c:out>
    				  </p>

               </c:if>
            </div>

      <div class="container mt-3">
        <h1 class="text-primary">Ajout Spécialite</h1>
      </div>
      <div class="container mt-4">
           <form method="POST" action="formulaireSpecialite">
           <div class="mb-3">
             <label for="specialite" class="form-label">Specialite</label>
             <input type="text" class="form-control" name="specialite" placeholder=" veuillez saisir une specialite">
           </div>
           <div class="col-12">
             <button class="btn btn-primary" type="submit">Ajouter</button>
           </div>
         </form>
       </div>

  </body>
</html>
