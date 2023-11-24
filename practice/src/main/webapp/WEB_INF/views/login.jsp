<%--
  Created by IntelliJ IDEA.
  User: 개발
  Date: 2023-11-23
  Time: 오후 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .loginWrapper {
            position: absolute;
            top: 35%;
            left: 37%;
            width: 500px;
            text-align: center;
        }

        #id, #pwd {
            width: 300px;
            height: 30px;
            margin-bottom: 10px;
            border: none;
            border-bottom: 1px solid pink;
        }

        .loginBtn {
            margin-bottom: 10px;
            width: 300px;
            height: 30px;
            background-color: pink;
        }

        .loginBtn:hover {
            background-color: rgb(255, 159, 175);
        }
    </style>
</head>
<body>
    <div class="loginWrapper">
        <h1>Login</h1>
        <form method="post" action="/login">
            <input type="text" id="id" name="id" placeholder="아이디를 입력해주세요" required="required" />
            <br>
            <input type="password" id="pwd" name="pwd" placeholder="패스워드를 입력해주세요" required="required" />
            <br>
            <button type="submit" class="loginBtn">Login</button>
            <button type="button" class="loginBtn" onclick="location.href = '/signup'">SingUp</button>
        </form>
    </div>
</body>
</html>
