<html lang="en"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Лаборатории</title>


    <!-- Bootstrap core CSS -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/loader.css" rel="stylesheet">
    <script src="/resources/jquery-3.6.0.min.js"></script>
    <script src="/resources/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="/resources/js/loader.js"></script>

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


</head>
<body>

<#include "header.ftl">

<main>
    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <h1 class="fw-light">Лаборатории</h1>
                <p class="lead text-muted">На этой странице вы можете выбрать лабораторию, в которой хотите заказать исследование или анализ.</p>
                <p>
                    <a href="#" class="btn btn-primary my-2">Какая то синяя кнопка</a>
                    <a href="#" class="btn btn-secondary my-2">А эта чет серая</a>
                </p>
            </div>
        </div>
    </section>

    <div class="album py-5 bg-light">
        <div class="container">
            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                <#list labs as lab>
                <div class="col">
                    <div class="card shadow-sm">
                        <#if lab.avatarId??>
                            <img src="/files/${lab.avatarId}" class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><text class = "text-center" x="50%" y="50%" fill="#eceeef" dy=".3em">${lab.name}</text></img>
                        </#if>

                        <div class="card-body">
                            <p class="card-text">${lab.name}</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <a href = "/labs?labId=${lab.id}" type="button" class="btn btn-sm btn-outline-secondary">Подробнее</a>
                                </div>
                                <small class="text-muted">10 заказов</small>
                            </div>
                        </div>
                    </div>
                </div>
                </#list>
            </div>
        </div>
    </div>
   <#include "loader.ftl">

</main>


<script src="/resources/bootstrap/js/bootstrap.bundle.min.js"></script>



<#include "footer.ftl">
</body>
</html>