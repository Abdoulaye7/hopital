package servlets.specialites;

import com.mycompany.hopital.dantec.entity.Specialite;
import com.mycompany.hopital.dantec.service.SpecialiteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/specialites")
public class Specialites extends HttpServlet {
    private SpecialiteService specialiteService;

    public Specialites(){
        specialiteService=new SpecialiteService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Specialite> listeSpecialites = specialiteService.getListeSpecialite();
        for (Specialite specialite : listeSpecialites) {
            System.out.println("ID: " + specialite.getId() + ", Nom: " + specialite.getNom());
        }
        req.setAttribute("listeSpecialites", listeSpecialites);

        String message = (String) req.getSession().getAttribute("message");
        String messageSuppression = (String) req.getSession().getAttribute("messageSuppression");
        req.setAttribute("messageSuppression", messageSuppression);

        String messageModification = (String) req.getSession().getAttribute("messageModification");
        req.setAttribute("message", message);
        req.setAttribute("messageModification", messageModification);

        //suppression pour eviter que ca s'affiche à chaque chargement de la page
        req.getSession().removeAttribute("messageModification");
        req.getSession().removeAttribute("message");
        req.getSession().removeAttribute("messageSuppression");



            this.getServletContext().getRequestDispatcher("/WEB-INF/specialites.jsp").forward(req, resp);


    }
}
