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
import model.Cliente;
import model.DAOCliente;

/**
 *
 * @author mathe
 */
public class SvCliente extends HttpServlet {

    private DAOCliente dc;

    @Override
    public void init() {

        dc = new DAOCliente();

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ACAO, s_cod_cliente, s_nome, s_email, s_telefone, s_cpf, s_senha;

        ACAO = request.getParameter("ACAO");

        if (ACAO.equalsIgnoreCase("SIGN_UP")) {
            s_nome = request.getParameter("nome");
            s_email = request.getParameter("email");
            s_cpf = request.getParameter("cpf");
            s_telefone = request.getParameter("telefone");
            s_senha = request.getParameter("senha");

            Cliente c = new Cliente();

            if (s_nome == null || s_email == null || s_cpf == null || s_telefone == null || s_senha == null) {
                response.sendRedirect("cliente/sign_up.jsp?empty=true");
            } else {
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

            ArrayList<Cliente> valid = dc.pesquisar("SELECT * FROM clientes WHERE email = '" + s_email + "' AND senha = '" + s_senha + "'");

            if (valid.size() == 1) {
                for (Cliente c : valid) {
                    Cookie new_cookie = new Cookie("cliente_sign_in", Integer.toString(c.getCod_cliente()));
                    new_cookie.setMaxAge(5 * 60);
                    response.addCookie(new_cookie);
                    response.sendRedirect("cliente/index.jsp?success");
                }
            } else {
                response.sendRedirect("cliente/sign_in.jsp");
            }
        } else if (ACAO.equalsIgnoreCase("EDITAR")) {
            s_cod_cliente = request.getParameter("cod_cliente");
            s_nome = request.getParameter("nome");
            s_email = request.getParameter("email");
            s_cpf = request.getParameter("cpf");
            s_telefone = request.getParameter("telefone");
            s_senha = request.getParameter("senha");

            Cliente c = new Cliente();

            if (s_nome == null || s_email == null || s_cpf == null || s_telefone == null || s_senha == null) {
                response.sendRedirect("cliente/sign_up.jsp?empty=true");
            } else {
                c.setCod_cliente(Integer.parseInt(s_cod_cliente));
                c.setNome(s_nome);
                c.setEmail(s_email);
                c.setCpf(s_cpf);
                c.setTelefone(s_telefone);
                c.setSenha(s_senha);

                boolean id = dc.alterar(c);
                response.sendRedirect("/SistemaComercial/admin/gerenciar/usuarios.jsp?ins=" + (id == true));
            }
        } else if (ACAO.equalsIgnoreCase("EXCLUIR")) {
            s_cod_cliente = request.getParameter("cod_cliente");

            boolean id = dc.excluir(Integer.parseInt(s_cod_cliente));
            response.sendRedirect("/SistemaComercial/admin/gerenciar/usuarios.jsp?ins=" + (id == true));
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
