# Crypto Alert App - Backend  
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white) ![Telegram](https://img.shields.io/badge/Telegram-2CA5E0?style=for-the-badge&logo=telegram&logoColor=white)  

Backend service for cryptocurrency price alerts that notifies users via Telegram when Bitcoin hits their target price.  

## 📌 Features  
- User authentication with Spring Security & JWT  
- CRUD operations for BTC price alerts  
- Real-time price monitoring with Crypto API  
- Instant Telegram notifications via webhooks  
- PostgreSQL database storage  
- RESTful API endpoints  

## 🛠 Tech Stack  
**Backend**: Java 17, Spring Boot 3, Spring Security  
**Database**: PostgreSQL, Hibernate ORM  
**Integration**: Telegram Bot API, Webhooks  
**Tools**: Maven, Swagger (API Docs)  

## 📋 API Endpoints  
| Endpoint            | Method | Description                      | Auth Required |  
|---------------------|--------|----------------------------------|---------------|  
| `/api/auth/register`| POST   | Register new user                | No            |  
| `/api/auth/login`   | POST   | User login                       | No            |  
| `/api/alerts`       | POST   | Create new BTC price alert       | Yes (JWT)     |  
| `/api/alerts`       | GET    | Get all user's alerts            | Yes (JWT)     |  
| `/api/alerts/{id}`  | DELETE | Delete specific alert            | Yes (JWT)     |  
| `/api/price/btc`    | GET    | Get current BTC price            | No            |  

## 🚀 Quick Setup  
1. **Prerequisites**:  
   - Java 17+, PostgreSQL 14+, Telegram bot token  

2. **Configure application.properties**:  

```spring.datasource.url=jdbc:postgresql://localhost:5432/crypto_alerts  
spring.datasource.username=postgres  
spring.datasource.password=yourpassword  
telegram.bot.token=YOUR_BOT_TOKEN  
crypto.api.key=YOUR_COINGECKO_API_KEY  
Run the application:
```


### 🌐 Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── com/cryptoalert/
│   │       ├── config/       # Security & Webhook config
│   │       ├── controller/   # REST & Telegram endpoints
│   │       ├── model/        # JPA Entities
│   │       ├── repository/   # Spring Data interfaces
│   │       ├── service/      # Business logic
│   │       └── utils/        # Price fetcher, Notifier
│   └── resources/
│       └── application.properties
```
### 📜 License
MIT © 2025
