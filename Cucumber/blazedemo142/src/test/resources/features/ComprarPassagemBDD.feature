# language: pt
Funcionalidade: Comprar Passagem
    Escolher e comprar passagens aereas

  Cenario: Comprar com Sucesso
    Dado que acesso o site: "https://www.blazedemo.com/"
    Quando seleciono a origem "São Paolo" e o destino "Cairo"
    E clico no botão Find Flights
    Entao visualiza a lista de voos
