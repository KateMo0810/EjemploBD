/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.Ejercicios;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LabingI5
 */
public class DAOEjercicios {
    
    
    public List<Ejercicios>  findAllByTopic(String topic) {
        List<Ejercicios> ejer = null;
        String query = "SELECT EXERCICES.TOPIC,AVG(POINTS) FROM EXERCICES NATURAL JOIN RESULTS WHERE TOPIC=? GROUP BY EXERCICES.TOPIC;";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOEjercicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement preparedStmt = null;
            preparedStmt = connection.prepareStatement(query);
	    preparedStmt.setString(1, topic);
            ResultSet rs = preparedStmt.executeQuery();
            double promedio = 0;
            String topico = null;

            while (rs.next()) {
               if (ejer == null) {
                    ejer = new ArrayList<Ejercicios>();
                }

                Ejercicios estudiante = new Ejercicios();
                promedio = rs.getDouble("avg");
                estudiante.setPromedio(promedio);

                topico = rs.getString("topico");
                estudiante.setTopico(topico);
                
                
                ejer.add(estudiante);
            }
            preparedStmt.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return ejer;

    }
    
        public List<Ejercicios> findAll() {
        List<Ejercicios> Topicos = null;
        String query = "SELECT DISTINCT  TOPIC FROM EXERCICES";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOEjercicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            String topico = null;

            while (rs.next()) {
                if ( Topicos== null) {
                    Topicos = new ArrayList<Ejercicios>();
                }

                Ejercicios registro = new Ejercicios();
                topico= rs.getString("topic");
                registro.setTopico(topico);
                Topicos.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return Topicos;

    }

}
