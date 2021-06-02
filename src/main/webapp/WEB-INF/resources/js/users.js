$(document).ready(function () {
    let table = $('#userList').DataTable({
        paging: false,
        bAutoWidth: false,
        data: users,

        columnDefs: [{
            defaultContent: "<input class='form-control'>",
            orderable: false,
            targets: "_all"
        }],

        columns: [
            {
                title: "Id",
                data: "id",
                render: function (data, type, row, meta) {
                    return "<input name='" + 'userViewDTOS[' + meta.row + '].id' + "' class='form-control' readonly value='" + data + "'>";
                }
            },

            {
                title: "First name",
                data: "firstName",
                render: function (data, type, row, meta) {
                    return "<input name='" + 'userViewDTOS[' + meta.row + '].firstName' + "' class='form-control' value='" + data + "'>";
                }
            },

            {
                title: "Last name",
                data: "lastName", render: function (data, type, row, meta) {
                    return "<input name='" + 'userViewDTOS[' + meta.row + '].lastName' + "' class='form-control' value='" + data + "'>";
                }
            },

            {
                title: "Email",
                data: "email", render: function (data, type, row, meta) {
                    return "<input name='" + 'userViewDTOS[' + meta.row + '].email' + "' class='form-control' value='" + data + "'>";
                }
            },

            {
                title: "Phone number",
                data: "phoneNumber", render: function (data, type, row, meta) {
                    return "<input name='" + 'userViewDTOS[' + meta.row + '].phoneNumber' + "' class='form-control' value='" + data + "'>";
                }
            },

            {
                title: "Password",
                data: "password", render: function (data, type, row, meta) {
                    return "<input name='" + 'userViewDTOS[' + meta.row + '].password' + "' class='form-control' value='" + data + "'>";
                }
            },

            {
                title: "Function",
                defaultContent: "<button class='btn btn-danger'>Delete</button>"
            }
        ]
    });


    $('#addRow').on('click', function () {
        table
            .row
            .add([])
            .draw();
    });

    $('#userList tbody').on('click', 'button', function () {
        table
            .row($(this).parents('tr'))
            .remove()
            .draw();
    });
});
