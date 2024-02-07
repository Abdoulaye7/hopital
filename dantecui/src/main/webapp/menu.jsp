<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Accueil</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha384-GLhlTQ8iKu1iTRj/53nJvDDpZlYUAfxl+rt9sNT8CQ1TakUIdWCTq5FOeF04Pbq" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">

    <!-- Styles personnalisés -->
    <style>
        body {
            background-color: #f8f9fa;
        }

        .navbar {
            background-color: #343a40;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
        }

        .navbar-brand {
            color: #ffffff;
            font-weight: bold;
        }

        .navbar-nav .nav-link {
            color: #ffffff;
            transition: color 0.3s ease-in-out;
        }

        .navbar-nav .nav-link:hover {
            color: #ffc107;
        }
    </style>
</head>

<body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container">
            <a class="navbar-brand" href="#">Gestion Hopital</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/menu.jsp"><i class="fas fa-home"></i> Accueil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/a-propos.jsp"><i class="fas fa-info-circle"></i> À Propos</a>
                    <c:if test="${sessionScope.loggedInUser ne null}">
                         <!-- Afficher le lien Services seulement si l'utilisateur est connecté -->
                          <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/services.jsp"><i class="fas fa-cogs"></i> Services</a>
                           </li>
                     </c:if>

                </ul>

                <ul class="navbar-nav ms-auto">
                    <c:choose>
                        <c:when test="${sessionScope.loggedInUser ne null}">
                          <!-- Afficher le courriel et le lien de déconnexion quand connecté -->
                             <li class="nav-item">
                                <a class="nav-link" href="#"><i class="fas fa-envelope"></i> ${sessionScope.loggedInUser.username}</a>
                             </li>
                             <li class="nav-item">
                                 <a class="nav-link" href="${pageContext.request.contextPath}/logout"><i class="fas fa-sign-out-alt"></i> Déconnexion</a>
                                </li>
                          </c:when>
                          <c:otherwise>
                              <!-- Afficher le lien de connexion quand non connecté -->
                             <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/connexion.jsp"><i class="fas fa-sign-in-alt"></i> Connexion</a>
                              </li>
                               <!-- Afficher le lien de création de compte quand non connecté -->
                              <li class="nav-item">
                                   <a class="nav-link" href="${pageContext.request.contextPath}/register.jsp"><i class="fas fa-user-plus"></i> Créer un compte</a>
                               </li>
                         </c:otherwise>
                     </c:choose>
                </ul>
            </div>
        </div>
    </nav>


    <!-- Content -->


   <!-- Inclure le fichier JavaScript externe -->



    <!-- Bootstrap JS (si nécessaire) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-r9Zpvo1Mz9ATKxIep9tiCxS/Z9O7bZNEFWEEX6BcVSmGn49b7UkTbMKeCGI7CcA" crossorigin="anonymous"></script>
</body>

</html>
