<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Modifier Consultation</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
   <%@ include file="/menu.jsp" %>
<div class="container mt-4">
    <h2>Modifier Consultation</h2>

    <form method="post" action="<c:url value='/modifierConsultation'/>">
       <div class="mb-3">
                <label for="id" class="form-label">ID de la Consultation</label>
                <input type="text" class="form-control" id="id" name="id" value="${consultation.id}" readonly>
       </div>
        <div class="mb-3">
            <label for="nom" class="form-label">Date Consultation</label>
            <input type="number" class="form-control" id="nom" name="date" value="${consultation.date}" >
        </div>

           <div class="mb-3">
             <label for="nom" class="form-label">Prescription</label>
             <input type="text" class="form-control" id="nom" name="prescription" value="${consultation.prescription}" >
           </div>

           <div class="mb-3">
            <label for="nom" class="form-label">Remarque</label>
             <input type="text" class="form-control" id="nom" name="remarque" value="${consultation.remarque}" >
           </div>


         <div class="mb-3">
             <label for="medecin" class="form-label">Medecin </label>
             <select class="form-select" id="medecin" name="medecin">
                 <c:forEach var="medecin" items="${listeMedecins}">
                     <option value="${medecin.id}" ${consultation.medecin.id == medecin.id ? 'selected' : ''}>${medecin.matricule}${medecin.nom}</option>
                 </c:forEach>
             </select>
         </div>
         <div class="mb-3">
             <label for="patieent" class="form-label">Patient </label>
             <select class="form-select" id="patient" name="patient">
              <c:forEach var="patient" items="${listePatients}">
               <option value="${patient.id}" ${consultation.patient.id == patient.id ? 'selected' : ''}>${patient.code}${patient.nom}</option>
              </c:forEach>
              </select>
       </div>

        <input type="hidden" name="id" value="${consultation.id}">
        <button type="submit" class="btn btn-primary">Enregistrer les modifications</button>
    </form>
</div>
</body>
</html>
