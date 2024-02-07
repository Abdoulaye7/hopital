<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Services</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha384-GLhlTQ8iKu1iTRj/53nJvDDpZlYUAfxl+rt9sNT8CQ1TakUIdWCTq5FOeF04Pbq" crossorigin="anonymous">

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

    <%@ include file="menu.jsp" %>
    <!-- Content -->
    <div class="container mt-4">
        <h2 class="text-secondary-emphasis">Gestion des Services</h2>

        <div class="row mt-4">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Ajouter un Médecin</h5>
                        <p class="card-text">Ajoutez un nouveau médecin avec une description.</p>
                        <a href="<c:url value='/formulaireMedecin'/>"class="btn btn-secondary"><i class="fas fa-user-md"></i> Ajouter Médecin</a>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title ">Ajouter un Patient</h5>
                        <p class="card-text">Ajoutez un nouveau patient.</p>
                        <a href="<c:url value='/formulairePatient'/>" class="btn btn-secondary"><i class="fas fa-user"></i> Ajouter Patient</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                  <div class="card-body">
                  <h5 class="card-title ">Ajouter une Specialite</h5>
                    <p class="card-text">Ajoutez une nouvelle Specialite.</p>
                       <a href="<c:url value='/formulaireSpecialite'/>" class="btn btn-secondary"><i class="fas fa-user"></i> Ajouter Patient</a>
                     </div>
                </div>
             </div>

            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Ajouter une Consultation</h5>
                        <p class="card-text">Ajoutez une nouvelle consultation.</p>
                        <a href="<c:url value='/formulaireConsultation'/>" class="btn btn-secondary"><i class="fas fa-stethoscope"></i> Ajouter Consultation</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="row mt-4">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Suivre les Consultations d'un Patient</h5>
                        <p class="card-text">Consultez les consultations d'un patient spécifique.</p>
                        <a href="#" class="btn btn-secondary"><i class="fas fa-list-alt"></i> Suivre Consultations</a>
                    </div>
                </div>
            </div>

            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Suivi des Consultations par un Médecin</h5>
                        <p class="card-text">Consultez les consultations effectuées par un médecin.</p>
                        <a href="#" class="btn btn-secondary"><i class="fas fa-history"></i> Suivi Consultations</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS (si nécessaire) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-r9Zpvo1Mz9ATKxIep9tiCxS/Z9O7bZNEFWEEX6BcVSmGn49b7UkTbMKeCGI7CcA" crossorigin="anonymous"></script>
</body>

</html>
