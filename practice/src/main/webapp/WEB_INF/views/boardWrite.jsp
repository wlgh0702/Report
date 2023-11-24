<%@ page import="com.domaji.practice.member.dto.MemberDTO" %><%--
  Created by IntelliJ IDEA.
  User: 개발
  Date: 2023-11-24
  Time: 오전 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .wrapper {
            position: absolute;
            top: 28%;
            left: 33%;
        }

        .title {
            width: 700px;
            height: 30px;
        }

        #content {
            resize: none;
        }

        .button {
            background-color: #ffedee;
            border: none;
            cursor: pointer;
            margin-top: 5px;
            width: 100px;
            height: 30px;
            font-size: medium;
        }

        .button:hover {
            background-color: pink;
        }

        .title:focus, #content:focus {
            outline: 2px solid rgb(253, 135, 154);
            border: none;
        }
    </style>
</head>
<body>
<% MemberDTO member = (MemberDTO) session.getAttribute("member"); %>
    <div class="wrapper">
        <form action="boardWrite" method="post">
            <input type="text" class="title" name="title" placeholder="제목을 입력해주세요" required maxlength="20">
            <br><br>
            <textarea name="content" id="content" cols="98" rows="30" required placeholder="내용을 입력해주세요"></textarea>
            <input type="hidden" value="${member.memberNo}" name="memberNo">
            <br>
            <button type="submit" class="button">작성하기</button>
        </form>
    </div>
</body>
</html>
