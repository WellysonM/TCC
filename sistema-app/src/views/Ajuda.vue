<template>
    <v-container
            fill-height
            fluid
            grid-list-xl>
        <v-layout justify-center wrap>
            <v-flex md8 xs12>
                <section>
                    <h3>Cadastro de mesa</h3>
                    <v-divider/>
                    <v-flex md2/>
                    <p>Ao entrar pela primeira vez no sistema não haverá mesas cadastradas, será necessario clicar no
                        botão de inserir mesa e confirma a operação.</p>
                    <v-flex md2/>
                    <img src="../img/inserir mesa.gif" width="100%" height="100%"/>
                </section>
            </v-flex>
            <v-flex md8 xs12>
                <section>
                    <h3>Cadastro de produto</h3>
                    <v-divider/>
                    <v-flex md2/>
                    <p>Assim como a mesa será necessário cadastrar um novo produto para começar a vender, Os produtos
                        serão divididos em categorias para facilitar encontrar um específico.</p>
                    <v-flex md2/>
                    <img src="../img/inserir categoria.gif" width="100%" height="100%"/>
                    <img src="../img/inserir produto.gif" width="100%" height="100%"/>
                </section>
            </v-flex>
            <v-flex md8 xs12>
                <section>
                    <h3>Primeira venda</h3>
                    <v-divider/>
                    <v-flex md2/>
                    <p>Após cadastrar a categoria e o produtos em seguida, você já pode fazer sua primeira venda :)
                        <br/>
                        Você pode começar uma nova venda a partir de dois lugares do sistema, uma na tela de produtos
                        marcando quais produtos você deseja vender e a outra na própia tela de vendas, abrindo uma
                        categoria e marcando o produto. Lembrando que você pode escolher mais de um produto se houver
                        necessidade.
                    </p>
                    <v-flex md2/>
                    <img src="../img/inserir venda.gif" width="100%" height="100%"/>
                </section>
            </v-flex>
            <v-flex md8 xs12>
                <section>
                    <h3>Pagamento</h3>
                    <v-divider/>
                    <v-flex md2/>
                    <p>Agora chegamos na parte boa não é mesmo?
                        <br/>
                        Ao fazer uma venda a mesa que antes estava disponível (em verde), agora se encontra ocupada (em
                        amarelo), se você clicar nela irá abrir uma janelinha com a descrição dos produtos e dois
                        botões. Um para fechar a janelinha e o outro para pagamento, ao fazer o pagamento a mesa ficará
                        em vermelho pois o sistema entende que o cliente foi embora e precisa limpa a mesa em questão,
                        para informa ao sistema que a mesa já foi limpa é só clicar na mesa em vermelho que o mesmo
                        volta a ficar em verde.
                    </p>
                    <v-flex md2/>
                    <img src="../img/fazer pagamento.gif" width="100%" height="100%"/>
                </section>
            </v-flex>
            <v-flex md8 xs12>
                <section>
                    <h3>Relatório</h3>
                    <v-divider/>
                    <v-flex md2/>
                    <p>Existe alguns gráficos de vendas para você mas iremos falar sobre o relatório de vendas por data,
                        ele é bem simples de se utilizar basta escolher a data e clicar em gerar relatório, irá abrir
                        uma janelinha com a somatória de todas as vendas daquele dia.
                    </p>
                    <v-flex md2/>
                    <img src="../img/relatorios.gif" width="100%" height="100%"/>
                </section>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
    export default {
        name: "Ajuda"
    }
</script>

<style scoped>

</style>