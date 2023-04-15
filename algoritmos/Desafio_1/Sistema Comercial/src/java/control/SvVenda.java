/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import model.Venda;
import model.DAOProduto;
import model.DAOVenda;
import model.DAOVenda_Produto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import model.DAOCliente;
import model.Produto;


/**
 *
 * @author clebe
 */

public class SvVenda extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private DAOVenda dv;
    
    @Override
    public void init(){
        dv = new DAOVenda();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String ACAO;
        float svalor = 0;
        int qnt = 0;
        ACAO = request.getParameter("ACAO");
        
        if(ACAO.equalsIgnoreCase("INSERIR")){
            
            Date data = new Date();
            String aux;
            DAOProduto pi = new DAOProduto();
            ArrayList<Produto> ap = pi.pesquisar("SELECT * FROM produto");
                    
            for (Produto p : ap)
            {
               aux = request.getParameter( String.valueOf(p.getCod_produto()));
               if(Integer.parseInt(aux) > 0){
                   svalor = svalor+ p.getValor_unidade()*Integer.parseInt(aux);
               }
            }
            
            Venda v = new Venda();
            DAOVenda_Produto vp = new DAOVenda_Produto();
            v.setValorTotal(svalor);
            String cpf = request.getParameter("cpf");
            DAOCliente cliente = new DAOCliente();
            v.setCliente(cliente.getByCfp(cpf).getCod_cliente());
            v.setData(data.toString());

            int id = dv.inserir(v);
        
             for (Produto p : ap)
            {
               aux = request.getParameter( String.valueOf(p.getCod_produto()));
               if(Integer.parseInt(aux) > 0){
                   
                   vp.inserir(id, p,Integer.parseInt(aux) );
               }
            }
        response.sendRedirect("vender.jsp?r=Venda cadastrado, id:"+id);
        }else if (ACAO.equalsIgnoreCase("EXCLUIR"))
        {
            String id = request.getParameter("id");
            
            boolean r = dv.excluir(Integer.parseInt(id));
            
            if (r)
              response.sendRedirect("listarVendas.jsp");
        }
        else
        if (ACAO.equalsIgnoreCase("ALTERAR"))
        {
            Venda v = new Venda();
            
            
            String cod = request.getParameter("cod");
            
            v.setCod_venda(Integer.parseInt(cod));
            v.setValorTotal(svalor);
            
            dv.alterar(v);
            
            response.sendRedirect("listarVendas.jsp");
               
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
