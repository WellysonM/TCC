import cadastrar from '../views/SingIn/Cadastrar'
import modal from '../views/modal/ModalProduto'

export default[
    {
        path: '/',
        component: cadastrar,
        name: 'Cadastrar',
        view: 'Cadastrar'
    },
    {
        path: '/modalProduto',
        component: modal,
        name: 'Modal',
        view: 'ModalProduto'
    }
]
