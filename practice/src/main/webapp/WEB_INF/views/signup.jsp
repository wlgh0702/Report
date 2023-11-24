<%--
  Created by IntelliJ IDEA.
  User: 개발
  Date: 2023-11-23
  Time: 오전 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>T-soft</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <style type="text/css">
        .signupWrapper {
            position: absolute;
            top: 32%;
            left: 37%;
            width: 500px;
            text-align: center;
        }

        .signupBtn {
            margin-bottom: 10px;
            width: 300px;
            height: 30px;
            background-color: pink;
        }

        .signupBtn:hover {
            background-color: rgb(255, 159, 175);
        }

        #id, #pwd, #name, #birth, #email {
            width: 300px;
            height: 30px;
            margin-bottom: 10px;
            border: none;
            border-bottom: 1px solid pink;
            outline: none;
        }

        #id:focus, #pwd:focus, #name:focus, #birth:focus, #email:focus {
            border-bottom: 2px solid rgb(255, 159, 175);
        }

        .duplication {
            position: absolute;
            left: 83%;
            background-color: #ffedee;
            padding: 5px;
            border-radius: 5px;
            cursor: pointer;
        }

        .duplication:hover {
            background-color: pink;
        }
    </style>
</head>
<body>
<div class="signupWrapper">
    <h1>Sign Up</h1>
    <div class="duplication" onclick="dup()">중복검사</div>
    <form method="post" action="/signup">
        <input type="text" id="id" name="id" placeholder="아이디를 입력해주세요" required="required" />
        <br>
        <input type="password" id="pwd" name="pwd" placeholder="패스워드를 입력해주세요" required="required" />
        <br>
        <input type="text" id="name" name="name" placeholder="이름을 입력해주세요" required="required" />
        <br>
        <input type="text" id="birth" maxlength="8" name="birth" placeholder="생년월일을 입력해주세요 ex) 19970702" />
        <br>
        <input type="text" id="email" name="email" placeholder="이메일을 입력해주세요" />
        <br>
        <button type="submit" class="signupBtn" disabled>SingUp</button>
    </form>
</div>
<script>
    function dup() {
        let id = document.getElementById("id").value;
        let btn = document.getElementsByClassName("signupBtn")[0];

        $.ajax({
            type : 'POST',
            data : {id : id},
            url : "/duplication",
            success : function(data) {
                if(data == 0) {
                    alert("아이디가 존재합니다. 다른 아이디를 입력해주세요");
                    btn.disabled = true;
                } else {
                    alert("사용가능한 아이디입니다.");
                    btn.disabled = false;
                }
            }
        })
    }
</script>
</body>
</html>
