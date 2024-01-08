# 빗썸 api, nexon api 사용 
## 작성자: 윤동현

<p align="center">
실행화면 입니다! <br/><br/>

<p align="center">
<img width="348" alt="스크린샷 2024-01-08 오후 5 17 48" src="https://github.com/Retudy/Maplemate/assets/129308578/1263b156-8154-42fd-a6d8-6e704fadb883">
<img width="348" alt="스크린샷 2024-01-08 오후 7 16 34" src="https://github.com/Retudy/Maplemate/assets/129308578/bc502b36-3e45-40bf-af13-5e7ede415291">



** 업데이트 할 예정입니다. **<br/>
- 불러온 데이터들을 즐겨찾기하는 기능을 리싸이클러뷰에 표시하고, 데이터를 다른 페이지에 표시합니다. ->즐겨찾기 목록을 RecyclerView로 만들고,디테일 페이지도 추가<br/>
- 데이터를 저장하고,출력 해봅니다 ( Room, Sharedpreferences-> deprecated 되어 공식문서가 권장하는 dataStore 사용 )<br/>
- viewModel 을 사용해 mvvm 아키텍쳐로 코드를 리팩토링합니다. <br/>

빗썸api문서:https://apidocs.bithumb.com/reference/%ED%98%B8%EA%B0%80-%EC%A0%95%EB%B3%B4-%EC%A1%B0%ED%9A%8C<br/>
넥슨api문서:https://openapi.nexon.com/game/maplestory/?id=22 <br/>

#사용기술
## 작성자: 윤동현
<br/>
라이브러리 <br/>
Retrofit2 / Coil / SharedPreferences / Viewbinding / Property / Corutine / RecyclerView / DataStore / 
