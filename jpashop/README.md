![image](https://user-images.githubusercontent.com/33277588/118580118-45f6a180-b7ca-11eb-879b-a2e067fae458.png)

회원, 주문, 상품의 관계: 
회원은 여러 상품을 주문할 수 있다. 그리고 한 번 주문할 때 여러 상품을 선택할 수
있으므로 주문과 상품은 다대다 관계다. 하지만 이런 다대다 관계는 관계형 데이터베이스는 물론이고 엔티
티에서도 거의 사용하지 않는다. 따라서 그림처럼 주문상품이라는 엔티티를 추가해서 다대다 관계를 일대 다, 
다대일 관계로 풀어냈다.

상품 분류: 
상품은 도서, 음반, 영화로 구분되는데 상품이라는 공통 속성을 사용하므로 상속 구조로 표현했다.

![image](https://user-images.githubusercontent.com/33277588/118580409-cae1bb00-b7ca-11eb-9db3-8489ffa9275d.png)
