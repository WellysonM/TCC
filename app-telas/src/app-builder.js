import Vue from 'vue'
import router from '@/globals/router'
import store from '@/commons/store'
import App from './App'
import {sync} from 'vuex-router-sync'
import '@/globals/vendors'
import '@/commons/layout'

sync(store, router)
class AppBuilder {

    async build() {
        this.instanciarComponenteRaiz()
    }

    instanciarComponenteRaiz() {
        new Vue({
            router,
            store,
            render: h => h(App)
        }).$mount('#app')
    }
}

export default new AppBuilder()
