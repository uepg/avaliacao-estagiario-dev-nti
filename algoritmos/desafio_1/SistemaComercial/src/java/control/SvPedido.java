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
import java.util.List;
import model.Pedido;
import model.DAOPedido;
import model.DAOProduto;
import model.InfoPedido;
import model.Produto;

/**
 *
 * @author mathe
 */
public class SvPedido extends HttpServlet {

    private DAOPedido dc;

    @Override
    public void init() {
        dc = new DAOPedido();

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ACAO, s_cod_cliente;

        ACAO = request.getParameter("ACAO");

        if (ACAO.equalsIgnoreCase("FAZER_PEDIDO")) {
            s_cod_cliente = request.getParameter("cod_cliente");

            Pedido c = new Pedido();
            DAOProduto pr = new DAOProduto();
            ArrayList<Produto> produtos = pr.pesquisar("SELECT * FROM produtos");

            c.setCod_cliente(Integer.parseInt(s_cod_cliente));

            double preco_total = 0.0;

            ArrayList<InfoPedido> info_produtos = new ArrayList<>();

            for (Produto p : produtos) {
                String aux = request.getParameter("produto_" + Integer.toString(p.getCod_produto()));

                if (aux != null && Integer.parseInt(aux) > 0) {
                    double preco = 0, qtd_elementos = Integer.parseInt(request.getParameter("produto_" + Integer.toString(p.getCod_produto())));

                    InfoPedido new_pedido = new InfoPedido();
                    new_pedido.setCod_produto(p.getCod_produto());
                    new_pedido.setNome(p.getNome());
                    new_pedido.setQuantidade_produto((int) qtd_elementos);
                    new_pedido.setPreco_produto(p.getPreco());

                    if (qtd_elementos > 30) {
                        preco = qtd_elementos * p.getPreco() * (1 - 0.2);
                    } else if (qtd_elementos > 20) {
                        preco = qtd_elementos * p.getPreco() * (1 - 0.1);
                    } else if (qtd_elementos > 10) {
                        preco = qtd_elementos * p.getPreco() * (1 - 0.05);
                    } else {
                        preco = qtd_elementos * p.getPreco() * (1);
                    }

                    new_pedido.setPreco_total(preco);
                    preco_total += preco;
                    info_produtos.add(new_pedido);
                }
            }

            c.setPreco(preco_total);

            if (preco_total != 0.0) {
                dc.inserir(c, info_produtos);
                response.sendRedirect("admin/");
            } else {
                response.sendRedirect("admin/pedidos.jsp?error");
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
