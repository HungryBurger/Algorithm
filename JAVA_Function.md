# JAVA FUNCTION


## ArrayList
<b>

### ArrayList 사용방법

### Import 선언
import java.util.ArrayList

### ArrayList 생성

ArrayList<Integer> arrayList = new ArrayList<>();

### ArrayList에 데이터 추가하기

-> void add(int index, E element)

예시
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
 
        arrayList.add(1,10);

        0 10 1 2가 출력된다

        밀어넣는 것이 가능하다.

<b>ArrayList에 ArrayList를 추가하기</b><br>
-> void addAll(int index, Collection<>)

예시

        arrayList.addAll(arrayList2);


<b>ArrayList 데이터 제거하기</b>

-> boolean remove(int index)

예시
    // arrayList에 있는 1번째 index를 삭제하겠다.
    arraList.remove(1)


<b>ArrayList로부터 특정 데이터 가져오기</b>

-> .subList(int fromIndex, int toIndex)

예시

    arrayList.subList(1,3);


## LinkeList


# Sort 방법

### Array 정렬
int [] arr

오름차순
Arrays.sort(arr)
내림차순
Arrays.sort(arr, Comparator.reverseOrder())

### List or ArrayList 정렬

오름차순
Collection.sort(ArrayList)

내림차순
Collection.sort(ArrayList,Comparator.reverseOrder())



