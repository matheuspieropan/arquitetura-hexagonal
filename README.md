## Arquitetura hexagonal

Projeto tem como finalidade apresentar um pouco mais da arquitetura hexagonal e como realizar sua implementação.

Repositório foi dividido em duas pastas *(aplicação e adaptadores)*

##### - *Aplicação*

Essa pasta contém toda lógica de negócio da nossa aplicação. Ela é agnóstica ao mundo externo e fornece as portas necessárias para que os adaptadores façam suas implementações.

##### - *Adaptadores*

- *API REST*

Essa pasta contém uma implementação utilizando api rest com framework Spring. Nesse projeto adicionamos a lib da nossa aplicação  e fizemos a implementação (adapter) das portas fornecidas pela aplicação. 

Esse adaptador fornece o endpoint /usuario que pode ser consumido com a seguinte estrutura JSON

```
{
  "login": "seu_logisnn",
  "email": "seu_email@example.com",
  "senha": "sua_senha_secreta"
}
```
- *PROMPT*

Essa pasta contém a implementação utilizando prompt. Nesse projeto adicionamos a lib da nossa aplicação e fizemos a implementação (adapter) das portas fornecidas pela aplicação.

Basta executar o programa e criar seu usuário por linha de comando. Será  informado o email, login e senha. Uma vez validado na regra de negócio, usuário será salvo num arquivo CSV no diretório raíz da aplicação.
