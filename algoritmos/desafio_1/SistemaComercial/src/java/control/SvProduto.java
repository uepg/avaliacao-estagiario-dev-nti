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
import model.Produto;
import model.DAOProduto;

/**
 *
 * @author mathe
 */
public class SvProduto extends HttpServlet {

    private DAOProduto dc;

    @Override
    public void init() {

        dc = new DAOProduto();

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ACAO, s_cod_produto, s_nome, s_preco, s_qtd_estoque;

        ACAO = request.getParameter("ACAO");

        if (ACAO.equalsIgnoreCase("CRIAR")) {
            s_nome = request.getParameter("nome");
            s_preco = request.getParameter("preco");
            s_qtd_estoque = request.getParameter("qtd_estoque");

            Produto c = new Produto();

            c.setNome(s_nome);
            c.setPreco(Float.parseFloat(s_preco));
            c.setQtd_estoque(Integer.parseInt(s_qtd_estoque));

            int id = dc.inserir(c);
            response.sendRedirect("/SistemaComercial/admin/gerenciar/produtos.jsp?ins=" + id);

        } else if (ACAO.equalsIgnoreCase("EDITAR")) {
            s_nome = request.getParameter("nome");
            s_preco = request.getParameter("preco");
            s_qtd_estoque = request.getParameter("qtd_estoque");

            Produto c = new Produto();

            c.setCod_produto(Integer.parseInt(request.getParameter("cod_produto")));
            c.setNome(s_nome);
            c.setPreco(Float.parseFloat(s_preco));
            c.setQtd_estoque(Integer.parseInt(s_qtd_estoque));

            dc.alterar(c);
            response.sendRedirect("/SistemaComercial/admin/gerenciar/produtos.jsp");

        } else if (ACAO.equalsIgnoreCase("EXCLUIR")) {
            s_cod_produto = request.getParameter("cod_produto");

            dc.excluir(Integer.parseInt(s_cod_produto));

            response.sendRedirect("/SistemaComercial/admin/gerenciar/produtos.jsp?success");
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
