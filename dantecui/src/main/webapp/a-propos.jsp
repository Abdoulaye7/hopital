<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>À Propos de Gestion Hopital</title>
    <!-- Intégration du thème Flatly de Bootswatch -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link  rel="stylesheet" href="https://bootswatch.com/flatly/bootstrap.min.css">
</head>

<body>
    <%@ include file="menu.jsp" %>

    <header class="container">
        <h1 class=" text-secondary mt-5">À Propos de Gestion Hopital</h1>
    </header>

    <section id="description" class="container">
        <h2 class=" text-primary mt-5">Description du Projet</h2>
        <p>Notre projet de gestion d'hôpital vise à fournir une plateforme efficace pour le suivi des patients, la gestion des consultations et la coordination des services associés à chaque médecin et sa spécialité. Cette application permet également la gestion des médecins et des consultations, en fournissant une interface conviviale pour les professionnels de la santé et le personnel administratif.</p>
    </section>

    <section id="fonctionnalites" class="container">
        <h2 class=" text-primary mt-5">Fonctionnalités Principales</h2>
        <ul>
            <li>Suivi des patients : Enregistrement des informations des patients, suivi des rendez-vous et des traitements médicaux.</li>
            <li>Gestion des consultations : Planification et suivi des consultations médicales, enregistrement des diagnostics et des prescriptions.</li>
            <li>Gestion des services associés aux médecins : Attribution des services et des spécialités à chaque médecin, permettant une coordination efficace des soins.</li>
            <li>Gestion des médecins : Enregistrement des informations personnelles et professionnelles des médecins, gestion des horaires de travail et des disponibilités.</li>
        </ul>
    </section>

    <section id="technologies" class="container">
        <h2 class=" text-primary mt-5">Technologies Utilisées</h2>
        <p>Notre projet de gestion d'hôpital est développé en utilisant les technologies suivantes :</p>
        <ul>
            <li>Java EE (Servlets, JSP) pour la logique côté serveur</li>
            <li>HTML, CSS et JavaScript pour l'interface utilisateur</li>
            <li>Bootstrap pour la mise en page et les composants frontend</li>
            <li>Hibernate pour la couche d'accès aux données et la gestion de la base de données</li>
            <!-- Ajoutez d'autres technologies utilisées si nécessaire -->
        </ul>
    </section>

    <footer class="container">
        <p class=" text-info mt-5">&copy; 2024 Gestion Hopital. Tous droits réservés.</p>
    </footer>

    <!-- Inclure les liens vers les fichiers JavaScript et autres scripts si nécessaire -->

    <!-- Intégration de Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>
</body>

</html>
