// confirmSuppression.js
function confirmerSuppression(idSpecialite) {
    var confirmation = confirm("Êtes-vous sûr de vouloir supprimer cette spécialité ?");
    if (confirmation) {
        // Utiliser AJAX pour envoyer une requête de suppression directement à la servlet Specialites
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "/dantecui/specialites?id=" + idSpecialite, true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                // Actualiser la page après la suppression
                location.reload();
            }
        };
        xhr.send();
    }
}
