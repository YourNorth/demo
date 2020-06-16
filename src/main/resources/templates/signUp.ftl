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
<div>
    <p>${_csrf.token}</p>
    <form name="registration" action="/sing_up" method="POST">
        First Name: <@spring.formInput "registrationForm.name" "" "text"/>    <br/>
        E-mail: <@spring.formInput "registrationForm.email" "" "email"/>    <br/>
        Password: <@spring.formInput "registrationForm.password" "" "password"/>    <br/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input type="submit" value="SIGN UP" />
    </form>
</div>
</body>
</html>