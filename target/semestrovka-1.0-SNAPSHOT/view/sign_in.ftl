<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Вход</title>



    <!-- Bootstrap core CSS -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <script src="/resources/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


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
    <link rel="stylesheet" type="text/css" href="/resources/css/loading.css"/>
    <link href="/resources/css/loader.css" rel="stylesheet">
    <link href="/resources/css/signin.css" rel="stylesheet">
    <link href="/resources/css/victbtn.css" rel="stylesheet">

</head>

<body class="d-flex flex-column h-100">
<header class="p-3 bg-dark text-white">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <img class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap" src = "/resources/white-flask.svg"/>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="/" class="nav-link px-2 text-secondary">Главная</a></li>
            </ul>

            <div id = "signBtns" class="text-end">
                <#if user??>
                    <div class="dropdown">
                        <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                            <#if user.avatarId??>
                                <img src="/files/${user.avatarId}" alt="" class="rounded-circle me-2" width="32" height="32">
                            <#elseif lab??>
                                <div class="dropdown">
                                    <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                                        <#if lab.avatarId??>
                                            <img src="/files/${lab.avatarId}" alt="" class="rounded-circle me-2" width="32" height="32">
                                        <#else>
                                            <img src="/no-avatar.png" alt="" class="rounded-circle me-2" width="32" height="32">
                                        </#if>
                                        <strong>${lab.name}</strong>
                                    </a>

                                    <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                                        <li><a class="dropdown-item" href="#">Settings</a></li>
                                        <li><a class="dropdown-item" href="/profile">Profile</a></li>
                                        <li><hr class="dropdown-divider"></li>
                                        <li><a class="dropdown-item" href="/sign-out">Sign out</a></li>
                                    </ul>
                                </div>
                            <#else>
                                <img src="/no-avatar.png" alt="" class="rounded-circle me-2" width="32" height="32">
                            </#if>
                            <strong>${user.firstName}</strong>
                        </a>

                        <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                            <li><a class="dropdown-item" href="#">Settings</a></li>
                            <li><a class="dropdown-item" href="/profile">Profile</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="/sign-out">Sign out</a></li>
                        </ul>
                    </div>
                <#else>
                    <button type="button" class="btn btn-outline-light me-2" onclick="location.href = '/sign-in'">Войти</button>
                    <button type="button" class="btn btn-warning" onclick="location.href = '/sign-up'">Регистрация</button>
                </#if>
            </div>
        </div>
    </div>
</header>
<div class="text-center">
<main class="form-signin">
        <img class="mb-4" src="/resources/black_flask.svg" alt="" width="91" height="72">
        <h1 class="h3 mb-3 fw-normal">Вход</h1>

        <ul class="nav nav-pills mb-3 align-items-center" id="pills-tab" role="tablist">
            <li class="nav-item" role="presentation">
                <button class="nav-link active" id="pills-user-tab" data-bs-toggle="pill" data-bs-target="#pills-user" type="button" role="tab" aria-controls="pills-user" aria-selected="true">пользователь</button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="pills-lab-tab" data-bs-toggle="pill" data-bs-target="#pills-lab" type="button" role="tab" aria-controls="pills-lab" aria-selected="false">лаборатория</button>
            </li>
        </ul>
        <div class="align-items-start">
            <div class="tab-content" id="v-pills-tabContent">
                <div class="tab-pane fade show active" id="pills-user" role="tabpanel" aria-labelledby="pills-user-tab">
                    <form id = "userform" action="/sign-in-user">
                        <div class="form-floating">
                            <input name = "email" type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                            <label for="floatingInput">Email</label>
                        </div>
                        <div class="form-floating">
                            <input name = "password" type="password" class="form-control" id="floatingPassword" placeholder="Ваш пароль">
                            <label for="floatingPassword">Пароль</label>
                        </div>
                        <a href="#" class="btn btn-sm animated-button victoria-one" onclick="document.getElementById('userform').submit()">Войти</a>
                        <noscript>
                            <input type="submit" value="Войти" />
                        </noscript>

                        <p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>
                    </form>
                </div>
                <div class="tab-pane fade" id="pills-lab" role="tabpanel" aria-labelledby="pills-lab-tab">
                    <form id = "labform" action="/sign-in-lab">
                        <div class="form-floating">
                            <input name="email" type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                            <label for="floatingInput">Email</label>
                        </div>
                        <div class="form-floating">
                            <input name="password" type="password" class="form-control" id="floatingPassword" placeholder="Ваш пароль">
                            <label for="floatingPassword">Пароль</label>
                        </div>
                        <a href="#" class="btn btn-sm animated-button victoria-one" onclick="document.getElementById('labform').submit()">Войти</a>
                        <noscript>
                            <input type="submit" value="Войти" />
                        </noscript>
                        <p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>
                    </form>
                </div>
            </div>
        </div>
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
<footer class="footer mt-auto py-3 bg-light">
    <div class="container">
        <div class="col-md-4 d-flex align-items-center">
            <a href="/" class="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1">
                <svg class="bi" width="30" height="24"><use xlink:href="#bootstrap"></use></svg>
            </a>
            <span class="text-muted">© 2021 Company, Inc</span>
        </div>

        <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
            <li class="ms-3"><a class="text-muted" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#twitter"></use></svg></a></li>
            <li class="ms-3"><a class="text-muted" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#instagram"></use></svg></a></li>
            <li class="ms-3"><a class="text-muted" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#facebook"></use></svg></a></li>
        </ul>
    </div>
</footer>
</body>
</html>
