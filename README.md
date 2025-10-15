# 📚 BookMarket

Spring Boot 기반의 온라인 서점 웹 애플리케이션입니다. 도서 검색, 장바구니, 주문 처리 등의 전자상거래 핵심 기능을 제공합니다.

## 🎯 주요 기능

### 도서 관리
- 📖 도서 목록 조회 및 상세 정보 확인
- 🔍 카테고리별 도서 검색
- 🎛️ 출판사/카테고리 복합 필터링 (Matrix Variable 사용)
- 📥 도서 이미지 업로드 및 다운로드
- ➕ 관리자 전용 도서 등록 (Spring Security)

### 장바구니
- 🛒 세션 기반 장바구니 관리
- ➕ 장바구니에 도서 추가
- ➖ 개별 도서 삭제
- 🗑️ 장바구니 전체 비우기
- 💰 실시간 총액 자동 계산

### 주문 처리
- 📋 다단계 주문 프로세스
  1. 장바구니 확인
  2. 고객 정보 입력
  3. 배송 정보 입력
  4. 주문 최종 확인
  5. 주문 완료
- ✅ 각 단계별 유효성 검증
- ❌ 주문 취소 기능
- 💾 MySQL 데이터베이스에 주문 영구 저장

## 🛠️ 기술 스택

### Backend
- **Framework**: Spring Boot 3.4.3
- **Language**: Java 17
- **Security**: Spring Security
- **ORM**: Spring Data JPA
- **Database**: MySQL
- **Template Engine**: Thymeleaf
- **Validation**: Jakarta Bean Validation

### Build Tool
- **Gradle**

### 주요 라이브러리
- Lombok (보일러플레이트 코드 감소)
- Spring Boot DevTools (개발 편의성)
- MySQL Connector

## 📋 사전 요구사항

- Java 17 이상
- MySQL 8.0 이상
- Gradle (또는 프로젝트에 포함된 Gradle Wrapper 사용)

## 🚀 설치 및 실행

### 1. 저장소 클론
```bash
git clone <repository-url>
cd BookMarket
```

### 2. MySQL 데이터베이스 생성
```sql
CREATE DATABASE BookMarketDB;
CREATE USER 'park'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON BookMarketDB.* TO 'park'@'localhost';
FLUSH PRIVILEGES;
```

### 3. 애플리케이션 설정 (선택사항)
`src/main/resources/application.properties` 파일에서 데이터베이스 연결 정보 수정 가능:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/BookMarketDB
spring.datasource.username=park
spring.datasource.password=1234
```

### 4. 파일 업로드 디렉토리 생성
```bash
mkdir D:/Upload/
# 또는 원하는 경로로 변경 후 application.properties의 file.uploadDir 수정
```

### 5. 애플리케이션 실행
```bash
./gradlew bootRun
```

### 6. 브라우저에서 접속
```
http://localhost:8080/BookMarket
```

## 👤 기본 관리자 계정

도서 등록 등의 관리자 기능을 사용하려면 다음 계정으로 로그인하세요:

- **사용자명**: `admin`
- **비밀번호**: `admin1234`

## 📁 프로젝트 구조

```
src/main/java/kr/ac/kopo/su/bookmarket/
├── Controller/          # HTTP 요청 처리
│   ├── BookController.java
│   ├── CartController.java
│   ├── OrderController.java
│   ├── LoginController.java
│   └── WelcomeController.java
├── service/            # 비즈니스 로직
│   ├── BookService.java
│   ├── CartService.java
│   └── OrderService.java
├── repository/         # 데이터 접근 계층
│   ├── BookRepository.java
│   ├── CartRepository.java
│   └── OrderRepository.java
├── domain/            # 도메인 모델
│   ├── Book.java
│   ├── Cart.java
│   ├── Order.java
│   ├── Customer.java
│   └── Shipping.java
├── config/            # 설정 클래스
│   ├── SecurityConfig.java
│   ├── ResourceConfig.java
│   └── ValidationConfig.java
├── exception/         # 커스텀 예외
│   ├── BookIdException.java
│   ├── CartException.java
│   └── CategoryException.java
└── validator/         # 커스텀 검증기
    ├── BookValidator.java
    └── BookIdValidator.java
