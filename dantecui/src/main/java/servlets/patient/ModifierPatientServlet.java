package servlets.patient;

import com.mycompany.hopital.dantec.entity.Medecin;
import com.mycompany.hopital.dantec.entity.Patient;
import com.mycompany.hopital.dantec.entity.Service;
import com.mycompany.hopital.dantec.service.MedecinService;
import com.mycompany.hopital.dantec.service.PatientService;
import com.mycompany.hopital.dantec.service.ServiceMedecin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/modifierPatient")
public class ModifierPatientServlet extends HttpServlet {
    private PatientService patientService;

    public ModifierPatientServlet() {
        patientService = new PatientService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String identifiantParam = req.getParameter("id");


        if (identifiantParam != null && !identifiantParam.isEmpty()) {
            int idPatient = Integer.parseInt(identifiantParam);


            Patient patient = patientService.getPatient(idPatient);


            req.setAttribute("patient", patient);



            req.getRequestDispatcher("/WEB-INF/modifierPatient.jsp").forward(req, resp);
        } else {

            // Gérer le cas où l'identifiant est manquant ou invalide
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Identifiant du patient manquant ou invalide.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int identifiant = Integer.parseInt(req.getParameter("id"));
        String nouveauCode = req.getParameter("code");
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

            Patient patient = patientService.getPatient(identifiant);
            patient.setCode(nouveauCode);
            patient.setNom(nouveauNom);
            patient.setPrenom(nouveauPrenom);
            patient.setDateNaissance(nouveauNaissance);

            patientService.updatePatient(patient);

            HttpSession session = req.getSession();
            session.setAttribute("messageModification", "La modification s'est bien passée.");

            resp.sendRedirect(req.getContextPath() + "/patients");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("errorMessage", "Erreur de format pour la date de naissance.");
            resp.sendRedirect(req.getContextPath() + "/patients");
        }
    }
}
