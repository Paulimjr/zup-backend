# Zup Backend
- Ferramentas
  - Git
  - Maven
  - JDK 8 ou Superior
  
- 1 Caso não tenha o GIT instalado, efetue o download atráves do link: https://git-scm.com/downloads

- 2 Caso nao tenha o Maven instalado, efetue o download atrásves do link: https://maven.apache.org/download.cgi?Preferred=ftp%3A%2F%2Fmirror.reverse.net%2Fpub%2Fapache%2F
  - 2.1 Após efetuar o download vá em variavéis de ambiente e adicione a variavel como nome: MVN_HOME e Caminho: c:\dev\apache-mave-3.5.0 (Configuração para Windows).
  - 2.2 Abra a variável PATH ao final dela digite: ";%MVN_HOME%\bin" e salve. 
    Abra o terminal vá até o projeto e digite: mvn clean install.

- 3 Crie uma pasta ex: "zup-backend", abra o terminal e efetue o clone do projeto com o comando abaixo:
    git clone https://github.com/Paulimjr/xy-inc.git
   
- 4 Dentro da pasta do projeto execute o comando pelo terminal: mvn clean install (com testes) - mvn clean install -DskipTests  (sem os testes)

- 5 Abra o projeto em sua IDE (ex: Eclipse ou NetBeans) importe o projeto e rode.
	- Outra opção para rodar também pelo terminal.
	- Execute o comando: mvn spring-boot:run
	
- 6 Para verificar onde os dados estão salvos basta acessar o link: http://localhost:8080/h2-console

- ENDPOINTS

# Customers
   - GET - /customers - Retorna todos os clientes
   - GET - /customers/{id} - Retorna o cliente pelo ID
   - GET - /customers/page?{linesPerPage, page, direction} - Buscar o cliente com paginação
   - PUT - /customers/{id} - Alterar um cliente (passando o body)
   - DELETE - /customers/{id} - Deletar um cliente


# Products
   - GET - /products - Retorna todos os produtos
   - GET - /products/{id} - Retorna o produto pelo ID
   - PUT - /products/{id} - Alterar um produto (passando o body)
   - DELETE - /products/{id} - Deletar um produto
   
# Products
   - GET - /orders - Retorna todos os pedidos
   - GET - /orders/{id} - Retorna o pedido pelo ID
      