```

## 🔧 빌드 및 테스트

### 프로젝트 빌드
```bash
./gradlew build
```

### 테스트 실행
```bash
./gradlew test
```

### 클린 빌드
```bash
./gradlew clean build
```

## 📝 API 엔드포인트

### 도서 관련
- `GET /books` - 전체 도서 목록
- `GET /books/book?id={bookId}` - 도서 상세 정보
- `GET /books/{category}` - 카테고리별 도서 목록
- `GET /books/filter/{bookFilter}` - 복합 필터링
- `GET /books/add` - 도서 등록 폼 (관리자 전용)
- `POST /books/add` - 도서 등록 처리
- `GET /books/download?file={filename}` - 도서 이미지 다운로드

### 장바구니 관련
- `GET /cart` - 장바구니 조회
- `GET /cart/{cartId}` - 특정 장바구니 조회
- `PUT /cart/book/{bookId}` - 장바구니에 도서 추가
- `DELETE /cart/book/{bookId}` - 장바구니에서 도서 제거
- `DELETE /cart/{cartId}` - 장바구니 전체 삭제

### 주문 관련
- `GET /order/{cartId}` - 주문 시작
- `GET /order/orderCustomerInfo` - 고객 정보 입력
- `POST /order/orderCustomerInfo` - 고객 정보 제출
- `GET /order/orderShippingInfo` - 배송 정보 입력
- `POST /order/orderShippingInfo` - 배송 정보 제출
- `GET /order/orderConfirmation` - 주문 확인
- `POST /order/orderConfirmation` - 주문 최종 제출
- `GET /order/orderFinished` - 주문 완료
- `GET /order/orderCancelled` - 주문 취소

## 🎨 주요 기술적 특징

### 1. 하이브리드 데이터 저장소
- **도서 데이터**: 인메모리 리스트 (초기 데모 데이터 포함)
- **장바구니**: 세션 기반 HashMap
- **주문 데이터**: MySQL + JPA 영속성

### 2. Matrix Variable 필터링
Spring의 Matrix Variable을 활용한 유연한 필터링:
```
/books/filter/publisher=길벗캠퍼스;category=IT 교재
```

### 3. 다단계 폼 위저드
주문 프로세스를 여러 단계로 분리하여 사용자 경험 향상

### 4. Bean Validation
커스텀 어노테이션과 검증기를 활용한 강력한 데이터 검증:
- `@BookId`: ISBN 형식 검증
- `@Size`, `@Min`, `@Digits`: 기본 검증
- 국제화된 오류 메시지

### 5. 예외 처리
`@ExceptionHandler`를 통한 체계적인 예외 처리 및 사용자 친화적 오류 페이지

## 🔒 보안

- Spring Security를 통한 인증/인가
- BCrypt 암호화
- 관리자 페이지 접근 제어 (ROLE_ADMIN)
- 세션 기반 장바구니 관리


## 🖥️ 주요 화면

- 도서 목록

![도서 목록](https://velog.velcdn.com/images/mourn5367/post/d44756b0-a37a-4300-bf4f-6c9eae59f93b/image.png)

- 카테고리별 도서 검색(좌측 상단 IT 교재 클릭)

![IT 교재](https://velog.velcdn.com/images/mourn5367/post/f7d286b5-b74d-49d6-8f2c-45ea07410be3/image.png)

- 도서 상세 정보

![도서 상세 정보](https://velog.velcdn.com/images/mourn5367/post/524ea283-ce05-4727-8a0d-427dc28e257e/image.png)

- 도서 주문 후 장바구니 확인 및 도서 삭제

![장바구니](https://velog.velcdn.com/images/mourn5367/post/c38a21d9-d8a4-4a32-b794-68974fefa13c/image.png)
![장바구니_1](https://velog.velcdn.com/images/mourn5367/post/6005dcf8-ba16-49d6-9c8e-7d725f04726e/image.png)

- 주문

![주문](https://velog.velcdn.com/images/mourn5367/post/aa611dbf-4e22-421b-bad0-78dd4583add2/image.png)
![주문](https://velog.velcdn.com/images/mourn5367/post/cbc67a8b-3832-499f-990f-2c8dd6672d2c/image.png)

- 영수증

![영수증](https://velog.velcdn.com/images/mourn5367/post/2118472a-b7af-42d8-a26b-84c0c0d81458/image.png)

- 주문취소
  
![주문취소](https://velog.velcdn.com/images/mourn5367/post/a0b05d6a-d9a1-47e8-b094-897fe5e76561/image.png)

- 주문 취소후 장바구니
<p align="left">
  <img src="https://velog.velcdn.com/images/mourn5367/post/0b2a1dbb-53c0-479f-9f1a-1b17c83fa188/image.png" alt="취소 장바구니" width="700">
</p>
