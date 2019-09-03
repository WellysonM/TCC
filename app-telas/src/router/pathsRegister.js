import cadastrar from '../views/SingIn/Cadastrar'
import vendas from '../views/Vendas'

export default[
    {
        path: '/',
        component: cadastrar,
        name: 'Cadastrar',
        view: 'Cadastrar'
    },
    {
        path: '/vendas',
        component: vendas,
        name: 'Vendas',
        view: 'Vendas'
    }
]
