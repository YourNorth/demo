<#import "/spring.ftl" as spring/>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<p>${_csrf.token}</p>
<#--<form action="/login" method="post">

    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <div><input type="submit" value="Sign In"/></div>
</form>-->
<div>
    <form action="/login" method="POST">
        First Name: <@spring.formInput "loginForm.name" "" "text"/> <br/>
        Password: <@spring.formInput "loginForm.password" "" "password"/> <br/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input type="submit" value="SIGN IN"/>
    </form>
</div>
</body>
</html>