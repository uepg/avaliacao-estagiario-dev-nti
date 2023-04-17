/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import model.Cliente;
import model.DAOCliente;
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

public class SvCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private DAOCliente dc;
    
    @Override
    public void init(){
        dc = new DAOCliente();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String snome, scpf, semail,scelular,ACAO;
        
        ACAO = request.getParameter("ACAO");
        
        if(ACAO.equalsIgnoreCase("INSERIR")){
            snome = request.getParameter("name");
            scpf = request.getParameter("cpf");
            semail = request.getParameter("email");
            scelular = request.getParameter("celular");

            Cliente c = new Cliente();
            c.setNome(snome);
            c.setCpf(scpf);
            c.setEmail(semail);
            c.setCelular(scelular);

            int id = dc.inserir(c);
        
        response.sendRedirect("cadCliente.jsp?r=Cliente cadastrado, id:"+id);
        }else if (ACAO.equalsIgnoreCase("EXCLUIR"))
        {
            String id = request.getParameter("id");
            
            boolean r = dc.excluir(Integer.parseInt(id));
            
            if (r)
              response.sendRedirect("listarClientes.jsp");
        }
        else
        if (ACAO.equalsIgnoreCase("ALTERAR"))
        {
            Cliente c = new Cliente();
            
            snome = request.getParameter("nome");
            semail = request.getParameter("email");
            scpf = request.getParameter("cpf");
            scelular = request.getParameter("celular");
            
            String cod = request.getParameter("cod");
            
            c.setCod_cliente(Integer.parseInt(cod));
            c.setNome(snome);
            c.setCpf(scpf);
            c.setEmail(semail);
            c.setCelular(scelular);
            
            dc.alterar(c);
            
            response.sendRedirect("listarClientes.jsp");
               
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
