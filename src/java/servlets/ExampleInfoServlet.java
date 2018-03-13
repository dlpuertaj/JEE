/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dlpuertaj
 */
@WebServlet("/other/exampleInfo")
public class ExampleInfoServlet extends HttpServlet {

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
            out.println("<style> span {color:blue;} </style>");
 
            String requestURL = request.getRequestURL().toString();
            out.println("<br><span>requestURL:</span>");
            out.println(requestURL);

            String requestURI = request.getRequestURI();
            out.println("<br><span>requestURI:</span>");
            out.println(requestURI);

            String contextPath = request.getContextPath();
            out.println("<br><span>contextPath:</span>");
            out.println(contextPath);

            out.println("<br><span>servletPath:</span>");
            String servletPath = request.getServletPath();
            out.println(servletPath);

            String queryString = request.getQueryString();
            out.println("<br><span>queryString:</span>");
            out.println(queryString);

            String param1 = request.getParameter("text1");
            out.println("<br><span>getParameter text1:</span>");
            out.println(param1);

            String param2 = request.getParameter("text2");
            out.println("<br><span>getParameter text2:</span>");
            out.println(param2);

            // Server Infos
            out.println("<br><br><b>Server info:</b>");

            out.println("<br><span>serverName:</span>");
            String serverName = request.getServerName();
            out.println(serverName);

            out.println("<br><span>serverPort:</span>");
            int serverPort = request.getServerPort();
            out.println(serverPort + "");

            // Client Infos
            out.println("<br><br><b>Client info:</b>");

            out.println("<br><span>remoteAddr:</span>");
            String remoteAddr = request.getRemoteAddr();
            out.println(remoteAddr);

            out.println("<br><span>remoteHost:</span>");
            String remoteHost = request.getRemoteHost();
            out.println(remoteHost);

            out.println("<br><span>remoteHost:</span>");
            int remotePort = request.getRemotePort();
            out.println(remotePort + "");

            out.println("<br><span>remoteUser:</span>");
            String remoteUser = request.getRemoteUser();
            out.println(remoteUser);

            // Header Infos
            out.println("<br><br><b>headers:</b>");

            Enumeration<String> headers = request.getHeaderNames();
            while (headers.hasMoreElements()) {
                String header = headers.nextElement();
                out.println("<br><span>" + header + "</span>: " + request.getHeader(header));
            }

            // Servlet Context info:
            out.println("<br><br><b>Servlet Context info:</b>");
            ServletContext servletContext = request.getServletContext();

            // Location of web application in hard disk
            out.println("<br><span>realPath:</span>");
            String realPath = servletContext.getRealPath("");
            out.println(realPath);
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
