<h1>RPA API</h1> </br>


<p> O projeto consiste em um API Java construida com SpringBoot e organizada em três camdas.  Controllers, reposáveis por receber as requisições HTTP. Os Services responsáveis por implementar as regras de negócio e cominicar-se com seu Repositorio a ultima camada, com a reposabilidade de se comunicar com a base de dados.
A ultima camada é a de Repository qual tem aceso aos dados do banco.</p>

<h2>Build</h2>
<p>O projeto está configurado com Docer e Docker-Compose. </p>
<p>De uma forma simples e rapida basta digitar o seguinte comando </p>


```
 docker-compose up -d
 
```


<p> A parti deste comando o dockers vai  baixar as imagens necesárias. Ao termino o build do projeto java pelo maven. 
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
  <li> Mokito - ferramneta para criar mocks e auxiliar na criação de testes </li>
  <li> Junit 5 - ferramenta de teste </li>
</ul>

<p> PS: as ferramentas de teste já vêm integradas junto ao Spring Boot </p>

</br>
<h2>Sugestões e melhorias </h2>
<p> Algumas melhorias possiveis seriam:</p> 
<p> 1 - retirar o ORM para garantir maior performance.  <p/>
<p> 2 -  garantir testes para os controllers que não foram cobertos </p>
<p> 3 -  documentar o código com swagger ou alguma ferramenta do genero </P>




