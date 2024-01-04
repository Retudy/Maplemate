# 빗썸 api, nexon api 사용 
## 작성자: 윤동현

구조<br/>

View: CoinActivity, activity_coin (xml)<br/>
Data Class: Ticker,Data<br/>
interface: Apiservice<br/><br/>
CoinActivity에서
<br/>
retrofit2
1.Retrofit 객체초기화<br/>
2.service 객체생성<br/>
3.Call 객체 생성<br/>
4.네트워크 통신<br/>

을통해서 EditText 에 입력받은 값을 통해서 textView에 표시합니다.<br/>
필요한 데이터는 response.body() 를 통해 꺼내오게 됩니다.<br/>

CoinActivity 를 실행하고 editText에 코인정보를 입력하고, 조회버튼을 누르면 조회됩니다.<br/><br/>

실행화면<br/><br/>

<img width="322" alt="스크린샷 2023-12-03 오전 6 10 10" src="https://github.com/Retudy/Retrofit2/assets/129308578/d2c2a88a-8c18-44f9-9396-c19352dbcd32"><br/>

** 앞으로 할일 **<br/>
1.유튜브api,공공데이터api,네이버 api 등을 recyclerview에 표시해봅니다,<br/>
2.서버와 통신하여 받아와서 recyclerview에 표시된 데이터들을 다른 fragment or activity에 보낸뒤 표시해봅니다. (데이터전달 intent or bundle)<br/>
3.데이터를 저장하고,출력 해봅니다 ( Room, Sharedpreferences )<br/>
4.viewModel을 사용하고, mvvm 아키텍쳐로 코드를 리팩토링합니다. (본프로젝트 시에)<br/>

api문서:https://apidocs.bithumb.com/reference/%ED%98%B8%EA%B0%80-%EC%A0%95%EB%B3%B4-%EC%A1%B0%ED%9A%8C<br/> 빗썸 api
api문서:https://openapi.nexon.com/game/maplestory/?id=22   nexon/maple api


#사용기술
## 작성자: 윤동현

라이브러리 <br/>
Retrofit2 / Coil / SharedPreferences / Viewbinding / Property / Corutine / RecyclerView
