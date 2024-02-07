package servlets.patient;

import com.mycompany.hopital.dantec.entity.Patient;
import com.mycompany.hopital.dantec.entity.Specialite;
import com.mycompany.hopital.dantec.service.PatientService;
import com.mycompany.hopital.dantec.service.SpecialiteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/patients")
public class PatientsServlet extends HttpServlet {
    private PatientService patientService;

    public PatientsServlet(){
        patientService=new PatientService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Patient> listePatients = patientService.getListePatient();

        req.setAttribute("listePatients", listePatients);

        if (listePatients != null && !listePatients.isEmpty()) {

            req.setAttribute("listePatients", listePatients);

        } else {
            System.out.println("La liste des patients est vide ou null.");
        }

        String messageSuccess = (String)req.getSession().getAttribute("messageSuccess") ;
        req.setAttribute("messageSuccess",messageSuccess);

        this.getServletContext().getRequestDispatcher("/WEB-INF/patients.jsp").forward(req,resp);

        req.getSession().removeAttribute("messageSuccess");


    }
}
