# Spring Boot (Gradle) & Hibernate & Mysql
````
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── hibernate
│   │   │           └── spring
│   │   │               ├── SpringHibernateApplication.java
│   │   │               └── controller
|   |   |                       └── MainController.java
│   │   └── resources
│   │       ├── application.yml
│   │       ├── static
│   │       └── templates
|
├── build.gradle
└── README.md
````

## Gradle
### Gradle 이란
Gradle은 Maven을 대체 빌드 도구(build tool) 이다.
Grooby 기반의 DSL(Domain Specific Language)를 사용한다.
스프링 오픈소스 프로젝트, 안드로이드 스튜디오에서는 Gradle을 사용되고 있다.

### build.gradle 설명
1. buildscript :
buildscript에는 SpringBoot Version 정보, Maven Repository 정보, Dependency 모듈을 지정하여 스프링 부트 플러그인을 사용할 수 있는 기본 바탕을 정의합니다.

2. apply :
플러그인을 적용합니다.

- apply plugin: 'java' → java용 웹 프로젝트를 생성합니다. sourceCompatibility = '1.8' 호환 버전을 지정하여 java 웹 프로젝트에서 사용할 java를 명시합니다.

- apply plugin: 'io.spring.dependency-management' → Spring IO Platform의 Gradle Plugin인 dependency-management를 사용합니다. 스프링 부트 1.x에서는 디폴트로 사용되었지만 2.x에서는 명시적으로 선언해 주어야 합니다.

3. dependencies :
프로젝트에서 사용할 디펜던시 모듈을 정의합니다.

- compile → 먼저 compile 시점에 필요한 디펜던시 라이브러리들을 compile로 정의합니다.

- runtime → 런타임 시에 참조할 라이브러리를 정의합니다. 기본적으로 compile 라이브러리를 포함합니다.

- compileOnly → 컴파일 시점에만 사용하고 런타임에는 필요없는 라이브러리를 정의합니다.

- testCompile → 프로젝트의 테스트를 위한 디펜던시 라이브러리를 정의합니다. 기본적으로 Compile된 클래스와 compile 라이브러리를 포함합니다.

 
수정이 완료되면 다음과 같이 gradle → Refresh Gradle Project를 선택하여 라이브러리를 업데이트 합니다.

## Hibernate
### Hibernate 이란
Hibernate는 JPA의 구현체이다. ... 그럼여기서 또 JPA 는 무엇인가라는 의문이 생긴다. JPA는 Java Persistence API의 약자로, 자바 어플리케이션에서 관계형 데이터베이스를 사용하는 방식을 정의한 인터페이스이다. 라고 해당 블로그 에서 설명하고있다.(https://suhwan.dev/2019/02/24/jpa-vs-hibernate-vs-spring-data-jpa) 내가 설명 하는것도 좋지만 좀더 잘 설명된 내용이 있어 참조한다. 해당 설명을 읽고 Hibernate는, JPA의 계념을 잡을 수 있었다.

### Hibernate Gradle 설정
#### build.gradle 
해당 모듈을 build.gradle 정의한다.

`````
dependencies {
    // Hibernate
    compile("org.springframework.boot:spring-boot-starter-data-jpa")
    compile("mysql:mysql-connector-java")
}
`````

#### application.yml
해당 설정을 application.yml 정의한다.

`````
spring:
  profiles:
    active: local
---
spring:
  profiles: local
  datasource:
    url: jdbc:mysql://<host>:<port>/<dbname>
    username: <username>
    password: <password>
  jpa:
    hibernate:
      ddl-auto: update # 운영시에는 validate 추천
    show-sql: true
`````

- spring.jpa.hibernate.ddl-auto: sessionFactory가 올라갈 때, DBMS의 스키마를 자동으로 수정하거나 검증하는 설정 값. (none/create/create-drop/update/validate)
- show-sql: console에 JPA 실행 SQL Log 유무. true/false

### 용어 정리

@Entity : DB 테이블에 대응하는 하나의 클래스를 정의 
- name : Entity들간의 충돌이 될때나 이름을 설정해준다. 설정을 안하면 default는 Class명으로 설정된다.

(기본 생성자 필수, final, enum, interface, inner 클래스 사용 못함, 저장 필드에 final 사용 못함)

@Table : Entity와 매핑할 DB Table을 지정 한다.
- name : 매핑할 table 이름, 기본은 Entity 이름을 사용한다.
- catalog : catalog 기능이 있는 DB에서 catalog를 매핑
- schema : schema 기능이 있는 DB에서 schema를 매핑
- uniqueConstraints : DDL 생성 시에 유니크 제약조건을 만든다.