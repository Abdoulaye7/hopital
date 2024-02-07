package servlets.consultation;

import com.mycompany.hopital.dantec.entity.Consultation;
import com.mycompany.hopital.dantec.entity.Medecin;
import com.mycompany.hopital.dantec.entity.Patient;
import com.mycompany.hopital.dantec.entity.Service;
import com.mycompany.hopital.dantec.service.ConsultationService;
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

@WebServlet("/modifierConsultation")
public class ModifierConsultationServlet extends HttpServlet {

    private MedecinService medecinService;
   private PatientService patientService;
   private ConsultationService consultationService;

    public ModifierConsultationServlet() {
        medecinService = new MedecinService();
        patientService = new PatientService();
        consultationService= new ConsultationService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String identifiantParam = req.getParameter("id");


        if (identifiantParam != null && !identifiantParam.isEmpty()) {
            Long idConsultation = Long.parseLong(identifiantParam);


            Consultation consultation = consultationService.getConsultation(idConsultation);
            List<Medecin> listeMedecins = medecinService.getListeMedecin();
            List<Patient> listePatients = patientService.getListePatient();

            req.setAttribute("consultation", consultation);
            req.setAttribute("listeMedecins", listeMedecins);
            req.setAttribute("listePatients", listePatients);


            req.getRequestDispatcher("/WEB-INF/modifierConsultation.jsp").forward(req, resp);
        } else {

            // Gérer le cas où l'identifiant est manquant ou invalide
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Identifiant de la consultation manquant ou invalide.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long identifiant = Long.parseLong(req.getParameter("id"));
        String nouvelleRemarque = req.getParameter("remarque");
        String nouvellePrescription = req.getParameter("prescription");
        String dateParam = req.getParameter("date");
        Short nouveauDate = null;

        if (dateParam != null && !dateParam.isEmpty()) {
            try {
                nouveauDate = Short.valueOf(dateParam);
            } catch (NumberFormatException e) {
                nouveauDate = null;
            }
        } else {
            nouveauDate = null;
        }

        if (nouveauDate != null) {
            int nouveauPatientId = Integer.parseInt(req.getParameter("patient"));
            Long nouveauMedecinId = Long.parseLong(req.getParameter("medecin"));
           Consultation consultation = consultationService.getConsultation(identifiant);
           consultation.setDate(nouveauDate);
           consultation.setPrescription(nouvellePrescription);
           consultation.setRemarque(nouvelleRemarque);

           Medecin medecin = medecinService.getMedecin(nouveauMedecinId);
           Patient patient = patientService.getPatient(nouveauPatientId);

           consultation.setMedecin(medecin);
           consultation.setPatient(patient);

           consultationService.updateConsultation(consultation);

            HttpSession session = req.getSession();
            session.setAttribute("messageModification", "La modification s'est bien passée.");

            resp.sendRedirect(req.getContextPath() + "/consultations");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("errorMessage", "Erreur de format pour la date.");
            resp.sendRedirect(req.getContextPath() + "/consultations");
        }
    }
}
