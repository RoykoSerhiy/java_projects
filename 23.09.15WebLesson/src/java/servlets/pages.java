/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Serhiy
 */
@WebServlet(name = "pages", urlPatterns = {"/pages"})
public class pages extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            /* TODO output your page here. You may use following sample code. */
            String[] strings = new String[105];
            int limit = 10;
            int curPage = Integer.parseInt(request.getParameter("page"));
            out.println("<div>" + strings.length + "</div>");
            int endIndex = curPage * limit; 
            int startIndex = endIndex - limit;
            out.printf("startidx %d endidx %d", startIndex , endIndex);
            for(int i = 0;i<strings.length;++i){
                strings[i] = "string" + i;
            }
            out.println("<table>");
            for(int i = startIndex;i<endIndex;++i)
            {
               out.println("<tr>");
               out.println("<td>" +strings[i] +"</td>");
               out.println("</tr>");
            }
            out.println("</table>");
            for(int i = 0 ;i<strings.length / limit;++i){
                
                if(curPage == i+1){
                    out.println("<a href=./pages?page="+(i+1)+">"+"|"+(i+1)+"|"+"</a>");
                }else{
                   out.println("<a href=./pages?page="+(i+1)+">"+(i+1)+"</a>"); 
                }        
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
