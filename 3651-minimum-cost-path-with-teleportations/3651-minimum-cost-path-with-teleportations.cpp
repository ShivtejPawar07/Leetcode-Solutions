class Solution {
	const int INF = 1e9;
public:
	int minCost(vector<vector<int>>& g, int k) {
		int m = g.size(), n = g[0].size();

		vector<array<int,3>> srt;
		for (int i=0; i<m; ++i) {
			for (int j=0; j<n; ++j) {
				srt.push_back({g[i][j], i, j});
			}
		}
		sort(srt.begin(), srt.end());

		map<pair<int,int>, int> mp;
		for (int i=m*n-1; i>=0; --i) {
			int j = i;
			while (j > 0 and srt[j-1][0] == srt[i][0]) --j;
			for (int q=j; q<=i; ++q) mp[{srt[q][1], srt[q][2]}] = j;
			i = j;
		}

		vector<int> prefmn(m*n, INF);

		vector dp(m, vector(n, vector<int>(k+1, INF)));
		dp[0][0][k] = 0;
		for (int t=k; t>=0; --t) {

			for (int i=0; i<m; ++i) for (int j=0; j<n; ++j) {
				if (i) dp[i][j][t] = min(dp[i][j][t], dp[i-1][j][t] + g[i][j]);
				if (j) dp[i][j][t] = min(dp[i][j][t], dp[i][j-1][t] + g[i][j]);
			}

			for (int i=0; i<m; ++i) for (int j=0; j<n; ++j) {
				prefmn[mp[{i, j}]] = min(prefmn[mp[{i, j}]], dp[i][j][t]);
			}
			for (int i=m*n-2; i>=0; --i) {
				prefmn[i] = min(prefmn[i], prefmn[i+1]);
			}

			for (int i=0; i<m; ++i) for (int j=0; j<n; ++j) {
				if (t) dp[i][j][t-1] = min(dp[i][j][t-1], prefmn[mp[{i, j}]]);
			}
		}

		int ans = INF;
		for (int t=0; t<=k; ++t) ans = min(ans, dp[m-1][n-1][t]);
		return ans;
	}
};