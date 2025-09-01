#Executar no Terminal:
#mvn clean test -Dsurefire.includeJUnit5Engines=cucumber -Dcucumber.features="src/test/resources/featuresPO"
#mvn clean test -Dtest=Runner
#mvn clean test -Dtest=stepsPO.Runner
# language: pt
Funcionalidade: Comprar Passagem PO
    Escolher e comprar passagens aereas

  Esquema do Cenario: Comprar com Sucesso PO
    Dado que acesso o site "https://blazedemo.com/" PO
    Quando seleciono a <origem> e <destino> PO
    E clico no botao Find Flights PO
    Entao visualiza a lista de voos PO
    Quando clico no <ordem_do_voo> PO

    Exemplos:
      | origem      | destino  | ordem_do_voo |
      | "São Paolo" | "Cairo"  |            2 |
      | "Boston"    | "London" |            5 |
