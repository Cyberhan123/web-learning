<%@ page import="java.util.List" %>
<%@ page import="cn.hselfweb.jsp.VO.User" %><%--
  Created by IntelliJ IDEA.
  User: Cybertron
  Date: 2018/10/11
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>显示全部</title>
</head>
<body>
<table>
    <tr>
        <td>用户名</td>
        <td>密码</td>
        <td>性别</td>
        <td>是否同意用户协议</td>
    </tr>
    <%
        List<User> users = (List<User>) request.getAttribute("studntList");
    %>
</table>
</body>
</html>
