<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire Médecin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
    <%@ include file="/menu.jsp" %>

   <%@page contentType="text/html;charset=UTF-8" language="java" %>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <html>
   <head>
       <meta charset="UTF-8">
       <title>Formulaire Médecin</title>
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
   </head>
   <body>


       <div class="container mt-3">
                   <c:if test="${not empty messageError}">
                       <div class="alert alert-dismissible alert-danger" id="errorAlert">
                           <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" onclick="closeAlert()"></button>
                          <p><c:out value="${messageError}"></c:out></p>
                       </div>
                   </c:if>
               </div>

       <div class="container mt-3">
           <h1 class="text-secondary">Ajout Médecin</h1>
       </div>

       <div class="container mt-4">
           <form method="POST" action="formulaireMedecin">
               <!-- Utilisez une seule balise <form> -->
               <div class="form-group">
                   <label for="exampleInputEmail1" class="form-label mt-4">Matricule</label>
                   <input type="text" class="form-control" name="matricule" aria-describedby="emailHelp" placeholder="Enter matricule">
               </div>
               <div class="form-group">
                   <label for="exampleInputPassword1" class="form-label mt-4">Nom</label>
                   <input type="text" class="form-control" name="nom" placeholder="Entrer nom" >
               </div>
               <div class="form-group">
                   <label for="exampleInputPassword1" class="form-label mt-4">Prenom</label>
                   <input type="text" class="form-control" name="prenom" placeholder="Entrer prenom" >
               </div>
               <div class="form-group">
                   <label for="exampleInputPassword1" class="form-label mt-4">Date naissance</label>
                   <input type="text" class="form-control" name="naissance" placeholder="Entrer naissance" >
               </div>

                <div class="form-group">
                    <label for="exampleSelect1" class="form-label mt-4">Service</label>
                    <select class="form-select" name="service" >
                        <c:forEach var="service" items="${listeServices}">
                            <option value="${service.id}">${service.nom}</option>
                        </c:forEach>
                    </select>
                </div>

               <div class="container mt-3">
                   <button type="submit" class="btn btn-secondary">Ajouter</button>

               </div>
           </form>
       </div>
       <script>
       function closeAlert() {
               var alertElement = document.getElementById("errorAlert");
               alertElement.style.display = "none";
           }
          </script>
   </body>
   </html>


</body>
</html>
