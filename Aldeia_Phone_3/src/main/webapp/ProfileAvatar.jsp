<%--
  Created by IntelliJ IDEA.
  User: Vera Estanqueiro
  Date: 08/11/2018
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <title>Profile</title>
    </head>

    <body>
        <form action="createProfileAvatar" method="post">
            <input type="image" src="avatar1.jpg" name="avatar1" id="avatar1" value="image1" style="border: solid 0px #000000; width: 150px; height: 150px;"/>

            <input type="image" src="avatar2.png" name="avatar2" id="avatar2" value="image1" style=" position: relative; left: 150px; border: solid 0px #000000; width: 150px; height: 150px;" />

        </form>
    </body>
</html>
