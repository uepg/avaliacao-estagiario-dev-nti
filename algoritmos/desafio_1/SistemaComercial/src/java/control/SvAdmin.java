/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Admin;
import model.DAOAdmin;

/**
 *
 * @author mathe
 */
public class SvAdmin extends HttpServlet {

    private DAOAdmin dc;

    @Override
    public void init() {

        dc = new DAOAdmin();

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ACAO, s_nome, s_email, s_telefone, s_cpf, s_senha;

        ACAO = request.getParameter("ACAO");

        if (ACAO.equalsIgnoreCase("SIGN_UP")) {
            s_nome = request.getParameter("nome");
            s_email = request.getParameter("email");
            s_cpf = request.getParameter("cpf");
            s_telefone = request.getParameter("telefone");
            s_senha = request.getParameter("senha");

            if (s_nome == "" || s_email == "" || s_cpf == "" || s_telefone == "" || s_senha == "") {
                response.sendRedirect("admin/sign_up.jsp?empty=true");
            } else {
                Admin c = new Admin();

                c.setNome(s_nome);
                c.setEmail(s_email);
                c.setCpf(s_cpf);
                c.setTelefone(s_telefone);
                c.setSenha(s_senha);

                int id = dc.inserir(c);
                response.sendRedirect("index.jsp?ins=" + id);

            }
        } else if (ACAO.equalsIgnoreCase("SIGN_IN")) {
            s_email = request.getParameter("email");
            s_senha = request.getParameter("senha");

            ArrayList<Admin> valid = dc.pesquisar("SELECT * FROM admins WHERE email = '" + s_email + "' AND senha = '" + s_senha + "'");

            if (valid.size() == 1) {
                for (Admin c : valid) {
                    Cookie new_cookie = new Cookie("admin_sign_in", Integer.toString(c.getCod_admin()));
                    new_cookie.setMaxAge(5 * 60);
                    response.addCookie(new_cookie);
                    response.sendRedirect("admin/index.jsp?success");
                }
            } else {
                response.sendRedirect("/SistemaComercial/admin/sign_in.jsp");
            }
        } else if (ACAO.equalsIgnoreCase("ALTERAR")) {
            Admin c = new Admin();

            s_nome = request.getParameter("nome");
            s_email = request.getParameter("email");
            s_telefone = request.getParameter("telefone");
            s_senha = request.getParameter("senha");

            String cod = request.getParameter("cod");

            c.setCod_admin(Integer.parseInt(cod));
            c.setNome(s_nome);
            c.setEmail(s_email);
            c.setTelefone(s_telefone);
            c.setSenha(s_senha);

            dc.alterar(c);

            response.sendRedirect("listarContato.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
