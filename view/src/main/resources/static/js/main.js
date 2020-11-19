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
            text: '',
            id: ''
        }
    },
    watch: {
        loadAttr: function (newVal, oldVal) {
            this.text = newVal.text;
            this.id = newVal.id;
        }
    },
    template:
        '<div>' +
        '<input type="text" placeholder="Write something" v-model="text" />' +
        '<input type="button" value="Save" @click="save" />' +
        '</div>',
    methods: {
        save: function () {
            var load = {text: this.text};

            if (this.id) {
                loadApi.update({id: this.id}, load).then(result =>
                    result.json().then(data => {
                        var index = getIndex(this.loads, data.id);
                        this.loads.splice(index, 1, data);
                        this.text = ''
                        this.id = ''
                    })
                )
            } else {
                loadApi.save({}, load).then(result =>
                    result.json().then(data => {
                        this.loads.push(data);
                        this.text = ''
                    })
                )
            }
        }
    }
});

Vue.component('load-row', {
    props: ['load', 'editMethod', 'loads'],
    template: '<div>' +
        '<i>({{ load.id }})</i> {{ load.text }}' +
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
        '<div style="position: relative; width: 300px;">' +
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