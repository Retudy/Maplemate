# 빗썸 api, nexon api 사용 
## 작성자: 윤동현

<p align="center">
실행화면 입니다. <br/><br/>

<p align="center">

![KakaoTalk_Image_2024-01-12-01-51-49_001](https://github.com/Retudy/Maplemate/assets/129308578/0291ee41-c2a5-44e5-a2ea-515ff4cf3c18)
![KakaoTalk_Image_2024-01-12-01-51-49_002](https://github.com/Retudy/Maplemate/assets/129308578/ed711f78-ee44-488b-a704-8b86f11bb268)
<br/>



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
