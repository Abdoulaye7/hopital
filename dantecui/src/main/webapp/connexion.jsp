<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html
<head>
<title>Formulaire de connexion</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

       <%@ include file="menu.jsp" %>
    <div class="container mt-3">
            <c:if test="${not empty errorMessage}">
                <div class="alert alert-dismissible alert-danger" id="errorAlert">
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" onclick="closeAlert()"></button>
                    <h4 class="alert-heading">Vos identifiants sont incorrects!</h4>
                    <p>Veuillez vérifier votre email ou mot de passe.</p>
                </div>
            </c:if>
        </div>

        <div class="container mt-4">
               <!-- Votre contenu ici -->
               <h1 class="text-body-secondary">Formulaire de connexion</h1>
           </div>

           <div class="container">
           <form method="POST" action="connexion">

                <div class="form-group">
                 <label for="exampleInputEmail1" class="form-label mt-4">Email </label>
                 <input type="email" class="form-control" name="email" aria-describedby="emailHelp" placeholder="Enter email">

               </div>
               <div class="form-group">
                 <label for="exampleInputPassword1" class="form-label mt-4">Password</label>
                 <input type="password" class="form-control" name="password" placeholder="Password" autocomplete="off">
               </div>
               </fieldset>
                   <button type="submit" class="btn btn-secondary mt-3">Connexion</button>
                 </fieldset>
           </div>

            </form>
    <script>
    function closeAlert() {
        var alertElement = document.getElementById("errorAlert");
        alertElement.style.display = "none";
    }
   </script>

</body>
</html>