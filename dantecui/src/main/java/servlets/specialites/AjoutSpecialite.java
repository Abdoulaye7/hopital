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

@WebServlet("/formulaireSpecialite")
public class AjoutSpecialite extends HttpServlet {

    private SpecialiteService specialiteService;

    public AjoutSpecialite(){
        specialiteService=new SpecialiteService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Logique pour les requêtes GET (si nécessaire)
        this.getServletContext().getRequestDispatcher("/WEB-INF/formulaireSpecialite.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String specialite = req.getParameter("specialite");


        String message="";
        if(specialite.trim().isEmpty()){
            message ="Veuillez saisir la spécialité      svp !!";
            req.setAttribute("message", message);
            this.getServletContext().getRequestDispatcher("/WEB-INF/formulaireSpecialite.jsp").forward(req,resp);

        }else
        {
            message ="Ajout spécialité réussi avec succès !";
            Specialite sp = new Specialite();
            sp.setNom(specialite);
            specialiteService.createSpecialite(sp);


            req.getSession().setAttribute("message",message);
            req.setAttribute("sp",sp);
           // this.getServletContext().getRequestDispatcher("/WEB-INF/specialites.jsp").forward(req,resp);
            resp.sendRedirect(req.getContextPath() + "/specialites");
        }

    }
}
