function editBtnClickHandler(event) {
    event.preventDefault();
    let btnId = event.target.id;
    let textId = btnId+"SID";
    let serviceId = $("#"+textId).val();

    $.ajax("/edit-service", {
        method: "GET",
        data: "serviceId=" + serviceId,
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        success: function (data) {
            let service = JSON.parse(data)
            let serviceName = $("#serviceName");
            let serviceDescr = $("#serviceDescription");
            let servicePrice = $("#servicePrice");
            let serviceIdInput = $("#editOrder_id");
            serviceName.val(service.name);
            serviceDescr.val(service.description);
            servicePrice.val(service.price);
            serviceIdInput.val(service.id);
        }
    })
    return false
}

$(document).ready(function () {
    let formEdit = $("#editOrder")
    let formAdd = $("#addOrder")
    let serviceList = $("#service-list")
    console.log(formAdd)
    formEdit.on('submit', function () {
        let serviceId = $("#editOrder_id").val();
        let card = $("#"+serviceId)
        let serviceName = formEdit.find("#serviceName").val();
        let serviceDescr = formEdit.find("#serviceDescription").val();
        let servicePrice = formEdit.find("#servicePrice").val();
        $.ajax("/edit-service", {
            method: "POST",
            data: "id=" + serviceId + "&name=" + serviceName + "&description=" + serviceDescr + "&price=" + servicePrice,
            headers: {
                'Encoding-Type': 'UTF-8',
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            success: function (data) {
                let serviceDto = JSON.parse(data)
                let string = $("<div class=\"col\">\n")
                string.append("                                <textarea id=\"editBtn"+ serviceDto.id + "SID\" required=\"\" name=\"serviceId\" style=\"display: none\">"+ serviceDto.id + "</textarea>\n" +
                    "                                <div class=\"card shadow-sm\">\n" +
                    "                                    <div class=\"card-body\">\n" +
                    "                                        <div class=\"card-header text-center\">\n" +
                    "                                            <strong>"+ serviceDto.name +"</strong>\n" +
                    "                                        </div>\n" +
                    "                                        <p class=\"card-text\">" + serviceDto.description + "</p>\n" +
                    "                                        <div class=\"d-flex justify-content-between align-items-center\">\n" +
                    "                                            <div class=\"btn-group\">\n" +
                    "                                                <button id=\"editBtn" + serviceDto.id + "\" type=\"button\" class=\"btn btn-secondary\" data-bs-toggle=\"modal\" data-bs-target=\"#exampleModalDefault\" onclick=\"editBtnClickHandler(event)\">Редактировать</button>\n" +
                    "                                            </div>\n" +
                    "                                            <small class=\"text-muted\">" + serviceDto.price + " руб </small>\n" +
                    "                                        </div>\n" +
                    "                                    </div>\n" +
                    "                                </div>\n" +
                    "                            </div>")
                string.hide()
                card.hide()
                serviceList.prepend(string)
                string.show(300)
            }
        })
        return false
    })
    formAdd.on('submit', function () {
        let serviceName = formAdd.find("#addName").val();
        let serviceDescr = formAdd.find("#addDescr").val();
        let servicePrice = formAdd.find("#addPrice").val();
        $.ajax("/edit-service", {
            method: "POST",
            data:"name=" + serviceName + "&description=" + serviceDescr + "&price=" + servicePrice,
            headers: {
                'Encoding-Type': 'UTF-8',
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            success: function (data) {
                let serviceDto = JSON.parse(data)
                let string = $("<div class=\"col\">\n")
                string.append("                                <textarea id=\"editBtn"+ serviceDto.id + "SID\" required=\"\" name=\"serviceId\" style=\"display: none\">"+ serviceDto.id + "</textarea>\n" +
                    "                                <div class=\"card shadow-sm\">\n" +
                    "                                    <div class=\"card-body\">\n" +
                    "                                        <div class=\"card-header text-center\">\n" +
                    "                                            <strong>"+ serviceDto.name +"</strong>\n" +
                    "                                        </div>\n" +
                    "                                        <p class=\"card-text\">" + serviceDto.description + "</p>\n" +
                    "                                        <div class=\"d-flex justify-content-between align-items-center\">\n" +
                    "                                            <div class=\"btn-group\">\n" +
                    "                                                <button id=\"editBtn" + serviceDto.id + "\" type=\"button\" class=\"btn btn-secondary\" data-bs-toggle=\"modal\" data-bs-target=\"#exampleModalDefault\" onclick=\"editBtnClickHandler(event)\">Редактировать</button>\n" +
                    "                                            </div>\n" +
                    "                                            <small class=\"text-muted\">" + serviceDto.price + " руб" +"</small>\n" +
                    "                                        </div>\n" +
                    "                                    </div>\n" +
                    "                                </div>\n" +
                    "                            </div>")
                string.hide()
                serviceList.prepend(string)
                string.show(300)
            }
        })
        return false
    })
})