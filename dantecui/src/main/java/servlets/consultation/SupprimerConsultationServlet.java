package servlets.consultation;

import com.mycompany.hopital.dantec.service.ConsultationService;
import com.mycompany.hopital.dantec.service.MedecinService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/supprimerConsultation")
public class SupprimerConsultationServlet extends HttpServlet {
    private ConsultationService consultationService;

    public SupprimerConsultationServlet() {

        consultationService = new ConsultationService();


    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Logique pour les requêtes GET (si nécessaire)
        this.getServletContext().getRequestDispatcher("/WEB-INF/supprimerMedecin.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParameter = req.getParameter("id");

        if (idParameter != null && !idParameter.isEmpty()) {
            Long identifiant = Long.parseLong(idParameter);
            consultationService.deleteConsultation(identifiant);

            HttpSession session = req.getSession();
            session.setAttribute("messageSuppression", "La suppression s'est bien passée.");

            resp.sendRedirect(req.getContextPath() + "/supprimerConsultation");
        } else {
            // Gérer le cas où le paramètre "id" est nul ou vide
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "L'identifiant (id) est manquant ou invalide.");
        }
    }
}

