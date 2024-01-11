# nexon api 사용 
## 작성자: 윤동현

<p align="center">
실행화면 입니다. <br/><br/>


<p align="center">
  
<img width="717" alt="스크린샷 2024-01-12 오전 2 10 10" src="https://github.com/Retudy/Maplemate/assets/129308578/765d7cb9-58fc-4c95-ba3c-c100698fedf9">


** 업데이트 할 예정입니다. **<br/>
- 아이디를 입력하면 캐릭터의 정보, 아이템이 조회됩니다. </br>
- api 호출량을 줄이기 위해 입력받은 이름 =k ey 식별자 = value 를 쌍으로 key = value 형태로 저장합니다. (Room, Sharedpreferences-> deprecated 되어 공식문서가 권장하는 dataStore 사용 )<br/>
- viewModel 을 사용해 mvvm 아키텍쳐로 코드를 리팩토링합니다. <br/>

넥슨api문서:https://openapi.nexon.com/game/maplestory/?id=22 <br/>

#Stack
## 작성자: 윤동현
<br/>
라이브러리 <br/>
Native: Retrofit2 / Coil / SharedPreferences / Viewbinding / Property / Corutine / RecyclerView </br>
Jetpack: dataStore
