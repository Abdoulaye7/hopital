<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Liste des Spécialités</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <style>
        /* Nouvelle couleur pour le titre */
        h2.text-primary {
            color: #ffffff; /* Blanc */
        }

        /* Nouvelle couleur pour le bouton Ajouter */
        .btn.btn-primary {
            background-color: #007bff; /* Couleur du navbar pour le bouton Ajouter */
            border-color: #007bff;
        }

        .btn.btn-primary:hover {
            background-color: #0056b3; /* Couleur plus foncée au survol */
            border-color: #0056b3;
        }

        .btn.btn-primary:focus {
            box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.5); /* Ombre légère sur la mise au point */
        }

        /* Nouvelle couleur pour le bouton Supprimer */
        .btn.btn-danger {
            background-color: #ff6b6b; /* Rouge plus doux pour le bouton Supprimer */
            border-color: #ff6b6b;
        }

        .btn.btn-danger:hover {
            background-color: #ff4949; /* Rouge plus foncé au survol */
            border-color: #ff4949;
        }

        .btn.btn-danger:focus {
            box-shadow: 0 0 0 0.2rem rgba(255, 107, 107, 0.5); /* Ombre légère sur la mise au point */
        }
    </style>
</head>
<body>

<%@ include file="/menu.jsp" %>

<div class="container mt-4">
    <c:if test="${!empty message}">
        <div class="alert alert-success" role="alert">
            <c:out value="${message}"/>
        </div>
    </c:if>

    <c:if test="${not empty messageModification}">
        <div class="alert alert-success" role="alert">
            <c:out value="${messageModification}"/>
        </div>
    </c:if>
</div>

<div class="container mt-4">
    <h2 class="text-primary">Liste des spécialités</h2>
    <a href="<c:url value='/formulaireSpecialite'/>" class="btn btn-primary mt-3"><i class="fas fa-plus"></i> Ajouter Spécialité</a>

    <table class="table mt-4">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Spécialité</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="specialite" items="${listeSpecialites}" varStatus="loop">
            <tr>
                <th scope="row">${loop.index + 1}</th>
                <td>${specialite.nom}</td>
                <td>
                    <a href="<c:url value='/modifierSpecialite'/>?id=${specialite.id}" class="btn btn-primary"><i class="fas fa-edit"></i> Modifier</a>

                    <form action="<c:url value='/supprimerSpecialite'/>" method="post" style="display: inline;">
                        <input type="hidden" name="id" value="${specialite.id}" />
                        <button type="submit" class="btn btn-danger" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cette spécialité ?')"><i class="fas fa-trash"></i> Supprimer</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-rZyo1g1xu7Iq5R7bDek7A5dI9YF3p99RFiCEVgF/KJWmL+MlTJ7V93rJSqL+JcZ" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js"></script>
</body>
</html>
