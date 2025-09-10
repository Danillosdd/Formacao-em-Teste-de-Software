# language: pt
Funcionalidade: Comprar Produto

  Esquema do Cenario: Compra com Sucesso
    Dado que estou na tela de produtos
    Quando eu selecionar o produto "Sauce Labs Backpack"
    Entao o produto "Sauce Labs Backpack" deve ser exibido com o preco "$ 29.99"
    E o botao "ADD TO CART" deve estar visivel
    