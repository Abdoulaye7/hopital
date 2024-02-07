package servlets.patient;

import com.mycompany.hopital.dantec.entity.Patient;
import com.mycompany.hopital.dantec.service.PatientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/formulairePatient")
public class AjoutPatientServlet extends HttpServlet {

    private PatientService patientService;

    public  AjoutPatientServlet()
    {
        this.patientService = new PatientService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/formulairePatient.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String naissanceParam = req.getParameter("naissance");

        String message="";

        if(code.trim().isEmpty() || nom.trim().isEmpty() || prenom.trim().isEmpty() || naissanceParam.trim().isEmpty())
        {
            message="Veuillez saisir tous les champs svp !";
            req.setAttribute("messageError",message);

            this.getServletContext().getRequestDispatcher("/WEB-INF/formulairePatient.jsp").forward(req,resp);

        }else {

            message = "Patient  a été ajouté avec succès";
            Short naissance = Short.parseShort(naissanceParam);
            Patient patient = new Patient();
            patient.setCode(code);
            patient.setNom(nom);
            patient.setPrenom(prenom);
            patient.setDateNaissance(naissance);

            patientService.createPatient(patient);

            req.setAttribute("patient",patient);
            req.getSession().setAttribute("messageSuccess", message);
            resp.sendRedirect(req.getContextPath() + "/patients");
        }
    }
}
