<html lang="en"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Оформление заказа</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/resources/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="/resources/jquery-3.6.0.min.js"></script>


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
    <link href="/resources/css/form-validation.css" rel="stylesheet">
    <script src="/resources/js/loader.js"></script>
    <link href="/resources/css/loader.css" rel="stylesheet">


</head>
<body class="bg-light">

<div class="container">
    <main>
        <#include "loader.ftl">
        <div class="py-5 text-center">
            <img class="d-block mx-auto mb-4" src="/resources/black_flask.svg" alt="" width="72" height="57">
            <h2>Оформление заказа</h2>
            <p>Вы собираетесь заказать ${service.name} у ${lab.name}</p>
        </div>

        <div class="row g-5">
            <div class="col-md-5 col-lg-4 order-md-last">
                <h4 class="d-flex justify-content-between align-items-center mb-3">
                    <span class="text-primary">Корзина</span>
                    <span class="badge bg-primary rounded-pill">4</span>
                </h4>
                <ul class="list-group mb-3">
                    <li class="list-group-item d-flex justify-content-between lh-sm">
                        <div>
                            <h6 class="my-0">Корзина не работает</h6>
                            <small class="text-muted">Красивое описание товара</small>
                        </div>
                        <span class="text-muted">$12</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between lh-sm">
                        <div>
                            <h6 class="my-0">Но будь мне не лень</h6>
                            <small class="text-muted">Красивое описание товара</small>
                        </div>
                        <span class="text-muted">$8</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between lh-sm">
                        <div>
                            <h6 class="my-0">Я бы все сделал!!</h6>
                            <small class="text-muted">Красивое описание товара</small>
                        </div>
                        <span class="text-muted">$5</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between bg-light">
                        <div class="text-success">
                            <h6 class="my-0">Даже промокоды бы мог!</h6>
                            <small>EXAMPLECODE</small>
                        </div>
                        <span class="text-success">−$5</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between lh-sm">
                        <div>
                            <h6 class="my-0">${service.name}</h6>
                        </div>
                        <span class="text-muted">${service.price} руб</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between">
                        <span>Сумма</span>
                        <strong>${service.price} руб</strong>
                    </li>
                </ul>

                <form class="card p-2">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Промокод">
                        <button type="submit" class="btn btn-secondary">Активировать</button>
                    </div>
                </form>
            </div>
            <div class="col-md-7 col-lg-8">
                <h4 class="mb-3">Данные заказа</h4>
                <p>Описание заказа: ${service.description}</p>
                <form class="needs-validation" novalidate="" method="post">
                        <div class="col-12">
                            <label for="address" class="form-label">Адрес заказа</label>
                            <input name ="address" type="text" class="form-control" id="address" placeholder="ул. Пушкина, д. Колотушкина" required="">
                            <div class="invalid-feedback">
                                Please enter your shipping address.
                            </div>
                        </div>
                    <small class="text-muted">Наш курьер приедет к вам, чтобы забрать материалы для анализа.</small>

                    <hr class="my-4">

                    <h4 class="mb-3">Оплата</h4>

                    <div class="my-3">
                        <div class="form-check">
                            <input id="credit" name="paymentMethod" type="radio" class="form-check-input" checked="" required="">
                            <label class="form-check-label" for="credit">Кредитная карта</label>
                        </div>
                        <div class="form-check">
                            <input id="debit" name="paymentMethod" type="radio" class="form-check-input" required="">
                            <label class="form-check-label" for="debit">Дебетовая карта</label>
                        </div>
                    </div>

                    <div class="row gy-3">
                        <div class="col-md-6">
                            <label for="cc-name" class="form-label">Имя</label>
                            <input type="text" class="form-control" id="cc-name" placeholder="" required="">
                            <small class="text-muted">Полное имя как на карте</small>
                            <div class="invalid-feedback">
                                Необходимо указать имя владельца карты
                            </div>
                        </div>

                        <div class="col-md-6">
                            <label for="cc-number" class="form-label">Номер карты</label>
                            <input type="text" class="form-control" id="cc-number" placeholder="" required="">
                            <div class="invalid-feedback">
                                Необходимо указать номер карты
                            </div>
                        </div>

                        <div class="col-md-3">
                            <label for="cc-expiration" class="form-label">Expiration</label>
                            <input type="text" class="form-control" id="cc-expiration" placeholder="" required="">
                            <div class="invalid-feedback">
                                Expiration date required
                            </div>
                        </div>

                        <div class="col-md-3">
                            <label for="cc-cvv" class="form-label">CVV-код</label>
                            <input type="text" class="form-control" id="cc-cvv" placeholder="" required="">
                            <div class="invalid-feedback">
                                Необходимо указать защитный код
                            </div>
                        </div>
                    </div>

                    <hr class="my-4">

                    <button class="w-100 btn btn-primary btn-lg" type="submit">Продолжить</button>
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


<script src="/resources/bootstrap/js/bootstrap.bundle.min.js"></script>

<script src="/resources/js/form-validation.js"></script>


</body></html>