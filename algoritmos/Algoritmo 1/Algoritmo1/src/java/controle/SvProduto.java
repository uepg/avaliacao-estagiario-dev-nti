package controle;

/**
 *
 * @author fabio
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Produto;
import modelo.DAOProduto;

public class SvProduto extends HttpServlet {

    private DAOProduto dp; 
    
    @Override
    public void init(){
        dp = new DAOProduto();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String ACAO, snomeProduto;
        int sqtdeProduto;
        double svalorProduto;
        
        ACAO = request.getParameter("ACAO");
        
        if(ACAO.equalsIgnoreCase("EXCLUIR")){
            String id = request.getParameter("id");
            
            boolean r = dp.excluir(Integer.parseInt(id));
            
            if(r)
                response.sendRedirect("listarProduto.jsp");
                
        }else{
        
            snomeProduto = request.getParameter("nomeProduto");
            svalorProduto = Double.parseDouble(request.getParameter("valorProduto"));
            sqtdeProduto = Integer.parseInt(request.getParameter("qtdeProduto"));

            if(ACAO.equalsIgnoreCase("INSERIR")){
                Produto p = new Produto();

                p.setNomeProduto(snomeProduto);
                p.setValorProduto(svalorProduto);
                p.setQtdeProduto(sqtdeProduto);

                int id = dp.inserir(p);

                response.sendRedirect("listarProduto.jsp");    
            }else if(ACAO.equalsIgnoreCase("ALTERAR")){
                Produto p = new Produto();

                String scod = request.getParameter("cod");

                p.setIdProduto(Integer.parseInt(scod));
                p.setNomeProduto(snomeProduto);
                p.setValorProduto(svalorProduto);
                p.setQtdeProduto(sqtdeProduto);

                boolean r = dp.alterar(p);

                if(r)
                    response.sendRedirect("listarProduto.jsp");  
            }
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