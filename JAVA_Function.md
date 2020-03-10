# JAVA FUNCTION
<hr>

# ArrayList 사용방법

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



# 2중 반복문(For, While) 나오는 방법

```
loop: for (int i = 0; i < 9; i++) {
			for (int k = i + 1; k < 9; k++) {
				int result = sum - goblin.get(i) - goblin.get(k);
				if (result == 100) {
					ArrayList<Integer> deletion = new ArrayList<>();
					deletion.add(goblin.get(i));
					deletion.add(goblin.get(k));
					goblin.removeAll(deletion);
					break loop;
				}
			}
		}
```
loop라는 이름을 설정해주고 break loop를 하면 해당 루프를 나올 수 있다.
