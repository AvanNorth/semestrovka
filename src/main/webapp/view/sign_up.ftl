<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>SignUp by pskda</title>



    <!-- Bootstrap core CSS -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <script src="/resources/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


    <!-- Favicons -->
    <meta name="theme-color" content="#7952b3">


    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>


    <!-- Custom styles for this template -->
    <link href="/resources/css/loader.css" rel="stylesheet">
    <link href="/resources/css/signup.css" rel="stylesheet">
    <link href="/resources/css/victbtn.css" rel="stylesheet">

</head>

<body>
<#include "header.ftl">
<div class="text-center">
<main class="form-signin">
    <img class="mb-4" src="/resources/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
    <h1 class="h3 mb-3 fw-normal">Please sign up</h1>
    <ul class="nav nav-pills mb-3 align-items-center" id="pills-tab" role="tablist">
        <li class="nav-item" role="presentation">
            <button class="nav-link active" id="pills-user-tab" data-bs-toggle="pill" data-bs-target="#pills-user" type="button" role="tab" aria-controls="pills-user" aria-selected="true">as user</button>
        </li>
        <li class="nav-item">or</li>
        <li class="nav-item" role="presentation">
            <button class="nav-link" id="pills-lab-tab" data-bs-toggle="pill" data-bs-target="#pills-lab" type="button" role="tab" aria-controls="pills-lab" aria-selected="false">as lab</button>
        </li>
    </ul>
    <div class="align-items-start">
        <div class="tab-content" id="v-pills-tabContent">
            <div class="tab-pane fade show active" id="pills-user" role="tabpanel" aria-labelledby="pills-user-tab">
                <form id = "userform" action="/sign-up-user">
                    <div class="form-floating">
                        <input name="email" type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                        <label for="floatingInput">email</label>
                    </div>
                    <div class="form-floating">
                        <input name="phone" type="tel" class="form-control" id="floatingInput" placeholder="name@example.com">
                        <label for="floatingInput">Номер телефона</label>
                    </div>
                    <div class="form-floating">
                        <input name="firstName" type="text" class="form-control" id="floatingInput" placeholder="first name">
                        <label for="floatingInput">Имя</label>
                    </div>
                    <div class="form-floating">
                        <input name="lastName" type="text" class="form-control" id="floatingInput" placeholder="last name">
                        <label for="floatingInput">Фамилия</label>
                    </div>
                    <div class="form-floating">
                        <input name="password" type="password" class="form-control" id="floatingPassword" placeholder="password">
                        <label for="floatingPassword">Пароль</label>
                    </div>
                    <a href="#" class="btn btn-sm animated-button victoria-one" onclick="document.getElementById('userform').submit()">Регистрация</a>
                    <noscript>
                        <input type="submit" value="Регистрация" />
                    </noscript>
                    <#if error??>
                        <p class="mt-5 mb-3 text-warning">${error}</p>
                    </#if>
                </form>
            </div>
            <div class="tab-pane fade" id="pills-lab" role="tabpanel" aria-labelledby="pills-lab-tab">
                <form id = "labform" action="/sign-up-lab">
                    <div class="form-floating">
                        <input name="email" type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                        <label for="floatingInput">email</label>
                    </div>
                    <div class="form-floating">
                        <input name="phone" type="tel" class="form-control" id="floatingInput" placeholder="name@example.com">
                        <label for="floatingInput">Номер телефона</label>
                    </div>
                    <div class="form-floating">
                        <input name="name" type="text" class="form-control" id="floatingInput" placeholder="name@example.com">
                        <label for="floatingInput">Название лаборатории</label>
                    </div>
                    <div class="form-floating">
                        <input name="password" type="password" class="form-control" id="floatingPassword" placeholder="Password">
                        <label for="floatingPassword">Пароль</label>
                    </div>
                    <a href="#" class="btn btn-sm animated-button victoria-one" onclick="document.getElementById('labform').submit()">Регистрация</a>
                    <noscript>
                        <input type="submit" value="Регистрация" />
                    </noscript>
                    <#if error??>
                        <p class="mt-5 mb-3 text-warning">${error.getMessage}</p>
                    </#if>
                </form>
            </div>
        </div>
    </div>
    <!-- Loader -->
    <div class="loader-wrapper">
        <span class="loader"><span class="loader-inner"></span></span>
    </div>
    <script>
        $(window).on("load",function(){
            $(".loader-wrapper").fadeOut("slow");
            $(".loader-wrapper").overflow = "hidden";
        });
    </script>
</main>
</div>
</body>
</html>
