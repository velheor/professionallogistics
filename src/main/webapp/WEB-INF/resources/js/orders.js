$(document).ready(function () {
    $('#orderList').DataTable({
        data: orders,

        columnDefs: [
            {
                render: function (data, type, row) {
                    return "<a href='/prolog/mvc/orders/fullInfo/" + data + "'>" + row.shipper.firstName + " " + row.shipper.lastName  + "</a>";
                },
                targets: [7],

            },

            {
                visible: false,
                targets: [5, 6]
            }
        ],
        columns: [
            {
                title: "Id",
                data: "id", render: function (data) {
                    return "<a href='/prolog/mvc/orders/fullInfo/" + data + "'>" + data + "</a>";
                }
            },

            {
                title: "Date pick up",
                data: "datePickup"

            },

            {
                title: "Date delivery",
                data: "dateDelivery"
            },

            {
                title: "Price",
                data: "price"
            },

            {
                title: "Truck category",
                data: "truckCategory"
            },

            {
                data: "shipper.firstName"
            },

            {
                data: "shipper.lastName"
            },

            {
                title: "Shipper name",
                data: "shipper.id"

            }
        ]
    });
});