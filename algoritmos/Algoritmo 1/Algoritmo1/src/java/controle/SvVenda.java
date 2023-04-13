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
import modelo.Venda;
import modelo.DAOVenda;

public class SvVenda extends HttpServlet {

    private DAOVenda dv; 
    
    @Override
    public void init(){
        dv = new DAOVenda();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String ACAO, sdataVenda; 
        int sqtdeVenda, sidCliente, sidProduto;
        double stotalVenda, sdesconto;
        
        ACAO = request.getParameter("ACAO");
        
        if(ACAO.equalsIgnoreCase("EXCLUIR")){
            String id = request.getParameter("id");
            
            boolean r = dv.excluir(Integer.parseInt(id));
            
            if(r)
                response.sendRedirect("listarVenda.jsp");
                
        }else{
        
            sdataVenda = request.getParameter("dataVenda");
            sqtdeVenda = Integer.parseInt(request.getParameter("qtdeVenda"));
            sidCliente = Integer.parseInt(request.getParameter("idCliente"));
            sidProduto = Integer.parseInt(request.getParameter("idProduto"));
            sdesconto = Double.parseDouble(request.getParameter("desconto"));
            stotalVenda = Double.parseDouble(request.getParameter("totalVenda"));

            if(ACAO.equalsIgnoreCase("INSERIR")){
                Venda v = new Venda();

                v.setDataVenda(sdataVenda);
                v.setQtdeVenda(sqtdeVenda);
                v.setIdCliente(sidCliente);
                v.setIdProduto(sidProduto);
                v.setDesconto(sdesconto);
                v.setTotalVenda(stotalVenda);

                int id = dv.inserir(v);

                response.sendRedirect("listarVenda.jsp");    
            }else if(ACAO.equalsIgnoreCase("ALTERAR")){
                Venda v = new Venda();

                String scod = request.getParameter("cod");

                v.setIdVenda(Integer.parseInt(scod));
                v.setDataVenda(sdataVenda);
                v.setQtdeVenda(sqtdeVenda);
                v.setIdCliente(sidCliente);
                v.setIdProduto(sidProduto);
                v.setDesconto(sdesconto);
                v.setTotalVenda(stotalVenda);
                boolean r = dv.alterar(v);

                if(r)
                    response.sendRedirect("listarVenda.jsp");  
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
