#Executar no Terminal:
#mvn clean test -Dsurefire.includeJUnit5Engines=cucumber -Dcucumber.features="src/test/resources/features"
# language: pt
Funcionalidade: Comprar Passagem
    Escolher e comprar passagens aereas

  Esquema do Cenario: Comprar com Sucesso PO
    Dado que acesso o site "https://blazedemo.com/"
    Quando seleciono a <origem> e <destino>
    E clico no botao Find Flights
    Entao visualiza a lista de voos

    Exemplos:
      | origem      | destino  |
      | "São Paolo" | "Cairo"  |
      | "Boston"    | "London" |
