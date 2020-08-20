<h1>RPA API</h1> </br>


<p> O projeto Consiste em um API Java construida com SpringBoot.
A arquitetura escolhida para o serviço foi em camdas. Por tanto termos três. Os controllers, que são os componentes
mais reposáveis por receber as requisições HTTP. E por meio de um método "delegate", dela ao Services, a segunda camada, a responsabilidade pela aplicação da regra de negócio e comunicar-se com seu Repositorio.
A ultima camada é a de Repository qual tem aceso aos dados do banco.</p>

<h2>Build</h2>
<p>O projeto está configurado com Docer e Docker-Compose. </p>
<p>De uma forma simples e rapida basta digitar o seguinte comando</p>


```
 docker-compose up -d
 
```


<p> A partis deste comando 1° docker vai baixar as imagens necesárias, após teremos o build do projeto java pelo maven. 
Isto pode demorar alguns minutos pois todas as dependências do proejto serão baixadas. 
Em um segundo momento será rodadas as mrigrations do BD.</p>
<p>Passado isto o projeto estrá pronto<p/>


<h2>Tecnologias</h2>
<p>neste tópico teremos listagem das principas tecnologias. </p>
<ul> 
  <li> Java 1.8 - ou também versão 8. </li>
  <li> Spring Boot - framework popular e que conscede muita agilidade para projetos java. </li> 
  <li> Flyway - ferramenta de versionamento do Banco de dados. Garatindo mais controle e organização das alterações do BD. </li>
  <li> Lombok - produtividade e diminuir verbosidade do codigo </li>
  <li> JPA - ORM </li>
  <li> MOCKITO - ferramneta para criar mocks e auxiliar na criação de testes </li>
  <li> JUNIT 5 - ferramenta de teste </li>
<ul>

<p> PS: as ferramentas de teste já vêm integradas junto ao Spring Boot </p>


<h2>Sugestões e melhorias </h2>
<p> Algumas melhorias possiveis seriam:</p> 
<p> 1 - retirar o ORM para garantir maior performance.  <p/>
<p> 2 -  garantir testes para os controllers que não foram cobertos </p>
<p> 3 -  documentar o código com swagger ou alguma ferramenta do genero </P>




