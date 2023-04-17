<%-- 
    Document   : sairCliente
    Created on : 16 de abr. de 2023, 13:07:24
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    Cookie cookie = null;
    Cookie[] cookies = null;
    
    cookies = request.getCookies();
    String sign_name = "cliente_sign_in";
    
    for(int i = 0; i < cookies.length; ++i) {
        cookie = cookies[i];
        System.out.println(cookie.getMaxAge());
        if(cookie.getName().equals(sign_name)) {
            Cookie kill_cookie = new Cookie(sign_name, "kill");
            kill_cookie.setPath("/SistemaComercial");
            kill_cookie.setMaxAge(0);
            response.addCookie(kill_cookie);
        }
    }
    
    response.sendRedirect("index.jsp");
%>
