<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${lab.name}</title>

    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/resources/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="/resources/bootstrap/js/sidebars.js"></script>
    <link href="/resources/bootstrap/css/list-groups.css" rel="stylesheet">
    <link href="/resources/css/modals.css" rel="stylesheet">
    <link href="/resources/css/profile.css" rel="stylesheet">
    <script src="/resources/jquery-3.6.0.min.js"></script>
    <script src="/resources/js/loader.js"></script>
    <link href="/resources/css/loader.css" rel="stylesheet">

</head>
<body>
<#include "header.ftl">
<main>
    <div class="tab-content" style="margin-top: 1%">
        <div class="tab-pane active" id="home" role="tabpanel" aria-labelledby="home-tab">
            <div class="container emp-profile">
                <form action="/update-avatar" method="post" enctype="multipart/form-data">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="profile-img">
                                <#if lab.avatarId??>
                                    <img src="/files/${lab.avatarId}" alt="" width="32" height="32">
                                <#else>
                                    <img src="/no-avatar.png" alt="" width="32" height="32">
                                </#if>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="profile-head">
                                <h3 class="text-center">
                                    ${lab.name}
                                </h3>
                                <h5>${lab.email}</h5>
                                <h5>${lab.phone}</h5>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="container emp-profile">
                <div class="container">

                    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3" id="service-list">
                        <#list services as service>
                            <div class="col">
                                <div class="card shadow-sm">
                                    <div class="card-body">
                                        <div class="card-header text-center">
                                            <strong>${service.name}</strong>
                                        </div>
                                        <p class="card-text">${service.description}</p>
                                        <div class="d-flex justify-content-between align-items-center">
                                            <div class="btn-group">
                                                <a href="/order?serviceId=${service.id}" type="button" class="btn btn-secondary">Заказать</a>
                                            </div>
                                            <small class="text-muted">${service.price} руб</small>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </#list>
                    </div>
                </div>

            </div>

        </div>
    </div>
    <#include "loader.ftl">
</main>

</body>