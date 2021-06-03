$(document).ready(function () {
    let table = $('#userList').DataTable({
        paging: false,
        bAutoWidth: false,
        data: users,

        columnDefs: [{
            orderable: false,
            targets: "_all"
        }],

        columns: [
            {
                title: "Id",
                data: "id",
                render: function (data, type, row, meta) {
                    if (data === undefined) {
                        data = '';
                    }
                    return "<input name='" + 'userViewDtos[' + meta.row + '].id' + "' class='form-control' value='" + data + "' readonly>";
                }
            },

            {
                title: "First name",
                data: "firstName",
                render: function (data, type, row, meta) {
                    if (data === undefined) {
                        data = '';
                    }
                    return "<input name='" + 'userViewDtos[' + meta.row + '].firstName' + "' class='form-control' value='" + data + "'>";
                }
            },

            {
                title: "Last name",
                data: "lastName", render: function (data, type, row, meta) {
                    if (data === undefined) {
                        data = '';
                    }
                    return "<input name='" + 'userViewDtos[' + meta.row + '].lastName' + "' class='form-control' value='" + data + "'>";
                }
            },

            {
                title: "Email",
                data: "email", render: function (data, type, row, meta) {
                    if (data === undefined) {
                        data = '';
                    }
                    return "<input name='" + 'userViewDtos[' + meta.row + '].email' + "' class='form-control' value='" + data + "'>";
                }
            },

            {
                title: "Phone number",
                data: "phoneNumber", render: function (data, type, row, meta) {
                    if (data === undefined) {
                        data = '';
                    }
                    return "<input name='" + 'userViewDtos[' + meta.row + '].phoneNumber' + "' class='form-control' value='" + data + "'>";
                }
            },

            {
                title: "Password",
                data: "password", render: function (data, type, row, meta) {
                    if (data === undefined) {
                        data = '';
                    }
                    return "<input name='" + 'userViewDtos[' + meta.row + '].password' + "' class='form-control' value='" + data + "'>";
                }
            },

            {
                title: "Status",
                data: "Status", render: function (data, type, row, meta) {
                    if (data === undefined) {
                        data = '';
                    }
                    return "<input name='" + 'userViewDtos[' + meta.row + '].Status' + "' class='form-control' value='" + data + "'>";
                }
            },

            {
                title: "Function",
                defaultContent: "<button class='btn btn-danger deleteBtn' type='button'>Delete</button>"
            }
        ]
    });


    $('#addRow').on('click', function () {
        table
            .row
            .add([])
            .draw();
    });

    $('#userList tbody').on('click', 'deleteBtn', function () {
        table
            .row($(this).parents('tr'))
            .remove()
            .draw();
    });
});
