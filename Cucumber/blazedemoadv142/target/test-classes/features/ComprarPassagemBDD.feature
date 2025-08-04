#Executar no Terminal:
#mvn clean test -Dsurefire.includeJUnit5Engines=cucumber -Dcucumber.features="src/test/resources/features"
# language: pt
Funcionalidade: Comprar Passagem
    Escolher e comprar passagens aereas

  Cenario: Comprar com Sucesso
    Dado que acesso o site: "https://www.blazedemo.com/"
    Quando seleciono a origem "São Paolo" e destino "Cairo"
    E clico no botão Find Flights
    Entao visualiza a lista de voos

  Esquema do Cenario: Comprar com Sucesso DDT
    Dado que acesso o site: "https://www.blazedemo.com/"
    Quando seleciono a <origem> e destino <destino>
    E clico no botão Find Flights
    Entao visualiza a lista de voos

    Exemplos:
      | origem      | destino  |
      | "São Paolo" | "Cairo"  |
      | "Boston"    | "London" |
