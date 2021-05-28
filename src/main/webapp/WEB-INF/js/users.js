$(document).ready(function () {
    let table = $('#userList').DataTable({
        ajax : {
            url : 'http://localhost:8080/prolog/mvc/users/',
            dataSrc : ''
        },
        columns: [
            {data: "id"},
            {data: "firstName"},
            {data: "lastName"},
            {data: "email"},
            {data: "phoneNumber"}
        ]
    });

    $('#addRow').on('click', function () {
        table.row.add().draw(false);
    });

    $('.btnDelete').on('click', function () {
        $(this).closest("tr").remove();
    });
});
