<header class="p-3 bg-dark text-white">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <img class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"
                     src="/resources/white-flask.svg"/>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="/" class="nav-link px-2 text-secondary">Главная</a></li>
                <li><a href="/labs" class="nav-link px-2 text-white">Заказать</a></li>
            </ul>

            <div id="signBtns" class="text-end">
                <#if user??>
                    <div class="dropdown">
                        <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
                           id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                            <#if user.avatarId??>
                                <img src="/files/${user.avatarId}" alt="" class="rounded-circle me-2" width="32"
                                     height="32">
                            <#else>
                                <img src="/no-avatar.png" alt="" class="rounded-circle me-2" width="32" height="32">
                            </#if>
                            <strong>${user.firstName}</strong>
                        </a>

                        <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                            <li><a class="dropdown-item" href="#">Настройки</a></li>
                            <li><a class="dropdown-item" href="/profile">Профиль</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="/sign-out">Выйти</a></li>
                        </ul>

                        <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                            <li><a class="dropdown-item" href="#">Settings</a></li>
                            <li><a class="dropdown-item" href="/profile">Profile</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="/sign-out">Sign out</a></li>
                        </ul>
                    </div>

                <#elseif lab??>
                    <div class="dropdown">
                        <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
                           id="dropdownUser2" data-bs-toggle="dropdown" aria-expanded="false">
                            <#if lab.avatarId??>
                                <img src="/files/${lab.avatarId}" alt="" class="rounded-circle me-2" width="32"
                                     height="32">
                            <#else>
                                <img src="/no-avatar.png" alt="" class="rounded-circle me-2" width="32" height="32">
                            </#if>
                            <strong>${lab.name}</strong>
                        </a>

                        <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser2">
                            <li><a class="dropdown-item" href="#">Настройки лабы</a></li>
                            <li><a class="dropdown-item" href="/profile">Профиль</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="/sign-out">Выйти</a></li>
                        </ul>
                    </div>
                <#else>
                    <button type="button" class="btn btn-outline-light me-2" onclick="location.href = '/sign-in'">
                        Войти
                    </button>
                    <button type="button" class="btn btn-warning" onclick="location.href = '/sign-up'">Регистрация
                    </button>
                </#if>
            </div>
        </div>
    </div>
</header>