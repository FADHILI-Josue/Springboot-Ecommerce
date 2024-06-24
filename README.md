## ECOMMERCE API

full ecommerce api


### run the project

```sh
git clone https://github.com/FADHILI-Josue/Springboot-Ecommerce.git Ecommerce

cd Ecommerce

docker compose up -d

./mvnw clean -f pom.xml

./mvnw install -f pom.xml

./mvnw exec:java -Dexec.mainClass="com.fadhili.Ecommerce.EcommerceApplication"
```

### Host

```localhost:8000``` - API Ecommerce running on port 8000


    user : root
    passowrd : password
    database : ecommerce
