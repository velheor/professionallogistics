$(document).ready(function () {
    let table = $('#userList').DataTable({
        ajax: {
            url: "http://localhost:8080/prolog/users/",
            type: "GET"
        },
        columns: [
            {
                title: "Id",
                data: "id"
            },
            {
                title: "First name",
                data: "firstName"
            },

            {
                title: "Last name",
                data: "lastName"
            },

            {
                title: "Email",
                data: "email"
            },

            {
                title: "Phone number",
                data: "phoneNumber"
            }
        ]
    });

    $('#addRow').on('click', function () {
        table.row.add().draw(false);
    });

    $('.btnDelete').on('click', function () {
        $(this).closest("tr").remove();
    });
});
