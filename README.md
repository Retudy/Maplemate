<p align="center">
  
# maplestory 캐릭터 정보 검색
## 작성자: 윤동현

<p align="center">
실행화면 입니다. <br/><br/>


<p align="center">

  ![1](https://github.com/Retudy/Maplemate/assets/129308578/67d5371a-3e33-4e8d-be18-56e732a8cf60)
  ![2](https://github.com/Retudy/Maplemate/assets/129308578/7797aeef-6284-4593-a9e0-319d9d62c1ce)





<p align="center">
** 업데이트 내용** <br/>
24.01.01</br>
- 아이디를 입력하면 캐릭터의 정보, 아이템이 조회됩니다. </br>
24.01.11</br>
- 장비아이템을 표시합니다.<br/>
24.01.12</br>
- 캐릭터 조회후, 다음 캐릭터의 장비 리스트가 갱신되지 않던 문제 해결.<br/>
24.01.13</br>
- 00시 ~ 04 시에 데이터를 받아오지 못하는 문제 해결.<br/>
- 잠재능력이 없는 아이템에 에디셔널 탭이 노출되는 문제 해결.<br/>
24.01.15</br>
- 캐릭명 입력시 좌우 공백제거, 띄어쓰기 공백제거</br>
24.02.04</br>
- ViewModel 사용, LiveData 적용</br>
24.02.04</br>
- 아이템의 1번 옵션이 없을시 해당 View를 GONE 처리 할때, 해당 리스트가 아닌 다른 리스트의 옵션이 사라지는 문제 해결</br>
24.02.06</b>
- 잠재능력 옵션의 등급에 따라 색상이 표시되도록 변경, 및 디자인 수정
<p align="center">
** nexon maple api 발견된 문제 **</br>

- 고레벨 캐릭터의 경우에 DTO에 (경험치) character_exp:Int? 로 받을 경우에 정수 범위를 초과하여 Long으로 변경하여 받습니다.

<p align="center">
#Stack
## 작성자: 윤동현
<br/>
라이브러리 <br/>
Native: Retrofit2 / Coil / SharedPreferences / Viewbinding / Property / Corutine / RecyclerView </br>
Jetpack: dataStore
