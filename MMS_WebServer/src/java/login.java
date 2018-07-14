/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author csrua
 */
public class login extends HttpServlet {
    

    
            

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequestPass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>"); 
            out.println("<link rel=stylesheet type=text/css href=./css/style.css>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>YOU SUCCEEDED!</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            droppedProcessRequestError401(request, response);
        }
    }
    
    protected void processLoginFail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MakeMyStay -- Invalid login credentials </title>");  
            out.println("<link rel=stylesheet type=text/css href=./css/style.css>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1><b>/403: Forbidden!</b></h1>");
            out.println("<h3><i>MakeMyStay is only accessible by registered "
                    + "users. Your username and password were not "
                    + "validated.</i><p></h3>");
            out.println("<img src=./images/Halt-man-hi.png "
                    + "align=center width=200 height=200 "
                    + "alt=\"Halt Man\"> ");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            droppedProcessRequestError401(request, response);
        }
    }
    
    protected void processRequestFailBadSQL (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>System is not responding...</title>");
            out.println("<link rel=stylesheet type=text/css href=./css/style.css>");              
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>444/ No response: Do not attempt to continue.</h1>");
            out.println("</body>");
            out.println("</html>"); 
        } catch (Exception e) {
            droppedProcessRequestError401(request, response);
        }
    }
    
    protected void processRequestFwdCustomer (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {   
            /*TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MakeMyStay -- Customer Console</title>");
            out.println("<link rel=stylesheet type=text/css href=./css/style.css>");              
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>CUSTOMER CONSOLE PLACEHOLDER</h1>");
            out.println("</body>");
            
        } catch (Exception e) {
            droppedProcessRequestError401(request, response);
        }
    }
    
    protected void processRequestFwdPropertyOwner (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {      
            /*TODO output your page here. You may use following sample code.*/
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=stylesheet type=text/css href=./css/style.css>");
            out.println("<title>MakeMyStay -- Transfer Page</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div align='center'>");
            out.println("<h1>PROPERTY OWNER CONSOLE PLACEHOLDER</h1>");
            out.println("<h4><i>Please click <a href=propertyowner.html>here</a>"
                    + " to continue...</i></h4>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
        droppedProcessRequestError401(request, response);
        }    
    }    
    
    protected void processRequestFwdSystemAdmin (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {     
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=stylesheet type=text/css href=./css/style.css>");
            out.println("<title>MakeMyStay -- SystemAdmin Owner Console</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>SYSTEM ADMIN CONSOLE PLACEHOLDER</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            droppedProcessRequestError401(request, response);
        }   
    }

    protected void droppedProcessRequestError401 (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=stylesheet type=text/css href=./css/style.css>");
            out.println("<title>MakeMyStay -- !!! Unauthorized !!! </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1><b>/401: User has not been authorized to use MMS</b></h1>");
            out.println("<img src=./images/Halt-man-hi.png "
                + "align=center width=200 height=200 "
                + "alt=\"Halt Man\"> ");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            System.out.println("Doh! Exiting...");
            System.exit(0); 
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
        MyDb db = new MyDb();
        
        Connection con = db.getCon();
        PrintStream console = System.out;
        System.setOut(console);
        
        String user = request.getParameter("input_name");
        String pass = request.getParameter("input_pass");
        int user_type = 0;
        
         
        try {
            
            String Query = "SELECT UserName,Password,IdUserType FROM User "
                    + "where Username= ? AND Password = ?";
            PreparedStatement pst = con.prepareStatement(Query);
            
            pst.setString(1, user);
            pst.setString(2, pass);
            
            
            ResultSet rs = pst.executeQuery();
                             
            if (rs.next()) {
                System.out.println("Good credentials...");       
                System.out.println(user);
                System.out.println(pass); 
                user_type=rs.getInt(3);
                System.out.println(user_type);
                
                switch (user_type) {
                    case 1: processRequestFwdPropertyOwner(request, response);                     
                    case 2: processRequestFwdCustomer(request, response);                     
                    case 3: processRequestFwdSystemAdmin(request, response);
                    default: droppedProcessRequestError401(request, response);
                        break;
                }
                
                processRequestPass(request, response);
                
             
            } 
            else {
                System.out.println("LOGIN ERROR DETECTED! Cannot process request");       
                System.out.println(user);
                System.out.println(pass); 
                processLoginFail(request, response);
            }
        } catch (SQLException ex) {
            System.out.println("Invalid SQL query...");
            processRequestFailBadSQL(request, response);
        }
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
        processRequestPass(request, response);
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

    private void Switch(int user_type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
