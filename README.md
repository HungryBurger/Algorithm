# Algorithm

Algorithm study(C++, JAVA)

## C++

[About C++](https://github.com/MCJoo/Algorithm/blob/master/JAVA_Function.md)
<br>  
[C++ Function](https://github.com/MCJoo/Algorithm/blob/master/JAVA_Function.md)

## JAVA 

<b>

[About JAVA](https://github.com/MCJoo/Algorithm/blob/master/JAVA_Function.md)
<br>  
[JAVA Function](https://github.com/MCJoo/Algorithm/blob/master/JAVA_Function.md)
</b>

## DFS (Depth-First-Search)

pseudo code <br>
```
void search(Node root) {
  if (root == null) return;
  // 1. root 노드 방문
  visit(root);
  root.visited = true; // 1-1. 방문한 노드를 표시
  // 2. root 노드와 인접한 정점을 모두 방문
  for each (Node n in root.adjacent) {
    if (n.visited == false) { // 4. 방문하지 않은 정점을 찾는다.
      search(n); // 3. root 노드와 인접한 정점 정점을 시작 정점으로 DFS를 시작
    }
  }
}
```

Reference : https://gmlwjd9405.github.io/2018/08/14/algorithm-dfs.html

## BFS

```
void search(Node root) {
	Queue queue = new Queue();
	root.marked = true; // (방문한 노드 체크)
	queue.enqueue(root); // 1-1. 큐의 끝에 추가

	// 3. 큐가 소진될 때까지 계속한다.
	while (!queue.isEmpty()) {
		Node r = queue.dequeue(); // 큐의 앞에서 노드 추출
		visit(r); // 2-1. 큐에서 추출한 노드 방문
		// 2-2. 큐에서 꺼낸 노드와 인접한 노드들을 모두 차례로 방문한다.
		foreach(Node n in r.adjacent) {
			if (n.marked == false) {
				n.marked = true; // (방문한 노드 체크)
				queue.enqueue(n); // 2-3. 큐의 끝에 추가
			}
		}
	}
}
```
Reference : https://gmlwjd9405.github.io/2018/08/15/algorithm-bfs.html

## BruteForce
## Simulation


<hr>

## Graph Algorithm

## Dijkstra

## Bellman Ford

