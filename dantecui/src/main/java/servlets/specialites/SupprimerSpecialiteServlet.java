package servlets.specialites;

import com.mycompany.hopital.dantec.service.SpecialiteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/supprimerSpecialite")
public class SupprimerSpecialiteServlet extends HttpServlet {
    private SpecialiteService specialiteService;

    public SupprimerSpecialiteServlet() {

        specialiteService = new SpecialiteService();


    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Logique pour les requêtes GET (si nécessaire)
        this.getServletContext().getRequestDispatcher("/WEB-INF/supprimerSpecialite.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParameter = req.getParameter("id");

        if (idParameter != null && !idParameter.isEmpty()) {
            int identifiant = Integer.parseInt(idParameter);
            specialiteService.deleteSpecialite(identifiant);

            HttpSession session = req.getSession();
            session.setAttribute("messageSuppression", "La suppression s'est bien passée.");

            resp.sendRedirect(req.getContextPath() + "/supprimerSpecialite");
        } else {
            // Gérer le cas où le paramètre "id" est nul ou vide
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "L'identifiant (id) est manquant ou invalide.");
        }
    }
}

