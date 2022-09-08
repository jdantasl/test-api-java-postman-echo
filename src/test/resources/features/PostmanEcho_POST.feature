# language: pt

@Regressivo
Funcionalidade: Postman Echo POST
  Eu como analista de teste de software
  Quero fazer uma chamada na url do Postman Echo
  Para obter apenas um response válido

  @Postman @Call_POST_Body
  Cenario: Efetuar chamada POST com dados por Body no Postman Echo
    Dado a url POST do Postman Echo
    Quando efetuar a chamada por método POST com dados via body
    Então a resposta deve conter o elemento data com conteúdo "bar1" e "bar2"

  @Postman @Call_POST_FormParam
  Cenario: Efetuar chamada POST com dados por formParam no Postman Echo
    Dado a url POST do Postman Echo
    Quando efetuar a chamada por método POST com dados via formParam
    Então a resposta deve conter o elemento form com conteúdo "bar1" e "bar2"
