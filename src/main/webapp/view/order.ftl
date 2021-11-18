<html lang="en"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Заказ №${order.id}</title>



    <!-- Bootstrap core CSS -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/resources/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="/resources/jquery-3.6.0.min.js"></script>
    <link href="/resources/css/order.css" rel="stylesheet">



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



</head>
<body class="bg-light">

<div class="container">
    <main>
        <div class="py-5 text-center">
            <img class="d-block mx-auto mb-4" src="/resources/black_flask.svg" alt="" width="72" height="57">
            <h2>Заказ ${order.id}</h2>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                    ${order.status}
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                    <#list statuses as status>
                        <li><a class="dropdown-item" href="/order?orderId=${order.id}&statusId=${status.id}">${status.name}</a></li>
                    </#list>
                </ul>
            </div>
            <p>Стоймость: ${order.cost} руб</p>
        </div>


        <div class="row g-5 text-center">
            <div class="col-md-7 col-lg-8" style="margin-left: auto;margin-right: auto;">
                <h4 class="mb-3">Данные заказа</h4>
                <p>Описание заказа: ${service.description}</p>
                <form class="needs-validation" novalidate="" method="post">
                    <div class="col-12">
                        <label for="address" class="form-label">Адрес заказа:</label>
                        <p type="text" class="disabled form-control" id="address">${order.userAddress}</p>
                    </div>
                    <hr class="my-4">

                    <a href="/profile" class="w-100 btn btn-primary btn-lg" style="margin-bottom: 2%">В профиль</a>
                    <a href="/" class="w-100 btn btn-primary btn-lg">На главную</a>
                </form>
            </div>
        </div>
    </main>
    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">© 2017–2021 Company Name</p>
        <ul class="list-inline">
            <li class="list-inline-item"><a href="#">Privacy</a></li>
            <li class="list-inline-item"><a href="#">Terms</a></li>
            <li class="list-inline-item"><a href="#">Support</a></li>
        </ul>
    </footer>
</div>
</body>
</html>