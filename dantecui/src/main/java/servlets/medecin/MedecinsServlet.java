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
import java.io.IOException;
import java.util.List;

@WebServlet("/medecins")
public class MedecinsServlet  extends HttpServlet {
    private MedecinService medecinService;
    public MedecinsServlet(){
        this.medecinService = new MedecinService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Medecin> listeMedecin = medecinService.getListeMedecin();

        if (listeMedecin != null && !listeMedecin.isEmpty()) {

            req.setAttribute("listeMedecin", listeMedecin);

        } else {
            System.out.println("La liste des services est vide ou null.");
        }

        String messageSuccess = (String)req.getSession().getAttribute("messageSuccess") ;
        req.setAttribute("messageSuccess",messageSuccess);

        this.getServletContext().getRequestDispatcher("/WEB-INF/medecins.jsp").forward(req,resp);

        req.getSession().removeAttribute("messageSuccess");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
