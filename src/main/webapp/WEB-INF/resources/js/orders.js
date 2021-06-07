$(document).ready(function () {
    $('#orderList').DataTable({
        data: orders,

        columns: [
            {
                title: "Id",
                data: "id"
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