$(document).ready(function () {
    $('#orderList').DataTable({
        data: orders,

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
            }
        ]
    });
});