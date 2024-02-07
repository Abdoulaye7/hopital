package servlets;

import com.mycompany.hopital.dantec.entity.User;
import com.mycompany.hopital.dantec.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {

    private UserService userService;
    public ConnexionServlet(){
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          String email = req.getParameter("email");
          String password =req.getParameter("password");

          User user = userService.getUserByEmail(email);

          if(user!=null && userService.authenticateUser(password,user)){
              req.getSession().setAttribute("loggedInUser", user);
              resp.sendRedirect(req.getContextPath() + "/menu.jsp");

          }else {
              req.getSession().setAttribute("errorMessage", "Identifiants incorrects");
              resp.sendRedirect(req.getContextPath() + "/connexion.jsp");
          }

    }
}
