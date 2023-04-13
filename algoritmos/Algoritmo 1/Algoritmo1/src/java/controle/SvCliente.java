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
import modelo.Cliente;
import modelo.DAOCliente;

public class SvCliente extends HttpServlet {

    private DAOCliente dc; 
    
    @Override
    public void init(){
        dc = new DAOCliente();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

        String ACAO, snomeCliente;
        
        snomeCliente = request.getParameter("nomeCliente");
        ACAO = request.getParameter("ACAO");
        
        if(ACAO.equalsIgnoreCase("INSERIR")){
            Cliente c = new Cliente();

            c.setNomeCliente(snomeCliente);

            int id = dc.inserir(c);

            response.sendRedirect("listarCliente.jsp");    
            
        }else if(ACAO.equalsIgnoreCase("EXCLUIR")){
            String id = request.getParameter("id");
            
            boolean r = dc.excluir(Integer.parseInt(id));
            
            if(r)
                response.sendRedirect("listarCliente.jsp");
                
        }else if(ACAO.equalsIgnoreCase("ALTERAR")){
            Cliente c = new Cliente();
            
            String scod = request.getParameter("cod");
            
            c.setIdCliente(Integer.parseInt(scod));
            c.setNomeCliente(snomeCliente);

            boolean r = dc.alterar(c);
            
            if(r)
                response.sendRedirect("listarCliente.jsp");
            
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