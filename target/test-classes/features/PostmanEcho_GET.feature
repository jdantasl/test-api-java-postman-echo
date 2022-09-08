# language: pt

@Regressivo
Funcionalidade: Postman Echo GET
  Eu como analista de teste de software
  Quero fazer uma chamada na url do Postman Echo
  Para obter apenas um response válido

  @Postman @Call_GET
  Cenario: Efetuar chamada GET no Postman Echo
    Dado a url GET do Postman Echo
    Quando efetuar a chamada por método GET
    Então a resposta deve conter o elemento "args" com conteúdo "bar1" e "bar2"

