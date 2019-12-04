import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import '@/commons/theme'
import '@/globals/http/axios'
import '@/globals/vendors'
import store from '@/commons/store'

Vue.config.productionTip = false

new Vue({
    store,
    vuetify,
    render: h => h(App)
}).$mount('#app')
