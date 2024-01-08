# 빗썸 api, nexon api 사용 
## 작성자: 윤동현


실행화면<br/><br/>
<p align="center">
<img width="348" alt="스크린샷 2024-01-08 오후 5 17 48" src="https://github.com/Retudy/Maplemate/assets/129308578/1263b156-8154-42fd-a6d8-6e704fadb883">


** 앞으로 할일 **<br/>
- [] 1.유튜브api,공공데이터api,네이버 api 등을 recyclerview에 표시합니다.<br/>
- [] 2.불러온 데이터들을 즐겨찾기하는 기능을 리싸이클러뷰에 표시하고, 데이터를 다른 페이지에 표시합니다. ->즐겨찾기 목록을 RecyclerView로 만들고,디테일 페이지도 추가<br/>
- [] 3.데이터를 저장하고,출력 해봅니다 ( Room, Sharedpreferences-> deprecated 되어 공식문서가 권장하는 dataStore 사용 )<br/>
- []4.viewModel 을 사용해 mvvm 아키텍쳐로 코드를 리팩토링합니다. <br/>

빗썸api문서:https://apidocs.bithumb.com/reference/%ED%98%B8%EA%B0%80-%EC%A0%95%EB%B3%B4-%EC%A1%B0%ED%9A%8C<br/>
넥슨api문서:https://openapi.nexon.com/game/maplestory/?id=22 <br/>

#사용기술
## 작성자: 윤동현
<br/>
라이브러리 <br/>
Retrofit2 / Coil / SharedPreferences / Viewbinding / Property / Corutine / RecyclerView / DataStore / 
