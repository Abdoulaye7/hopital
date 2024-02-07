<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Modifier Medecin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
   <%@ include file="/menu.jsp" %>
<div class="container mt-4">
    <h2>Modifier Spécialité</h2>

    <form method="post" action="<c:url value='/modifierMedecin'/>">
       <div class="mb-3">
                <label for="id" class="form-label">ID du médecin</label>
                <input type="text" class="form-control" id="id" name="id" value="${medecin.id}" readonly>
       </div>
        <div class="mb-3">
            <label for="nom" class="form-label">Matricule du medecin</label>
            <input type="text" class="form-control" id="nom" name="matricule" value="${medecin.matricule}" >
        </div>

           <div class="mb-3">
             <label for="nom" class="form-label">Nom du medecin</label>
             <input type="text" class="form-control" id="nom" name="nom" value="${medecin.nom}" >
           </div>

           <div class="mb-3">
            <label for="nom" class="form-label">Prenom du medecin</label>
             <input type="text" class="form-control" id="nom" name="prenom" value="${medecin.prenom}" >
           </div>

          <div class="mb-3">
           <label for="nom" class="form-label">Naissance du medecin</label>
            <input type="number" class="form-control" id="nom" name="naissance" value="${medecin.dateNaissance}" >
         </div>

         <div class="mb-3">
             <label for="service" class="form-label">Service du médecin</label>
             <select class="form-select" id="service" name="service">
                 <c:forEach var="service" items="${listeServices}">
                     <option value="${service.id}" ${medecin.service.id == service.id ? 'selected' : ''}>${service.nom}</option>
                 </c:forEach>
             </select>
         </div>

        <input type="hidden" name="id" value="${medecin.id}">
        <button type="submit" class="btn btn-primary">Enregistrer les modifications</button>
    </form>
</div>
</body>
</html>
