package servlets;

import dataaccess.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.UserService;

/**
 *
 * @author user
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDB userDB = new UserDB();
        ArrayList<User> users = new ArrayList<>();
        try {
            if (users == null) {
            } else {
                users = null;
            }
            users = userDB.getAll();
            request.setAttribute("users", users);

        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        UserDB userDB = new UserDB();
        UserService us = new UserService();

        switch (action) {
            case "add":
                String email = request.getParameter("addEmail");
                String firstname = request.getParameter("addFirst");
                String lastname = request.getParameter("addLast");
                String password = request.getParameter("addPass");
                int role = Integer.parseInt(request.getParameter("addRole"));

                try {
                    us.insert(email, firstname, lastname, password, role);
                } catch (Exception ex) {
                    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "edit":
                String editedEmail = request.getParameter("newEmail");
                String editedFirst = request.getParameter("newFirst");
                String editedLast = request.getParameter("newLast");
                String editedPass = request.getParameter("newPass");
                String editedRole = request.getParameter("newRole");

                request.setAttribute("editEmail", editedEmail);
                request.setAttribute("editFirst", editedFirst);
                request.setAttribute("editLast", editedLast);
                request.setAttribute("editPass", editedPass);
                request.setAttribute("editRole", editedRole);
                break;

            case "delete":
                String deletedEmail = request.getParameter("deleteEmail");
                 {
                    try {
                        us.delete(deletedEmail);
                    } catch (Exception ex) {
                        Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                break;

            case "update":
                String updatedEmail = request.getParameter("editEmail");
                String updatedFirst = request.getParameter("editFirst");
                String updatedLast = request.getParameter("editLast");
                String updatedPass = request.getParameter("editPass");
                int updatedRole = Integer.parseInt(request.getParameter("editRole"));

                 {
                    try {
                        us.update(updatedEmail, updatedFirst, updatedLast, updatedPass, updatedRole);
                    } catch (Exception ex) {
                        Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                break;

            case "cancel":
                request.setAttribute("editEmail", "");
                request.setAttribute("editFirst", "");
                request.setAttribute("editLast", "");
                request.setAttribute("editPass", "");
                request.setAttribute("editRole", "");
                break;
        }
        ArrayList<User> users;
        try {
            users = userDB.getAll();
            request.setAttribute("users", users);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }
}
