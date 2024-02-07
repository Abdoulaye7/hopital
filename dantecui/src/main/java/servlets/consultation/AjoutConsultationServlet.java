package servlets.consultation;

import com.mycompany.hopital.dantec.entity.Consultation;
import com.mycompany.hopital.dantec.entity.Medecin;
import com.mycompany.hopital.dantec.entity.Patient;
import com.mycompany.hopital.dantec.service.ConsultationService;
import com.mycompany.hopital.dantec.service.MedecinService;
import com.mycompany.hopital.dantec.service.PatientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/formulaireConsultation")
public class AjoutConsultationServlet extends HttpServlet {

    private ConsultationService consultationService;
    private MedecinService medecinService;
    private PatientService patientService;

    public  AjoutConsultationServlet()
    {
        consultationService = new ConsultationService();
        medecinService = new MedecinService();
        patientService = new PatientService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Medecin> listeMedecins = medecinService.getListeMedecin();
        List<Patient> listePatients = patientService.getListePatient();

        req.setAttribute("listeMedecins",listeMedecins);
        req.setAttribute("listePatients",listePatients);

        this.getServletContext().getRequestDispatcher("/WEB-INF/formulaireConsultation.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String datePara = req.getParameter("date");
        String prescription = req.getParameter("prescription");
        String remarque = req.getParameter("remarque");
        String medecinParam =req.getParameter("medecin");
        String patientParam = req.getParameter("patient");

        String message="";
        if(prescription.trim().isEmpty() || remarque.trim().isEmpty() || datePara.trim().isEmpty() ){

            message ="Veuillez saisir tous les champs svp !";
            req.setAttribute("messageError",message);
            this.getServletContext().getRequestDispatcher("/WEB-INF/formulaireConsultation.jsp").forward(req,resp);
        }else {

            message = "Consultation a été ajoutée avec succès";

             Short date = Short.parseShort(datePara);
             Long medecinId =Long.parseLong(medecinParam);
             int patientId = Integer.parseInt(patientParam);
            Consultation consultation = new Consultation();
            consultation.setDate(date);
            consultation.setPrescription(prescription);
            consultation.setRemarque(remarque);

            Medecin medecin = medecinService.getMedecin(medecinId);
            Patient patient = patientService.getPatient(patientId);

            consultation.setMedecin(medecin);
            consultation.setPatient(patient);

            consultationService.createConsultation(consultation);


            req.setAttribute("consultation", consultation);
            req.getSession().setAttribute("messageSuccess", message);

            resp.sendRedirect(req.getContextPath() + "/consultations");
        }



    }
}
