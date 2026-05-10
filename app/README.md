# Agendamento de Tarefas Diárias
Aplicativo Android desenvolvido como atividade prática para cadastro, resumo e listagem de tarefas 
diárias.

O projeto foi construído em etapas, evoluindo da manipulação básica de componentes visuais 
até a organização com arquitetura MVVM e uso de LiveData.

## Objetivo da atividade

Desenvolver um aplicativo Android para agendamento de tarefas diárias, utilizando componentes de 
interface, navegação entre telas, lista dinâmica e separação de responsabilidades com MVVM.

## Funcionalidades implementadas

### Cadastro de tarefa

A tela de cadastro permite informar os dados principais de uma tarefa:

- Título da tarefa;
- Tipo da tarefa;
- Prioridade;
- Horário;
- Local;
- Confirmação do cadastro com simulação de carregamento.

Componentes utilizados:

- `EditText`
- `Spinner`
- `CheckBox`
- `TimePicker`
- `AutoCompleteTextView`
- `Button`
- `ProgressBar`

### Resumo da tarefa

Após o cadastro, o aplicativo navega para uma tela de resumo, exibindo os dados da tarefa cadastrada.

A tela também mostra duas tarefas anteriores fixas, simulando registros já existentes.

### Lista de tarefas

O aplicativo possui uma tela de listagem que exibe as tarefas cadastradas dinamicamente.

Cada tarefa mostra:

- Título;
- Tipo;
- Horário;
- Local;
- Indicação de prioridade.

A lista foi implementada com:

- `ListView`
- `ArrayList<Tarefa>`
- Adapter personalizado

### Arquitetura MVVM com LiveData

O projeto foi organizado seguindo o padrão MVVM, separando responsabilidades entre as camadas:

- `model`: representação dos dados da tarefa;
- `view`: telas do aplicativo;
- `viewModel`: controle dos dados utilizados pelas telas;
- `data`: repositório em memória;
- `adapter`: adaptação dos dados para exibição na lista.

O uso de `LiveData` permite que a interface observe alterações na lista de tarefas e 
atualize automaticamente os dados exibidos.

## Tecnologias utilizadas

- Java
- Android Studio
- XML para construção das telas
- Android SDK
- MVVM
- LiveData
- ViewModel
- ListView
- ArrayAdapter personalizado
- Intent
- ArrayList

## Estrutura do projeto

```text
com.example.agendamentotarefas
├── adapter
│   └── TarefaAdapter
├── data
│   └── TarefaRepository
├── model
│   └── Tarefa
├── view
│   ├── CadastroActivity
│   ├── ResumoActivity
│   └── ListaActivity
└── viewModel
    └── TarefaViewModel