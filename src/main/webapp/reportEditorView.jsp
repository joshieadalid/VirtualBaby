<%@ page import="com.virtualbaby.entities.Nino" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title> Reporte Individual </title>

  <link rel="stylesheet" href="css/rep.css">
</head>
<body>
<body bgcolor="#33fff9"></body>
<div class="bar">
  <table>
    <tr>
      <td>
        <h1>
            Reporte Diario
        </h1>
      </td>
      <td>
        <input type="date" placeholder="..." name="" id="Fecha">
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
                <label for="Nombre_Completo" >Nombre del alumno: </label>
                <label for="Edad">Fecha nacimiento: </label>
                <label for="Grupo">Grupo: </label>
                <label for="Boleta">Boleta: </label>
              </td>
              <td class="respuesta">
                <%Nino nino = (Nino) request.getAttribute("nino");%>
                <label for="Nombre_Completo" class="respuesta"><%=nino.getNombreNino()%> <%=nino.getAp_paterno()%> <%=nino.getAp_materno()%></label>
                <label for="Edad" class="respuesta"><%=nino.getFechaNacimiento()%></label>
                <label for="Grupo" class="respuesta"><%=nino.getIdGrupo()%>></label>
                <label for="Boleta" class="respuesta"><%=nino.getIdNino()%></label>
              </td>
            </tr>
          </table>
        </div>
      </td>
      <!--Poniendo los datos de contacto del padre de familia-->
      <td>
        <div class="blocky">
          <h2>CONTACTO DEL TUTOR</h2>
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
      <tr><th> Hora </th><th>Alimento</th><th>Cantidad</th><th>Observaciones</th></tr>
      <!--Fila columna-->
      <tr class="suave"><td><input type="time" name="" id="Hora Comida"></td> <td> <input type="text" placeholder="Enliste los alimentos ingeridos" size="45" maxlength="65" name="" id="Alimentos"></td> <td><select name="Comias" id="Comidas">
        <option value="CT">Comio todo</option>
        <option value="CM">Comio a medias</option>
        <option value="CN">No comio nada</option>
      </select></td> <td><input type="text" placeholder="Escriba alguna observacion de ser necesario" size="45" maxlength="100"  name="" id="Observaciones_Comida"></td> </tr>

      <tr class="suave"><td><input type="time" name="" id="Hora Comida"></td> <td> <input type="text" placeholder="Enliste los alimentos ingeridos" size="45" maxlength="65" name="" id="Alimentos"></td> <td><select name="Comias" id="Comidas">
        <option value="CT">Comio todo</option>
        <option value="CM">Comio a medias</option>
        <option value="CN">No comio nada</option>
      </select></td> <td><input type="text" placeholder="Escriba alguna observacion de ser necesario" size="45" maxlength="100"  name="" id="Observaciones_Comida"></td> </tr>

      <tr class="suave"><td><input type="time" name="" id="Hora Comida"></td> <td> <input type="text" placeholder="Enliste los alimentos ingeridos" size="45" maxlength="65" name="" id="Alimentos"></td> <td><select name="Comias" id="Comidas">
        <option value="CT">Comio todo</option>
        <option value="CM">Comio a medias</option>
        <option value="CN">No comio nada</option>
      </select></td> <td><input type="text" placeholder="Escriba alguna observacion de ser necesario" size="45" maxlength="100"  name="" id="Observaciones_Comida"></td> </tr>

      <tr class="suave"><td><input type="time" name="" id="Hora Comida"></td> <td> <input type="text" placeholder="Enliste los alimentos ingeridos" size="45" maxlength="65" name="" id="Alimentos"></td> <td><select name="Comias" id="Comidas">
        <option value="CT">Comio todo</option>
        <option value="CM">Comio a medias</option>
        <option value="CN">No comio nada</option>
      </select></td> <td><input type="text" placeholder="Escriba alguna observacion de ser necesario" size="45" maxlength="100"  name="" id="Observaciones_Comida"></td> </tr>

      <tr class="suave"><td><input type="time" name="" id="Hora Comida"></td> <td> <input type="text" placeholder="Enliste los alimentos ingeridos" size="45" maxlength="65" name="" id="Alimentos"></td> <td><select name="Comias" id="Comidas">
        <option value="CT">Comio todo</option>
        <option value="CM">Comio a medias</option>
        <option value="CN">No comio nada</option>
      </select></td> <td><input type="text" placeholder="Escriba alguna observacion de ser necesario" size="45" maxlength="100"  name="" id="Observaciones_Comida"></td> </tr>

      <tr class="suave"><td><input type="time" name="" id="Hora Comida"></td> <td> <input type="text" placeholder="Enliste los alimentos ingeridos" size="45" maxlength="65" name="" id="Alimentos"></td> <td><select name="Comias" id="Comidas">
        <option value="CT">Comio todo</option>
        <option value="CM">Comio a medias</option>
        <option value="CN">No comio nada</option>
      </select></td> <td><input type="text" placeholder="Escriba alguna observacion de ser necesario" size="45" maxlength="100"  name="" id="Observaciones_Comida"></td> </tr>
      </tbody>
    </table>
    <br/><input type="button" value="Agregar Comida">
    <!--Fin de la tabla comidas-->
  </div>

  <!--Sue??o-->
  <div class="blocky">
    <h2>Siestas </h2>

    <table> <!--Inicio de la tabla-->

      <tbody>
      <tr><th> Hora Inicio </th><th>Hora de despertar</th><th>Observaciones</th></tr>
      <!--Fila columna-->
      <tr class="suave"><td><input type="time" name="" id="Hora Siesta"></td> <td><input type="time" name="" id="Hora_fin_siesta"></td><td><input type="text" placeholder="Escriba alguna observacion de ser necesario" size="55" maxlength="100"  name="" id="Observaciones_Sue??o"></td></tr>
      <tr class="suave"><td><input type="time" name="" id="Hora Siesta"></td> <td><input type="time" name="" id="Hora_fin_siesta"></td><td><input type="text" placeholder="Escriba alguna observacion de ser necesario" size="55" maxlength="100"  name="" id="Observaciones_Sue??o"></td></tr>
      <tr class="suave"><td><input type="time" name="" id="Hora Siesta"></td> <td><input type="time" name="" id="Hora_fin_siesta"></td><td><input type="text" placeholder="Escriba alguna observacion de ser necesario" size="55" maxlength="100"  name="" id="Observaciones_Sue??o"></td></tr>
      <tr class="suave"><td><input type="time" name="" id="Hora Siesta"></td> <td><input type="time" name="" id="Hora_fin_siesta"></td><td><input type="text" placeholder="Escriba alguna observacion de ser necesario" size="55" maxlength="100"  name="" id="Observaciones_Sue??o"></td></tr>
      <tr class="suave"><td><input type="time" name="" id="Hora Siesta"></td> <td><input type="time" name="" id="Hora_fin_siesta"></td><td><input type="text" placeholder="Escriba alguna observacion de ser necesario" size="55" maxlength="100"  name="" id="Observaciones_Sue??o"></td></tr>

      </tbody>
    </table>
    <br/><input type="button" value="Agregar Siesta">
    <!--Fin de la tabla sue??o-->
  </div>


  <!--Evacuaciones-->
  <div class="blocky">
    <h2>Evacuaciones </h2>

    <table> <!--Inicio de la tabla-->
      <tbody>
      <tr><th> Hora </th><th>Tipo</th><th>Observaciones</th></tr>
      <!--Fila columna-->
      <tr class="suave"><td><input type="time" name="" id="Hora Ba??o"></td> <td><select name="Ba??o" id="Ba??o">
        <option value="PI">Pip??</option>
        <option value="PO">Pop??</option>
        <option value="NA">No aplica</option>
      </select></td> <td><input type="text" placeholder="Escriba alguna observacion de ser necesario" size="55" maxlength="100"  name="" id="Observaciones_Comida"></td></tr>

      <tr class="suave"><td><input type="time" name="" id="Hora Ba??o"></td> <td><select name="Ba??o" id="Ba??o">
        <option value="PI">Pip??</option>
        <option value="PO">Pop??</option>
        <option value="NA">No aplica</option>
      </select></td> <td><input type="text" placeholder="Escriba alguna observacion de ser necesario" size="55" maxlength="100"  name="" id="Observaciones_Comida"></td></tr>

      <tr class="suave"><td><input type="time" name="" id="Hora Ba??o"></td> <td><select name="Ba??o" id="Ba??o">
        <option value="PI">Pip??</option>
        <option value="PO">Pop??</option>
        <option value="NA">No aplica</option>
      </select></td> <td><input type="text" placeholder="Escriba alguna observacion de ser necesario" size="55" maxlength="100"  name="" id="Observaciones_Comida"></td></tr>

      <tr class="suave"><td><input type="time" name="" id="Hora Ba??o"></td> <td><select name="Ba??o" id="Ba??o">
        <option value="PI">Pip??</option>
        <option value="PO">Pop??</option>
        <option value="NA">No aplica</option>
      </select></td> <td><input type="text" placeholder="Escriba alguna observacion de ser necesario" size="55" maxlength="100"  name="" id="Observaciones_Comida"></td></tr>

      <tr class="suave"><td><input type="time" name="" id="Hora Ba??o"></td> <td><select name="Ba??o" id="Ba??o">
        <option value="PI">Pip??</option>
        <option value="PO">Pop??</option>
        <option value="NA">No aplica</option>
      </select></td> <td><input type="text" placeholder="Escriba alguna observacion de ser necesario" size="55" maxlength="100"  name="" id="Observaciones_Comida"></td></tr>
      </tbody>
    </table>
    <br/><input type="button" value="Agregar Evacuacion">
    <!--Fin de la tabla sue??o-->
  </div>

  <h2>Observaciones Generales </h2>

  <input type="text" placeholder="Describa todo lo relevante respecto al comportamiento del ni??o" size="100" maxlength="200"  name="" id="Observaciones_Generales">

  <br/><br/>
  <input type="button" value="Finalizar Reporte">
</form>

</body>
</html>