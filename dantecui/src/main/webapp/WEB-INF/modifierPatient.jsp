<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Modifier Patient</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
   <%@ include file="/menu.jsp" %>
<div class="container mt-4">
    <h2>Modifier Patient</h2>

    <form method="post" action="<c:url value='/modifierPatient'/>">
       <div class="mb-3">
                <label for="id" class="form-label">ID du patient</label>
                <input type="text" class="form-control" id="id" name="id" value="${patient.id}" readonly>
       </div>
        <div class="mb-3">
            <label for="nom" class="form-label">Code du patient</label>
            <input type="text" class="form-control" id="nom" name="code" value="${patient.code}" >
        </div>

           <div class="mb-3">
             <label for="nom" class="form-label">Nom du patient</label>
             <input type="text" class="form-control" id="nom" name="nom" value="${patient.nom}" >
           </div>

           <div class="mb-3">
            <label for="nom" class="form-label">Prenom du patient</label>
             <input type="text" class="form-control" id="nom" name="prenom" value="${patient.prenom}" >
           </div>

          <div class="mb-3">
           <label for="nom" class="form-label">Naissance du patient</label>
            <input type="number" class="form-control" id="nom" name="naissance" value="${patient.dateNaissance}" >
         </div>


        <input type="hidden" name="id" value="${patient.id}">
        <button type="submit" class="btn btn-primary">Enregistrer les modifications</button>
    </form>
</div>
</body>
</html>
