<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Demo jsp</title>
    <style>
        table {
            font-family: arial, sans-serif;
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
    <%
        List<String> listStudent = new ArrayList<>();
        listStudent.add("student 1");
        listStudent.add("student 2");
        listStudent.add("student 3");
    %>
    <table>
        <tr>
            <th>Name</th>
        </tr>
        <%
            for (String item: listStudent) {
        %>
        <tr>
            <td><%=item%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
