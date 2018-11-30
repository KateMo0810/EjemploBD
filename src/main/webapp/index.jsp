<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="edu.co.sergio.mundo.vo.*"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
body {
    background-image:
        url('http://cdn.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
}
</style>
 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Estudiantes</title>
    </head>
    <body>
        <h1> Lista de Tópicos</h1>
        <div align="center" style="margin-top: 50px;">
            <%
              if(request.getAttribute("topicos")!=null){
            %>   
            <form action="Topico" method="post">
                <select name = "Tópico">
           <%
              List<Ejercicios> top  = (List<Ejercicios>)request.getAttribute("topicos");  
               for (Ejercicios ej : top) {
             %>
               <option value="<%=ej.getTopico()%>"><%=ej.getTopico()%></option>
             
             <%
               }
           %>
                </select>
                <input type="submit" value="submit">
            </form>
            <%
              }
            
            %>
            
          
        </div>


        <div align="center" style="margin-top: 50px;">
            
            <%
              if(request.getAttribute("promedios")!=null){
            %>      
              <table style="width:100%">
               <tr>
                    <th>Tópico</th>
                    <th>Promedio</th> 
              </tr>
                
              <%  
              List<Ejercicios> promedios  = (List<Ejercicios>)request.getAttribute("promedios");  
               for (Ejercicios ejerci : promedios) {
             %>
             
               <tr>
                  <td><%=ejerci.getTopico()%></td>
                  <td><%=ejerci.getPromedio()%></td> 
              </tr>
             
             <%
             }
             %>
               
                </table>
               
            <%
              }
            %>   
            
        </div>
    
    
</body>
</html>
