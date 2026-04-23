version: '3.8'
services:
  app:
    build: .
    ports:
      - "8081:8081"
    environment:
      - SPRING_DATASOURCE_URL=jdbc:postgresql://dpg-d7l65977f7vs73as19c0-a.oregon-postgres.render.com/eficiencia
      - SPRING_DATASOURCE_USERNAME=amanda
      - SPRING_DATASOURCE_PASSWORD=eVMo56MRHkqCOA01yzSAptIXBKQWXCzV
    depends_on:
      - db
  db:
    image: postgres:15
    environment:
      - POSTGRES_DB=eficiencia
      - POSTGRES_USER=amanda
      - POSTGRES_PASSWORD=eVMo56MRHkqCOA01yzSAptIXBKQWXCzV