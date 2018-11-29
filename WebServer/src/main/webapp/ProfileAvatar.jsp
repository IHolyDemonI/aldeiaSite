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
        <style type="text/css">
            /* Hide radio button */
            [type=radio] {
                position: absolute;
                opacity: 0;
                width: 0;
                height: 0;
            }

            /* Image styles */
            [type=radio] + img {
                cursor: pointer;
            }

            /* Checked styles */
            [type=radio]:checked + img {
                outline: 2px solid #00f;
            }
        </style>
    </head>

    <body>
    <form method="post" action="createProfileAvatar">
        <label>
            <input type="radio" name="avatar" value="avatar1">
            <img src="avatar1.jpg" width="100px" height="100px">
        </label>
        <label>
            <input type="radio" name="avatar" value="avatar2">
            <img src="avatar2.png" width="100px" height="100px">
        </label>
        <br>
        <input type="submit" value="It's high time to chow down or bow down!"/>

    </form>
    </body>
</html>
