# Museum Finder API

## Descrição
O Museum Finder API é um projeto desenvolvido em Java com o auxílio do framework Spring Boot. Ele permite buscar e cadastrar museus com base em sua localização. Utilizando dados históricos, a API facilita a descoberta de museus próximos a uma determinada área.

## Requisitos para Execução
- Java Development Kit (JDK)
- Maven

## Como Rodar Localmente
1. Clone o repositório do projeto:
    ```
    git clone https://github.com/seu-usuario/museum-finder.git
    ```

2. Navegue até o diretório do projeto:
    ```
    cd museum-finder
    ```

3. Compile o projeto utilizando o Maven:
    ```
    mvn clean install
    ```

4. Execute a aplicação Spring Boot:
    ```
    java -jar target/museum-finder.jar
    ```

5. Acesse a API localmente através do navegador ou de uma ferramenta como Postman:
    ```
    http://localhost:8080
    ```

## Funcionalidades do Museum Finder API

### Cadastro de Museus
- Permite cadastrar novos museus na base de dados, fornecendo informações como nome, endereço e coordenadas geográficas.

### Busca por Museu Mais Próximo
- Facilita a busca pelo museu mais próximo com base na localização informada pelo usuário, utilizando algoritmos de geolocalização.

### Monitoramento da Saúde da Aplicação
- Habilita o Spring Boot Actuator para monitorar a saúde da aplicação, fornecendo informações sobre status, métricas e outras estatísticas importantes.

### Tratamento de Erros Padronizado
- Utiliza um ControllerAdvice para tratar exceções de forma padronizada e gerar respostas consistentes em caso de falhas na API.

### Testes Unitários
- Implementa testes unitários para garantir a robustez e qualidade do código, atingindo uma cobertura mínima de 80% das linhas de código nas classes Controller e Service.

### Dockerfile para Implantação em Contêineres
- Inclui um Dockerfile para facilitar o empacotamento e implantação da aplicação em contêineres Docker, tornando o processo de implantação mais eficiente e escalável.
