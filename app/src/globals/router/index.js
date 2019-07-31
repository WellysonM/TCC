import Vue from 'vue'
import Router from 'vue-router'
import singIn from '../../commons/components/PaginaInicial/SignIn'
import Menu from '../../commons/components/Alert/Alert'
import Cadastro from '../../commons/components/PaginaInicial/Cadastrar'

Vue.use(Router)

const index = new Router({
    routes: [
        {
            path: '/',
            name: 'SignIn',
            component: singIn
        },
        {
            path: '/menu',
            name: 'paginaInicial',
            component: Menu
        },
        {
            path: '/cadastrar',
            name: 'cadastrar',
            component: Cadastro
        }
    ]
})
export default index