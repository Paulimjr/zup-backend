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
    
- 4 Abra o projeto em sua IDE (ex: Eclipse ou NetBeans) importe o projeto e rode.

- ENDPOINTS

# Customers
   - GET - /customers - Retorna todos os clientes
   - GET - /customers/{id} - Retorna o cliente pelo ID
   - PUT - /customers/{id} - Alterar um cliente (passando o body)
   - DELETE - /customers - Deletar um cliente


# Products
   - GET - /products - Retorna todos os produtos
   - GET - /products/{id} - Retorna o produto pelo ID
   - PUT - /products/{id} - Alterar um produto (passando o body)
   - DELETE - /products - Deletar um produto
      


