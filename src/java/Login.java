/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import exception.NullValueException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DBConnection;
import model.DormModel;

/**
 *
 * @author strix
 */
public class Login extends HttpServlet {



    String classNm;
    String user;
    String pass;
    String driver;
    String dbHost;
    String dbPort;
    String dbName;


    @Override
    public void init(ServletConfig cg) throws ServletException{
        super.init(cg);
        

        
        classNm = cg.getInitParameter("jdbcClassName");
        user = cg.getInitParameter("dbUserName");
        pass = cg.getInitParameter("dbPassword");
        driver = cg.getInitParameter("jdbcDriverURL");
        dbHost = cg.getInitParameter("dbHostName");
        dbPort = cg.getInitParameter("dbPort");
        dbName = cg.getInitParameter("databaseName");

    }
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

            
            String u = request.getParameter("Username");
            String p = request.getParameter("Password");
            
            DBConnection db = new DBConnection(classNm, user, pass, driver, dbHost, dbPort, dbName);      
            Connection con = db.getConnection();
            
            DormModel model = new DormModel(con, u);
            
            
            try{
            ResultSet output = model.getPass();

           if(con != null){
               if(output.next()){
                    String username1 = output.getString("username");
                    String password1 = output.getString("password");
                    
                                if(u.equals(username1) && p.equals(password1)) //checking if username and pass is equal to the first user
                                {
                                    HttpSession session = request.getSession();
                                    session.setAttribute("username", u);
                                    RequestDispatcher view = request.getRequestDispatcher("registeredUser/addListing.jsp");
                                    view.forward(request, response);

                                }
                                    else{
                                        RequestDispatcher view = request.getRequestDispatcher("error/loginError.jsp");
                                        view.forward(request, response);
                                        }
               }
                else{
                    response.sendRedirect("error/loginError.jsp");
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
