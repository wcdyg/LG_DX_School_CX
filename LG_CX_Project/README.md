# Commit 컨벤션
- Feat: 새로운 기능 추가 
- Fix: 오류, 버그 수정 
- Design: UI 디자인 변경 
- Modify: 단순한 코드 수정 
- Delete: 코드 삭제(설명 필요)
- Remove: 단순 파일 삭제 작업 
- Comment: 주석 추가 및 변경 
- Docs: 문서 수정 
- Test: 테스트 추가, 리팩토링 
- Refactor: 코드 리팩토링 
- Rename: 파일, 폴더명 수정 혹은 이동 
- Chore: 이외 모든 기타 작업 
- Merge: 변경 사항 설명

# 디렉토리 구조 및 설명
```angular2html
/LG_CX_Project
│
├── /src
│   ├── /main
│   │   ├── /java                 # Spring Boot Java 코드
│   │   │   └── /com
│   │   │       └── /example
│   │   │           └── /project
│   │   │               ├── /controller  # 컨트롤러 클래스들
│   │   │               ├── /service     # 서비스 클래스들
│   │   │               ├── /repository  # 레포지토리 클래스들
│   │   │               └── /model       # 모델/엔티티 클래스들
│   │   └── /resources
│   │       ├── /static           # 정적 파일
│   │       │   ├── /css          # CSS 파일
│   │       │   ├── /js           # JavaScript 파일
│   │       │   └── /images       # 이미지 파일
│   │       ├── /templates        # Thymeleaf 템플릿 파일
│   │       └── application.properties  # Spring Boot 설정 파일
│   │
│   └── /test                     # 테스트 코드
│       └── /java
│           └── /com
│               └── /example
│                   └── /project
│
├── /build                        # Gradle 빌드 출력 디렉토리 (빌드 시 자동 생성)
│
├── build.gradle                  # Gradle 빌드 스크립트
├── settings.gradle               # Gradle 설정 파일
│
├── gradlew                       # Gradle 래퍼 스크립트 (Unix)
├── gradlew.bat                   # Gradle 래퍼 스크립트 (Windows)
│
└── README.md    
```


# DB 계정
- 계정 : hr / 12345
- DB : Oracle
- port : 8090
