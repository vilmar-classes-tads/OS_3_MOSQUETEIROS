# Changelog
##[0.1.0] - 09/11/2026
### `Added`
- Implementação do cadastro de usuários (Issue 0).
- Criação das classes Usuario e Perfil.
- Implementação do serviço de cadastro de usuários.
- Validação de unicidade de CPF e e-mail.
- Simulação de persistência em memória utilizando List ou Map.
- Implementação do gerenciamento de editais (Issue 1).
- Criação da classe Edital com título, número, ano e datas de submissão e avaliação.
- Validação das datas dos editais, impedindo períodos invertidos.
- Implementação de serviço ou repositório em memória para listar e editar editais.
- Configuração do GitHub Actions para integração contínua.
- Criação do workflow Maven para compilação e execução de testes automatizados.
### `Changed`
- Organização do fluxo de desenvolvimento utilizando branches e Pull Requests.
- Integração das funcionalidades das Issues 0 e 1 na branch develop.
- Testing
- Testes de compilação com Maven.
- Execução de testes automatizados pelo GitHub Actions.
- Verificação do pipeline em situações de sucesso e falha.
- Revisão de código por meio de Pull Requests.
