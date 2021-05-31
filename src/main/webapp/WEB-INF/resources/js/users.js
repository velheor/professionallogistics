$(document).ready(function () {
    let table = $('#userList').DataTable({

        bAutoWidth: false,
        ajax: {
            url: "http://localhost:8080/prolog/users/",
            dataSrc: ''
        },

        columnDefs: [{
            defaultContent: "<input class='form-control'>",
            targets: '_all',
        }],

        columns: [
            {
                title: "Id",
                data: "id",
            },

            {
                title: "First name",
                data: "firstName", render: function (dataField) {
                    return "<input class='form-control' value='" + dataField + "'>";
                }
            },

            {
                title: "Last name",
                data: "lastName", render: function (dataField) {
                    return "<input class='form-control' value='" + dataField + "'>";
                }
            },

            {
                title: "Email",
                data: "email", render: function (dataField) {
                    return "<input class='form-control' value='" + dataField + "'>";
                }
            },

            {
                title: "Phone number",
                data: "phoneNumber", render: function (dataField) {
                    return "<input class='form-control' value='" + dataField + "'>";
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

    $('#submit').click(function () {
        let data1 = table.$('input', 'select').serialize();
        let data = table
            .rows()
            .data()
            .toArray();
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/prolog/users/saveAll",
            data: JSON.stringify(data),
            dataType: 'json',
        });
    });
});
