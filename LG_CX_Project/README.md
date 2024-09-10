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
/my-springboot-project
│
├── /frontend                     # 프론트엔드 관련 폴더
│   ├── /node_modules             # npm 패키지들
│   ├── /src                      # 프론트엔드 소스 파일 (CSS, JS 등)
│   │   ├── /components           # 재사용 가능한 UI 컴포넌트
│   │   ├── /assets               # 이미지, 폰트 등의 정적 자산
│   │   └── /styles               # CSS/SCSS 파일
│   ├── /dist                     # 빌드된 파일
│   ├── package.json              # npm 설정 파일
│   ├── webpack.config.js         # (필요 시) Webpack 설정 파일
│   └── .babelrc                  # (필요 시) Babel 설정 파일
│
├── /src
│   ├── /main
│   │   ├── /java                 # Spring Boot Java 코드
│   │   │   └── /com
│   │   │       └── /example
│   │   │           └── /project  # Controller, Service, Repository 등 백엔드 파일
│   │   ├── /resources
│   │   │   ├── /static           # 빌드된 프론트엔드 정적 파일 배치
│   │   │   │   ├── /css          # 빌드된 CSS 파일
│   │   │   │   ├── /js           # 빌드된 JS 파일
│   │   │   └── /templates        # Thymeleaf 템플릿 파일
│   │   └── /application.properties  # Spring Boot 설정 파일
│
├── /test                         # 테스트 관련 폴더
│   └── /java                     # Java 테스트 코드
│
├── /target                       # Maven 빌드 파일 (빌드 후 생성)
│ 
└── README.md                     # 프로젝트 설명 파일
```


# DB 계정
- 계정 : hr / 12345
- DB : Oracle
- port : 8090
