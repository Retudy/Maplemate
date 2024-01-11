# 빗썸 api, nexon api 사용 
## 작성자: 윤동현

<p align="center">
실행화면 입니다. <br/><br/>


<p align="center">
  
![1](https://github.com/Retudy/Maplemate/assets/129308578/1d2b0e42-9b1f-408b-b298-206f6b051a0a)
![2](https://github.com/Retudy/Maplemate/assets/129308578/69f4fecb-8512-4c65-a7d6-d1c3fcd76752)





** 업데이트 할 예정입니다. **<br/>
- 아이디를 입력하면 캐릭터의 정보, 아이템이 조회됩니다. </br>
- api 호출량을 줄이기 위해 입력받은 이름 =k ey 식별자 = value 를 쌍으로 key = value 형태로 저장합니다. (Room, Sharedpreferences-> deprecated 되어 공식문서가 권장하는 dataStore 사용 )<br/>
- viewModel 을 사용해 mvvm 아키텍쳐로 코드를 리팩토링합니다. <br/>

빗썸api문서:https://apidocs.bithumb.com/reference/%ED%98%B8%EA%B0%80-%EC%A0%95%EB%B3%B4-%EC%A1%B0%ED%9A%8C<br/>
넥슨api문서:https://openapi.nexon.com/game/maplestory/?id=22 <br/>

#Stack
## 작성자: 윤동현
<br/>
라이브러리 <br/>
Native: Retrofit2 / Coil / SharedPreferences / Viewbinding / Property / Corutine / RecyclerView </br>
Jetpack: dataStore
