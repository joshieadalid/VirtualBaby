<jsp:useBean id="nino" scope="request" type="com.virtualbaby.entities.Nino"/>
<%@ page import="com.virtualbaby.entities.Nino" %>
<%@ page import="com.virtualbaby.entities.Comida" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title> Reporte del dia</title>

    <link rel="stylesheet" href="css/tutr.css">
</head>
<body>

<div class="bar">
    <table>
        <tr>
            <td>
                <h1>
                    Consulta de reportes
                </h1>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/TutorReportServlet" method="get">
                    <input type="hidden" name="nino" value="${nino}">
                    <label for="Fecha">
                    </label><input type="date" placeholder="..." name="date" id="Fecha">
                    <input type="submit" name="changeDateButton">
                </form>
            </td>
        </tr>
    </table>
</div>
<form>
    <!--Poniendo los datos personales del alumno hasta arriba del reporte principal-->
    <table class="completo">
        <tr>
            <td>
                <div class="blocky">
                    <h2>DATOS DEL ALUMNO</h2>
                    <table>
                        <tr>
                            <td>
                                <label for="Nombre_Completo">Nombre del alumno: </label>
                                <label for="Edad">Edad: </label>
                                <label for="Grupo">Grupo: </label>
                                <label for="Boleta">Boleta: </label>
                            </td>
                            <td class="respuesta">
                                <label for="Nombre_Completo" class="respuesta"><%=nino.getNombreNino()%>
                                </label>
                                <label for="Edad" class="respuesta"><%=nino.getFechaNacimiento()%>
                                </label>
                                <label for="Grupo" class="respuesta"><%=nino.getGrupo()%>
                                </label>
                                <label for="Boleta" class="respuesta"><%=nino.getIdNino()%>
                                </label>
                            </td>
                        </tr>
                    </table>
                </div>
            </td>
            <!--Poniendo los datos de contacto del padre de familia-->
            <td>
                <div class="blocky">
                    <h2>CONTACTO DEL DOCENTE</h2>
                    <table>
                        <tr>
                            <td>
                                <label for="Nombre_Tutor">Nombre tutor: </label>
                                <label for="Telefono_Tutor">Telefono: </label>
                                <label for="email_Tutor">Correo Electronico: </label>
                                <label for="email_Tutor"> .</label>
                            </td>
                            <td class="respuesta">
                                <label for="Nombre_Tutor" class="respuesta">juana dsaasda lotkyot </label>
                                <label for="Telefono_Tutor" class="respuesta">555720471 </label>
                                <label for="email_Tutor" class="respuesta">uitmxppw@hpkg.com</label>
                                <label for="email_Tutor" class="respuesta"> .</label>
                            </td>
                        </tr>
                    </table>
                </div>
            </td>
        </tr>
    </table>
    <!--Iniciando la generalizacion de datos en el alumno-->
    <!--Alimentos-->
    <div class="container">
        <h2>Comida </h2>

        <table> <!--Inicio de la tabla-->
            <tbody>
            <tr>
                <th> Hora</th>
                <th>Alimento</th>
                <th>Cantidad</th>
                <th>Observaciones</th>
            </tr>
            <!--Fila columna-->

            <%List<Comida> foodList = (List<Comida>) request.getAttribute("foodList");%>
            <%for(Comida i : foodList){%>
            <tr class="suave">
                <td><h3 id="Hora Comida"><%=i.getHora()%></h3></td>
                <td><h3 id="alimentos"><%=i.getNombreComida()%></h3></td>
                <td><h3 id="comias"><%=i.getCantidad()%></h3></td>
                <td><h3 id="Observaciones_Comida"><%=i.getObsComida()%></h3</td>
            </tr>
            <%} %>
            </tbody>
        </table>
        <br/>
        <!--Fin de la tabla comidas-->
    </div>

    <!--Sueño-->
    <div class="blocky">
        <h2>Siestas </h2>

        <table> <!--Inicio de la tabla-->

            <tbody>
            <tr>
                <th> Hora Inicio</th>
                <th>Hora de despertar</th>
                <th>Observaciones</th>
            </tr>
            <!--Fila columna-->
            <tr class="suave">
                <td><h3 id="Hora_Siesta"> 03:40 </h3></td>
                <td><h3 id="Hora_fin_siesta"> 16:00 </h3></td>
                <td><h3 id="Observaciones_Sueño"> No hay observaciones </h3></td>
            </tr>
            <tr class="suave">
                <td><h3 id="Hora_Siesta"> 03:40 </h3></td>
                <td><h3 id="Hora_fin_siesta"> 16:00 </h3></td>
                <td><h3 id="Observaciones_Sueño"> No hay observaciones </h3></td>
            </tr>
            <tr class="suave">
                <td><h3 id="Hora_Siesta"> 03:40 </h3></td>
                <td><h3 id="Hora_fin_siesta"> 16:00 </h3></td>
                <td><h3 id="Observaciones_Sueño"> No hay observaciones </h3></td>
            </tr>
            <tr class="suave">
                <td><h3 id="Hora_Siesta"> 03:40 </h3></td>
                <td><h3 id="Hora_fin_siesta"> 16:00 </h3></td>
                <td><h3 id="Observaciones_Sueño"> No hay observaciones </h3></td>
            </tr>
            <tr class="suave">
                <td><h3 id="Hora_Siesta"> 03:40 </h3></td>
                <td><h3 id="Hora_fin_siesta"> 16:00 </h3></td>
                <td><h3 id="Observaciones_Sueño"> No hay observaciones </h3></td>
            </tr>

            </tbody>
        </table>
        <br/>
        <!--Fin de la tabla sueño-->
    </div>


    <!--Evacuaciones-->
    <div class="blocky">
        <h2>Evacuaciones </h2>

        <table> <!--Inicio de la tabla-->
            <tbody>
            <tr>
                <th> Hora</th>
                <th>Tipo</th>
                <th>Observaciones</th>
            </tr>
            <!--Fila columna-->
            <tr class="suave">
                <td><h3 id="Hora Baño">12:00</h3></td>
                <td><h3 id="Baño">Pipí</h3></td>
                <td><h3 id="Observaciones_Comida">Sin observaciones</h3></td>
            </tr>
            <tr class="suave">
                <td><h3 id="Hora Baño">12:00</h3></td>
                <td><h3 id="Baño">Pipí</h3></td>
                <td><h3 id="Observaciones_Comida">Sin observaciones</h3></td>
            </tr>
            <tr class="suave">
                <td><h3 id="Hora Baño">12:00</h3></td>
                <td><h3 id="Baño">Pipí</h3></td>
                <td><h3 id="Observaciones_Comida">Sin observaciones</h3></td>
            </tr>
            <tr class="suave">
                <td><h3 id="Hora Baño">12:00</h3></td>
                <td><h3 id="Baño">Pipí</h3></td>
                <td><h3 id="Observaciones_Comida">Sin observaciones</h3></td>
            </tr>
            <tr class="suave">
                <td><h3 id="Hora Baño">12:00</h3></td>
                <td><h3 id="Baño">Pipí</h3></td>
                <td><h3 id="Observaciones_Comida">Sin observaciones</h3></td>
            </tr>


            </tbody>
        </table>
        <br/>
        <!--Fin de la tabla sueño-->
    </div>

    <h2>Observaciones Generales </h2>

    <h3 id="Observaciones_Generales"> No hay observaciones</h3>

    <br/><br/>
</form>

</body>
</html>