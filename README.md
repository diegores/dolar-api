# dolar-api

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/dolar-api-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing Jakarta REST and more

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)

Histórias do Usuário:
Como usuário, eu quero visualizar a cotação atual do dólar:
Definição: O usuário deverá acessar a aplicação e visualizar a cotação mais recente do dólar na página inicial.
Como usuário, eu quero poder consultar a cotação em uma data específica:
Definição: O usuário deve ter a opção de selecionar uma data específica e ver a cotação do dólar naquela data.


Critério de Aceitação 1: Exibição da Cotação na Página Inicial:

Descrição: Ao acessar a página inicial da aplicação, o usuário deve visualizar claramente a cotação mais recente do dólar.
Validação: Verificar se a cotação atual do dólar é exibida na página inicial da aplicação.
Critério de Aceitação 2: Atualização Automática da Cotação:

Descrição: A cotação exibida na página inicial deve ser atualizada automaticamente para refletir as mudanças mais recentes.
Validação: Confirmar que a cotação na página inicial é atualizada automaticamente sem a necessidade de recarregar a página.
Critério de Aceitação 3: Exibição de Informações Adicionais:

Descrição: Junto com a cotação atual do dólar, devem ser exibidas informações adicionais relevantes, como a data e a hora da última atualização.
Validação: Verificar se informações complementares, como data e hora da última atualização, são exibidas junto com a cotação na página inicial.


Cenário de Teste 1: Exibição Inicial da Cotação:

Descrição: O usuário acessa a página inicial da aplicação.
Passos:
Abrir a aplicação.
Verificar se a cotação atual do dólar é exibida na página inicial.
Resultado Esperado: A cotação do dólar é claramente visível na página inicial.

Cenário de Teste 2: Atualização Automática da Cotação:
Descrição: O usuário observa a cotação por um período de tempo.
Passos:
Acessar a página inicial.
Observar a cotação por alguns minutos.
Resultado Esperado: A cotação é atualizada automaticamente para refletir as mudanças mais recentes.

Cenário de Teste 3: Informações Adicionais na Exibição:
Descrição: O usuário verifica se informações adicionais são exibidas junto com a cotação.
Passos:
Acessar a página inicial.
Verificar se há informações complementares, como data e hora da última atualização.
Resultado Esperado: Informações adicionais são exibidas junto com a cotação.

Cenário de Teste 4: Navegação para Detalhes da Cotação:
Descrição: O usuário deseja obter mais detalhes sobre a cotação atual.
Passos:
Acessar a página inicial.
Clicar em um link ou botão para obter detalhes adicionais.
Resultado Esperado: O usuário é direcionado para uma página com mais informações sobre a cotação.

Cenário de Teste 5: Experiência Responsiva em Diferentes Dispositivos:
Descrição: O usuário verifica a experiência da aplicação em dispositivos diferentes.
Passos:
Acessar a aplicação em um dispositivo desktop.
Acessar a aplicação em um dispositivo móvel.
Resultado Esperado: A aplicação é responsiva e a exibição da cotação é adequada em diferentes tamanhos de tela.