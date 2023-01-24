/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DBConnection;
import model.DormModel;

/**
 *
 * @author strix
 */
public class UpdateListing extends HttpServlet {

    String classNm;
    String user;
    String pass;
    String driver;
    String dbHost;
    String dbPort;
    String dbName;
            
    public void init(ServletConfig config) throws ServletException{
            super.init(config);
            classNm = config.getInitParameter("jdbcClassName");
            user = config.getInitParameter("dbUserName");
            pass = config.getInitParameter("dbPassword");
            driver = config.getInitParameter("jdbcDriverURL");
            dbHost = config.getInitParameter("dbHostName");
            dbPort = config.getInitParameter("dbPort");
            dbName = config.getInitParameter("databaseName");
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("dormName");
        String userCity = request.getParameter("city");
        String dormAddress = request.getParameter("address");
        int price = Integer.parseInt(request.getParameter("price"));
        int space = Integer.parseInt(request.getParameter("space"));
        String contact = request.getParameter("contact");
        String link = request.getParameter("link");

            
        DBConnection db = new DBConnection(classNm, user, pass, driver, dbHost, dbPort, dbName);
        
        Connection con = db.getConnection();
        DormModel model = new DormModel(con, id, name, userCity, dormAddress, price, space, contact, link);

        
        
        
        try{
            ResultSet output = model.updateOutput();

            if(con != null){
                if(output.next()){
                    ResultSet record = model.getUpdateOutput();
                    request.setAttribute("userOutput",record);
                    request.getRequestDispatcher("registeredUser/registeredResult.jsp").forward(request,response);
                }
                else{
                    response.sendRedirect("error/inputError.jsp");
                }     
            }
            else{
                response.sendRedirect("error/error.jsp");
                } 
            } catch (SQLException sqle){
                   response.sendRedirect("error/SQLExceptionError.jsp");
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
