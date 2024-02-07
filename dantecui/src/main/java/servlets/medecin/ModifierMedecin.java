package servlets.medecin;

import com.mycompany.hopital.dantec.entity.Medecin;
import com.mycompany.hopital.dantec.entity.Service;
import com.mycompany.hopital.dantec.service.MedecinService;
import com.mycompany.hopital.dantec.service.ServiceMedecin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/modifierMedecin")
public class ModifierMedecin extends HttpServlet {
    private MedecinService medecinService;
    private ServiceMedecin serviceMedecin;

    public ModifierMedecin() {
        medecinService = new MedecinService();
        serviceMedecin = new ServiceMedecin();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String identifiantParam = req.getParameter("id");


        if (identifiantParam != null && !identifiantParam.isEmpty()) {
            Long idMedecin = Long.parseLong(identifiantParam);


            Medecin medecin = medecinService.getMedecin(idMedecin);
            List<Service> listeServices = serviceMedecin.getListeService();

            req.setAttribute("medecin", medecin);
            req.setAttribute("listeServices", listeServices);


            req.getRequestDispatcher("/WEB-INF/modifierMedecin.jsp").forward(req, resp);
        } else {

            // Gérer le cas où l'identifiant est manquant ou invalide
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Identifiant de spécialité manquant ou invalide.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long identifiant = Long.parseLong(req.getParameter("id"));
        String nouveauMatricule = req.getParameter("matricule");
        String nouveauNom = req.getParameter("nom");
        String nouveauPrenom = req.getParameter("prenom");
        String naissanceParam = req.getParameter("naissance");
        Short nouveauNaissance = null;

        if (naissanceParam != null && !naissanceParam.isEmpty()) {
            try {
                nouveauNaissance = Short.valueOf(naissanceParam);
            } catch (NumberFormatException e) {
                nouveauNaissance = null;
            }
        } else {
            nouveauNaissance = null;
        }

        if (nouveauNaissance != null) {
            int nouveauServiceId = Integer.parseInt(req.getParameter("service"));
            Medecin medecin = medecinService.getMedecin(identifiant);
            medecin.setMatricule(nouveauMatricule);
            medecin.setNom(nouveauNom);
            medecin.setPrenom(nouveauPrenom);
            medecin.setDateNaissance(nouveauNaissance);

            Service service = serviceMedecin.getService(nouveauServiceId);
            medecin.setService(service);
            medecinService.updateMedecin(medecin);

            HttpSession session = req.getSession();
            session.setAttribute("messageModification", "La modification s'est bien passée.");

            resp.sendRedirect(req.getContextPath() + "/medecins");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("errorMessage", "Erreur de format pour la date de naissance.");
            resp.sendRedirect(req.getContextPath() + "/medecins");
        }
    }
}
