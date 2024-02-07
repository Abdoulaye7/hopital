// webapp/js/script.js
function closeAlert() {
    var alertElement = document.getElementById("successAlert");
    alertElement.style.display = "none";
}

// Rediriger après 3 secondes
setTimeout(function () {
   window.location.href = "${pageContext.request.contextPath}/services.jsp";
}, 3000);
