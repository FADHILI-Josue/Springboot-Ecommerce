## ECOMMERCE API

API genérica para lojas ecommerce.


### Clone e Execute

```sh
git clone https://github.com/dalmofelipe/Ecommerce

cd Ecommerce

docker compose up -d

./mvnw clean -f pom.xml

./mvnw install -f pom.xml

./mvnw exec:java -Dexec.mainClass="com.dalmofelipe.Ecommerce.EcommerceApplication"
```

### Host

```localhost:8000``` - API Ecommerce na porta padrão 8000

```localhost:5000``` - Cliente Adminer gestão da base de dados

Acessando Adminer

         Servidor : mysql-db
          Usuário : root
            Senha : root
    Base de dados : ecommerce
