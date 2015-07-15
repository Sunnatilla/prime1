/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mavenproject1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sunnatilla
 */
public class Servlet extends HttpServlet {

            double CR_SUM;
            double CR_OWN_SUM;
            double CR_MONTHES;
            double CR_FEE_RATE;
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
        PrintWriter out = response.getWriter();
        try {
            CR_SUM = 0;
            CR_OWN_SUM = 0;
            CR_MONTHES = 0;
            CR_FEE_RATE = 0;
            
            
            if(!request.getParameter("CR_SUM").equals("")){
                CR_SUM = Double.parseDouble(request.getParameter("CR_SUM"));
            }
            if(!request.getParameter("CR_OWN_SUM").equals("")){
                CR_OWN_SUM = Double.parseDouble(request.getParameter("CR_OWN_SUM"));
            }
            if(!request.getParameter("CR_MONTHES").equals("")){
                CR_MONTHES = Double.parseDouble(request.getParameter("CR_MONTHES"));
            }
            if(!request.getParameter("CR_FEE_RATE").equals("")){
                CR_FEE_RATE = Double.parseDouble(request.getParameter("CR_FEE_RATE"));
            }
            
            
            set_CR_OWN_SUM_PERCENT(request);
            set_CR_PAYMENT_SUM(request);
            set_CR_OVERPAY(request);
            set_OUT_RES(request);
            
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            
        } finally {
            out.close();
        }
    }
    
    
    private void set_CR_OWN_SUM_PERCENT(HttpServletRequest request){
        if(CR_OWN_SUM>0){
            request.setAttribute("CR_OWN_SUM_PERCENT", round(CR_OWN_SUM*100/CR_SUM, 2));
        }else{
            request.setAttribute("CR_OWN_SUM_PERCENT", "");
        }
        
    }
    
    private void set_CR_PAYMENT_SUM(HttpServletRequest request){
        
        double percent = round(((double)CR_FEE_RATE/1200), 2);  
        
        if(CR_OWN_SUM>0){
             request.setAttribute("CR_PAYMENT_SUM", round(((CR_SUM-CR_OWN_SUM)*percent) / (1- Math.pow((1 + percent), (-CR_MONTHES))),2));
        }else{
            request.setAttribute("CR_PAYMENT_SUM", "");
        }
       
    }
    
    private void set_CR_OVERPAY(HttpServletRequest request){
        if(CR_OWN_SUM>0){            
            request.setAttribute("CR_OVERPAY", Math.round((double)CR_OWN_SUM*100.0)/CR_SUM);
        }else{
            request.setAttribute("CR_OVERPAY", "");
        }
    }

    private void set_OUT_RES(HttpServletRequest request){
        if(CR_OWN_SUM>0){
            request.setAttribute("OUT_RES", "");
        }else{
            request.setAttribute("OUT_RES", "Сумма первоначального взноса должна быть больше нуля!");
        }
    }
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
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
