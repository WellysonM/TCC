import Vue from 'vue'
import '@/globals/plugins'
import App from './App.vue'
import router from '@/globals/router'

Vue.config.productionTip = false

new Vue({
    router,
    render: h => h(App),
}).$mount('#app')
