<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>


<body>

<h1>测试信息123</h1>
<form action="stud/s001/show" method="post">
    <input type="submit" value="提交">
</form>

<form action="stud/show1" method="post">
    <input type="submit" value="提交">
</form>

<hr>
<br>
<div>
    <form id = "adminlogin" name ="adminlogin" method = "post" onsubmit="false">
        <input type="email" placeholder="用户名" name="userName" id="userName">
        <input type="password" placeholder="密码" name="password" id ="password">
        <button type="button" 登录></button>
        <a href="##" onclick="javascript:adminlogin.reset();return false"><small>reset</small>
            </a>

    </form>
    </div>


<input >
</body>
</html>
