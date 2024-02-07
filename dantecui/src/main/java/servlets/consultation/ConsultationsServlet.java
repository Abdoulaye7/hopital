package servlets.consultation;

import com.mycompany.hopital.dantec.entity.Consultation;
import com.mycompany.hopital.dantec.entity.Medecin;
import com.mycompany.hopital.dantec.service.ConsultationService;
import com.mycompany.hopital.dantec.service.MedecinService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/consultations")
public class ConsultationsServlet extends HttpServlet {
    private ConsultationService consultationService;
    public ConsultationsServlet(){
        this.consultationService = new ConsultationService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Consultation> listeConsultations = consultationService.getListeConsultation();

        if (listeConsultations != null && !listeConsultations.isEmpty()) {

            req.setAttribute("listeConsultations", listeConsultations);

        } else {
            System.out.println("La liste des consultations est vide ou null.");
        }

        String messageSuccess = (String)req.getSession().getAttribute("messageSuccess") ;
        req.setAttribute("messageSuccess",messageSuccess);

        this.getServletContext().getRequestDispatcher("/WEB-INF/consultations.jsp").forward(req,resp);

        req.getSession().removeAttribute("messageSuccess");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
