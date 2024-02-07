package servlets.medecin;

import com.mycompany.hopital.dantec.entity.Medecin;
import com.mycompany.hopital.dantec.entity.Service;
import com.mycompany.hopital.dantec.service.MedecinService;
import com.mycompany.hopital.dantec.service.ServiceMedecin;
import com.mycompany.hopital.dantec.service.SpecialiteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/formulaireMedecin")
public class AjoutMedecinServlet extends HttpServlet {
    private ServiceMedecin serviceMedecin;
    private MedecinService medecinService;

    public AjoutMedecinServlet() {
        this.serviceMedecin = new ServiceMedecin();
        this.medecinService = new MedecinService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Service> listeServices = serviceMedecin.getListeService();

        if (listeServices != null && !listeServices.isEmpty()) {
            req.setAttribute("listeServices", listeServices);
            // Envoyer la liste à la JSP
        } else {
            System.out.println("La liste des services est vide ou null.");
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/formulaireMedecin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String matricule = req.getParameter("matricule");
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        //short naissance = Short.parseShort(req.getParameter("service"));
        //int idService = Integer.parseInt(req.getParameter("service"));
        String serviceP = req.getParameter("service");
        String dateNaissance = req.getParameter("naissance");

        String message="";

        if(matricule.trim().isEmpty() || nom.trim().isEmpty()|| prenom.trim().isEmpty() ||
        serviceP.trim().isEmpty() || dateNaissance.trim().isEmpty())
        {
            message ="Veuillez saisir tous les champs svp !";
            req.setAttribute("messageError",message);
            this.getServletContext().getRequestDispatcher("/WEB-INF/formulaireMedecin.jsp").forward(req,resp);
        }else {

            try {
                short naissance = Short.parseShort(dateNaissance);
                int idService = Integer.parseInt(serviceP);

                message = "Medecin a été ajouté avec succès";
                Medecin medecin = new Medecin();
                medecin.setMatricule(matricule);
                medecin.setNom(nom);
                medecin.setPrenom(prenom);
                medecin.setDateNaissance(naissance);
                Service service = serviceMedecin.getService(idService);

                medecin.setService(service);
                medecinService.createMedecin(medecin);

                req.setAttribute("medecin", medecin);
                req.getSession().setAttribute("messageSuccess", message);

                resp.sendRedirect(req.getContextPath() + "/medecins");
            } catch (NumberFormatException e) {
                message = "Erreur lors de la conversion du service en nombre.";
                req.setAttribute("messageError", message);
                this.getServletContext().getRequestDispatcher("/WEB-INF/formulaireMedecin.jsp").forward(req, resp);
            }
        }


    }
}
