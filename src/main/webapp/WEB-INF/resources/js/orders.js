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
                data: "datePickup", render: function (data, type, row) {
                    return moment(data, 'YYYY,MM,DD,hh,mm,ss').format('MM/DD/YYYY hh:mm:ss');
                },
            },

            {
                title: "Date delivery",
                data: "dateDelivery", render: function (data, type, row) {
                    return moment(data, 'YYYY,MM,DD,hh,mm,ss').format('MM/DD/YYYY hh:mm:ss');
                }
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
                title: "Shipper name",
                data: "shipper.id", render: function (data, type, row) {
                    return "<a href='/prolog/mvc/users/" + data + "'>" + row.shipper.firstName + " " + row.shipper.lastName + "</a>";
                },
            }
        ]
    });
});