<%@ page import="com.domaji.practice.member.dto.MemberDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 개발
  Date: 2023-11-24
  Time: 오전 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            border: 1px solid #ccc;
            border-collapse: collapse;
            margin: 0;
            padding: 0;
            width: 1000px;
            table-layout: fixed;
            background-color: rgb(255, 233, 237);
        }

        .td1 {
            width: 200px;
        }

        td {
            border: 1px solid #ccc;
            text-align: center;
            height: 40px;
        }

        .tr1 {
            height: 300px;
        }

        .wrapper {
            position: absolute;
            top: 30%;
            left: 27%;
        }
    </style>
</head>
<body>
<% MemberDTO member = (MemberDTO)session.getAttribute("member"); %>
    <div class="wrapper">
        <table>
            <tbody>
            <tr>
                <td class="td1">제목</td>
                <td>${board.title}</td>
            </tr>
            <tr>
                <td class="td1">작성자</td>
                <td>${board.name}</td>
            </tr>
            <tr class="tr1">
                <td class="td1">내용</td>
                <td>${board.content}</td>
            </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
