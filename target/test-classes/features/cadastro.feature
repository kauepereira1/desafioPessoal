#language: pt

Funcionalidade: Cadastro de Task

Contexto: Cadastrar Task
  Dado que estou acessando a aplicação
  Quando informo usuário "will"
  E a senha "will"
  Então visualizo a página inicial
  Quando seleciono Create
  E seleciono Create Task
  E preencho os campos
  Então vejo que a task foi cadastrada com sucesso.

Cenario: Editar Task
  E clico na opção Actions
  E clico em Editar
  Então o arquivo é alterado com sucesso

@Deletar
Cenario: Deletar Task
  E clico na opção Actions
  E clico em Deletar
  Então o arquivo é deletado com sucesso






