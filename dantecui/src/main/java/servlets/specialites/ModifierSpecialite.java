
package servlets.specialites;
import com.mycompany.hopital.dantec.entity.Specialite;
import com.mycompany.hopital.dantec.service.SpecialiteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/modifierSpecialite")

public class ModifierSpecialite extends HttpServlet {
    private SpecialiteService specialiteService;

    public ModifierSpecialite() {
        specialiteService = new SpecialiteService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String identifiantParam = req.getParameter("id");


        if (identifiantParam != null && !identifiantParam.isEmpty()) {
            int idSpecialite = Integer.parseInt(identifiantParam);


            Specialite specialite = specialiteService.getSpecialite(idSpecialite);


            req.setAttribute("specialite", specialite);


            req.getRequestDispatcher("/WEB-INF/modifierSpecialite.jsp").forward(req, resp);
        } else {

            // Gérer le cas où l'identifiant est manquant ou invalide
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Identifiant de spécialité manquant ou invalide.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         int identifiant = Integer.parseInt(req.getParameter("id"));
         String nouveauSpecialite = req.getParameter("nom");
         Specialite specialite = specialiteService.getSpecialite(identifiant);
         specialite.setNom(nouveauSpecialite);
         specialiteService.renomme(identifiant,nouveauSpecialite);

        HttpSession session = req.getSession();
        session.setAttribute("messageModification", "La modification s'est bien passée.");


        resp.sendRedirect(req.getContextPath() + "/specialites");


    }
}
