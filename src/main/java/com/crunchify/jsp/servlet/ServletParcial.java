/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchify.jsp.servlet;


import edu.co.sergio.mundo.dao.DAOEjercicios;
import edu.co.sergio.mundo.vo.Ejercicios;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author fabian.giraldo
 */
public class ServletParcial extends  HttpServlet{
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         DAOEjercicios daoEj = new DAOEjercicios();
         List<Ejercicios> escuelas= daoEj.findAll();
         request.setAttribute("topicos", escuelas);
         //Redireccionando la informacion
         RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
         redireccion.forward(request, response);      
      
     }
     
     
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         DAOEjercicios daoEjerci = new DAOEjercicios();
         String topico = request.getParameter("topico");
         Ejercicios ejercicio= daoEjerci.findAllByTopic(topico);
         request.setAttribute("promedios", ejercicio);
         //Redireccionando la informacion
         RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
         redireccion.forward(request, response);      
         
      
     }
}
