<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.domaji.practice.member.dto.MemberDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.domaji.practice.board.dto.BoardDTO" %><%--
  Created by IntelliJ IDEA.
  User: 개발
  Date: 2023-11-23
  Time: 오후 1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            margin: 0;
            padding: 0;

        }

        .header {
            width: 100%;
            height: 35px;
            background-color: pink;
            line-height: 35px;
            display: flex;
            justify-content: space-between;

        }

        .footer {
            width: 100%;
            height: 35px;
            background-color: pink;
            text-align: center;
            position: fixed;
            bottom: 0;
            line-height: 35px;
        }

        .board {
            margin-left: 48%;
        }

        .logout {
            margin-right: 30px;
            cursor: pointer;
        }

        .logout:hover {
            color: blueviolet;
        }

        .boardWrapper {
            width: 90%;
            margin-left: 5%;
            margin-top: 100px;
            height: 700px;
        }

        .table {
            margin-top: 10px;
            width: 100%;
            border-collapse: collapse;
            border-top: 1px solid #d0d0d0;
        }

        td {
            border-bottom: 1px solid #d0d0d0;
            padding: 8px;
            text-align: center;
        }

        th {
            border-bottom: 1px solid #d0d0d0;
            padding: 8px;
            background-color: #ffedee;
        }

        .write {
            margin-top: 20px;
            text-align: center;
            box-shadow: 0 2px 4px 0 rgb(211, 211, 211);
            width: 100px;
            height: 25px;
            line-height: 25px;
            border-radius: 5px;
            background-color: #ffedee;
            cursor: pointer;
            margin-left: 94.3%;
        }

        .write:hover {
            background-color: pink;
        }

        .logout {
            margin-top: 5px;
            background-color: #ffedee;
            outline: none;
        }

        .title {
            cursor: pointer;
        }

        .title:hover {
            color: pink;
        }
    </style>
</head>
<body>
<% MemberDTO member = (MemberDTO) session.getAttribute("member"); %>
<header>
    <div class="header">
        <div class="board">게시판</div>
        <div>${member.name}님</div>
        <form action="login" method="get">
            <button type="submit" class="logout">로그아웃</button>
        </form>
    </div>
</header>
<body>
<div style="width: 100%;">
    <div class="boardWrapper">
        <table class = "table">
            <thead>
            <tr>
                <th>순번</th>
                <th>작성자</th>
                <th>제목</th>
                <th>등록일</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${boardList}" var="item" varStatus="i">
                <tr>
                    <td><c:out value="${item.boardNo}"/></td>
                    <td><c:out value="${item.name}"/> </td>
                    <td class="title" onclick="location.href='/board/${item.boardNo}'"><c:out value="${item.title}"/></td>
                    <td><c:out value="${item.regDate}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <form action="boardWrite" method="get">
            <button type="submit" class="write">글쓰기</button>
        </form>
    </div>
</div>
</body>
<footer>
    <div class="footer">
        @Copyright jiho 2023.11
    </div>
</footer>
</body>
</html>
