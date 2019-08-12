import Vue from 'vue'
import './components'
import './plugins'
import App from './App'
import router from '@/router'


Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
