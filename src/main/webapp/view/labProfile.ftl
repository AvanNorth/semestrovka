<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${lab.name}</title>

    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/resources/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="/resources/jquery-3.6.0.min.js"></script>
    <script src="/resources/bootstrap/js/sidebars.js"></script>
    <link href="/resources/bootstrap/css/list-groups.css" rel="stylesheet">
    <link href="/resources/css/modals.css" rel="stylesheet">
    <link href="/resources/css/profile.css" rel="stylesheet">
    <script src="/resources/js/services.js" charset="utf-8"></script>
    <script src="/resources/js/loader.js"></script>
    <link href="/resources/css/loader.css" rel="stylesheet">


</head>
<body>
<main>
    <div class="modal fade" id="exampleModalDefault" tabindex="-1" aria-labelledby="exampleModalLabel"
         style="display: none;" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Редактирование</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                        <form id="editOrder">
                            <div class="form-floating mb-3">
                                <input name = "name" type="text" class="form-control rounded-4" id="serviceName"
                                       placeholder="Название">
                                <label for="serviceName">Название</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input name ="description" type="text" class="form-control rounded-4" id="serviceDescription"
                                       placeholder="Описание">
                                <label for="serviceDescription">Описание</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input name ="price" type="number" class="form-control rounded-4" id="servicePrice"
                                       placeholder="Цена">
                                <label for="servicePrice">Цена</label>
                            </div>
                            <input id = "editOrder_id" name="id" type="hidden">
                            <input type="submit" class="btn btn-secondary" data-bs-dismiss="modal">
                        </form>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="addServiceModal" tabindex="-1" aria-labelledby="exampleModalLabel"
         style="display: none;" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Редактирование</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id="addOrder">
                        <div class="form-floating mb-3">
                            <input name="name" type="text" class="form-control rounded-4" id="addName"
                                   placeholder="Название">
                            <label for="addName">Название</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input name="description" type="text" class="form-control rounded-4" id="addDescr"
                                   placeholder="Описание">
                            <label for="addDescr">Описание</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input name="price" type="number" class="form-control rounded-4" id="addPrice"
                                   placeholder="Цена">
                            <label for="addPrice">Цена</label>
                        </div>
                        <input type="submit" class="btn btn-secondary" data-bs-dismiss="modal">
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px;">
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
            <img class="bi me-2" width="40" height="32" src="/resources/white-flask.svg"/>
            <span class="fs-4">Профиль</span>
        </a>
        <hr>
        <ul class="nav nav-pills flex-column mb-auto">
            <li class="nav-item">
                <a class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button"
                   role="tab" aria-controls="home" aria-selected="true">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                         class="bi bi-house" viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
                              d="M2 13.5V7h1v6.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V7h1v6.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5zm11-11V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
                        <path fill-rule="evenodd"
                              d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
                    </svg>
                    Home
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="order-tab" data-bs-toggle="tab" data-bs-target="#order" type="button" role="tab"
                   aria-controls="order" aria-selected="true">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                         class="bi bi-receipt-cutoff" viewBox="0 0 16 16">
                        <path d="M3 4.5a.5.5 0 0 1 .5-.5h6a.5.5 0 1 1 0 1h-6a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 1 1 0 1h-6a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 1 1 0 1h-6a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5zM11.5 4a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1h-1zm0 2a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1h-1zm0 2a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1h-1zm0 2a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1h-1zm0 2a.5.5 0 0 0 0 1h1a.5.5 0 0 0 0-1h-1z"/>
                        <path d="M2.354.646a.5.5 0 0 0-.801.13l-.5 1A.5.5 0 0 0 1 2v13H.5a.5.5 0 0 0 0 1h15a.5.5 0 0 0 0-1H15V2a.5.5 0 0 0-.053-.224l-.5-1a.5.5 0 0 0-.8-.13L13 1.293l-.646-.647a.5.5 0 0 0-.708 0L11 1.293l-.646-.647a.5.5 0 0 0-.708 0L9 1.293 8.354.646a.5.5 0 0 0-.708 0L7 1.293 6.354.646a.5.5 0 0 0-.708 0L5 1.293 4.354.646a.5.5 0 0 0-.708 0L3 1.293 2.354.646zm-.217 1.198.51.51a.5.5 0 0 0 .707 0L4 1.707l.646.647a.5.5 0 0 0 .708 0L6 1.707l.646.647a.5.5 0 0 0 .708 0L8 1.707l.646.647a.5.5 0 0 0 .708 0L10 1.707l.646.647a.5.5 0 0 0 .708 0L12 1.707l.646.647a.5.5 0 0 0 .708 0l.509-.51.137.274V15H2V2.118l.137-.274z"/>
                    </svg>
                    Orders
                </a>
            </li>
        </ul>
        <hr>
        <div class="dropdown">
            <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
               id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                <#if lab.avatarId??>
                    <img src="/files/${lab.avatarId}" alt="" class="rounded-circle me-2" width="32" height="32">
                <#else>
                    <img src="/no-avatar.png" alt="" class="rounded-circle me-2" width="32" height="32">
                </#if>
                <strong>${lab.name}</strong>
            </a>

            <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                <li><a class="dropdown-item" href="/sign-out">Sign out</a></li>
            </ul>
        </div>
    </div>
    <div class="tab-content">
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
                                <div class="file btn btn-lg btn-primary">
                                    Выбрать аватар..
                                    <input type="file" name="file" style="width: -moz-available;"/>
                                </div>
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
                            <input type="submit" class="profile-edit-btn" name="btnAddMore" value="Edit Profile"/>
                            <button type="button" class="btn btn-secondary" data-bs-toggle="modal"
                                    data-bs-target="#addServiceModal">
                                Добавить
                            </button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="container emp-profile">
                <div class="container">

                    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3" id="service-list">
                        <#list services as service>
                            <div class="col" id = "${service.id}" >
                                <textarea id="editBtn${service.id}SID" required name="serviceId" style="display: none">${service.id}</textarea>
                                <div class="card shadow-sm">
                                    <div class="card-body">
                                        <div class="card-header text-center">
                                            <strong>${service.name}</strong>
                                        </div>
                                        <p class="card-text">${service.description}</p>
                                        <div class="d-flex justify-content-between align-items-center">
                                            <div class="btn-group">
                                                <button id = "editBtn${service.id}" type="button" class="btn btn-secondary" data-bs-toggle="modal"
                                                        data-bs-target="#exampleModalDefault"  onclick="editBtnClickHandler(event)">Редактировать</button>
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
        <div class="tab-pane" id="order" role="tabpanel" aria-labelledby="order-tab">
            <div>
                <!-- Лист заказов -->
                <div class="list-group">
                    <#list orders as order>
                        <a href="/order?orderId=${order.id}" class="list-group-item list-group-item-action d-flex gap-3 py-3"
                           aria-current="true">
                            <img src="https://github.com/twbs.png" alt="twbs" class="rounded-circle flex-shrink-0"
                                 width="32" height="32">
                            <div class="d-flex gap-2 w-100 justify-content-between">
                                <div>
                                    <h6 class="mb-0">Заказ №${order.id}
                                        <span class="badge rounded-pill bg-warning text-dark">${order.status}</span>
                                    </h6>
                                </div>
                                <small class="opacity-100 text-nowrap">${order.cost} руб</small>
                            </div>
                        </a>
                    </#list>
                </div>
            </div>
        </div>
    </div>
    <#include "loader.ftl">
</main>

</body>