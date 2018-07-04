<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: hochnt
  Date: 2018/07/04
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo Servlet JSP 6</title>
    <style>
        table {
            font-family: Arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
    <p>Hello</p>
    <%
        List<String> lstString = new ArrayList<>();
        lstString.add("st 1");
        lstString.add("st 2");
        lstString.add("st 3");
        lstString.add("st 4");
        lstString.add("st 5");
        lstString.add("st 6");
    %>

    <table>
        <tr>
            <th>Name</th>
        </tr>
        <%
            for (String item : lstString) {

        %>
        <tr>
            <td><%=item%></td>
        </tr>
<%}%>
</table>
</body>
</html>
