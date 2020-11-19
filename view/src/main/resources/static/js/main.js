function getIndex(list, id) {
    for (var i = 0; i < list.length; i++) {
        if (list[i].id === id) {
            return i;
        }
    }

    return -1;
}

var loadApi = Vue.resource('/load{/id}');

Vue.component('load-form', {
    props: ['loads', 'loadAttr'],
    data: function () {
        return {
            id: '',
            cityTo: '',
            cityFrom: '',
            dateTo: '',
            dateFrom: '',
            dateCheckIn: '',
            dateCheckOut: '',
            weight: '',
            price: ''
        }
    },
    watch: {
        loadAttr: function (newVal, oldVal) {
            this.id = newVal.id;
            this.cityTo = newVal.cityTo;
            this.cityFrom = newVal.cityFrom;
            this.dateTo = newVal.dateTo;
            this.dateFrom = newVal.dateFrom;
            this.dateCheckIn = newVal.dateCheckIn;
            this.dateCheckOut = newVal.dateCheckOut;
            this.weight = newVal.weight;
            this.price = newVal.price;
        }
    },
    template:
        '<div>' +
        '<input type="text" placeholder="City to" v-model="text" />' +
        '<input type="text" placeholder="City from" v-model="text" />' +
        '<input type="date" placeholder="Date to" v-model="date" />' +
        '<input type="date" placeholder="Date from" v-model="date" />' +
        '<input type="date" placeholder="Date checkin" v-model="date" />' +
        '<input type="date" placeholder="Date checkout" v-model="date" />' +
        '<input type="number" placeholder="Weight" v-model="number" />' +
        '<input type="number" placeholder="Price" v-model="number" />' +
        '<input type="button" value="Save" @click="save" />' +
        '</div>',
    methods: {
        save: function () {
            var load = {
                cityTo: this.cityTo,
                cityFrom: this.cityFrom,
                dateTO: this.dateTO,
                dateFrom: this.dateFrom,
                dateCheckIn: this.dateCheckIn,
                dateCheckOut: this.dateCheckOut,
                weight: this.weight,
                price: this.price
            };

            if (this.id) {
                loadApi.update({id: this.id}, load).then(result =>
                    result.json().then(data => {
                        var index = getIndex(this.loads, data.id);
                        this.loads.splice(index, 1, data);
                        this.id = ''
                        this.cityTo = ''
                        this.cityFrom = ''
                        this.dateTo = ''
                        this.dateFrom = ''
                        this.dateCheckIn = ''
                        this.dateCheckOut = ''
                        this.weight = ''
                        this.price = ''
                    })
                )
            } else {
                loadApi.save({}, load).then(result =>
                    result.json().then(data => {
                        this.loads.push(data);
                    })
                )
            }
        }
    }
});

Vue.component('load-row', {
    props: ['load', 'editMethod', 'loads'],
    template: '<div>' +
        '<i>({{ load.id }})</i> {{ load.cityTo }}, {{load.cityFrom}}' +
        '{{load.dateTo}}, {{load.dateFrom}}' +
        '{{load.dateCheckIn}}, {{load.dateCheckOut}}' +
        '{{load.weight}}, {{load.price}}' +
        '{{load.customerDTO}}, {{load.driverDTO}}' +
        '<span style="position: absolute; right: 0">' +
        '<input type="button" value="Edit" @click="edit" />' +
        '<input type="button" value="X" @click="del" />' +
        '</span>' +
        '</div>',
    methods: {
        edit: function () {
            this.editMethod(this.load);
        },
        del: function () {
            loadApi.remove({id: this.load.id}).then(result => {
                if (result.ok) {
                    this.loads.splice(this.loads.indexOf(this.load), 1)
                }
            })
        }
    }
});

Vue.component('loads-list', {
    props: ['loads'],
    data: function () {
        return {
            load: null
        }
    },
    template:
        '<div style="position: relative; width: 800px;">' +
        '<load-form :loads="loads" :loadAttr="load" />' +
        '<load-row v-for="load in loads" :key="load.id" :load="load" ' +
        ':editMethod="editMethod" :loads="loads" />' +
        '</div>',
    created: function () {
        loadApi.get().then(result =>
            result.json().then(data =>
                data.forEach(load => this.loads.push(load))
            )
        )
    },
    methods: {
        editMethod: function (load) {
            this.load = load;
        }
    }
});

var app = new Vue({
    el: '#app',
    template: '<loads-list :loads="loads" />',
    data: {
        loads: []
    }
});