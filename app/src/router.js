import Vue from 'vue'
import VueRouter from 'vue-router'
import singIn from './commons/components/SignIn'
import Menu from './views/Menu'

Vue.use(VueRouter)

export default new VueRouter({
    routes: [
        {path: '/autenticacao', component: singIn},
        {path: '/menu', component: Menu}
    ]
})