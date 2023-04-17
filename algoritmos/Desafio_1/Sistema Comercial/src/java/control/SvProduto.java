/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import model.Produto;
import model.DAOProduto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author clebe
 */

public class SvProduto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private DAOProduto dp;
    
    @Override
    public void init(){
        dp = new DAOProduto();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String snome, svalor,ACAO;
        
        ACAO = request.getParameter("ACAO");
        
        if(ACAO.equalsIgnoreCase("INSERIR")){
            snome = request.getParameter("name");
            svalor = request.getParameter("valor");

            Produto p = new Produto();
            p.setNome(snome);
            p.setValor_unidade(Integer.parseInt(svalor));


            int id = dp.inserir(p);
        
        response.sendRedirect("cadProduto.jsp?r=Produto cadastrado, id:"+id);
        }else if (ACAO.equalsIgnoreCase("EXCLUIR"))
        {
            String id = request.getParameter("id");
            
            boolean r = dp.excluir(Integer.parseInt(id));
            
            if (r)
              response.sendRedirect("listarProdutos.jsp");
        }
        else
        if (ACAO.equalsIgnoreCase("ALTERAR"))
        {
            Produto p = new Produto();
            
            snome = request.getParameter("nome");
            svalor = request.getParameter("valor");
            
            String cod = request.getParameter("cod");
            
            p.setCod_produto(Integer.parseInt(cod));
            p.setNome(snome);
            p.setValor_unidade(Integer.parseInt(svalor));
            
            dp.alterar(p);
            
            response.sendRedirect("listarProdutos.jsp");
               
        }
    }
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
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


}
