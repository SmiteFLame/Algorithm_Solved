#include <cstdio>
#include <cstring>
#include <stack>
#include <vector>
using namespace std;
int v, e,s,scc[10005];
bool visit[10005];
vector<int> edge[10005],re[10005];
stack<int> p;
void dfs(int cur) {
	visit[cur] = 1;
	for(auto i:re[cur])
		if (!visit[i])
			dfs(i);
	p.push(cur);
}
void dfs2(int k,int cur) {
	visit[cur] = 1;
	scc[cur] = k;
	for (auto i : edge[cur])
		if (!visit[i])
			dfs2(k,i);
}
int main() {
	scanf("%d%d", &v, &e);
	for (int i = 0,U,V; i < e; i++) {
		scanf("%d%d", &U, &V);
		edge[U].push_back(V);
		re[V].push_back(U);
	}
	for(int i=1;i<=v;i++)
		if(!visit[i])
			dfs(i);
	memset(visit, 0, sizeof(visit));
	while (!p.empty()) {
		int cur = p.top(); p.pop();
		if (visit[cur])continue;
		dfs2(++s,cur);
	}
	printf("%d\n", s);
	for (int i = 1; i <= v; i++) {
		if (scc[i] == -1)continue;
		printf("%d ", i);
		for(int j=i+1;j<=v;j++)
			if (scc[j] == scc[i]) {
				printf("%d ", j);
				scc[j] = -1;
			}
		printf("-1\n");
	}
	return 0;
}