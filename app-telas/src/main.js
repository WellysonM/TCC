import Vue from 'vue'
import './components'
import './plugins'
import App from './App'
import router from '@/router'
import store from '@/store'
import { sync } from 'vuex-router-sync'

sync(store, router)
Vue.config.productionTip = false

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
