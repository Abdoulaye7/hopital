    package servlets;

    import com.mycompany.hopital.dantec.entity.User;

    import javax.servlet.RequestDispatcher;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import javax.servlet.http.HttpSession;
    import java.io.IOException;

    @WebServlet("/accueil")
    public class MenuServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session = req.getSession(false);

            if(session!=null && session.getAttribute("loggedInUser")!=null){
                req.getRequestDispatcher("/menu.jsp").forward(req, resp);
            }else {
                resp.sendRedirect(req.getContextPath() + "/connexion.jsp");
            }
            /*
            User loggedInUser = (User) req.getSession().getAttribute("loggedInUser");

           if(req.getSession()!=null )
            req.setAttribute("loggedInUser", loggedInUser);

           RequestDispatcher requestDispatcher =req.getRequestDispatcher("/menu.jsp");
           requestDispatcher.forward(req,resp);*/

        }
    }
