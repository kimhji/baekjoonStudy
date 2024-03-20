#pragma warning(disable:4996)
#include <stdio.h>
#include <stdlib.h>

enum NodeState {
	UNVISITED, VISITED
};

typedef struct node {
	int id;
	int state;
	struct edge* connectedEdge;
	struct edge* insertLoc;
}nd;

typedef struct edge {
	int id1;
	int id2;
	struct edge* nextEdge;
}ed;

nd* nodes = NULL;

void dfs(nd* nodeIN) {
	ed* tnsEd = nodeIN->connectedEdge;
	while (tnsEd->nextEdge != NULL) {
		int oppositeNode;
		if (tnsEd->nextEdge->id1 == nodeIN->id) {
			oppositeNode = tnsEd->nextEdge->id2;
		}
		else {
			oppositeNode = tnsEd->nextEdge->id1;
		}
		if (nodes[oppositeNode].state == UNVISITED) {
			nodes[oppositeNode].state = VISITED;
			dfs(&nodes[oppositeNode]);
		}
		tnsEd = tnsEd->nextEdge;
	}
}
int main() {
	int N, M;
	scanf("%d%d", &N, &M);
	nodes = (nd*)malloc(sizeof(nd) * (N + 1));
	for (int i = 1; i <= N; i++)
	{
		nodes[i].state = UNVISITED;
		nodes[i].id = i;
		nodes[i].connectedEdge = (ed*)malloc(sizeof(ed));
		nodes[i].connectedEdge->nextEdge = NULL;
		nodes[i].insertLoc = nodes[i].connectedEdge;
	}
	for (int i = 0; i < M; i++) {
		int one, theOther;
		scanf("%d%d", &one, &theOther);
		nodes[one].insertLoc->nextEdge = (ed*)malloc(sizeof(ed));
		nodes[one].insertLoc->nextEdge->id1 = one;
		nodes[one].insertLoc->nextEdge->id2 = theOther;
		nodes[one].insertLoc->nextEdge->nextEdge = NULL;
		nodes[one].insertLoc = nodes[one].insertLoc->nextEdge;
		nodes[theOther].insertLoc->nextEdge = (ed*)malloc(sizeof(ed));
		nodes[theOther].insertLoc->nextEdge->id1 = one;
		nodes[theOther].insertLoc->nextEdge->id2 = theOther;
		nodes[theOther].insertLoc->nextEdge->nextEdge = NULL;
		nodes[theOther].insertLoc = nodes[theOther].insertLoc->nextEdge;
	}
	int result = 0;
	for (int cycle = 1; cycle <= N; cycle++) {
		if (nodes[cycle].state == UNVISITED) {
			nodes[cycle].state = VISITED;
			dfs(&nodes[cycle]);
			result += 1;
		}
	}
	printf("%d\n", result);
	return 0;
}